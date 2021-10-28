package com.xt.domain;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = "/addToApplication")
public class Servlet5 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向application域中添加数据
        ServletContext servletContext = req.getServletContext();
        List<String> x = new ArrayList<>();
        Collections.addAll(x, "a", "b", "c");
        servletContext.setAttribute("list", x);
        servletContext.setAttribute("gender","boy");
        servletContext.setAttribute("gender","girl");
        servletContext.setAttribute("name","晓明");
    }
}
