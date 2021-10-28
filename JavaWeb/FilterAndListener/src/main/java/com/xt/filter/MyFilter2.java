package com.xt.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class MyFilter2 implements Filter {

    public MyFilter2() {
        System.out.println("MyFilter2 constructor");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter2 init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter2 doFilter 对请求作出过滤");
        chain.doFilter(request, response);
        System.out.println("MyFilter2 doFilter 对响应作出过滤");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter2 destroy");
    }
}
