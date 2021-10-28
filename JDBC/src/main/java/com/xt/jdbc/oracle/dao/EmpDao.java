package com.xt.jdbc.oracle.dao;

import com.xt.jdbc.entity.Emp;

import java.util.List;

/**
 * @author xt
 * @Desc
 */
public interface EmpDao {
    int add(Emp emp);
    int deleteById(Integer empno);
    int update(Emp emp);
    Emp findById(Integer empno);
    List<Emp> findList();

    Emp findByEname(String s);
}
