package com.xt.jdbc.oracle;

import java.sql.*;

/**
 * @author xt
 * @Desc
 */
public class JDBCTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
            statement = connection.createStatement();

//            String sql = "select * from emp";
//            resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt("empno"));
//                System.out.println(resultSet.getString("ename"));
//                System.out.println("---------");
//            }

//            String sql = "create table psn(id number(10) primary key, name varchar2(10))";
            String sql = "create sequence seq_1 increment by 1 start with 1";
            boolean execute = statement.execute(sql);  // false
            System.out.println(execute);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
