package com.xt.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author xt
 * @Desc
 */
public class CharacterEncodingFilter implements Filter {
    private String charset;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        charset = filterConfig.getInitParameter("charset");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(charset);
        chain.doFilter(request, response);
    }
}
