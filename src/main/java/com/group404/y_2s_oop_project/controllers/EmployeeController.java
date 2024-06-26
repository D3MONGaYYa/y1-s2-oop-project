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
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author D3MON
 */
public class EmployeeController {
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
    
    public static boolean addNewEmployee(String email, String username, String password, String fullname) {
        String sql = "INSERT INTO employees (emp_email, emp_username, emp_password, emp_fullname, emp_addedOn) VALUES (?, ?, ?, ?, NOW())";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            String hashedPassword = hashPassword(password);

            pstmt.setString(1, email);
            pstmt.setString(2, username);
            pstmt.setString(3, hashedPassword);
            pstmt.setString(4, fullname);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<Object[]> fetchEmployees() {
        List<Object[]> employees = new ArrayList<>();
        String sql = "SELECT `emp_id`, `emp_email`, `emp_username`, `emp_password`, `emp_fullname`, `emp_addedOn` FROM employees";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Object[] employee = new Object[6];
                employee[0] = rs.getInt("emp_id");
                employee[1] = rs.getString("emp_email");
                employee[2] = rs.getString("emp_username");
                employee[3] = rs.getString("emp_fullname");
                employee[4] = rs.getTimestamp("emp_addedOn");
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    
    public static boolean removeEmployee(int employeeId) {
        String sql = "DELETE FROM employees WHERE emp_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateEmployeeEmail(int employeeId, String newEmail) {
        String sql = "UPDATE employees SET emp_email = ? WHERE emp_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, newEmail);
            pstmt.setInt(2, employeeId);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateEmployeePassword(int employeeId, String newPassword) {
        String sql = "UPDATE employees SET emp_password = ? WHERE emp_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            String hashedPassword = hashPassword(newPassword);
            pstmt.setString(1, hashedPassword);
            pstmt.setInt(2, employeeId);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
