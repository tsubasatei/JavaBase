package com.xt.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
@WebServlet(urlPatterns = "/cServlet3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        boolean flag = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("servlet3".equals(name)) {
                    int i = Integer.parseInt(cookie.getValue());
                    resp.addCookie(new Cookie("servlet3", String.valueOf(i + 1)));
                    System.out.println("您第" + (i + 1) + "次访问");
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) {
            resp.addCookie(new Cookie("servlet3", 1 + ""));
            System.out.println("您第1次访问");
        }
    }

}
