package com.xt.jdbc.oracle.dao;

import java.util.List;

/**
 * @author xt
 * @Desc
 */
public interface BaseDao {
    List getRows(String sql, Object[] params, Class clazz);
    void insert(String sql, Object[] params);
}
