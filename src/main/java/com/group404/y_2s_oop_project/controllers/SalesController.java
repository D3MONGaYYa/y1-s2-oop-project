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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author D3MON
 */
public class SalesController {
    public static double getTotalSales() {
        double totalSales = 0.0;
        String sql = "SELECT product_id, quantity FROM orders";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");

                double productPrice = ProductController.getProductPriceById(productId);
                double orderTotal = productPrice * quantity;

                totalSales += orderTotal;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalSales;
    }

    public static int getPrecentagesOfCompletedOrdersOutof100() {
        double percentage = 0.0;
        String sql = "SELECT COUNT(*) AS total_orders FROM orders";
        String completedSql = "SELECT COUNT(*) AS completed_orders FROM orders WHERE status = 1";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement totalStmt = conn.prepareStatement(sql);
             PreparedStatement completedStmt = conn.prepareStatement(completedSql);
             ResultSet totalRs = totalStmt.executeQuery();
             ResultSet completedRs = completedStmt.executeQuery()) {

            if (totalRs.next() && completedRs.next()) {
                int totalOrders = totalRs.getInt("total_orders");
                int completedOrders = completedRs.getInt("completed_orders");

                if (totalOrders > 0) {
                    percentage = ((double) completedOrders / totalOrders) * 100;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (int) percentage;
    }

    public static String getCurrentDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentDateTime.format(formatter);
    }

    public static String getHighestSellingProductName() {
        String highestSellingProduct = null;

        Map<Integer, Integer> productQuantities = new HashMap<>();

        String sql = "SELECT product_id, SUM(quantity) AS total_quantity " +
                     "FROM orders " +
                     "GROUP BY product_id " +
                     "ORDER BY total_quantity DESC " +
                     "LIMIT 1";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                int productId = rs.getInt("product_id");
                int totalQuantity = rs.getInt("total_quantity");

                highestSellingProduct = ProductController.getProductNameById(productId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return highestSellingProduct;
    }
}
