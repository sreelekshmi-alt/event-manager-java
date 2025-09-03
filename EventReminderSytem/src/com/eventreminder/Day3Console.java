package com.eventreminder;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Day3Console {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        EventDAO eventDAO = new EventDAO();

        while(true) {
            System.out.println("\n--- Event Reminder System ---");
            System.out.println("1. Add User");
            System.out.println("2. Show All Users");
            System.out.println("3. Add Event");
            System.out.println("4. Show Events by User ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();
                    userDAO.addUser(new User(username, email, password));
                    break;

                case 2:
                    userDAO.showAllUsers();
                    break;

                case 3:
                    System.out.print("Enter user ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter event name: ");
                    String eventName = sc.nextLine();
                    System.out.print("Enter event time (YYYY-MM-DDTHH:MM): ");
                    String timeStr = sc.nextLine();
                    LocalDateTime eventTime = LocalDateTime.parse(timeStr);
                    eventDAO.addEvent(new Event(userId, eventName, eventTime));
                    break;

                case 4:
                    System.out.print("Enter user ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    eventDAO.showEventsByUser(id);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}
