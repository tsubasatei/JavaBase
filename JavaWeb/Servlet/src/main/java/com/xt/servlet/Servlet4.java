package com.xt.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class Servlet4 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        String brand = servletConfig.getInitParameter("pinPai");
        System.out.println("Init Param brand: " + brand);
        String product = servletConfig.getInitParameter("chanPin");
        System.out.println("Init Param product: " + product);
    }
}
