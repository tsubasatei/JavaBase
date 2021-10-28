package com.xt.page.controller;

import com.xt.page.entity.Page;
import com.xt.page.entity.Student;
import com.xt.page.service.StudentService;
import com.xt.page.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
@WebServlet(urlPatterns = "/students")
public class StudentController extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        int currentPage = 1;
        int pageSize = 5;
        String currentPage2 = req.getParameter("currentPage");
        String pageSize2 = req.getParameter("pageSize");
        if (!"".equals(currentPage2)) {
            currentPage = Integer.parseInt(currentPage2);
        }
        if (!"".equals(pageSize2)) {
            pageSize = Integer.parseInt(pageSize2);
        }
        Page<Student> page = studentService.findStudentsByPage(name, age, currentPage, pageSize);
        req.setAttribute("pageList", page);
        req.setAttribute("name", name);
        req.setAttribute("age", age);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
