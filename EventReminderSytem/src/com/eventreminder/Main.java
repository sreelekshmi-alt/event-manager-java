package com.eventreminder;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        EventDAO eventDAO = new EventDAO();

        // Add a new user
        User user1 = new User("Satheesh", "satheesh@example.com", "pass123");
        userDAO.addUser(user1);

        // Show all users
        userDAO.showAllUsers();

        // Add a new event for user with ID 1
        Event event1 = new Event(1, "Doctorok Appointment", LocalDateTime.of(2025, 9, 2, 15, 30));
        eventDAO.addEvent(event1);

        // Show all events for user ID 1
        eventDAO.showEventsByUser(1);
    }
}
