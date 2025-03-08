package org.example.controller;

import org.example.model.Product;
import org.example.view.StoreView;

import java.util.List;

public class Controller {
    private StoreView storeView;

    public Controller() {
        this.storeView = new StoreView();
    }

    public void readProduct() {
        List<Product> products = storeView.getAllProducts();
        storeView.displayProducts(products);
    }

    public void writeProduct(Product product) {
        boolean success = storeView.insertProduct(product);
        if (success) {
            storeView.displayMessage("Product added successfully!");
        } else {
            storeView.displayMessage("Failed to add product.");
        }
    }
}
