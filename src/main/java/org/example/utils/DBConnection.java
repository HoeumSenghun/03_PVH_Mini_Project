package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/stockmanagement_db",
                    "postgres",
                    "2025"
            );
        }catch (SQLException sqlException){
            System.out.println("problem connecting to database");
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        getConnection();
    }

}
