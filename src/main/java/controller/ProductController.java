package controller;

import model.Product;
import model.ProductModelImplement;
import view.ProductView;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    ProductView pv;
    ProductModelImplement pmi;

    public ProductController(ProductView pv, ProductModelImplement pmi) {
        this.pv = pv;
        this.pmi = pmi;
    }

    public void getAllProducts() {

        // alert to model
        ArrayList <Product> products = (ArrayList<Product>) pmi.getAllProductsFromDatabase();

        //from view
        pv.displayProducts(products);
    }
}
