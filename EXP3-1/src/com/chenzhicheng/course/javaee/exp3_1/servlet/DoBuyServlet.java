package com.chenzhicheng.course.javaee.exp3_1.servlet;

import com.chenzhicheng.course.javaee.exp3_1.db.Database;
import com.chenzhicheng.course.javaee.exp3_1.util.SessionControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoBuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(SessionControl.isInvalid(req.getSession())){
            resp.sendRedirect("./logout");
            return;
        }
        try{
            Database database = new Database();
            String productid = req.getParameter("pid");
            String userid = (String)req.getSession().getAttribute("userid");
            database.addShopRecord(userid, productid, "1");
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("./error");
            return;
        }
        resp.sendRedirect("./products");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
