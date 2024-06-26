/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.group404.y_2s_oop_project.views;
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
public class layout_adminEmployeeList extends javax.swing.JPanel {

    /**
     * Creates new form layout_adminEmployeeList
     */
    public layout_adminEmployeeList() {
        initComponents();
        displayEmployees();
    }
    
    private void displayEmployees() {
        List<Object[]> employees = EmployeeController.fetchEmployees();
        String[] columnNames = {"Employee ID", "Email", "Username", "Full Name", "Added On", "Remove", "Update Email", "Update Password"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 5; 
            }
        };

        for (Object[] employee : employees) {
            Object[] rowData = new Object[8];
            System.arraycopy(employee, 0, rowData, 0, employee.length);
            rowData[5] = "Remove"; 
            rowData[6] = "Update Email"; 
            rowData[7] = "Update Password"; 
            tableModel.addRow(rowData);
        }

        table_employeeList.setModel(tableModel);
        table_employeeList.getColumn("Remove").setCellRenderer(new ButtonRenderer("Remove"));
        table_employeeList.getColumn("Remove").setCellEditor(new ButtonEditor(new JCheckBox(), "Remove"));
        table_employeeList.getColumn("Update Email").setCellRenderer(new ButtonRenderer("Update Email"));
        table_employeeList.getColumn("Update Email").setCellEditor(new ButtonEditor(new JCheckBox(), "Update Email"));
        table_employeeList.getColumn("Update Password").setCellRenderer(new ButtonRenderer("Update Password"));
        table_employeeList.getColumn("Update Password").setCellEditor(new ButtonEditor(new JCheckBox(), "Update Password"));
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
                    int employeeId = (int) table_employeeList.getValueAt(selectedRow, 0);

                    if (label.equals("Remove")) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this employee?", "Remove Employee", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            SwingUtilities.invokeLater(() -> {
                                if (EmployeeController.removeEmployee(employeeId)) {
                                    JOptionPane.showMessageDialog(null, "Employee removed successfully.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failed to remove employee.");
                                }
                                displayEmployees();
                            });
                        }
                    } else if (label.equals("Update Email")) {
                        String newEmail = JOptionPane.showInputDialog("Enter new email:");
                        if (newEmail != null && !newEmail.isEmpty()) {
                            SwingUtilities.invokeLater(() -> {
                                if (EmployeeController.updateEmployeeEmail(employeeId, newEmail)) {
                                    JOptionPane.showMessageDialog(null, "Email updated successfully.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failed to update email.");
                                }
                                displayEmployees();
                            });
                        }
                    } else if (label.equals("Update Password")) {
                        String newPassword = JOptionPane.showInputDialog("Enter new password:");
                        if (newPassword != null && !newPassword.isEmpty()) {
                            SwingUtilities.invokeLater(() -> {
                                if (EmployeeController.updateEmployeePassword(employeeId, newPassword)) {
                                    JOptionPane.showMessageDialog(null, "Password updated successfully.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failed to update password.");
                                }
                                displayEmployees();
                            });
                        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table_employeeList = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(731, 88));

        welcomeText.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        welcomeText.setForeground(new java.awt.Color(255, 255, 255));
        welcomeText.setText("Employee List");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(welcomeText)
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomeText, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        );

        table_employeeList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TABLE"
            }
        ));
        jScrollPane1.setViewportView(table_employeeList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_employeeList;
    private javax.swing.JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}
