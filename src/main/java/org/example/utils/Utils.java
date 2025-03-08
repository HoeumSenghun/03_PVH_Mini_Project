package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
    // connection method
    static String password= "nguon$$w0rd";
    static String userName = "postgres";

    public static Connection connection () throws SQLException {
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:3000/stockmanagement_db",userName,password);
            System.out.println("connection successfully");
        }catch (SQLException e){
            System.out.println("connection failed");
            System.out.println(e);
        }
        
        return connection;
    }
}