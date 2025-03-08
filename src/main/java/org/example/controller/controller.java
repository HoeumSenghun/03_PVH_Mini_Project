package org.example.controller;

import org.example.model.Product;
import org.example.view.StoreView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class controller {
    private Product product;
    private StoreView storeView;

    public void readProduct(){
        // read product to unsaved
    }
    public void writeProduct(){
        // write product
    }
    public void saveProduct(){
        //save product to database
    }
    public void unSaveProduct(){
        //
    }
    public void getProduct(){
        //get product from database
    }
    public void updateProduct(){
        // update pro
    }
    public void searchProduct(){
        //search logic
    }
    public void  deleteProduct(){
        // delete logic
//        String sql = "DELETE FROM products WHERE id = ?";
//        Connection connection;
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setInt(1, id);
//            int deleted = stmt.executeUpdate();
//            if (deleted > 0) {
//                System.out.println("Product deleted successfully!");
//            } else {
//                System.out.println("No product found with ID " + id);
//            }
//        } catch (SQLException e) {
//            System.err.println("Error deleting product: " + e.getMessage());
//        }
    }
    /// =========== backup and restore
    public void backUp(){
        // back up logic
    }
    public void restore(){
        //restore logic
    }
}