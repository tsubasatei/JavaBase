package com.xt.dao.impl;

import com.xt.dao.EmpDao;
import com.xt.entity.Emp;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class EmpDaoImpl implements EmpDao {
    @Override
    public List<Emp> findList() {
        List<Emp> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/base?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                    "root", "root");
            String sql = "select e.*, s.grade from emp e left join salgrade s on e.sal between s.losal and s.hisal";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

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
                Integer grade = resultSet.getInt(9);
                list.add(new Emp(eno, ename, job, mgr, date, sal, comm, deptno, grade));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
