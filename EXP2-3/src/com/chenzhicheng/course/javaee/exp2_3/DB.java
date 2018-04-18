package com.chenzhicheng.course.javaee.exp2_3;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/javaee?" +
            "user=root&password=12345678&useUnicode=true&characterEncoding=UTF8&useSSL=true";

    public DB() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url);
    }

    public boolean verify (String username, String password) throws Exception {
        boolean verified = false;
        String sql = "select * from username where username=? and password=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet resultSet = stmt.executeQuery();
        if(resultSet.next()){verified = true;}
        stmt.close();
        return verified;
    }

    public boolean addUser(String username, String password) throws Exception{
        boolean success = false;
        String sql = "insert into user(username, password) values(?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();
        //todo
    }

    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
