package com.xt.page.service.impl;

import com.xt.page.dao.StudentDao;
import com.xt.page.dao.impl.StudentDaoImpl;
import com.xt.page.entity.Page;
import com.xt.page.entity.Student;
import com.xt.page.service.StudentService;

/**
 * @author xt
 * @Desc
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public Page<Student> findStudentsByPage(String name, String age, int currentPage, int pageSize) {
        return studentDao.findStudentsByPage(name, age, currentPage, pageSize);
    }
}
