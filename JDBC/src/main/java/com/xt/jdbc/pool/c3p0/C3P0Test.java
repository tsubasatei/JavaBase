package com.xt.jdbc.pool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xt
 * @Desc
 */
public class C3P0Test {
    private static Connection connection;
    private static ComboPooledDataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource();
    }

    public static Connection getConnection() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void queryData() {
        Connection connection = getConnection();
        String sql = "select * from emp";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("empno"));
                System.out.println(resultSet.getString("ename"));
                System.out.println("-------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void main(String[] args) {
        /*ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/base");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            queryData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            dataSource.close();
        }*/
        queryData();
    }
}
