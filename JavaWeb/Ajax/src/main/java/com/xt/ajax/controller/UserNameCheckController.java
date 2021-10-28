package com.xt.ajax.controller;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
@WebServlet(urlPatterns = "/usernameCheck")
public class UserNameCheckController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String callBack = req.getParameter("jsoncallback");
        System.out.println(callBack);
        String name = req.getParameter("username");
        String msg = "";
        if ("msb".equals(name)) {

            msg = "用户名已被占用";
        } else {
            msg = "用户名可用";
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write(callBack + "('" + msg + "')");
    }
}
