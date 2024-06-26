/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.group404.y_2s_oop_project.views;
import com.group404.y_2s_oop_project.controllers.orderController;
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
public class layout_employeeOrders extends javax.swing.JPanel {

    /**
     * Creates new form layout_employeeOrders
     */
    public layout_employeeOrders() {
        initComponents();
        displayOrders();
    }
    
    private void displayOrders() {
        List<Object[]> orders = orderController.fetchOrders();
        String[] columnNames = {"Order ID", "Customer Username", "Product ID", "Product Name", "Quantity", "Created On", "Status", "Accept", "Reject", "Remove"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (Object[] order : orders) {
            Object[] rowData = new Object[10]; 
            System.arraycopy(order, 0, rowData, 0, order.length);
            
            if (order[6] instanceof String) {
                String status = (String) order[6];
                switch (status) {
                    case "1":
                        rowData[6] = "Accepted";
                        break;
                    case "2":
                        rowData[6] = "Declined";
                        break;
                    default:
                        rowData[6] = "Pending"; 
                        break;
                }
            }
            
            rowData[7] = "Accept";
            rowData[8] = "Reject";
            rowData[9] = "Remove";
            tableModel.addRow(rowData);
        }

        tbl_orders.setModel(tableModel);
        tbl_orders.getColumn("Accept").setCellRenderer(new ButtonRenderer("Accept"));
        tbl_orders.getColumn("Accept").setCellEditor(new ButtonEditor(new JCheckBox(), "Accept"));
        tbl_orders.getColumn("Reject").setCellRenderer(new ButtonRenderer("Reject"));
        tbl_orders.getColumn("Reject").setCellEditor(new ButtonEditor(new JCheckBox(), "Reject"));
        tbl_orders.getColumn("Remove").setCellRenderer(new ButtonRenderer("Remove"));
        tbl_orders.getColumn("Remove").setCellEditor(new ButtonEditor(new JCheckBox(), "Remove"));
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
            isPushed = true;
            selectedRow = row;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                if (selectedRow != -1) { 
                    int orderId = (int) tbl_orders.getValueAt(selectedRow, 0);
                    if (label.equals("Accept")) {
                        SwingUtilities.invokeLater(() -> {
                            if (orderController.updateOrderStatus(orderId, 1)) {
                                JOptionPane.showMessageDialog(null, "Order accepted successfully.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to accept order.");
                            }
                            displayOrders();
                        });
                    } else if (label.equals("Reject")) {
                        SwingUtilities.invokeLater(() -> {
                            if (orderController.updateOrderStatus(orderId, 2)) {
                                JOptionPane.showMessageDialog(null, "Order rejected successfully.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to reject order.");
                            }
                            displayOrders();
                        });
                    } else if (label.equals("Remove")) {
                        SwingUtilities.invokeLater(() -> {
                            if (orderController.removeOrder(orderId)) {
                                JOptionPane.showMessageDialog(null, "Order removed successfully.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to remove order.");
                            }
                            displayOrders();
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
        headerText = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_orders = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(731, 88));

        headerText.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        headerText.setForeground(new java.awt.Color(255, 255, 255));
        headerText.setText("ORDERS");

        btn_refresh.setText("Refresh Orders");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_refresh)
                .addGap(214, 214, 214)
                .addComponent(headerText)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_refresh)
                .addContainerGap())
        );

        tbl_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Customer Name", "Product", "Quantity", "Created On"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_orders);
        if (tbl_orders.getColumnModel().getColumnCount() > 0) {
            tbl_orders.getColumnModel().getColumn(0).setResizable(false);
            tbl_orders.getColumnModel().getColumn(1).setResizable(false);
            tbl_orders.getColumnModel().getColumn(2).setResizable(false);
            tbl_orders.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        displayOrders();
    }//GEN-LAST:event_btn_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_refresh;
    private javax.swing.JLabel headerText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_orders;
    // End of variables declaration//GEN-END:variables
}
