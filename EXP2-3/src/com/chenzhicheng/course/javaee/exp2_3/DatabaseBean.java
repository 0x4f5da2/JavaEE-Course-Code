package com.chenzhicheng.course.javaee.exp2_3;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseBean {
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/javaee?" +
            "user=root&password=12345678&useUnicode=true&characterEncoding=UTF8&useSSL=true";

    public DatabaseBean() throws Exception {
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
        stmt.setString(1, username);
        stmt.setString(2, password);
        success = stmt.executeUpdate()!=0;
        stmt.close();
        return success;
    }

    public boolean delUser(String uid) throws Exception{
        boolean success = false;
        String sql = "delete from user where id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, uid);
        success = stmt.executeUpdate()!=0;
        stmt.close();
        return success;

    }

    public boolean addProduct(String productCode, String productName, String productSource) throws Exception {
        boolean success = false;
        String sql = "insert into product(productcode, productname, productsource) values(?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, productCode);
        stmt.setString(2, productName);
        stmt.setString(3, productSource);
        success = stmt.executeUpdate()!=0;
        stmt.close();
        return success;
    }

    public boolean delProducts(String pid) throws Exception {
        boolean success = false;
        String sql = "delete from product where id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, pid);
        success = stmt.executeUpdate()!=0;
        stmt.close();
        return success;
    }

    boolean addShopRecord(String uid, String pid, String num, String date) throws Exception {
        boolean success = false;
        String sql = "insert into shop_record(userid, productid, numbers, shopdate) values(?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, uid);
        stmt.setString(2, pid);
        stmt.setString(3, num);
        stmt.setString(4, date);
        success = stmt.executeUpdate()!=0;
        stmt.close();
        return success;
    }

    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
