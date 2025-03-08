package org.example.model;
import org.example.controller.Controller;
import org.example.view.StoreView;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Unsave {
     ProductModel productModel;
     StoreView storeView;
    private List<Product> unSvaeProducts = new ArrayList<>();
    Controller controller = new Controller(productModel, storeView);

    public void unSaveAdd(Product product) {
        // show the uns product method here
//        controller.displayWriteProduct();


    }
    public void unSaveUpdate(Product product){
        // show
    }
}
