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
@WebServlet(name = "CookieDemo2", value = "/cookieDemo2")
public class CookieDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取cookie
        Cookie[] cookies = req.getCookies();
        StringBuilder builder = new StringBuilder();

        for (Cookie cookie : cookies) {
            builder.append(cookie.getName()).append(":").append(cookie.getValue());
            builder.append("\n");
        }

        // 输出有字符流和字节流两种方式，这里使用的是字符流
        resp.getWriter().write(builder.toString());
    }

}
