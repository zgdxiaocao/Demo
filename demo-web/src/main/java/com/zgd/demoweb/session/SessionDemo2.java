package com.zgd.demoweb.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author zgd
 */
@WebServlet(value = "/sessionDemo2", name = "SessionDemo2")
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String builder = "username:" + session.getAttribute("username") + "\n" +
                "password:" + session.getAttribute("password");

        resp.getWriter().write(builder);
    }
}
