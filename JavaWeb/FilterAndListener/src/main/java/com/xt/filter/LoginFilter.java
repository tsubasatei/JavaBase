package com.xt.filter;

import com.xt.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
//@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        if (requestURI.contains("login.jsp") || requestURI.contains("login")
                || requestURI.contains("/static/")) {
            chain.doFilter(req, response);
            return;
        }
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (null != user) {
            chain.doFilter(req, response);
            return;
        }
        ((HttpServletResponse)response).sendRedirect("login.jsp");
    }
}
