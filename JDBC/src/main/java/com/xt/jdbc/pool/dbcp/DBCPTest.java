package com.xt.jdbc.pool.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xt
 * @Desc
 */
public class DBCPTest {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/base");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            String sql = "select * from emp";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("empno"));
                System.out.println(resultSet.getString("ename"));
                System.out.println("-------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                dataSource.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
