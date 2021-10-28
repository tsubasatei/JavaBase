package com.xt.domain;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns="/readFromApplication")
public class Servlet6 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        // 从request域中读取数据
        List<String> list = (List<String>) servletContext.getAttribute("list");
        System.out.println(list);
        System.out.println(servletContext.getAttribute("gender"));
        System.out.println(servletContext.getAttribute("name"));
    }
}