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

    public Optional<Product> getProductById(int id) {
        String sql = "SELECT * FROM stock_tb WHERE id = ?";

        try {
            Connection  conn = Utils.connection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                Product product =new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("unit_price"),
                        rs.getInt("stock_qty"),
                        rs.getString("imported_date")
                );
                return Optional.of(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
}
