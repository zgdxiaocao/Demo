package com.zgd.demoweb.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * xml形式实现Servlet
 *
 * @author zgd
 */
public class HelloServlet implements Servlet {
    private String message;

    private static final String GET = "GET";
    private static final String POST = "POST";


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.message = "HelloServlet";
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String method = request.getMethod();
        if (GET.equals(method)) {
            doGet(servletResponse);
        }

        if (POST.equals(method)) {
            doPost(servletResponse);
        }
    }

    private void doPost(ServletResponse servletResponse) {
        System.out.println("===========Post Request==========");
    }

    private void doGet(ServletResponse servletResponse) {

        System.out.println("=========== Hello Servlet Get Request==========");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}