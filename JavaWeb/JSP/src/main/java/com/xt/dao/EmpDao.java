package com.xt.dao;

import com.xt.entity.Emp;

import java.util.List;

/**
 * @author xt
 * @Desc
 */
public interface EmpDao {
    List<Emp> findList();
}
