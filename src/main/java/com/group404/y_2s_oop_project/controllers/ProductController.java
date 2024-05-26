/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group404.y_2s_oop_project.controllers;
import com.group404.y_2s_oop_project.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author D3MON
 */
public class ProductController {
    
    public static List<Object[]> fetchProducts() {
        List<Object[]> products = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id, productName, productPrice, productStock, added_on FROM products");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String productName = resultSet.getString("productName");
                double productPrice = resultSet.getDouble("productPrice");
                int productStock = resultSet.getInt("productStock");

                products.add(new Object[]{productId, productName, productPrice, productStock, "Order"});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
    
    public static boolean createOrder(String productName, int quantity, int productID) {
        String sql = "INSERT INTO orders (customer_username, product_ID, product_name, quantity) VALUES (?,?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, UserController.getLoggedInUsername());
            pstmt.setInt(2, productID);
            pstmt.setString(3, productName);
            pstmt.setInt(4, quantity);

            pstmt.executeUpdate();
            
            stockUpdate(productName, quantity, productID);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private static void stockUpdate(String productName, int quantity, int productID) {
        String sql = "UPDATE products SET productStock = productStock - ? WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, quantity);
            pstmt.setInt(2, productID);

            pstmt.executeUpdate();
            System.out.println("Stock Updated !");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Stock Updated Failed !");
        }
    }

}
