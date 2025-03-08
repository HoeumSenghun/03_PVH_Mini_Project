package org.example;

import org.example.view.StoreView;
import org.example.controller.controller;

public class Main {
    public static void main(String[] args) {
        StoreView view = new StoreView();
//        Controller controller = new Controller();
        controller controller = new controller();

        while (true) {
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
                    controller.searchProduct();
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
