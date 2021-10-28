package com.xt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author xt
 * @Desc
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURL());//返回客户端浏览器发出请求时的完整URL。
        System.out.println(req.getRequestURI());//返回请求行中指定资源部分。
        System.out.println(req.getRemoteAddr());//返回发出请求的客户机的IP地址。
        System.out.println(req.getLocalAddr());//返回WEB服务器的IP地址。
        System.out.println(req.getLocalPort());//返回WEB服务器处理Http协议的连接器所监听的端口。
        System.out.println("主机名: " + req.getLocalName());
        System.out.println("客户端PORT: " + req.getRemotePort());
        System.out.println("当前项目部署名: " + req.getContextPath());
        System.out.println("协议名:"+req.getScheme());
        System.out.println("请求方式:"+req.getMethod());

        // 根据请求头名或者请求头对应的值
        System.out.println(req.getHeader("Accept"));
        // 获得全部的请求头名
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName+":"+req.getHeader(headerName));
        }
        String username = req.getParameter("username");
        System.out.println(username);
        String pwd = req.getParameter("pwd");
        String msg = "";
        if ("admin".equals(username) && "123".equals(pwd)) {
            msg = "success";
        } else {
            msg = "fail";
        }
        resp.getWriter().write(msg);
    }
}
