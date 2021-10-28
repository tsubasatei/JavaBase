package com.xt.page.dao.impl;

import com.xt.page.dao.StudentDao;
import com.xt.page.entity.Page;
import com.xt.page.entity.Student;
import com.xt.page.util.MyConnectionPool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public Page<Student> findStudentsByPage(String name, String age, int currentPage, int pageSize) {
        Connection connection = MyConnectionPool.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        StringBuilder sb = new StringBuilder("select * from student where 1 = 1 ");
        StringBuilder sb2 = new StringBuilder("select count(1) from student where 1 = 1 ");
        if (null != name && !"".equals(name)) {
            sb.append("and name like ? ");
            sb2.append("and name like ? ");
        }

        if (null != age && !"".equals(age)) {
            sb.append("and age >= ? ");
            sb2.append("and age >= ? ");
        }
        sb.append("limit ?, ?");
        String dataSql = sb.toString();
        String countSql = sb2.toString();
        List<Student> list = new ArrayList<>();
        int count = 0;
        try {
            if ((null != name && !"".equals(name)) && (null != age && !"".equals(age))) {
                list = queryRunner.query(connection, dataSql, new BeanListHandler<>(Student.class), "%" + name + "%", Integer.parseInt(age), (currentPage - 1) * pageSize, pageSize);
                count = ((Long)(queryRunner.query(connection, countSql, new ScalarHandler<>(), "%" + name + "%", Integer.parseInt(age)))).intValue();
            } else if ((null != name && !"".equals(name)) && (null == age || "".equals(age))) {
                list = queryRunner.query(connection, dataSql, new BeanListHandler<>(Student.class), "%" + name + "%", (currentPage - 1) * pageSize, pageSize);
                count = ((Long)(queryRunner.query(connection, countSql, new ScalarHandler<>(), "%" + name + "%"))).intValue();
            } else if ((null == name || "".equals(name)) && (null != age && !"".equals(age))) {
                list = queryRunner.query(connection, dataSql, new BeanListHandler<>(Student.class), Integer.parseInt(age), (currentPage - 1) * pageSize, pageSize);
                count = ((Long)(queryRunner.query(connection, countSql, new ScalarHandler<>(), Integer.parseInt(age)))).intValue();
            } else {
                list = queryRunner.query(connection, dataSql, new BeanListHandler<>(Student.class), (currentPage - 1) * pageSize, pageSize);
                count = ((Long)(queryRunner.query(connection, countSql, new ScalarHandler<>()))).intValue();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        Page<Student> page = new Page<>(list, totalPage, count, currentPage, pageSize);
//        System.out.println(page);
        return page;
    }
}
