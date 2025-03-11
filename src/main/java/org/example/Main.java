package org.example;

import org.example.model.Product;
import org.example.model.ProductModel;
import org.example.model.Unsave;
import org.example.view.StoreView;
import org.example.controller.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException{
        Scanner sc = new Scanner(System.in);
        StoreView view = new StoreView();
        ProductModel model = new ProductModel();
        System.out.println(model.getProducts());
        boolean running = true;
        Unsave unsave = new Unsave();

        while (running) {
            Controller controller = new Controller(model, view);
            controller.displayProductData();
            view.displayMenu();
            String choice = view.getUserChoice();

            switch (choice) {
                case "W":
                    controller.writeProduct(unsave);
                    break;
                case "R":
                    controller.readProduct();
                    break;
                case "U":
                    controller.updateProduct(unsave);
                    break;
                case "D":
                    controller.deleteProduct();
                    break;
                case "N":
//                    controller.nextPage();
                    break;
                case "P":
//                    controller.previousPage();
                    break;
                case "S":
                    System.out.print("Input Product Name:");
                    String name = sc.nextLine();
                    controller.searchProduct(name);
                    break;
                case "SA" :
                    controller.saveProduct(unsave);
                    break;
                case "UN":
                    controller.unSaveProduct(unsave);
                    break;
                case "E":
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
    }
}
