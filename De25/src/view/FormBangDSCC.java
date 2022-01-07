/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.IOFile;
import controller.TrongException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CongNhan;
import model.BangDSCC;
import model.XuongSX;

/**
 *
 * @author Admin
 */
public class FormBangDSCC extends javax.swing.JPanel {

    DefaultTableModel tm;
    private String f1;
    private List<BangDSCC> l1;
    private String f2;
    private List<XuongSX> l2;
    public FormBangDSCC() {
        initComponents();
        setSize(950,850);
        String[] cols={"Ma CN","Ten CN","Ma xuong","ten xuong",
            "so ngay"};
        tm=new DefaultTableModel(cols, 0);
        jTable1.setModel(tm);
        f1="src/controller/QLNS.dat";
        f2="src/controller/XSX.dat";
        loadData();
        load2Ma();
    }
    private void loadData(){
        File file=new File(f1);
        if(file.exists()){
            //List<Sach> list=IOFile.doc(fsach);
            l1=IOFile.doc(f1);
        }  
        else{
            l1=new ArrayList<>();
        }
        File fs=new File(f2);
        if(fs.exists()){
            //List<Sach> list=IOFile.doc(fsach);
            l2=IOFile.doc(f2);
        }  
        else{
            l2=new ArrayList<>();
        }
    }
    private void load2Ma(){
        cbMa1.removeAllItems();
        cbMa2.removeAllItems();
        //String fsach="src/controller/sach.txt";
        String fbd="src/controller/CN.dat";
        List<CongNhan> l1=IOFile.doc(fbd);
        if(l1!=null){
            for(CongNhan i:l1)
                cbMa1.addItem(i.getMa()+"");
        }
        
        
            for(XuongSX i:l2)
                cbMa2.addItem(i.getMa()+"");
        
    }
    private boolean trung2Ma(int mak, int mas){
        for(BangDSCC i:l1)
            if(i.getCn().getMa()==mak && i.getX().getMa()==mas)
                return true;
        return false;
    } 
    private int demDauXuong(int mas){
        int count=0;
        for(BangDSCC i:l1)
            if(i.getX().getMa()==mas)
                count++;
        return count; 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cbSapXep = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbMa1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbMa2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

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

        jButton2.setText("Them moi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hien thi");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Luu vao file");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...Lua chon sap xep...", "Ten con nhan", "Theo xuong" }));
        cbSapXep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSapXepItemStateChanged(evt);
            }
        });
        cbSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSapXepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jLabel1.setText("Ma CN");

        cbMa1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMa1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Ma xuong");

        cbMa2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMa2ActionPerformed(evt);
            }
        });

        jLabel3.setText("So ngay lam viec");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Lam tuoi 2 ma");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMa1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMa2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 58, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbMa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138)
                .addComponent(jButton1)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbMa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMa1ActionPerformed
        
    }//GEN-LAST:event_cbMa1ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        load2Ma();
    }//GEN-LAST:event_jButton1ActionPerformed
    private XuongSX getXuongByMa(int ma){
            for(XuongSX i:l2)
                if(i.getMa()==ma)
                    return i;
        
        return null;
    }
    private CongNhan getCNByMa(int ma){
        String f3="src/controller/CN.dat";
        List<CongNhan> l1=IOFile.doc(f3);
        if(l1!=null){
            for(CongNhan i:l1)
                if(i.getMa()==ma)
                    return i;
        }
        return null;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int ma1=Integer.parseInt(cbMa1.getSelectedItem().toString());
        int ma2=Integer.parseInt(cbMa2.getSelectedItem().toString());
        if(trung2Ma(ma1, ma2)){
            JOptionPane.showMessageDialog(this, "Trung 2 ma!");
            cbMa1.requestFocus();
            return;
        }
        int sn=0;
        try{
            sn=Integer.parseInt(jTextField1.getText());
            if(sn>30){
                JOptionPane.showMessageDialog(this, "Vuot qua so ngay");
                jTextField1.requestFocus();
                return;
            }
            double sngay=(double)sn;
            double luong=450*(getCNByMa(ma1).getBac())*(getXuongByMa(ma2).getHeso())*(sngay/22);
            BangDSCC ql=new BangDSCC(getCNByMa(ma1),getXuongByMa(ma2), sn, luong);
            tm.addRow(ql.toObjects());
            l1.add(ql);
            
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Nhap so");
            jTextField1.requestFocus();
            return;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        File f=new File(f1);
        if(f.exists()){
            l1=IOFile.doc(f1);
            tm.setRowCount(0);
            for(BangDSCC i:l1)
                tm.addRow(i.toObjects());
        }  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        IOFile.viet(f1, l1);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbMa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMa2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMa2ActionPerformed

    private void cbSapXepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSapXepItemStateChanged
        // TODO add your handling code here:
        if(cbSapXep.getSelectedIndex()==1){
            l1.sort(new Comparator<BangDSCC>(){
                @Override
                public int compare(BangDSCC o1, BangDSCC o2) {
                    String[] ten1=o1.getCn().getTen().split("\\s+");
                    String[] ten2=o2.getCn().getTen().split("\\s+");
                    if(ten1[ten1.length-1].equalsIgnoreCase(ten2[ten2.length-1])){
                        return o1.getCn().getTen().compareToIgnoreCase(o2.getCn().getTen());
                    }
                    else
                        return ten1[ten1.length-1].compareToIgnoreCase(ten2[ten2.length-1]);
                }
            });
        }
        if(cbSapXep.getSelectedIndex()==2){
            Collections.sort(l1, (o1,o2)->{
                    String[] x1=o1.getX().getTen().split("\\s+");
                    String[] x2=o2.getX().getTen().split("\\s+");
                    if(x1[x1.length-1].equalsIgnoreCase(x2[x2.length-1])){
                        return o1.getX().getTen().compareToIgnoreCase(o2.getX().getTen());
                    }
                    else
                        return x1[x1.length-1].compareToIgnoreCase(x2[x2.length-1]);
            });
        }
        tm.setRowCount(0);
        for(BangDSCC i:l1)
            tm.addRow(i.toObjects());
    }//GEN-LAST:event_cbSapXepItemStateChanged

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void cbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSapXepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSapXepActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMa1;
    private javax.swing.JComboBox<String> cbMa2;
    private javax.swing.JComboBox<String> cbSapXep;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}