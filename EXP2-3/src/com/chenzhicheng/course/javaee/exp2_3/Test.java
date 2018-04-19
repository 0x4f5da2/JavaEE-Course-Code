package com.chenzhicheng.course.javaee.exp2_3;
import java.sql.ResultSet;
public class Test {
    public static void main(String[] args) throws Exception {
        DatabaseBean databaseBean = new DatabaseBean();
        ResultSet resultSet = databaseBean.getOneWeekHistory("1");
        while(resultSet.next()){
            System.out.println(resultSet.getString("productname") + " " +
                    resultSet.getString("productsource") + " " + resultSet.getString("number") +
                    " " + resultSet.getString("shopdate"));
        }
    }
}
