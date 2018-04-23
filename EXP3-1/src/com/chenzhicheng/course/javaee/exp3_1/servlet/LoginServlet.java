package com.chenzhicheng.course.javaee.exp3_1.servlet;

import com.chenzhicheng.course.javaee.exp3_1.db.Database;
import com.chenzhicheng.course.javaee.exp3_1.util.SessionControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
//
        if(((String)session.getAttribute("userid")) != null){
            resp.sendRedirect("/products");
            return;
        }
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String uid = null;
        Database database = null;

        try{
            database = new Database();
            uid = database.verify(username, password);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("./error.jsp");
            return;
        }
        if(uid != null && Integer.parseInt(uid) > 0){
            session.setAttribute("username", username);
            session.setAttribute("userid", uid);
            resp.sendRedirect("./products");
        } else {
            resp.sendRedirect("./login.jsp");
        }
    }
}
