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

                products.add(new Object[]{productName, productPrice, productStock, "Order"});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

}
