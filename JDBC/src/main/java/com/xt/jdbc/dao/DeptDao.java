package com.xt.jdbc.dao;

import com.xt.jdbc.entity.Dept;

import java.util.List;

/**
 * @author xt
 * @Desc
 */
public interface DeptDao {
    int add(Dept dept);
    int deleteById(Integer deptno);
    int update(Dept dept);
    Dept findById(Integer deptno);
    List<Dept> findList();
}
