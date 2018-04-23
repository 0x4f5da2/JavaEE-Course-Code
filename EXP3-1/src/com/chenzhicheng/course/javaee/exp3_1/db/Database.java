package com.chenzhicheng.course.javaee.exp3_1.db;

import com.chenzhicheng.course.javaee.exp3_1.model.AllHistoryBean;
import com.chenzhicheng.course.javaee.exp3_1.model.OneWeekHistoryBean;
import com.chenzhicheng.course.javaee.exp3_1.model.ProductBean;
import com.chenzhicheng.course.javaee.exp3_1.model.UserBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Database {
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/javaee_exp2_3?" +
            "user=root&password=12345678&useUnicode=true&characterEncoding=UTF8&useSSL=true";

    public Database() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url);
    }

    public String verify(String username, String password) throws Exception {
        boolean verified = false;
        String uid = null;
        String sql = "select * from user where username=? and password=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            verified = true;
            uid = resultSet.getString("id");
        }
        stmt.close();
        if (verified) {
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

    public boolean delUser(String uid) throws Exception {
        boolean success = false;
        String sql = "delete from user where id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, uid);
        success = stmt.executeUpdate() != 0;
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
        success = stmt.executeUpdate() != 0;
        stmt.close();
        return success;
    }

    public boolean delProducts(String pid) throws Exception {
        boolean success = false;
        String sql = "delete from product where id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, pid);
        success = stmt.executeUpdate() != 0;
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
        success = stmt.executeUpdate() != 0;
        stmt.close();
        return success;
    }

    public ResultSet getProducts() throws Exception {
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

    public ResultSet getOneWeekHistory(String uid) throws Exception {
        ResultSet resultSet = null;
        String sql = "select * from shop_record, product where shop_record.productid=product.id and datediff(now(), shop_record.shopdate) < 7 and shop_record.userid=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, uid);
        resultSet = stmt.executeQuery();
        return resultSet;
    }

    public ResultSet getClassfiedHistory(String uid) throws Exception {
        ResultSet resultSet = null;
        String sql = "select productid, productname, productsource, productcode, sum(number) as num from shop_record, product where shop_record.productid=product.id and userid=? group by productid;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, Integer.parseInt(uid));
        resultSet = stmt.executeQuery();
        return resultSet;
    }

    public ArrayList getProductList() throws Exception{
        ResultSet resultSet = this.getProducts();
        ArrayList<ProductBean> arrayList = new ArrayList<>();
        while(resultSet.next()){
            String pc = resultSet.getString("productcode");
            String pn = resultSet.getString("productname");
            String ps = resultSet.getString("productsource");
            String id = resultSet.getString("id");
            arrayList.add(new ProductBean(pc, pn, ps, id));
        }
        return arrayList;
    }

    public ArrayList getUserList() throws Exception{
        ResultSet resultSet = this.getUsers();
        ArrayList<UserBean> arrayList = new ArrayList<>();
        while(resultSet.next()){
            String un = resultSet.getString("username");
            String pw = resultSet.getString("password");
            String id = resultSet.getString("id");
            arrayList.add(new UserBean(un, pw, id));
        }
        return arrayList;
    }

    public ArrayList getOneWeekHistoryList(String uid) throws Exception {
        ResultSet resultSet = this.getOneWeekHistory(uid);
        ArrayList<OneWeekHistoryBean> arrayList = new ArrayList<>();
        while(resultSet.next()){
            String pc = resultSet.getString("productcode");
            String pn = resultSet.getString("productname");
            String ps = resultSet.getString("productsource");
            String date = resultSet.getString("shopdate");
            arrayList.add(new OneWeekHistoryBean(pc, pn, ps, date));
        }
        return arrayList;
    }

    public ArrayList getAllHistoryList(String uid) throws Exception {
        ResultSet resultSet = this.getClassfiedHistory(uid);
        ArrayList<AllHistoryBean> arrayList = new ArrayList<>();
        while(resultSet.next()) {
            String pc = resultSet.getString("productcode");
            String pn = resultSet.getString("productname");
            String ps = resultSet.getString("productsource");
            String num = resultSet.getString("num");
            arrayList.add(new AllHistoryBean(pc, pn, ps, num));
        }
        return arrayList;
    }
}
