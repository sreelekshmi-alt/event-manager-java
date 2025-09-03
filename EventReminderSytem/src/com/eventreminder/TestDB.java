package com.eventreminder;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        if(con != null) {
            System.out.println("DB is ready! You can add Users and Events now.");
        }
    }
}
