package view;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductView {
    public void displayProducts(ArrayList<Product> products) {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
}
