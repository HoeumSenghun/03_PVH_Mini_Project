package org.example;

import java.sql.Connection;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/stockManagement_db";
        String username = "postgres";
        String password = "root";
        Connection con = null;

        try {
            //Load Driver
            Class.forName("org.postgresql.Driver");
            //Connection
            con = DriverManager.getConnection(url, username, password);
            if(con.isValid(2)) {
                System.out.println("Connection Successful");
            }

        } catch (ClassNotFoundException | SQLException e) {

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) { // Corrected exception
                e.printStackTrace();
            }
        }
    }
}