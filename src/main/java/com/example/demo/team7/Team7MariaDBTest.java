package com.example.demo.team7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Team7MariaDBTest {
    public static void main(String[] args) {

        String url = "jdbc:mariadb://3.219.123.102:3306";
        String user = "root";
        String password = "passg7";
        

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("MariaDBへの接続に成功しました！");

            //stmt.execute("USE kadai_db_7"); 
            stmt.execute("USE kensyu26db"); 
            
            //String sql = "SELECT * FROM users_7";
            String sql = "SELECT * FROM users7";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getString("email") + ", 名前: " + rs.getString("name"));
                }
            }

        } catch (SQLException e) {
            System.err.println("接続またはクエリの実行に失敗しました。");
            e.printStackTrace();
         
        }
    }
}


