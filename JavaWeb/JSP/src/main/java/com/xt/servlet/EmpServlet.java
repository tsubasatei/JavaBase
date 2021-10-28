package com.xt.servlet;

/**
 * @author xt
 * @Desc
 */

import com.xt.entity.Emp;
import com.xt.service.EmpService;
import com.xt.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/emp")
public class EmpServlet extends HttpServlet {
    private EmpService empService = new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Emp> list = empService.findAll();
        req.setAttribute("emps", list);
        req.getRequestDispatcher("emps.jsp").forward(req, resp);
    }
}
