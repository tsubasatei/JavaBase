package com.xt.page.dao;

import com.xt.page.entity.Page;
import com.xt.page.entity.Student;

/**
 * @author xt
 * @Desc
 */
public interface StudentDao {
    Page<Student> findStudentsByPage(String name, String age, int currentPage, int pageSize);
}
