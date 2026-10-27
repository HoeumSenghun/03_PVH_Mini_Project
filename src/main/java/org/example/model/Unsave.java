package org.example.model;
import org.example.controller.Controller;
import org.example.view.StoreView;

import java.util.ArrayList;
import java.util.List;


public class Unsave {
    public List<Product> unSaveProducts = new ArrayList<>();
    public List<UpdateProduct> unSaveUpdate = new ArrayList<>();
    private StoreView storeView;
    Controller controller = new Controller();


    public void unSaveAdd(List<Product> product) {
//         show the uns product method here
        storeView.displayProducts(product);


    }
    public void unSaveUpdate(UpdateProduct product){

    }

    public List<UpdateProduct> getUnSaveUpdate() {
        return unSaveUpdate;
    }
}
