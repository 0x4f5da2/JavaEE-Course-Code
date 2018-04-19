package com.chenzhicheng.course.javaee.exp2_3;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseBean {
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/javaee_exp2_3?" +
            "user=root&password=12345678&useUnicode=true&characterEncoding=UTF8&useSSL=true";

    public DatabaseBean() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url);
    }

    public String verify (String username, String password) throws Exception {
        boolean verified = false;
        String uid = null;
        String sql = "select * from user where username=? and password=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet resultSet = stmt.executeQuery();
        if(resultSet.next()){
            verified = true;
            uid = resultSet.getString("id");
        }
        stmt.close();
        if(verified){
            return uid;
        } else {
            return null;
        }
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

    public boolean addShopRecord(String uid, String pid, String num) throws Exception {
        boolean success = false;
        String sql = "insert into shop_record(userid, productid, number, shopdate) values(?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, uid);
        stmt.setString(2, pid);
        stmt.setString(3, num);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        stmt.setString(4, simpleDateFormat.format(date));
        success = stmt.executeUpdate()!=0;
        stmt.close();
        return success;
    }

    public ResultSet getProducts() throws Exception{
        ResultSet resultSet;
        String sql = "select * from product;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        resultSet = stmt.executeQuery();
        return resultSet;
    }

    public ResultSet getUsers() throws Exception {
        ResultSet resultSet;
        String sql = "select * from user";
        PreparedStatement stmt = connection.prepareStatement(sql);
        resultSet = stmt.executeQuery();
        return resultSet;
    }

    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public ResultSet getOneWeekHistory(String uid) throws Exception{
        ResultSet resultSet = null;
        String sql = "select * from shop_record, product where shop_record.productid=product.id and datediff(now(), shop_record.shopdate) < 7 and shop_record.userid=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, uid);
        resultSet = stmt.executeQuery();
        return resultSet;
    }

    public ResultSet getClassfiedHistory(String uid) throws Exception{
        ResultSet resultSet = null;
        String sql = "select productid, productname, productsource, productcode, sum(number) as num from shop_record, product where shop_record.productid=product.id and userid=? group by productid;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, Integer.parseInt(uid));
        resultSet = stmt.executeQuery();
        return resultSet;
    }
}
