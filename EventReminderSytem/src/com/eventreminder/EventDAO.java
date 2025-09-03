package com.eventreminder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

public class EventDAO {

    public void addEvent(Event event) {
        try {
            Connection con = DBConnection.getConnection();

            // Check if user exists
            PreparedStatement checkUser = con.prepareStatement(
                "SELECT * FROM Users WHERE user_id=?"
            );
            checkUser.setInt(1, event.getUserId());
            ResultSet rs = checkUser.executeQuery();

            if(!rs.next()) {
                System.out.println("Error: User does not exist!");
                rs.close();
                checkUser.close();
                con.close();
                return;
            }

            // Check future time
            if(event.getEventTime().isBefore(LocalDateTime.now())) {
                System.out.println("Error: Event time must be in the future!");
                rs.close();
                checkUser.close();
                con.close();
                return;
            }

            // Insert event
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO Events(user_id, event_name, event_time) VALUES (?, ?, ?)"
            );
            pst.setInt(1, event.getUserId());
            pst.setString(2, event.getEventName());
            pst.setString(3, event.getEventTime().toString());
            pst.executeUpdate();

            System.out.println("Event added successfully!");

            rs.close();
            checkUser.close();
            pst.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void showEventsByUser(int userId) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(
                "SELECT * FROM Events WHERE user_id=? ORDER BY event_time ASC"
            );
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            System.out.println("\nEvent Name         | Event Time");
            System.out.println("---------------------------------------");
            while(rs.next()) {
                System.out.printf("%-16s | %s\n",
                    rs.getString("event_name"),
                    rs.getString("event_time")
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
