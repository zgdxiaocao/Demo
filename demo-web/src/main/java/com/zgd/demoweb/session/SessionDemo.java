package com.zgd.demoweb.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author zgd
 */
@WebServlet(name = "SessionDemo", value = "/sessionDemo")
public class SessionDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // 向请求域中存数据
        session.setAttribute("username", "zjh");
        session.setAttribute("password", "123456");

        resp.getWriter().write("set session success");
    }
}
