package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class utils {
    // connection method
    static String password= "password";
    static String userName = "postgres";

    static void connection () throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stocks",userName,password);){
            System.out.println("connection successfully");
        }catch (SQLException e){
            System.out.println("connection failed");
            System.out.println(e);
        }
    }

    // testing method
    public static void main(String[] args) throws SQLException {
        connection();
    }
}
