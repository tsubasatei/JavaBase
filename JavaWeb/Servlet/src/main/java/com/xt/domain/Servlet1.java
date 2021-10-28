package com.xt.domain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = "/addToRequest")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向request域中添加数据
        List<String> x = new ArrayList<>();
        Collections.addAll(x, "a", "b", "c");
        req.setAttribute("list", x);
        req.setAttribute("gender","boy");
        req.setAttribute("gender","girl");
        req.setAttribute("name","晓明");
        // 请求转发
         req.getRequestDispatcher("/readFromRequest").forward(req,resp);
        // 重定向
        //resp.sendRedirect("readFromRequest.do");
    }
}
