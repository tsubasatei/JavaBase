package com.xt.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author xt
 * @Desc
 */
@WebFilter(urlPatterns = "/myServlet", initParams = {
        @WebInitParam(name="realName", value = "Sanae"),
        @WebInitParam(name="age", value = "18")
})
public class MyFilter3 implements Filter {

    public MyFilter3() {
        System.out.println("MyFilter3 constructor");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter3 init");
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
        System.out.println("MyFilter3 doFilter 对请求作出过滤");
        chain.doFilter(request, response);
        System.out.println("MyFilter3 doFilter 对响应作出过滤");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("过滤器");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter3 destroy");
    }
}
