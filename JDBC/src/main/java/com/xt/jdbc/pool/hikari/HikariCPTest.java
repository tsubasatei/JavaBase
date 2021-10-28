package com.xt.jdbc.pool.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCPTest {
    public static void main(String[] args) throws SQLException {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/base");
//        config.setUsername("root");
//        config.setPassword("root");


//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/base");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");

        HikariConfig config = new HikariConfig("D:\\project\\javase\\JDBC\\src\\main\\resources\\HikariCP.properties");
        HikariDataSource dataSource = new HikariDataSource(config);
//
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
