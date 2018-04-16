package com.chenzhicheng.course.javaee.exp2_1;
import java.sql.*;

public class ValidateBean {
    public boolean validate(String username, String password){
        boolean verified = false;
        Connection conn = null;
        String sql = null;
        PreparedStatement stmt;
        String url = "jdbc:mysql://localhost:3306/javaee?" +
                "user=root&password=12345678&useUnicode=true&characterEncoding=UTF8&useSSL=true";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            sql = "select * from verification where `username`=? and `password`=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){ verified = true; }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return verified;


    }
}
