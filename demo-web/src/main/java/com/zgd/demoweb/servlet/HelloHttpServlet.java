package com.zgd.demoweb.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注解形式实现HttpServlet
 *
 * @author zgd
 */
@WebServlet(name = "HelloHttpServlet",
        value = "/helloHttp",
        initParams = {@WebInitParam(name = "username", value = "tom")})
public class HelloHttpServlet extends HttpServlet {

    /**
     * ServletConfig三大作用
     * 1.获取Servlet的name
     * 2.获取init-param
     * 3.获取ServletContext对象
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        System.out.println("获取Servlet别名：" + servletConfig.getServletName());
        System.out.println("获取初始化参数：" + servletConfig.getInitParameter("username"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=========== Hello HttpServlet Get Request==========");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
