package com.chenzhicheng.course.javaee.exp6.database;

import com.chenzhicheng.course.javaee.exp6.model.LyTable;
import com.chenzhicheng.course.javaee.exp6.model.User;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/javaee_exp5_1?" +
            "user=root&password=12345678&useUnicode=true&characterEncoding=UTF8&useSSL=true";

    public Database() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url);
    }

    public User verify(String username, String password) {
        boolean verfied = false;
        int permissionLevel = -1;
        int userID = -1;
        String sql = "select * from usertable where username=? and password=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                permissionLevel = resultSet.getInt("permission");
                userID = resultSet.getInt("id");
                verfied = true;
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (verfied && userID != -1 && permissionLevel != -1) {
            return new User(userID, null, null, permissionLevel);
        } else {
            return null;
        }
    }

    public boolean addComment(String uid, String title, String content) {
        boolean success = false;
        String sql = "insert into lyTable (userId, date, title, content) values(?,now(),?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, uid);
            stmt.setString(2, title);
            stmt.setString(3, content);
            success = stmt.executeUpdate() != 0;
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean addUser(String username, String password, int permission) {
        boolean success = false;
        String sql = "insert into usertable(username, password, permission) values(?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, permission);
            success = stmt.executeUpdate() != 0;
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public ArrayList findLyInfo(User user) {
        String sql = "SELECT * FROM javaee_exp5_1.lytable, javaee_exp5_1.usertable where lytable.userId = usertable.id";
        if (user.getPermission() == 0) {
            sql += " and usertable.id = " + user.getId() + ";";
        }
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ArrayList al = new ArrayList();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                al.add(
                        new LyTable(
                                rs.getString("username"),
                                rs.getDate("date").toString(),
                                rs.getString("title"),
                                rs.getString("content")
                        )
                );
            }
            return al;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasSameTitle(String title) {
        String sql = "select count(*) as cnt from lytable where title=?;";
        boolean result = true;
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, title);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                int cnt = resultSet.getInt("cnt");
                if(cnt == 0){
                    result = false;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
