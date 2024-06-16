/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.group404.y_2s_oop_project.views;

import com.group404.y_2s_oop_project.controllers.serviceRequestController;
import javax.swing.JOptionPane;
/**
 *
 * @author D3MON
 */
public class layout_requestService extends javax.swing.JPanel {

    /**
     * Creates new form layout_requestService
     */
    public layout_requestService() {
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

        btn_requestService = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        topText = new javax.swing.JLabel();
        service_dropdown = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        req_description = new javax.swing.JTextArea();

        btn_requestService.setText("Request the Service");
        btn_requestService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_requestServiceActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(731, 88));

        topText.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        topText.setForeground(new java.awt.Color(255, 255, 255));
        topText.setText("ShipSharp Service Request");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(topText)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(topText)
                .addContainerGap())
        );

        service_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Repairs", "Re-Painting" }));

        jLabel1.setText("Select the service :");

        jLabel2.setText("Describe the service how you want :");

        req_description.setColumns(20);
        req_description.setRows(5);
        jScrollPane1.setViewportView(req_description);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(service_dropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                    .addComponent(btn_requestService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(service_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_requestService)
                .addGap(0, 30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_requestServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_requestServiceActionPerformed
        String req_service = String.valueOf(service_dropdown.getSelectedItem());
        String req_txtdescription = req_description.getText();
        
        if (req_service.isEmpty() || req_txtdescription.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All inputs must need a value", "Error Occured", JOptionPane.ERROR_MESSAGE);
            return;
        }   
        
        if(serviceRequestController.createRequest(req_service, req_txtdescription)){
            JOptionPane.showMessageDialog(null, "Service Requested Successfully !", "Service Requested", JOptionPane.INFORMATION_MESSAGE);
            clearAreas();
        } else {
            JOptionPane.showMessageDialog(null, "Service Requesting Failed", "Error Occured", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_requestServiceActionPerformed

    private void clearAreas() {
        req_description.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_requestService;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea req_description;
    private javax.swing.JComboBox<String> service_dropdown;
    private javax.swing.JLabel topText;
    // End of variables declaration//GEN-END:variables
}