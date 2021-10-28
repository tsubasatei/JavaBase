package com.xt.ajax.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xt.ajax.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
@WebServlet(urlPatterns = "/json")
public class JsonController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("pwd");
        System.out.println(username);
        System.out.println(password);

        User user = new User("小明", "123", 10, "1", new Date());
        User user2 = new User("小明2", "123", 11, "1", new Date());
        User user3 = new User("小明3", "123", 12, "1", new Date());
        User user4 = new User("小明4", "123", 13, "1", new Date());
        List<User> list = new ArrayList<>();
        Collections.addAll(list, user, user2, user3, user4);

        GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gson = gsonBuilder.create();
        String json = gson.toJson(list);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write(json);
    }
}
