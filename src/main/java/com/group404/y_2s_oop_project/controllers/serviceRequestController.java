/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group404.y_2s_oop_project.controllers;

import com.group404.y_2s_oop_project.util.DatabaseUtil;
import com.group404.y_2s_oop_project.controllers.UserController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author D3MON
 */
public class serviceRequestController {
    
    public static boolean createRequest(String service, String desc){
        String query = "INSERT INTO `service_requests`(`req_customer`, `req_service`, `req_description`) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            String username = UserController.getLoggedInUsername();
            statement.setString(1, username);
            statement.setString(2, service);            
            statement.setString(3, desc);
            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
