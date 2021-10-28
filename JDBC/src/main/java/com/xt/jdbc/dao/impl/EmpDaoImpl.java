package com.xt.jdbc.dao.impl;

import com.xt.jdbc.dao.BaseDao;
import com.xt.jdbc.dao.EmpDao;
import com.xt.jdbc.entity.Emp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class EmpDaoImpl extends BaseDao implements EmpDao {

    @Override
    public int add(Emp emp) {
        String sql = "insert into emp values (default, ?, ?, ?, ?, ?, ?, ?)";
        return this.executeUpdate(sql, emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDeptno());
    }

    @Override
    public int deleteById(Integer empno) {
        String sql = "delete from emp where empno = ?";
        return this.executeUpdate(sql, empno);
    }

    @Override
    public int update(Emp emp) {
        String sql = "update emp set ename = ?, job = ?, mgr =  ?, hiredate = ?, sal = ?, comm = ?, deptno = ? where empno = ?";
        return this.executeUpdate(sql, emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDeptno(), emp.getEmpno());
    }

    @Override
    public Emp findById(Integer empno) {
        String sql = "select * from emp where empno = ?";
        ResultSet resultSet = this.executeQuery(sql, empno);
        try {
            if (resultSet.next()) {
                Integer eno = resultSet.getInt(1);
                String ename = resultSet.getString(2);
                String job = resultSet.getString(3);
                Integer mgr = resultSet.getInt(4);
                String hiredate = resultSet.getString(5);
                SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = stf.parse(hiredate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Double sal = resultSet.getDouble(6);
                Double comm = resultSet.getDouble(7);
                Integer deptno = resultSet.getInt(8);
                return new Emp(eno, ename, job, mgr, date, sal, comm, deptno);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Emp> findList() {
        String sql = "select * from emp";
        ResultSet resultSet = this.executeQuery(sql);
        List<Emp> emps = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Integer eno = resultSet.getInt(1);
                String ename = resultSet.getString(2);
                String job = resultSet.getString(3);
                Integer mgr = resultSet.getInt(4);
                String hiredate = resultSet.getString(5);
                SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = stf.parse(hiredate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Double sal = resultSet.getDouble(6);
                Double comm = resultSet.getDouble(7);
                Integer deptno = resultSet.getInt(8);
                emps.add(new Emp(eno, ename, job, mgr, date, sal, comm, deptno));
            }
            return emps;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
