package com.xt.jdbc.dao.impl;

import com.xt.jdbc.dao.BaseDao;
import com.xt.jdbc.dao.DeptDao;
import com.xt.jdbc.entity.Dept;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class DeptDaoImpl extends BaseDao implements DeptDao {
    @Override
    public int add(Dept dept) {
        String sql = "insert into dept values (?, ?, ?)";
        return this.executeUpdate(sql, dept.getDeptno(), dept.getDname(), dept.getLoc());
    }

    @Override
    public int deleteById(Integer deptno) {
        String sql = "delete from dept where deptno = ?";
        return this.executeUpdate(sql, deptno);
    }

    @Override
    public int update(Dept dept) {
        String sql = "update dept set dname = ? , loc = ? where deptno = ?";
        return this.executeUpdate(sql, dept.getDname(), dept.getLoc(), dept.getDeptno());
    }

    @Override
    public Dept findById(Integer deptno) {
        String sql = "select * from dept where deptno = ?";
        ResultSet resultSet = this.executeQuery(sql, deptno);
        try {
            if (resultSet.next()) {
                int dno = resultSet.getInt(1);
                String dname = resultSet.getString(2);
                String loc = resultSet.getString(3);
                return new Dept(dno, dname, loc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Dept> findList() {
        String sql = "select * from dept";
        ResultSet resultSet = this.executeQuery(sql);
        List<Dept> depts = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int dno = resultSet.getInt(1);
                String dname = resultSet.getString(2);
                String loc = resultSet.getString(3);
                depts.add(new Dept(dno, dname, loc));
            }
            return depts;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
