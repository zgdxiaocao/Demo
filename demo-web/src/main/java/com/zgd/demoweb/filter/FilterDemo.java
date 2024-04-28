package com.zgd.demoweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zgd
 */
public class FilterDemo implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) servletResponse;
        // 前置代码
        Cookie cookie = new Cookie("hello", "hello");

        res.addCookie(cookie);

        // 访问资源
        filterChain.doFilter(servletRequest, res);

        // 后置代码
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
