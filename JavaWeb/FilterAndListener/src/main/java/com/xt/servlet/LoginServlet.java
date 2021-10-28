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

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);
        User user = new User(username, password);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        session.setAttribute("listener", new MySessionListener());
        resp.sendRedirect("welcome.jsp");
    }
}