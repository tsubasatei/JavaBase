package com.xt.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author xt
 * @Desc
 */
public class MyFilter implements Filter {

    public MyFilter() {
        System.out.println("MyFilter constructor");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter init");
        String realName = filterConfig.getInitParameter("realName");
        System.out.println("realName:" + realName);
        Enumeration<String> parameterNames = filterConfig.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name + ": " + filterConfig.getInitParameter(name));
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter doFilter 对请求作出过滤");
        chain.doFilter(request, response);
        System.out.println("MyFilter doFilter 对响应作出过滤");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("过滤器");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter destroy");
    }
}
