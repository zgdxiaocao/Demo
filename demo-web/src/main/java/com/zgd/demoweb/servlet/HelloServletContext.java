package com.zgd.demoweb.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servletContext功能演示
 *
 * @author zgd
 */
@WebServlet(name = "HelloServletContext", value = "/helloContext")
public class HelloServletContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
        // 获取init参数
        System.out.println(servletContext.getInitParameter("password"));
        // 获取工程路径
        System.out.println(servletContext.getContextPath());
        // 获取绝对路径
        System.out.println(servletContext.getRealPath("/"));
        // 存取数据
        servletContext.setAttribute("age", 15);
        System.out.println(servletContext.getAttribute("age"));
    }
}
