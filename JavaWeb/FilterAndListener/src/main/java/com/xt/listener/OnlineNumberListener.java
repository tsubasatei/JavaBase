package com.xt.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author xt
 * @Desc
 */
@WebListener
public class OnlineNumberListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext servletContext = session.getServletContext();
        Integer count = (Integer) servletContext.getAttribute("count");
        if (count == null) {
            servletContext.setAttribute("count", 1);
        } else {
            servletContext.setAttribute("count", count + 1);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext servletContext = session.getServletContext();
        Integer count = (Integer) servletContext.getAttribute("count");
        servletContext.setAttribute("count", --count);
    }
}
