package com.xt.servlet;

import com.xt.entity.User;
import com.xt.listener.MySessionListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/myServlet4")
public class MyServlet4 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("user", new User("zhangsan", "123"));
        session.setAttribute("user", new User("lisi", "456"));
        session.removeAttribute("user");
        session.setAttribute("myListener", new MySessionListener());
        session.invalidate();
    }
}