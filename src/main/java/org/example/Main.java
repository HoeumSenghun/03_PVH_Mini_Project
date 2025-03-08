package org.example;

import org.example.model.Product;
import org.example.model.ProductModel;
import org.example.view.StoreView;
import org.example.controller.Controller;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StoreView view = new StoreView();
        ProductModel model = new ProductModel();
        System.out.println(model.getProducts());

        while (true) {
            Controller controller = new Controller(model, view);
            controller.displayProductData();
            view.displayMenu();
            String choice = view.getUserChoice();

            switch (choice) {
                case "W":
//                    controller.addProduct();
                    break;
                case "R":
//                    controller.viewProduct();
                    break;
                case "U":
                    controller.updateProduct();
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
                case "E":
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
    }
}
