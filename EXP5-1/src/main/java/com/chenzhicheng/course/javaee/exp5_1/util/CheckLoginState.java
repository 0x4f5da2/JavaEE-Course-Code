package com.chenzhicheng.course.javaee.exp5_1.util;

import java.util.Map;

public class CheckLoginState {
    public static boolean check(Map session) {
        return session.get(StringSupport.SESSION_USER_BEAN) != null;
    }
}
