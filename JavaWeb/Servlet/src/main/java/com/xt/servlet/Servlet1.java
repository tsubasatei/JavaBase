package com.xt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        ServletContext servletContext1 = this.getServletContext();
        System.out.println(servletContext == servletContext1);

        // 获取项目的部署名
        String contextPath = servletContext.getContextPath();
        System.out.println("项目的部署名:" + contextPath);
        
        // 相对路径转绝对路径(文件上传下载时需要注意)
        // 该方法可以将一个相对路径转换为绝对路径，在文件上传与下载时需要用到该方法做路径的转换。
        String fileupload = servletContext.getRealPath("fileupload");
        System.out.println("绝对路径：" + fileupload);
        
        // 获取容器的附加信息
        String serverInfo = servletContext.getServerInfo();
        System.out.println("容器的附加信息：" + serverInfo);

        // 返回Servlet容器的名称和版本号
        // 返回Servlet容器所支持Servlet的主版本号
        int majorVersion = servletContext.getMajorVersion();
        // 返回Servlet容器所支持Servlet的副版本号。
        int minorVersion = servletContext.getMinorVersion();
        System.out.println(majorVersion + ":" + minorVersion);

        String username = servletContext.getInitParameter("username");
        System.out.println("Init Param username: " + username);
        String password = servletContext.getInitParameter("password");
        System.out.println("Init Param password: " + password);
    }
}
