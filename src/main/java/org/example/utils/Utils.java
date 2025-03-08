package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
    // connection method
    //root
    static String password= "root";
    static String userName = "postgres";

    public static Connection connection () throws SQLException {
        Connection connection = null;
        //stockManagement_db
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stockManagement_db",userName,password);
            System.out.println("connection successfully");
        }catch (SQLException e){
            System.out.println("connection failed");
            System.out.println(e);
        }
        
        return connection;
    }
}