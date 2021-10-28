package com.xt.service.impl;

import com.xt.dao.EmpDao;
import com.xt.dao.impl.EmpDaoImpl;
import com.xt.entity.Emp;
import com.xt.service.EmpService;

import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl();
    @Override
    public List<Emp> findAll() {
        return empDao.findList();
    }
}
