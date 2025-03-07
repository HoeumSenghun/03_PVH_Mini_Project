package org.example;

import org.example.Dao.ProductDaoImp;
import org.example.coontroller.ProductController;
import org.example.view.ProductView;

public class Main {
    public static void main(String[] args) {
        ProductController controller = new ProductController();
        // case 1
        controller.addProduct();
    }
}