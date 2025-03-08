package service;

import Connection.Connections;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Product> getAllProducts(int limit, int offset) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products LIMIT ? OFFSET ?";

        try (Connection connection = Connections.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("unit_price"),
                        rs.getInt("quantity"),
                        rs.getDate("imported_date").toLocalDate()
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // insert product
    public boolean insertProduct(Product product) {
        String query = "INSERT INTO products (name, unit_price, quantity, imported_date) VALUES (?, ?, ?, ?)";
        try (Connection connection = Connections.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, product.getName());
            ps.setDouble(2, product.getUnitPrice());
            ps.setInt(3, product.getQuantity());
            ps.setDate(4, Date.valueOf(product.getImportedDate()));

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
