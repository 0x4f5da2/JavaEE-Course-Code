package com.chenzhicheng.course.javaee.exp3_1.util;

import javax.servlet.http.HttpSession;

public class SessionControl {
    public static boolean isNotInvalid(HttpSession session){
        return (session.getAttribute("username") == null || session.getAttribute("userid") == null);
    }
}
