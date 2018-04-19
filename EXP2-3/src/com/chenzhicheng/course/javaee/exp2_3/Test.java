package com.chenzhicheng.course.javaee.exp2_3;
import java.sql.ResultSet;
public class Test {
    public static void main(String[] args) throws Exception {
        DatabaseBean databaseBean = new DatabaseBean();
        databaseBean.delUser("6");
    }
}
