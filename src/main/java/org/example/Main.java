package org.example;

import org.example.controller.Controller;
import org.example.model.Product;

import java.sql.Connection;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Controller ctrl = new Controller();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStock Management System");
            System.out.println("1. Write");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n======== Stock Management System ========");
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter import date (DD-MM-YYYY): ");
                    String importDate = scanner.nextLine();

                    Product newProduct = new Product(id, name, price, quantity, importDate);
                    ctrl.writeProduct(newProduct);
                    break;
                case 2:
                    ctrl.readProduct();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!! Try again..");
            }
        }
//        String url = "jdbc:postgresql://localhost:5432/stockManagement_db";
//        String username = "postgres";
//        String password = "root";
//        Connection con = null;
//
//        try {
//            //Load Driver
//            Class.forName("org.postgresql.Driver");
//            //org.example.Connection
//            con = DriverManager.getConnection(url, username, password);
//            if(con.isValid(2)) {
//                System.out.println("org.example.Connection Successful");
//            }
//
//        } catch (ClassNotFoundException | SQLException e) {
//
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) { // Corrected exception
//                e.printStackTrace();
//            }
//        }
//        System.out.println("Hello World");
//        System.out.println("Hello World");
    }
}