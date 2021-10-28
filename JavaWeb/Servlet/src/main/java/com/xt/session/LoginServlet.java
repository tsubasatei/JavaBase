package com.xt.session;

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
@WebServlet(urlPatterns = "/sLogin")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        if (!"admin".equals(username) || !"123".equals(pwd)) {
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }
        User user = new User(null, username, null);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        // 登录成功 跳转至 main.html
        resp.sendRedirect(req.getContextPath() + "/mainServlet");
    }
}
