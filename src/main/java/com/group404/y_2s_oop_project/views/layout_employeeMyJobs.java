/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.group404.y_2s_oop_project.views;

import com.group404.y_2s_oop_project.App;
import com.group404.y_2s_oop_project.controllers.serviceRequestController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author D3MON
 */
public class layout_employeeMyJobs extends javax.swing.JPanel {
    private Map<String, Object[]> jobDetailsMap = new HashMap<>();
    /**
     * Creates new form layout_employeeMyJobs
     */
    public layout_employeeMyJobs() {
        initComponents();
        if(!serviceRequestController.isJobAllocated()){
            JOptionPane.showMessageDialog(null, "No jobs allocated for you !");
            App.openLayout("layout_employeeMain", "Employee Main Menu");
            return;
        }
        displayAllocatedJobs();
    }
    
    private void displayAllocatedJobs() {
        List<Object[]> allocatedJobs = serviceRequestController.fetchAllocatedJobs();
        JOB_LIST.removeAllItems();

        JOB_LIST.addItem("Select job to process");
        for (Object[] job : allocatedJobs) {
            String jobDescription = String.format("%s - %s", job[0], job[2]);
            jobDetailsMap.put(jobDescription, job);
            JOB_LIST.addItem(jobDescription);
        }

        JOB_LIST.repaint();
        JOB_LIST.revalidate();
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
        headerText = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JOB_LIST = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JOB_NAME = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JOB_DESCRIPTION = new javax.swing.JLabel();
        btn_markJobDone = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(731, 88));

        headerText.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        headerText.setForeground(new java.awt.Color(255, 255, 255));
        headerText.setText("Jobs Management System");

        jButton1.setText("Main Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(headerText)
                .addGap(107, 107, 107))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jLabel1.setText("Select the job");

        JOB_LIST.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JOB_LIST.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JOB_LISTItemStateChanged(evt);
            }
        });
        JOB_LIST.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JOB_LISTPropertyChange(evt);
            }
        });

        jLabel2.setText("Service :");

        JOB_NAME.setText("JOB_NAME");

        jLabel4.setText("Service Description");

        JOB_DESCRIPTION.setText("JOB_DESCRIPTION");

        btn_markJobDone.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btn_markJobDone.setText("Mark Job as DONE");
        btn_markJobDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_markJobDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JOB_DESCRIPTION)
                            .addComponent(JOB_NAME)
                            .addComponent(JOB_LIST, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_markJobDone, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JOB_LIST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JOB_NAME)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JOB_DESCRIPTION)
                .addGap(30, 30, 30)
                .addComponent(btn_markJobDone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        App.openLayout("layout_employeeMain", "Employee Main Menu");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JOB_LISTPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JOB_LISTPropertyChange

    }//GEN-LAST:event_JOB_LISTPropertyChange

    private void JOB_LISTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JOB_LISTItemStateChanged
       JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
        String selectedJob = (String) comboBox.getSelectedItem();
        updateJobDetails(selectedJob);
    }//GEN-LAST:event_JOB_LISTItemStateChanged

    private void btn_markJobDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_markJobDoneActionPerformed
        String selectedJob = (String) JOB_LIST.getSelectedItem();
        if (jobDetailsMap.containsKey(selectedJob)) {
            Object[] jobDetails = jobDetailsMap.get(selectedJob);
            int jobId = (int) jobDetails[0];
            
            if(serviceRequestController.isJobDone(jobId)){
                JOptionPane.showMessageDialog(null, "Job already DONE !");
                return;
            }
            
            if(serviceRequestController.markJobAsDone(jobId)){
                JOptionPane.showMessageDialog(null, "Job Marked as DONE and Customer Informed about the action !");
                displayAllocatedJobs();
            } else {
                JOptionPane.showMessageDialog(null, "Job updating failed !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No job selected !");
        }
    }//GEN-LAST:event_btn_markJobDoneActionPerformed

    private void updateJobDetails(String selectedJob) {
        if (jobDetailsMap.containsKey(selectedJob)) {
            Object[] jobDetails = jobDetailsMap.get(selectedJob);
            String jobName = (String) jobDetails[2];
            String jobDescription = (String) jobDetails[3];

            JOB_NAME.setText(jobName);
            JOB_DESCRIPTION.setText(jobDescription);
        } else {
            JOB_NAME.setText("");
            JOB_DESCRIPTION.setText("");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JOB_DESCRIPTION;
    private javax.swing.JComboBox<String> JOB_LIST;
    private javax.swing.JLabel JOB_NAME;
    private javax.swing.JButton btn_markJobDone;
    private javax.swing.JLabel headerText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
