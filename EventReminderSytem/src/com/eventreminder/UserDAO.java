package com.eventreminder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean addUser(User user) {
        try {
            Connection con = DBConnection.getConnection();

            // Check if username or email exists
            PreparedStatement check = con.prepareStatement(
                "SELECT * FROM Users WHERE username=? OR email=?"
            );
            check.setString(1, user.getUsername());
            check.setString(2, user.getEmail());
            ResultSet rs = check.executeQuery();

            if(rs.next()) {
                System.out.println("Error: Username or Email already exists!");
            } else {
                PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO Users(username, email, password) VALUES (?, ?, ?)"
                );
                pst.setString(1, user.getUsername());
                pst.setString(2, user.getEmail());
                pst.setString(3, user.getPassword());
                pst.executeUpdate();
                System.out.println("User added successfully!");
                pst.close();
            }

            rs.close();
            check.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
		return false;
    }

    public void showAllUsers() {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Users");
            ResultSet rs = pst.executeQuery();

            System.out.println("\nID | Username       | Email");
            System.out.println("-------------------------------");
            while(rs.next()) {
                System.out.printf("%-2d | %-12s | %-20s\n",
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("email")
                );
            }

            rs.close();
            pst.close();
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
