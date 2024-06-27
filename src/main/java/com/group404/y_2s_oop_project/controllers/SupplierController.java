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
public class SupplierController {
    
    public static boolean addNewSupplier(String supName, String companyName, String email) {
        String sql = "INSERT INTO suppliers (sup_name, sup_companyName, sup_email) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, supName);
            pstmt.setString(2, companyName);
            pstmt.setString(3, email);

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<Object[]> fetchSuppliers() {
        List<Object[]> suppliers = new ArrayList<>();
        String sql = "SELECT * FROM suppliers";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Object[] supplier = new Object[5]; 
                supplier[0] = rs.getString("sup_id");
                supplier[1] = rs.getString("sup_name");
                supplier[2] = rs.getString("sup_companyName");
                supplier[3] = rs.getString("sup_email");
                supplier[4] = rs.getTimestamp("sup_addedOn");
                suppliers.add(supplier);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return suppliers;
    }
    
    public static boolean removeSupplier(String supplierId) {
        String sql = "DELETE FROM `suppliers` WHERE `sup_id` = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, supplierId);
            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0; // Return true if at least one row was deleted

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateSupplierEmail(String supplierId, String newEmail) {
        String sql = "UPDATE suppliers SET sup_email = ? WHERE sup_id = ?";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, newEmail);
            statement.setString(2, supplierId);
            
            int rowsAffected = statement.executeUpdate();
            
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateSupplierStore(String supplierId, String newStore) {
        String sql = "UPDATE suppliers SET sup_companyName = ? WHERE sup_id = ?";
        
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, newStore);
            statement.setString(2, supplierId);
            
            int rowsAffected = statement.executeUpdate();
            
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
