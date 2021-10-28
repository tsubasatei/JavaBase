package com.xt.jdbc.oracle.dao.impl;

import com.xt.jdbc.entity.Emp;
import com.xt.jdbc.oracle.DBUtil;
import com.xt.jdbc.oracle.dao.EmpDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class EmpDaoImpl implements EmpDao {
    @Override
    public int add(Emp emp) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into emp values (?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, emp.getEmpno());
            preparedStatement.setString(2, emp.getEname());
            preparedStatement.setString(3, emp.getJob());
            preparedStatement.setInt(4, emp.getMgr());
            preparedStatement.setDate(5, (Date) emp.getHiredate());
            preparedStatement.setDouble(6, emp.getSal());
            preparedStatement.setDouble(7, emp.getComm());
            preparedStatement.setInt(8, emp.getDeptno());
            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(preparedStatement, connection);
        }
        return 0;
    }

    @Override
    public int deleteById(Integer empno) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "delete from emp where empno = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, empno);
            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(preparedStatement, connection);
        }
        return 0;
    }

    @Override
    public int update(Emp emp) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update emp set ename = ? , job = ? , mgr = ? , hiredate=? " +
                ", sal = ? , comm = ? , deptno = ? where empno = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, emp.getEname());
            preparedStatement.setString(2, emp.getJob());
            preparedStatement.setInt(3, emp.getMgr());
            preparedStatement.setDate(4, (Date) emp.getHiredate());
            preparedStatement.setDouble(5, emp.getSal());
            preparedStatement.setDouble(6, emp.getComm());
            preparedStatement.setInt(7, emp.getDeptno());
            preparedStatement.setInt(8, emp.getEmpno());
            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(preparedStatement, connection);
        }
        return 0;
    }

    @Override
    public Emp findById(Integer empno) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "select * from emp where empno = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, empno);
            ResultSet resultSet = preparedStatement.executeQuery();
            Emp emp = null;
            while (resultSet.next()) {
                int eno = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                String job = resultSet.getString("job");
                int mgr = resultSet.getInt("mgr");
                Date hiredate = resultSet.getDate("hiredate");
                Double sal = resultSet.getDouble("sal");
                Double comm = resultSet.getDouble("comm");
                int deptno = resultSet.getInt("deptno");
                emp = new Emp(eno, ename, job, mgr, hiredate, sal, comm, deptno);
                return emp;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(preparedStatement, connection);
        }
        return null;
    }

    @Override
    public List<Emp> findList() {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "select * from emp";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Emp> list = new ArrayList<>();
            while (resultSet.next()) {
                int eno = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                String job = resultSet.getString("job");
                int mgr = resultSet.getInt("mgr");
                Date hiredate = resultSet.getDate("hiredate");
                Double sal = resultSet.getDouble("sal");
                Double comm = resultSet.getDouble("comm");
                int deptno = resultSet.getInt("deptno");
                Emp emp = new Emp(eno, ename, job, mgr, hiredate, sal, comm, deptno);
                list.add(emp);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(preparedStatement, connection);
        }
        return null;
    }

    @Override
    public Emp findByEname(String ename) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "select * from emp where ename = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ename);
            ResultSet resultSet = preparedStatement.executeQuery();
            Emp emp = null;
            while (resultSet.next()) {
                int eno = resultSet.getInt("empno");
                String name = resultSet.getString("ename");
                String job = resultSet.getString("job");
                int mgr = resultSet.getInt("mgr");
                Date hiredate = resultSet.getDate("hiredate");
                Double sal = resultSet.getDouble("sal");
                Double comm = resultSet.getDouble("comm");
                int deptno = resultSet.getInt("deptno");
                emp = new Emp(eno, name, job, mgr, hiredate, sal, comm, deptno);
                return emp;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(preparedStatement, connection);
        }
        return null;
    }

    public static void main(String[] args) {
        EmpDao empDao = new EmpDaoImpl();
        Emp emp = new Emp(3333, "sisi2", "SALES", 1111, new Date(new java.util.Date().getTime()), 1500.0, 500.0, 10);
//        int i = empDao.add(emp);
//        int i = empDao.update(emp);
//        int i = empDao.deleteById(3333);
//        System.out.println(i);
//        Emp emp2 = empDao.findById(3333);
        //sql注入
        Emp emp2 = empDao.findByEname("SMITH or 1 = 1");
        System.out.println(emp2);
    }
}
