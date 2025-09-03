package com.eventreminder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EventReminderDB?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                "root",
                "radhika"
            );
            System.out.println("Connected successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
