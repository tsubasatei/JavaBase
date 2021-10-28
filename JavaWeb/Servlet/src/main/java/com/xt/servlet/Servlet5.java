package com.xt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
@WebServlet(name = "servlet5", urlPatterns = "/servlet5", loadOnStartup = 7, initParams = {
        @WebInitParam(name = "brand", value = "三星"),
        @WebInitParam(name = "product", value = "笔记本")
})
public class Servlet5 extends HttpServlet {
    public Servlet5() {
        System.out.println("constructor 5");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init 5");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service 5");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 5");
    }
}
