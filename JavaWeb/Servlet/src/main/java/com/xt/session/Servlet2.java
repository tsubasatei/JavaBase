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
@WebServlet(urlPatterns = "/sServlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println(session.getAttribute("name"));
        System.out.println(session.getAttribute("gender"));

        // 获取Session对象的其他信息
        System.out.println("创建时间:" + session.getCreationTime());
        System.out.println("最后一次访问时间:" + session.getLastAccessedTime());
        System.out.println("最大不活动时间:" + session.getMaxInactiveInterval());
    }
}
