package org.example.controller;
import org.example.model.Product;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

import org.example.model.ProductModel;
import org.example.model.Unsave;
import org.example.utils.Utils;
import org.example.view.StoreView;

public class Controller {
    private ProductModel productModel;
    private StoreView storeView;
    static Scanner scanner = new Scanner(System.in);
    //arraylist to store temporary product
    private List<Product> tempProduct = new ArrayList<>();
//    private Connection conn;
//    private String sql = "";
//    private String qry = "";
//    private Statement stmt;
//    private PreparedStatement

    //static variables for writeProduct
    int id;
    String name;
    double price;
    int qty;
    String date;


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
    }
    public void writeProduct(){
        // write product
        id = tempProduct.size
        date = String.valueOf(LocalDate.now());
        System.out.println("==========) INSERT AN PRODUCT (==========");
        System.out.println("ID:\t" + id);
        System.out.print("Input Product Name:\t");
        name = scanner.next();
        scanner.nextLine();
        System.out.print("Input Product Price:\t");
        price = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Input Product Quantity:\t");
        qty = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Imported Date:\t"+date);
        tempProduct.add(new Product(id, name, price, qty, date));
        storeView.displayProducts(tempProduct);

    }

//    public void displayWriteProduct(){
//        while (true){
//            tempProduct.add(new Product(id, name, price, qty, date));
//            storeView.displayProducts(tempProduct);
//        }
//    }
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
    public void  deleteProduct() throws RuntimeException, SQLException {
        // delete logic
//        String deleteSQL = "CALL delete_stock_item(?);";
//        String deleteQuery = "SELECT * FROM stock_tb;";
//        List<Product> products = productModel.getProducts();

        Connection conn = Utils.connection();
        System.out.println("==========) DELETE PRODUCT BY ID (==========");
        System.out.print("Input ID:\t");
        int id = scanner.nextInt();
        scanner.nextLine();
        int deleteResult =0;
        try
            {
                PreparedStatement pstmt = conn.prepareStatement("CALL delete_stock_item(?)");
                pstmt.setInt(1, id);
                deleteResult = pstmt.executeUpdate();
                if (deleteResult > 0){
                    System.out.println("Product deleted successfully!");
                } else {
                    System.out.println("No product found with ID " + id);
                }
//            System.out.print("Delete record by ID");
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
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