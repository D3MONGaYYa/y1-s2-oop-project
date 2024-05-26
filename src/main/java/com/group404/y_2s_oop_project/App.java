/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.group404.y_2s_oop_project;

import com.group404.y_2s_oop_project.views.*;
import javax.swing.JPanel;
import javax.swing.JFrame;

import com.formdev.flatlaf.*;


/**
 *
 * @author D3MON
 */
public class App {
    private static JFrame frame = new JFrame("ShipShape"); 

    public static void main(String[] args) {
        FlatLightLaf.setup();
        openLayout("layout_login", "ShipShape Login Form");
    }

    public static void openLayout(String layoutName, String title) {
        JPanel layout = null;

        frame.getContentPane().removeAll();

        switch (layoutName.toLowerCase()) {
            case "layout_login":
                layout = new layout_login();
                break;
            case "layout_registercustomer":
                layout = new layout_registerCustomer();
                break;
            default:
                System.err.println("Layout not found: " + layoutName);
                return;
        }

        frame.setTitle(title);
        frame.setResizable(false);
        frame.setExtendedState(JFrame.NORMAL);
        frame.add(layout);
        frame.setSize(850, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

