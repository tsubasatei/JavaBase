package com.xt.servlet;

import com.xt.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);
        if ("admin".equals(username) && "123".equals(password)) {
            System.out.println("登录成功后");
            User user = new User(username, null);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("welcome.jsp");
        } else {
            resp.sendRedirect("login.jsp");
        }
    }
}
