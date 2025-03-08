package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class utils {
    // connection method
    static String password= "password";
    static String userName = "postgres";

    public static Connection connection() throws SQLException {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stocks",userName,password);

        }catch (SQLException e){
            System.out.println("connection failed");
            System.out.println(e);
        }
        return  connection;
    }

    // testing method
    public static void main(String[] args) throws SQLException {
        connection();
    }
}
