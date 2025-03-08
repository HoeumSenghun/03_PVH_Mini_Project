package org.example.controller;
import org.example.model.Product;
import java.util.*;
import org.example.model.ProductModel;
import org.example.view.StoreView;

public class Controller {
    private ProductModel productModel;
    private StoreView storeView;
    Scanner scanner = new Scanner(System.in);

    public Controller(ProductModel productModel, StoreView storeView) {
        this.productModel = productModel;
        this.storeView = storeView;
    }

    //Method to fetch and display products
    public void displayProductData(){
        List<Product> products = productModel.getProducts();

        storeView.displayProducts(products);
    }


    public void readProduct(){
        // read product to unsaved
        System.out.println("Enter id:");
        int productId = scanner.nextInt();
        Optional<Product>  product =  productModel.getProductById(productId);
        storeView.displayTableRow(product);

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