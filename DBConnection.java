package com.ipl.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ipl_db",
                    "root",
                    "Akhil@123");

            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {
        	System.out.println("DB Error occured ");
            e.printStackTrace();
        }

        return con;
    }
}