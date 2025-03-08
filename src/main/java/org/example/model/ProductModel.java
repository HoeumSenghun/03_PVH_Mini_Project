package org.example.model;
import org.example.utils.Utils;

import java.sql.*;
import java.util.*;


public class ProductModel {
    //Method to get list from products
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        try {
            Connection  conn = Utils.connection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM stock_tb");
            while(rs.next()){
                // declare variable to store each data from db
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double  unit_price = rs.getDouble ("unit_price");
                int qty = rs.getInt("stock_qty");
                String imported_date = rs.getString("imported_date");
                // Add each data to ArrayList
                products.add(new Product(id, name, unit_price, qty, imported_date));
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    // Method get search product by name
    public List<Product> getProductsByName(String name) {
        List<Product> productsName = new ArrayList<>();
        try {
            Connection  conn = Utils.connection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM stock_tb WHERE name ILIKE '%"+name+"%'");
//            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
//                System.out.println(rs.getString("name"));

//                if (rs.getString("name").equals(name)){
                    int id = rs.getInt("id");
                    String byName = rs.getString("name");
                    double  unit_price = rs.getDouble ("unit_price");
                    int qty = rs.getInt("stock_qty");
                    String imported_date = rs.getString("imported_date");
                    // Add each data to ArrayList
                    productsName.add(new Product(id, byName, unit_price, qty, imported_date));
                }
                conn.close();
//            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return productsName;

    }
}
