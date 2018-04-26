package com.chenzhicheng.course.javaee.exp4_1;

import java.sql.*;

public class Database {
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/javaee_exp2_3?" +
            "user=root&password=12345678&useUnicode=true&characterEncoding=UTF8&useSSL=true";
    public Database() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url);
    }

    public String verify(String username, String password) throws Exception {
        boolean verfied = false;
        String uid = null;
        String sql = "select * from user where username=? and password=?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet resultSet = stmt.executeQuery();
        if(resultSet.next()){
            verfied = true;
            uid = resultSet.getString("id");
        }
        stmt.close();
        if(verfied){
            return uid;
        } else {
            return null;
        }
    }

    public boolean addUser(String username, String password) throws Exception {
        boolean success = false;
        String sql = "insert into user(username, password) values(?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        success = stmt.executeUpdate() != 0;
        stmt.close();
        return success;
    }


}
