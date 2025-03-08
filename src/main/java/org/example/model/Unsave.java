package org.example.model;
import java.util.ArrayList;
import java.util.List;

public class Unsave {
    private List<Product> unSvaeProducts = new ArrayList<>();
    public List<UpdateProduct> unSaveUpdate = new ArrayList<>();

    public void unSaveAdd(Product product) {
        // show the uns product method here
    }
    public void unSaveUpdate(UpdateProduct product){

    }

    public List<UpdateProduct> getUnSaveUpdate() {
        return unSaveUpdate;
    }
}
