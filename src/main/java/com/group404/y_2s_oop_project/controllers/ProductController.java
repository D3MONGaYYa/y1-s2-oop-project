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
    
    
    public static void stockUpdate(String productName, int quantity, int productID) {
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
    
    public static List<Object[]> getUnallocatedProducts() {
        List<Object[]> unallocatedProducts = new ArrayList<>();
        String sql = "SELECT p.id, p.productName, p.productPrice, p.productStock, p.added_on " +
                     "FROM products p " +
                     "LEFT JOIN supplier_items si ON p.id = si.item_id " +
                     "WHERE si.id IS NULL";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Object[] product = new Object[5]; // Adjust array size as per your columns
                product[0] = rs.getInt("id");
                product[1] = rs.getString("productName");
                product[2] = rs.getDouble("productPrice");
                product[3] = rs.getInt("productStock");
                product[4] = rs.getTimestamp("added_on");
                unallocatedProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return unallocatedProducts;
    }

}
