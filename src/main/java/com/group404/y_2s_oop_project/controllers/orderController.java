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
public class orderController {
    public static List<Object[]> fetchOrders() {
        List<Object[]> orders = new ArrayList<>();
        String sql = "SELECT `id`, `customer_username`, `product_ID`, `product_name`, `quantity`, `created_on`, `status` FROM `orders` WHERE 1";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String customerUsername = rs.getString("customer_username");
                int productID = rs.getInt("product_ID");
                String productName = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                String createdOn = rs.getString("created_on");
                String status = rs.getString("status");

                orders.add(new Object[]{id, customerUsername, productID, productName, quantity, createdOn, status});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
    
    public static boolean updateOrderStatus(int orderId, int status) {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, status);
            pstmt.setInt(2, orderId);

            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}