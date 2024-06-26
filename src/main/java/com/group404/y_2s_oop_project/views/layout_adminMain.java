/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.group404.y_2s_oop_project.views;

import com.group404.y_2s_oop_project.App;

/**
 *
 * @author D3MON
 */
public class layout_adminMain extends javax.swing.JPanel {

    /**
     * Creates new form layout_adminMain
     */
    public layout_adminMain() {
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
        welcomeText = new javax.swing.JLabel();
        btn_employeeManagment = new javax.swing.JButton();
        btn_employeeManagment1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(731, 88));

        welcomeText.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        welcomeText.setForeground(new java.awt.Color(255, 255, 255));
        welcomeText.setText("ShipSharp Admin Panel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(welcomeText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomeText, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        );

        btn_employeeManagment.setBackground(new java.awt.Color(0, 102, 255));
        btn_employeeManagment.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_employeeManagment.setForeground(new java.awt.Color(255, 255, 255));
        btn_employeeManagment.setText("ADD EMPLOYEE");
        btn_employeeManagment.setToolTipText("");
        btn_employeeManagment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_employeeManagmentActionPerformed(evt);
            }
        });

        btn_employeeManagment1.setBackground(new java.awt.Color(0, 102, 255));
        btn_employeeManagment1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_employeeManagment1.setForeground(new java.awt.Color(255, 255, 255));
        btn_employeeManagment1.setText("EMPLOYEE MANAGMENT");
        btn_employeeManagment1.setToolTipText("");
        btn_employeeManagment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_employeeManagment1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_employeeManagment, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_employeeManagment1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(471, 471, 471))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_employeeManagment)
                .addGap(18, 18, 18)
                .addComponent(btn_employeeManagment1)
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_employeeManagmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_employeeManagmentActionPerformed
        App.openLayout("layout_adminAddEmployees", "Emplyoee Management");
    }//GEN-LAST:event_btn_employeeManagmentActionPerformed

    private void btn_employeeManagment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_employeeManagment1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_employeeManagment1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_employeeManagment;
    private javax.swing.JButton btn_employeeManagment1;
    private javax.swing.JButton btn_orders;
    private javax.swing.JButton btn_orders1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}
