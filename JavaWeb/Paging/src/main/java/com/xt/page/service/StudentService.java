package com.xt.page.service;

import com.xt.page.entity.Page;
import com.xt.page.entity.Student;

/**
 * @author xt
 * @Desc
 */
public interface StudentService {
    Page<Student> findStudentsByPage(String name, String age, int currentPage, int pageSize);
}
