package com.xt.ajax.controller;

import com.google.gson.Gson;
import com.xt.ajax.entity.Area;
import com.xt.ajax.service.AreaService;
import com.xt.ajax.service.impl.AreaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
@WebServlet(urlPatterns = "/area")
public class AreaController extends HttpServlet {

    private AreaService areaService = new AreaServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer parentId = 0;
        try {
            String pid = req.getParameter("parentId");
//            System.out.println("pid:" + pid);
            parentId = Integer.parseInt(pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(parentId);
        List<Area> list = areaService.findListByParentId(parentId);
        String json = new Gson().toJson(list);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(json);
    }
}
