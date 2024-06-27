/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.group404.y_2s_oop_project.views;

import com.group404.y_2s_oop_project.App;
import com.group404.y_2s_oop_project.controllers.serviceRequestController;
import com.group404.y_2s_oop_project.controllers.EmployeeController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author D3MON
 */
public class layout_adminManageServiceRequests extends javax.swing.JPanel {

    /**
     * Creates new form layout_adminManageServiceRequests
     */
    public layout_adminManageServiceRequests() {
        initComponents();
        displayRequests();
    }
    
    private void displayRequests() {
        List<Object[]> requests = serviceRequestController.fetchRequests();
        String[] columnNames = {"Request ID", "Customer", "Service", "Description", "Status", "Allocated Employee", "Created On", "Allocate Employee"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (Object[] request : requests) {
            Object[] rowData = new Object[8];
            System.arraycopy(request, 0, rowData, 0, request.length);
            rowData[7] = "Allocate"; 
            tableModel.addRow(rowData);
        }
        
        
        jTable1.setModel(tableModel);
        jTable1.getColumn("Allocate Employee").setCellRenderer(new ButtonRenderer("Allocate"));
        jTable1.getColumn("Allocate Employee").setCellEditor(new ButtonEditor(new JCheckBox(), "Allocate"));

    }
    
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer(String label) {
            setText(label);
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private String label;
        private JButton button;
        private boolean isPushed;
        private int selectedRow;

        public ButtonEditor(JCheckBox checkBox, String label) {
            super(checkBox);
            this.label = label;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            button.setText(label);
            isPushed = true;
            selectedRow = row;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                if (selectedRow != -1) {
                    int requestId = (int) jTable1.getValueAt(selectedRow, 0);
                    String serviceName = (String) jTable1.getValueAt(selectedRow, 2);
                    String serviceDesc = (String) jTable1.getValueAt(selectedRow, 3);

                    if (label.equals("Allocate")) {
                        SwingUtilities.invokeLater(() -> {
                            List<Object[]> employees = EmployeeController.fetchEmployees();

                            JComboBox<String> employeeComboBox = new JComboBox<>();
                            for (Object[] employee : employees) {
                                employeeComboBox.addItem(employee[3].toString()); 
                            }

                            int option = JOptionPane.showOptionDialog(null, employeeComboBox,
                                    "Select Employee to Allocate", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                                    null, null, null);

                            if (option == JOptionPane.OK_OPTION) {
                                String selectedFullName = (String) employeeComboBox.getSelectedItem();

                                int selectedEmployeeId = -1;
                                String selectedEmployeeEmail = "";
                                for (Object[] employee : employees) {
                                    if (selectedFullName.equals(employee[3].toString())) { 
                                        selectedEmployeeId = (int) employee[0];
                                        selectedEmployeeEmail = (String) employee[1];
                                        break;
                                    }
                                }

                                if (selectedEmployeeId != -1 && serviceRequestController.allocateEmployeeToRequest(requestId, selectedEmployeeId, selectedEmployeeEmail, serviceName, serviceDesc)) {
                                    JOptionPane.showMessageDialog(null, "Employee allocated successfully.");
                                    displayRequests(); 
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failed to allocate employee.");
                                }
                            }
                        });
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No row selected.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            isPushed = false;
            return label;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(731, 88));

        welcomeText.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        welcomeText.setForeground(new java.awt.Color(255, 255, 255));
        welcomeText.setText("Service Requests");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(179, 179, 179)
                .addComponent(welcomeText)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomeText, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Table"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        App.openLayout("layout_adminMain", "Admin Main Menu");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}
