package org.example.view;

import org.example.model.Product;

import java.util.ArrayList;
import java.util.List;

public class StoreView {

    private List<Product> products = new ArrayList<>();

    public StoreView() {
        products.add(new Product(1, "Apple", 1.5, 100, "2025-03-01"));
        products.add(new Product(2, "Banana", 1.2, 120, "2025-03-02"));
        products.add(new Product(3, "Orange", 1.8, 80, "2025-03-03"));
        products.add(new Product(4, "Mango", 2.5, 50, "2025-03-04"));
        products.add(new Product(5, "Grapes", 3.0, 60, "2025-03-05"));
        products.add(new Product(6, "Pineapple", 2.0, 30, "2025-03-06"));
        products.add(new Product(7, "Peach", 1.7, 90, "2025-03-07"));
        products.add(new Product(8, "Watermelon", 4.0, 25, "2025-03-08"));
        products.add(new Product(9, "Blueberry", 3.5, 40, "2025-03-09"));
        products.add(new Product(10, "Strawberry", 2.8, 70, "2025-03-10"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public boolean insertProduct(Product product) {
        // add products to Lis<> if it true
        return products.add(product);
    }

    public void displayProducts(List<Product> products) {
        System.out.println("=== Product List ===");
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + " | Name: " + product.getName() +
                    " | Price: $" + product.getPrice() + " | Quantity: " + product.getQuantity() +
                    " | Imported Date: " + product.getImportDate());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}