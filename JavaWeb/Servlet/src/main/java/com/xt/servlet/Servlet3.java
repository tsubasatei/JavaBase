package com.xt.servlet;

import javax.servlet.ServletConfig;
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
public class Servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        String brand = servletConfig.getInitParameter("brand");
        System.out.println("Init Param brand: " + brand);
        String product = servletConfig.getInitParameter("product");
        System.out.println("Init Param product: " + product);

        System.out.println("---------------");
        Enumeration<String> parameterNames = servletConfig.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println(servletConfig.getInitParameter(parameterNames.nextElement()));
        }
    }
}
