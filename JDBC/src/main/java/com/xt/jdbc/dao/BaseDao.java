package com.xt.jdbc.dao;

import com.xt.jdbc.MyConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xt
 * @Desc
 */
public class BaseDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    /**
     * 获取连接的方法
     * @return
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = MyConnectionPool.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 查询数据库的通用方法
     * @param sql
     * @return
     */
    public ResultSet executeQuery(String sql, Object...params) {
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 增删改
     * @param sql
     * @return
     */
    public int executeUpdate(String sql, Object...params){
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            int rows = preparedStatement.executeUpdate();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 用于关闭连接的方法
     */
    public void close() {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
