/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group404.y_2s_oop_project.controllers;

import com.group404.y_2s_oop_project.util.DatabaseUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author D3MON
 */
public class AdminController {
    private static String loggedInUsername;
    
    public static String getLoggedInUsername() {
        return loggedInUsername;
    }
    
    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean validateLogin(String username, String password) {
        String query = "SELECT `emp_id`, `emp_email`, `emp_username`, `emp_password`, `emp_fullname`, `emp_addedOn` FROM employees WHERE emp_username = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPasswordHash = resultSet.getString("emp_password");
                String enteredPasswordHash = hashPassword(password);

                if (storedPasswordHash.equals(enteredPasswordHash)) {
                    loggedInUsername = username;
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
}
