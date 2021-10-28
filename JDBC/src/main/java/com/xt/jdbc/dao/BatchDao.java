package com.xt.jdbc.dao;

import com.xt.jdbc.dbutil.MySQLDBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author xt
 * @Desc
 */
public class BatchDao {
    public void insertBatch(){
        Connection connection = MySQLDBUtil.getConnection();
        String sql = "insert into emp(empno, ename) values (?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 1000; i++) {
                preparedStatement.setInt(1, i+1000);
                preparedStatement.setString(2, "zhangsan");
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            MySQLDBUtil.close(preparedStatement, connection);
        }
    }

    public static void insert() {
        Connection connection = MySQLDBUtil.getConnection();
        String sql = "insert into emp(empno, ename) values (?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 1000; i++) {
                preparedStatement.setInt(1, i+2000);
                preparedStatement.setString(2, "zhangsan");
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            MySQLDBUtil.close(preparedStatement, connection);
        }
    }
    public static void main(String[] args) {
        BatchDao batchDao = new BatchDao();
        long start = System.currentTimeMillis();
        batchDao.insertBatch();
        long end = System.currentTimeMillis();
        System.out.println("batch插入用时：" + (end - start));

        start = System.currentTimeMillis();
        batchDao.insert();
        end = System.currentTimeMillis();
        System.out.println("一条条插入用时：" + (end - start));
    }
}
