package org.example.Dao;

import org.example.model.Product;

public interface ProductDao {
    Product insertProduct();
    void readProductById();
    void updateProduct();
    void deleteProduct();
    void searchProduct();
    void setRow();
    void save();
    void unsave();
    void backupRestore();
    void restore();
}
