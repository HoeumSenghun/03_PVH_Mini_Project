package org.example.view;

import org.example.model.Product;

import java.util.ArrayList;

public class ProductView {
    ArrayList<Product> insertProduct = new ArrayList<>();
    ArrayList<Product> updateProduct = new ArrayList<>();

    public void insertProduct(Product product) {
        insertProduct.add(product);
    }

}
