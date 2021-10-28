package com.xt.jdbc.oracle.dao.impl;

import com.xt.jdbc.entity.Dept;
import com.xt.jdbc.entity.Emp;
import com.xt.jdbc.oracle.DBUtil;
import com.xt.jdbc.oracle.dao.BaseDao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class BaseDaoImpl implements BaseDao {
    @Override
    public List getRows(String sql, Object[] params, Class clazz) {
        List list = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Object obj = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnName( i + 1).toLowerCase();
//                    System.out.println(columnName + "-" + columnValue);
                    Field declaredField = clazz.getDeclaredField(columnName);
                    String setName = getSetName(columnName);
                    Method method = clazz.getDeclaredMethod(setName, declaredField.getType());
                    method.setAccessible(true);
                    if (columnValue instanceof Number) {
                        Number number = (Number) columnValue;
                        String name = declaredField.getType().getName();
                        if ("int".equals(name) || "java.lang.Integer".equals(name)) {
                            method.invoke(obj, number.intValue());
                        } else if ("byte".equals(name) || "java.lang.Byte".equals(name)) {
                            method.invoke(obj, number.byteValue());
                        } else if ("short".equals(name) || "java.lang.Short".equals(name)) {
                            method.invoke(obj, number.shortValue());
                        } else if ("long".equals(name) || "java.lang.Long".equals(name)) {
                            method.invoke(obj, number.longValue());
                        } else if ("float".equals(name) || "java.lang.Float".equals(name)) {
                            method.invoke(obj, number.floatValue());
                        } else if ("double".equals(name) || "java.lang.Double".equals(name)) {
                            method.invoke(obj, number.doubleValue());
                        }
                    } else {
                        method.invoke(obj, columnValue);
                    }
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet, preparedStatement, connection);
        }

        return list;
    }

    @Override
    public void insert(String sql, Object[] params) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(preparedStatement, connection);
        }

    }

    private String getSetName(String name) {
        return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    public static void main(String[] args) {
        BaseDaoImpl baseDao = new BaseDaoImpl();
        String sql = "select * from emp where deptno = ?";
        List list = baseDao.getRows(sql, new Object[]{10}, Emp.class);
        list.forEach(System.out::println);

//        sql = "insert into dept values (?, ?, ?)";
//        baseDao.insert(sql, new Object[]{50, "人事部", "北京"});

        sql = "select * from dept ";
        list = baseDao.getRows(sql, null, Dept.class);
        list.forEach(System.out::println);
    }
}
