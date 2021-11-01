package com.xt.forward;

import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = "/fServlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String money = req.getParameter("money");
        System.out.println("servlet1: " + money);
//        resp.setHeader("hehe", "haha");
//        resp.addHeader("bj", "beijing");
//        resp.sendError(404, "not found");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/fServlet2");

        // 在forward转发模式下,请求应该完全交给目标资源去处理,我们在源组件中,不要作出任何的响应处理
        // 在forward方法调用之后,也不要在使用req和resp对象做其他操作了
        // 在include转发模式下,设置响应可以在转发之前,也可以在转发之后
        /*
         * 1请求转发是一种服务器的行为,是对浏览器屏蔽
         * 2浏览器的地址栏不会发生变化
         * 3请求的参数是可以从源组件传递到目标组件的
         * 4请求对象和响应对象没有重新创建,而是传递给了目标组件
         * 5请求转发可以帮助我们完成页面的跳转
         * 6请求转发可以转发至WEB-INF里
         * 7请求转发只能转发给当前项目的内部资源,不能转发至外部资源
         * 8常用forward
         * */
//        requestDispatcher.forward(req, resp);
        requestDispatcher.include(req, resp);
        resp.getWriter().write("\n转发到servlet2之后再返回");

    }
}
