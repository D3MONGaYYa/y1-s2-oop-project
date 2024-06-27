/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.group404.y_2s_oop_project.views;

import com.group404.y_2s_oop_project.App;
import com.group404.y_2s_oop_project.controllers.SupplierController;
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
public class layout_employeeSupplierList extends javax.swing.JPanel {

    /**
     * Creates new form layout_employeeSupplierList
     */
    public layout_employeeSupplierList() {
        initComponents();
        displaySuppliers();
    }
    
    private void displaySuppliers() {
        List<Object[]> suppliers = SupplierController.fetchSuppliers();
        String[] columnNames = {"Supplier ID", "Name", "Company Name", "Email", "Added On", "Remove", "Update Email", "Update Store"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 5; 
            }
        };

        for (Object[] supplier : suppliers) {
            Object[] rowData = new Object[8];
            System.arraycopy(supplier, 0, rowData, 0, supplier.length);
            rowData[5] = "Remove";
            rowData[6] = "Update Email";
            rowData[7] = "Update Store";
            tableModel.addRow(rowData);
        }

        table_supplierList.setModel(tableModel);

        table_supplierList.getColumn("Remove").setCellRenderer(new ButtonRenderer("Remove"));
        table_supplierList.getColumn("Remove").setCellEditor(new ButtonEditor(new JCheckBox(), "Remove"));

        table_supplierList.getColumn("Update Email").setCellRenderer(new ButtonRenderer("Update Email"));
        table_supplierList.getColumn("Update Email").setCellEditor(new ButtonEditor(new JCheckBox(), "Update Email"));

        table_supplierList.getColumn("Update Store").setCellRenderer(new ButtonRenderer("Update Store"));
        table_supplierList.getColumn("Update Store").setCellEditor(new ButtonEditor(new JCheckBox(), "Update Store"));
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
                    String supplierId = (String) table_supplierList.getValueAt(selectedRow, 0);

                    if (label.equals("Remove")) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this supplier?", "Remove Supplier", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            SwingUtilities.invokeLater(() -> {
                                if (SupplierController.removeSupplier(supplierId)) {
                                    JOptionPane.showMessageDialog(null, "Supplier removed successfully.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failed to remove supplier.");
                                }
                                displaySuppliers();
                            });
                        }
                    } else if (label.equals("Update Email")) {
                        String newEmail = JOptionPane.showInputDialog("Enter new email:");
                        if (newEmail != null && !newEmail.isEmpty()) {
                            SwingUtilities.invokeLater(() -> {
                                if (SupplierController.updateSupplierEmail(supplierId, newEmail)) {
                                    JOptionPane.showMessageDialog(null, "Email updated successfully.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failed to update email.");
                                }
                                displaySuppliers();
                            });
                        }
                    } else if (label.equals("Update Store")) {
                        String newStore = JOptionPane.showInputDialog("Enter new store:");
                        if (newStore != null && !newStore.isEmpty()) {
                            SwingUtilities.invokeLater(() -> {
                                if (SupplierController.updateSupplierStore(supplierId, newStore)) {
                                    JOptionPane.showMessageDialog(null, "Store updated successfully.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failed to update store.");
                                }
                                displaySuppliers();
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
        headerText = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_supplierList = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(731, 88));

        headerText.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        headerText.setForeground(new java.awt.Color(255, 255, 255));
        headerText.setText("Add Supplier");

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
                .addGap(177, 177, 177)
                .addComponent(headerText)
                .addContainerGap(283, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        table_supplierList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Table"
            }
        ));
        jScrollPane1.setViewportView(table_supplierList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        App.openLayout("layout_employeeMain", "Employee Main Menu");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel headerText;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_supplierList;
    // End of variables declaration//GEN-END:variables
}
