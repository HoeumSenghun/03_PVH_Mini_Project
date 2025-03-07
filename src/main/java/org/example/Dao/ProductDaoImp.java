package org.example.Dao;

import org.example.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProductDaoImp implements ProductDao {
    @Override
    public Product insertProduct() {
        // logic to inseert data
        return new Product(1, "", 10, 20, LocalDate.now());
    }

    @Override
    public void readProductById() {

    }

    @Override
    public void updateProduct() {

    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public void searchProduct() {

    }

    @Override
    public void setRow() {

    }

    @Override
    public void save() {

    }

    @Override
    public void unsave() {

    }

    @Override
    public void backupRestore() {

    }

    @Override
    public void restore() {

    }

}
