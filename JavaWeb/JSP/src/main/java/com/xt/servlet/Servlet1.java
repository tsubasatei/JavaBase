package com.xt.servlet;

import com.xt.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * @author xt
 * @Desc
 */
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("username:" + username);
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("hobby:" + Arrays.asList(hobbies));
        // 向三个域中放入数据
        /*向请求域中放入数据*/
        User user = new User(1,"李雷","123456");
        req.setAttribute("user", user);
        req.setAttribute("msg","requestMessage");
        /*向session域中放入数据*/
        List<User> users = new ArrayList<>();
        User user1 = new User(1,"韩梅梅","123456");
        User user2 = new User(1,"小明","123456");
        User user3 = new User(1,"小红","123456");
        Collections.addAll(users, user1, user2, user3);
        HttpSession session = req.getSession();
        session.setAttribute("users", users);
        session.setAttribute("msg","sessionMessage");
        /*向application域中放入数据*/
        ServletContext application = getServletContext();
        Map<String, User> map = new HashMap<>();
        map.put("a", user1);
        map.put("b", user2);
        map.put("c", user3);
        application.setAttribute("userMap", map);
        application.setAttribute("msg","applicationMessage");
        // 跳转至jsp
        req.getRequestDispatcher("showInfo.jsp").forward(req,resp);
    }
}
