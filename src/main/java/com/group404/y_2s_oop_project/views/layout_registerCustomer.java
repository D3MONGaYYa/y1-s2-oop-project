/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.group404.y_2s_oop_project.views;

import com.group404.y_2s_oop_project.App;
import javax.swing.JOptionPane;

/**
 *
 * @author D3MON
 */
public class layout_registerCustomer extends javax.swing.JPanel {

    /**
     * Creates new form layout_registerCustomer
     */
    public layout_registerCustomer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        input_fullname = new javax.swing.JTextField();
        input_password = new javax.swing.JTextField();
        btn_register = new javax.swing.JButton();
        btn_loginNavigation = new javax.swing.JLabel();
        input_username = new javax.swing.JTextField();
        input_email = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("ShipShape Register ");

        input_fullname.setBackground(new java.awt.Color(242, 242, 242));
        input_fullname.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter the Full Name :"));
        input_fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_fullnameActionPerformed(evt);
            }
        });

        input_password.setBackground(new java.awt.Color(242, 242, 242));
        input_password.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter the password :"));

        btn_register.setBackground(new java.awt.Color(242, 242, 242));
        btn_register.setText("Register");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });

        btn_loginNavigation.setText("Already Registered ? Click here to navigate login ");
        btn_loginNavigation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_loginNavigation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginNavigationMouseClicked(evt);
            }
        });

        input_username.setBackground(new java.awt.Color(242, 242, 242));
        input_username.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter the username :"));
        input_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_usernameActionPerformed(evt);
            }
        });

        input_email.setBackground(new java.awt.Color(242, 242, 242));
        input_email.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter the Email :"));
        input_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_emailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_username, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_password, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_loginNavigation)
                            .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_email, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(input_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(input_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(input_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(input_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_loginNavigation)
                .addGap(18, 18, 18)
                .addComponent(btn_register)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void input_fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_fullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_fullnameActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        String txt_fullname = input_fullname.getText();
        String txt_email = input_email.getText();
        String txt_username = input_username.getText();
        String txt_password = input_password.getText();
        
        JOptionPane.showMessageDialog(null, txt_fullname + txt_email + txt_username + txt_password , "Data Debug", JOptionPane.ERROR_MESSAGE);

        
    }//GEN-LAST:event_btn_registerActionPerformed

    private void btn_loginNavigationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginNavigationMouseClicked
        App.openLayout("layout_login", "Login User");
    }//GEN-LAST:event_btn_loginNavigationMouseClicked

    private void input_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_usernameActionPerformed

    private void input_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_emailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_loginNavigation;
    private javax.swing.JButton btn_register;
    private javax.swing.JTextField input_email;
    private javax.swing.JTextField input_fullname;
    private javax.swing.JTextField input_password;
    private javax.swing.JTextField input_username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
