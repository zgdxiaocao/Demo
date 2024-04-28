package com.zgd.demoweb.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zgd
 */
@WebServlet(name = "CookieDemo", value = "/cookieDemo")
public class CookieDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置cookie的值
        Cookie username = new Cookie("username", "zgd");
        Cookie password = new Cookie("password", "12345");

        // 设置过期时间
        username.setMaxAge(-1);
        password.setMaxAge(-1);

        // 设置有效路径为项目目录
        username.setPath(req.getContextPath());
        password.setPath(req.getContextPath());

        resp.addCookie(username);
        resp.addCookie(password);

        resp.getWriter().write("add cookie success!");
    }

}
