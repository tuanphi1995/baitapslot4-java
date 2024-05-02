package baitapSlot04Bai02;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    // Add a new product
    public void addProduct(String name, double price, int quantity) throws SQLException {
        String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();
        }
    }

    // Search for a product by name
    public List<String> searchProduct(String name) throws SQLException {
        String sql = "SELECT * FROM products WHERE name LIKE ?";
        List<String> products = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add("ID: " + rs.getInt("product_id") + ", Name: " + rs.getString("name"));
            }
        }
        return products;
    }

    // Delete a product by ID
    public void deleteProduct(int productId) throws SQLException {
        String sql = "DELETE FROM products WHERE product_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, productId);
            stmt.executeUpdate();
        }
    }

    // Display all products
    public List<String> getAllProducts() throws SQLException {
        String sql = "SELECT * FROM products";
        List<String> products = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add("ID: " + rs.getInt("product_id") + ", Name: " + rs.getString("name") + ", Quantity: " + rs.getInt("quantity"));
            }
        }
        return products;
    }

    // Display out-of-stock products
    public List<String> getOutOfStockProducts() throws SQLException {
        String sql = "SELECT * FROM products WHERE quantity = 0";
        List<String> products = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add("ID: " + rs.getInt("product_id") + ", Name: " + rs.getString("name"));
            }
        }
        return products;
    }

    // Display best-selling products
    public List<String> getBestSellers() throws SQLException {
        String sql = "SELECT * FROM products WHERE is_best_seller = TRUE";
        List<String> products = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add("ID: " + rs.getInt("product_id") + ", Name: " + rs.getString("name"));
            }
        }
        return products;
    }
}
