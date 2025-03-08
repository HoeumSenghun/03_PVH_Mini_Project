package org.example.controller;
import org.example.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import org.example.model.ProductModel;
import org.example.model.Unsave;
import org.example.model.UpdateProduct;
import org.example.utils.Utils;
import org.example.view.StoreView;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class Controller {
    private ProductModel productModel;
    private StoreView storeView;

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
    }
    public void saveProduct(){
        //save product to database
    }
    public void unSaveProduct(){
        Scanner scanner = new Scanner(System.in);
        String saveOpt;
        while (true){
            System.out.println("[UI] for saving insert product and [UU] for saving update products or [B] for back to menu.");
            System.out.print("Enter you option: ");
            saveOpt = scanner.nextLine();
            if(saveOpt.equalsIgnoreCase("ui") || saveOpt.equalsIgnoreCase("uu") || saveOpt.equalsIgnoreCase("b")){
                break;
            }
            System.out.println("Invalid option! ");

        }
        Unsave unsave = new Unsave();
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Name", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Unit Price ($)", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Quantity", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Import Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));

        if(saveOpt.equalsIgnoreCase("ui")){
           unsave.unSaveProducts.add(new Product(1,"cola",2.5,7,"20-20-20"));
           unsave.unSaveProducts.add(new Product(1,"cola",2.5,7,"20-20-20"));
            if(unsave.unSaveProducts.size()>0){
                unsave.unSaveProducts.forEach((un)->{
                    table.addCell(String.valueOf(un.getId()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                    table.addCell(un.getName(), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                    table.addCell(String.valueOf(un.getPrice()) + "$", new CellStyle(CellStyle.HorizontalAlign.CENTER));
                    table.addCell(String.valueOf(un.getQuantity()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                    table.addCell(un.getImportDate(), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                });
                System.out.println(table.render());
            }else{
                System.out.println("there no unsave product");
            }

        }else if(saveOpt.equalsIgnoreCase("uu")){
            unsave.unSaveUpdate.add(new UpdateProduct(1,"cola",2.5,7,"20-20-20"));
            unsave.unSaveUpdate.add(new UpdateProduct(1,"cola",2.5,7,"20-20-20"));
            if(unsave.unSaveUpdate.size()>0){
                unsave.unSaveUpdate.forEach((un)->{
                    table.addCell(String.valueOf(un.getId()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                    table.addCell(un.getName(), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                    table.addCell(String.valueOf(un.getPrice()) + "$", new CellStyle(CellStyle.HorizontalAlign.CENTER));
                    table.addCell(String.valueOf(un.getQuantity()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                    table.addCell(un.getImportDate(), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                });
                System.out.println(table.render());
            }else{
                System.out.println("there no unsave update");
            }

        }



    }
    public void getProduct(){
        //get product from database
    }
    public void updateProduct() throws SQLException {
        Unsave unsave = new Unsave();
        Scanner scanner = new Scanner(System.in);
        int Updateid;

        while (true) {
            System.out.print("Input ID to update: ");
            try {
                Updateid = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Wrong format");
                scanner.nextLine();
            }
        }

        PreparedStatement preparedStatement = Utils.connection().prepareStatement("SELECT * FROM stock_tb WHERE id = ?");
        preparedStatement.setInt(1, Updateid);
        ResultSet rs = preparedStatement.executeQuery();

        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Name", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Unit Price ($)", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Quantity", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Import Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));

        int id = 0;
        String name = "";
        double price = 0;
        int qty = 0;
        String date = "";

        if (rs.next()) {
            id = rs.getInt("id");
            name = rs.getString("name");
            price = rs.getDouble("unit_price");
            qty = rs.getInt("stock_qty");
            date = String.valueOf(rs.getDate("imported_date"));

            table.addCell(String.valueOf(id), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(name, new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(String.valueOf(price) + "$", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(String.valueOf(qty), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(date, new CellStyle(CellStyle.HorizontalAlign.CENTER));

            System.out.println(table.render());
        } else {
            System.out.println("Product ID not found.");
            return;
        }

        int updateOption = 0;
        boolean isUpdated = false;

        while (true) {
            System.out.println("1. Name\t2. Unit Price\t3. Quantity\t4. All Fields\t5. Exit");
            System.out.print("Choose an option to update: ");

            String optionInput = scanner.nextLine().trim(); // Read input as string to prevent Enter key issue

            if (optionInput.isEmpty()) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            try {
                updateOption = Integer.parseInt(optionInput);

                if (updateOption == 5) {
                    break;
                }

                switch (updateOption) {
                    case 1:
                        while (true) {
                            System.out.print("Enter Name: ");
                            String newName = scanner.nextLine().trim();
                            if (!newName.isEmpty()) {
                                name = newName;
                                isUpdated = true;
                                break;
                            } else {
                                System.out.println("Name cannot be empty! Please enter again.");
                            }
                        }
                        break;
                    case 2:
                        while (true) {
                            System.out.print("Enter Price: ");
                            String priceInput = scanner.nextLine().trim();
                            if (!priceInput.isEmpty() && priceInput.matches("\\d+(\\.\\d+)?")) {
                                double newPrice = Double.parseDouble(priceInput);
                                if (newPrice > 0) {
                                    price = newPrice;
                                    isUpdated = true;
                                    break;
                                }
                            }
                            System.out.println("Invalid price! Please enter a valid positive number.");
                        }
                        break;
                    case 3:
                        while (true) {
                            System.out.print("Enter Quantity: ");
                            String qtyInput = scanner.nextLine().trim();
                            if (!qtyInput.isEmpty() && qtyInput.matches("\\d+")) {
                                int newQty = Integer.parseInt(qtyInput);
                                if (newQty >= 0) {
                                    qty = newQty;
                                    isUpdated = true;
                                    break;
                                }
                            }
                            System.out.println("Invalid quantity! Please enter a valid non-negative number.");
                        }
                        break;
                    case 4:
                        // Validate name
                        while (true) {
                            System.out.print("Enter Name: ");
                            String newAllName = scanner.nextLine().trim();
                            if (!newAllName.isEmpty()) {
                                name = newAllName;
                                break;
                            }
                            System.out.println("Name cannot be empty! Please enter again.");
                        }

                        // Validate price
                        while (true) {
                            System.out.print("Enter Price: ");
                            String priceAllInput = scanner.nextLine().trim();
                            if (!priceAllInput.isEmpty() && priceAllInput.matches("\\d+(\\.\\d+)?")) {
                                double newAllPrice = Double.parseDouble(priceAllInput);
                                if (newAllPrice > 0) {
                                    price = newAllPrice;
                                    break;
                                }
                            }
                            System.out.println("Invalid price! Please enter a valid positive number.");
                        }

                        // Validate quantity
                        while (true) {
                            System.out.print("Enter Quantity: ");
                            String qtyAllInput = scanner.nextLine().trim();
                            if (!qtyAllInput.isEmpty() && qtyAllInput.matches("\\d+")) {
                                int newAllQty = Integer.parseInt(qtyAllInput);
                                if (newAllQty >= 0) {
                                    qty = newAllQty;
                                    break;
                                }
                            }
                            System.out.println("Invalid quantity! Please enter a valid non-negative number.");
                        }

                        isUpdated = true;
                        break;
                    default:
                        System.out.println("Invalid option! Please choose a valid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        if (isUpdated) {
//            unsave.unSaveUpdate.add(new UpdateProduct(id, name, price, qty, date));
            // test print
            System.out.println(unsave.unSaveUpdate.getFirst().toString());
        } else {
            System.out.println("No changes were made.");
        }

        System.out.println("Press Enter to continue...");
        scanner.nextLine();
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