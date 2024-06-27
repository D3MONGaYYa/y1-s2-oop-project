/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group404.y_2s_oop_project.controllers;

import com.group404.y_2s_oop_project.util.DatabaseUtil;
import com.group404.y_2s_oop_project.util.MailUtil;
import com.group404.y_2s_oop_project.controllers.UserController;
import com.group404.y_2s_oop_project.util.MailUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            MailUtil.sendServiceRequested(UserController.getEmail(), service, desc);
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<Object[]> fetchRequests() {
        List<Object[]> requests = new ArrayList<>();
        String sql = "SELECT `req_id`, `req_customer`, `req_service`, `req_description`, `req_status`, `allocated_employee`, `req_createdOn` FROM `service_requests`";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Object[] request = new Object[7];
                request[0] = rs.getInt("req_id");
                request[1] = rs.getString("req_customer");
                request[2] = rs.getString("req_service");
                request[3] = rs.getString("req_description");
                request[4] = rs.getString("req_status");
                request[5] = rs.getString("allocated_employee");
                request[6] = rs.getTimestamp("req_createdOn");
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }
    
    public static boolean allocateEmployeeToRequest(int requestId, int employeeId, String selectedEmployeeEmail, String serviceName, String serviceDesc) {
        String sql = "UPDATE service_requests SET allocated_employee = ? WHERE req_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);
            pstmt.setInt(2, requestId);

            int rowsUpdated = pstmt.executeUpdate();
            MailUtil.sendServiceAllocated(selectedEmployeeEmail, serviceName, serviceDesc);
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
