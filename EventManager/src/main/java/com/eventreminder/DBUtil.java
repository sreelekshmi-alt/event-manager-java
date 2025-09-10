package com.eventreminder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/event_manager?serverTimezone=UTC";
    private static final String USER = "root"; // change if needed
    private static final String PASSWORD = "radhika"; // change to your MySQL password

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL Driver
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found!", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
