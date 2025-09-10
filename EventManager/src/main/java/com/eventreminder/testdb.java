package com.eventreminder;

import java.sql.Connection;
import java.sql.DriverManager;

public class testdb {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/event_manager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";      // change if your MySQL user is different
        String password = "radhika";  // change to your MySQL password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load driver
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Database connected successfully!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
