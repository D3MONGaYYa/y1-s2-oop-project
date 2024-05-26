package com.group404.y_2s_oop_project.controllers;

import com.group404.y_2s_oop_project.util.DatabaseUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UserController {
    private static String loggedInUsername;
    
    public static String getLoggedInUsername() {
        return loggedInUsername;
    }
    
    public static String getUserFullname() {
        if (loggedInUsername == null) {
            return null; 
        }

        String query = "SELECT customerName FROM customers WHERE customerUsername = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, loggedInUsername);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("customerName");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; 
    }

    public static boolean usernameExists(String username) {
        String query = "SELECT COUNT(*) FROM customers WHERE customerUsername = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static  boolean registerCustomer(String fullname, String email, String username, String password) {
        if (usernameExists(username)) {
            JOptionPane.showMessageDialog(null, "Username Exist", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false; 
        }

        String hashedPassword = hashPassword(password);

        String query = "INSERT INTO customers (customerName, customerEmail, customerUsername, customerPassword) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, fullname);
            statement.setString(2, email);
            statement.setString(3, username);
            statement.setString(4, hashedPassword);

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
        String query = "SELECT id, customerName, customerUsername, customerPassword, registered_on FROM customers WHERE customerUsername = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPasswordHash = resultSet.getString("customerPassword");
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
