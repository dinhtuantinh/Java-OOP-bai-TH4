/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.IOFile;
import controller.TrongException;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.VeTau;
import model.HoaDon;
import model.NguoiMV;
public class FormHoaDon extends javax.swing.JPanel {

    DefaultTableModel tm;
    //private boolean them,sua;
    private String f1;
    private List<HoaDon> l1;
    private String f2;
    private List<VeTau> l2;
    public FormHoaDon() {
        initComponents();
        setSize(950,850);
        String[] cols={"Ma nguoi","Ten","Ma ve","Loai ve", "So luong"};
        tm=new DefaultTableModel(cols,0);
        jTable1.setModel(tm);
        f1="src/controller/HOADON.dat";
        f2="src/controller/VE.dat";
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
        String fbd="src/controller/NGUOIMUA.dat";
        List<NguoiMV> l1=IOFile.doc(fbd);
        if(l1!=null){
            for(NguoiMV i:l1)
                cbMa1.addItem(i.getMa()+"");
        }
        
        
            for(VeTau i:l2)
                cbMa2.addItem(i.getMa()+"");
        
    }
    private boolean trung2Ma(int makh, int map){
        for(HoaDon i:l1)
            if(i.getN().getMa()==makh && i.getV().getMa()==map)
                return true;
        return false;
    } 
    private VeTau getVeByMa(int ma){
            for(VeTau i:l2)
                if(i.getMa()==ma)
                    return i;
        
        return null;
    }
    private NguoiMV getNByMa(int ma){
        String f3="src/controller/NGUOIMUA.dat";
        List<NguoiMV> l1=IOFile.doc(f3);
        if(l1!=null){
            for(NguoiMV i:l1)
                if(i.getMa()==ma)
                    return i;
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbMa1 = new javax.swing.JComboBox<>();
        cbMa2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

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

        jLabel1.setText("Ma nguoi");

        jLabel2.setText("Ma ve");

        cbMa1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbMa2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Them");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Hien thi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Luu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sap xep", "Ho ten nguoi mua", "So luong ve ban" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        jLabel3.setText("So luong");

        jButton4.setText("Lam moi 2 ma");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbMa1, 0, 101, Short.MAX_VALUE)
                            .addComponent(cbMa2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton4)))
                .addGap(0, 19, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(52, 52, 52)
                .addComponent(jButton2)
                .addGap(66, 66, 66)
                .addComponent(jButton3)
                .addGap(61, 61, 61)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 60, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbMa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(cbMa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(146, 146, 146)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int ma1=Integer.parseInt(cbMa1.getSelectedItem().toString());
        int ma2=Integer.parseInt(cbMa2.getSelectedItem().toString());
        if(trung2Ma(ma1, ma2)){
            JOptionPane.showMessageDialog(this, "Trung 2 ma!");
            cbMa1.requestFocus();
            return;
        }
        
        try{
            int sl=Integer.parseInt(jTextField1.getText());
            int tien=getVeByMa(ma2).getGia()*sl;
            HoaDon ql=new HoaDon(getNByMa(ma1),getVeByMa(ma2), sl, tien);
            tm.addRow(ql.toObjects());
            l1.add(ql);
            
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Nhap so");
            jTextField1.requestFocus();
            return;
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        File f=new File(f1);
        if(f.exists()){
            l1=IOFile.doc(f1);
            tm.setRowCount(0);
            for(HoaDon i:l1)
                tm.addRow(i.toObjects());
        }  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        IOFile.viet(f1, l1);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        load2Ma();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        // TODO add your handling code here:
        if(jComboBox3.getSelectedIndex()==1){
            l1.sort(new Comparator<HoaDon>(){
                @Override
                public int compare(HoaDon o1,HoaDon o2) {
                    String[] ten1=o1.getN().getTen().split("\\s+");
                    String[] ten2=o2.getN().getTen().split("\\s+");
                    if(ten1[ten1.length-1].equalsIgnoreCase(ten2[ten2.length-1])){
                        return o1.getN().getTen().compareToIgnoreCase(o2.getN().getTen());
                    }
                    else
                        return ten1[ten1.length-1].compareToIgnoreCase(ten2[ten2.length-1]);
                }
            });
        }
        if(jComboBox3.getSelectedIndex()==2){
            l1.sort(new Comparator<HoaDon>(){
                @Override
                public int compare(HoaDon o1, HoaDon o2) {
                    return Integer.compare(o2.getSl(), o1.getSl());
                }
                
            });
        }
        tm.setRowCount(0);
        for(HoaDon i:l1)
            tm.addRow(i.toObjects());
    }//GEN-LAST:event_jComboBox3ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMa1;
    private javax.swing.JComboBox<String> cbMa2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
