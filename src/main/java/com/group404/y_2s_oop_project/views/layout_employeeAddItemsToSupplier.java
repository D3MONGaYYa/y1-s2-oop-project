/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.group404.y_2s_oop_project.views;

import com.group404.y_2s_oop_project.App;
import com.group404.y_2s_oop_project.controllers.SupplierController;
import com.group404.y_2s_oop_project.controllers.serviceRequestController;
import com.group404.y_2s_oop_project.controllers.ProductController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author D3MON
 */
public class layout_employeeAddItemsToSupplier extends javax.swing.JPanel {
    private Map<String, Object[]> supplierDataMap = new HashMap<>();
    private Map<String, Object[]> productDataMap = new HashMap<>();
    private String selectedSupplierGlobal;
    /**
     * Creates new form layout_employeeAddItemsToSupplier
     */
    public layout_employeeAddItemsToSupplier() {
        initComponents();
        setupSuppliers();
        updateProdList();
    }
    
    private void setupSuppliers() {
        List<Object[]> supplierList = SupplierController.fetchSuppliers();
        SUPPLIER_LIST.removeAllItems();

        SUPPLIER_LIST.addItem("Select supplier to process");
        for (Object[] supplier : supplierList) {
            String supplierListDrop = String.format("%s - %s", supplier[0], supplier[1]);
            supplierDataMap.put(supplierListDrop, supplier);
            SUPPLIER_LIST.addItem(supplierListDrop);
        }

        SUPPLIER_LIST.repaint();
        SUPPLIER_LIST.revalidate();
    }
    
    private void updateProdList() {
        List<Object[]> products = ProductController.getUnallocatedProducts();
        drop_prodList.removeAllItems();

        drop_prodList.addItem("Select product to allocate");
        for (Object[] product : products) {
            String prodDescription = String.format("%s - %s", product[0], product[1]);
            supplierDataMap.put(prodDescription, product);
            drop_prodList.addItem(prodDescription);
        }

        drop_prodList.repaint();
        drop_prodList.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        headerText = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SUPPLIER_LIST = new javax.swing.JComboBox<>();
        txt_supplierName = new javax.swing.JLabel();
        txt_supplierStoreName = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        allocated_items_table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        drop_prodList = new javax.swing.JComboBox<>();
        btn_allocateItem = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(731, 88));

        headerText.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        headerText.setForeground(new java.awt.Color(255, 255, 255));
        headerText.setText("SUPPLIER MANAGMENT");

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
                .addGap(68, 68, 68)
                .addComponent(headerText)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jLabel1.setText("Select Supplier");

        SUPPLIER_LIST.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SUPPLIER_LIST.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SUPPLIER_LISTItemStateChanged(evt);
            }
        });

        txt_supplierName.setText("Supplier Name : NULL");

        txt_supplierStoreName.setText("Supplier Store Name:");

        allocated_items_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Table"
            }
        ));
        jScrollPane2.setViewportView(allocated_items_table);

        jLabel2.setText("ALLOCATED ITEMS");

        jLabel3.setText("ALLOCATE ITEM");

        drop_prodList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_allocateItem.setBackground(new java.awt.Color(153, 153, 0));
        btn_allocateItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_allocateItem.setForeground(new java.awt.Color(255, 255, 255));
        btn_allocateItem.setText("ALLOCATE ITEM TO SUPPLIER");
        btn_allocateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_allocateItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_supplierStoreName)
                                    .addComponent(txt_supplierName)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(SUPPLIER_LIST, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(333, 333, 333)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(drop_prodList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(btn_allocateItem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SUPPLIER_LIST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_supplierName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_supplierStoreName)
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drop_prodList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_allocateItem)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        App.openLayout("layout_employeeMain", "Employee Main Menu");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SUPPLIER_LISTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SUPPLIER_LISTItemStateChanged
        JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
        String selectedSupplier = (String) comboBox.getSelectedItem();
        updateSupplierDetails(selectedSupplier);
    }//GEN-LAST:event_SUPPLIER_LISTItemStateChanged

    private void btn_allocateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_allocateItemActionPerformed
        String selectedProduct = String.valueOf(drop_prodList.getSelectedItem());
    
        if (supplierDataMap.containsKey(selectedProduct)) {
            Object[] supplierData = supplierDataMap.get(selectedProduct);

            Integer prodID = (Integer) supplierData[0];  
            String prodName = (String) supplierData[1]; 
            int selectedSupplierAllocate = Integer.parseInt(selectedSupplierGlobal);

            if(selectedSupplierAllocate != 0) {
                if(SupplierController.allocateItemToSupplier(selectedSupplierAllocate, prodID)){
                    JOptionPane.showMessageDialog(null, "Item Allocated To The Supplier.");
                    App.openLayout("layout_employeeAddItemsToSupplier", "Item allocate to supplier");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to allocate item to supplier.");
                }
            } else {
                    JOptionPane.showMessageDialog(null, "Please select a supplier");
            }
        }
    }//GEN-LAST:event_btn_allocateItemActionPerformed
    
    private void updateSupplierDetails(String selectedSupplier) {
        if (supplierDataMap.containsKey(selectedSupplier)) {
            Object[] supplierData = supplierDataMap.get(selectedSupplier);
            String supID = (String) supplierData[0];
            String supName = (String) supplierData[1]; 
            String supStoreName = (String) supplierData[2]; 
            selectedSupplierGlobal = supID;
            
            txt_supplierName.setText("Supplier Name: " + supName);
            txt_supplierStoreName.setText("Supplier Store Name: " + supStoreName);

            updateAllocatedItemList(supID);
        } else {
            selectedSupplierGlobal = "0";
            txt_supplierName.setText("Supplier Name: NULL");
            txt_supplierStoreName.setText("Supplier Store Name: NULL");
            clearAllocatedItemList();
        }
    }
    
    private void updateAllocatedItemList(String supplierId) {
        DefaultTableModel tableModel = new DefaultTableModel();

        List<Object[]> allocatedItems = SupplierController.getAllocatedItems(supplierId);
        String[] columnNames = {"Item ID", "Item Name"};
        tableModel.setColumnIdentifiers(columnNames);

        for (Object[] item : allocatedItems) {
            tableModel.addRow(item);
        }

        allocated_items_table.setModel(tableModel);

        allocated_items_table.repaint();
        allocated_items_table.revalidate();
    }

    private void clearAllocatedItemList() {
        DefaultTableModel tableModel = new DefaultTableModel();

        allocated_items_table.setModel(tableModel);

        allocated_items_table.repaint();
        allocated_items_table.revalidate();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> SUPPLIER_LIST;
    private javax.swing.JTable allocated_items_table;
    private javax.swing.JButton btn_allocateItem;
    private javax.swing.JComboBox<String> drop_prodList;
    private javax.swing.JLabel headerText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txt_supplierName;
    private javax.swing.JLabel txt_supplierStoreName;
    // End of variables declaration//GEN-END:variables
}
