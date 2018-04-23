package com.chenzhicheng.course.javaee.exp3_1.servlet;

import com.chenzhicheng.course.javaee.exp3_1.db.Database;
import com.chenzhicheng.course.javaee.exp3_1.model.AllHistoryBean;
import com.chenzhicheng.course.javaee.exp3_1.model.OneWeekHistoryBean;
import com.chenzhicheng.course.javaee.exp3_1.util.SessionControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class HistoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(SessionControl.isNotInvalid(req.getSession())){
            resp.sendRedirect("./logout");
            return;
        }
        HttpSession session = req.getSession();
        try{
            Database database = new Database();
            String uid = (String)session.getAttribute("userid");
            ArrayList<OneWeekHistoryBean> oneWeekList = database.getOneWeekHistoryList(uid);
            ArrayList<AllHistoryBean> allList = database.getAllHistoryList(uid);
            session.setAttribute("oneweeklist", oneWeekList);
            session.setAttribute("alllist", allList);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("./error.jsp");
            return;
        }
        resp.sendRedirect("./history.jsp");
    }
}
