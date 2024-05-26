/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.group404.y_2s_oop_project.views;
import com.group404.y_2s_oop_project.controllers.ProductController;
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
public class layout_customerOrderSpare extends javax.swing.JPanel {

    /**
     * Creates new form layout_customerOrderSpare
     */
    public layout_customerOrderSpare() {
        initComponents();
        displayProducts();
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
        productListTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(939, 383));

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(731, 88));

        welcomeText.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        welcomeText.setForeground(new java.awt.Color(255, 255, 255));
        welcomeText.setText("ShipSharp Spare Parts");

        jButton1.setText("My Orders");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(welcomeText)
                .addGap(218, 218, 218))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomeText, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        productListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Price", "Stock", "Order"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productListTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        displayProducts();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void displayProducts() {
        List<Object[]> products = ProductController.fetchProducts();
        String[] columnNames = {"Product ID", "Product Name", "Price", "Stock", "Order"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (Object[] product : products) {
//            System.out.print(product.productId);
            tableModel.addRow(product);
        }

        productListTable.setModel(tableModel);
        productListTable.getColumn("Order").setCellRenderer(new ButtonRenderer());
        productListTable.getColumn("Order").setCellEditor(new ButtonEditor(new JCheckBox()));
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
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

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                int rowIndex = productListTable.getEditingRow();
                if (rowIndex >= 0 && rowIndex < productListTable.getRowCount()) {
                    int productID = Integer.parseInt(productListTable.getValueAt(rowIndex, 0).toString());
                    String productName = productListTable.getValueAt(rowIndex, 1).toString();
                    int productQTY = Integer.parseInt(productListTable.getValueAt(rowIndex, 3).toString());
                    SwingUtilities.invokeLater(() -> processOrder(productName, productQTY, productID));
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

    private void processOrder(String productName, int productQTY, int productID) {
        String quantityStr = JOptionPane.showInputDialog(null, "Enter quantity for " + productName + " (Max QTY " + productQTY + "):");
        if (quantityStr != null && !quantityStr.isEmpty()) {
            try {
                int quantity = Integer.parseInt(quantityStr);
                if (quantity > productQTY) {
                    JOptionPane.showMessageDialog(null, "Entered quantity exceeds available stock.", "Order Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (ProductController.createOrder(productName, quantity, productID)) {
                        JOptionPane.showMessageDialog(null, "Ordered " + quantity + " of " + productName, "Order Placed", JOptionPane.INFORMATION_MESSAGE);
                        refreshPage();
                    } else {
                        JOptionPane.showMessageDialog(null, "Order Placing SQL Error", "Order Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid quantity entered.", "Order Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    
    private void refreshPage(){
        System.out.print("Products Refreshed !");
        displayProducts();
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productListTable;
    private javax.swing.JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}