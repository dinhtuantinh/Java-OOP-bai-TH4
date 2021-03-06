/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.IOFile;
import controller.TrongException;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import model.DichVu;
import model.HoaDon;

/**
 *
 * @author Admin
 */
public class FormHoaDon extends javax.swing.JPanel {

    DefaultTableModel tm;
    private String fHDon;
    private List<HoaDon> lHDon;
    private String fdichvu;
    private List<DichVu> ldichvu;
    public FormHoaDon() {
        initComponents();
        setSize(950,850);
        String[] cols={"Ma KH","Ho ten KH","Ma DV","Ten DV","So lan SDDV"};
        tm=new DefaultTableModel(cols, 0);
        jTable1.setModel(tm);
        fHDon="src/controller/HOADON.dat";
        fdichvu="src/controller/DV.dat";
        loadData();
        load2Ma();
    }

    private void loadData(){
        File f=new File(fHDon);
        if(f.exists()){
            //List<Sach> list=IOFile.doc(fsach);
            lHDon=IOFile.doc(fHDon);
        }  
        else{
            lHDon=new ArrayList<>();
        }
        File fdv=new File(fdichvu);
        if(fdv.exists()){
            //List<Sach> list=IOFile.doc(fsach);
            ldichvu=IOFile.doc(fdichvu);
        }  
        else{
            ldichvu=new ArrayList<>();
        }
    }
    private void load2Ma(){
        cbMaKH.removeAllItems();
        cbMaDV.removeAllItems();
        //String fsach="src/controller/sach.txt";
        String fkh="src/controller/KH.dat";
        List<KhachHang> l1=IOFile.doc(fkh);
        if(l1!=null){
            for(KhachHang i:l1)
                cbMaKH.addItem(i.getMa()+"");
        }
        
        
            for(DichVu i:ldichvu)
                cbMaDV.addItem(i.getMa()+"");
        
    }
    private boolean trung2Ma(int makh, int masp){
        for(HoaDon i:lHDon)
            if(i.getKhachhang().getMa()==makh && i.getDichvu().getMa()==masp)
                return true;
        return false;
    } 
    private int demDauDienThoai(int makh){
        int count=0;
        for(HoaDon i:lHDon)
            if(i.getKhachhang().getMa()==makh)
                count++;
        return count; 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cbMaKH = new javax.swing.JComboBox<>();
        cbMaDV = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cbSapxep = new javax.swing.JComboBox<>();

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

        jLabel1.setText("Ma khach hang");

        jLabel2.setText("Ma san pham");

        jLabel3.setText("So luong mua");

        jButton1.setText("Lam moi hai ma");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbMaKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbMaDV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbMaKH, 0, 114, Short.MAX_VALUE)
                            .addComponent(cbMaDV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(83, 83, 83))
        );

        jButton2.setText("Them");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Luu file");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hien thi file");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cbSapxep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lua chon sap xep", "Ho ten khach hang", "So luong dat mua giam dan" }));
        cbSapxep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSapxepItemStateChanged(evt);
            }
        });
        cbSapxep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSapxepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton4)
                .addGap(76, 76, 76)
                .addComponent(cbSapxep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(cbSapxep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        load2Ma();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        File f=new File(fHDon);
        if(f.exists()){
            lHDon=IOFile.doc(fHDon);
            tm.setRowCount(0);
            for(HoaDon i:lHDon)
                tm.addRow(i.toObjects());
        }  
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int maKH=Integer.parseInt(cbMaKH.getSelectedItem().toString());
        int maDV=Integer.parseInt(cbMaDV.getSelectedItem().toString());
        if(trung2Ma(maKH, maDV)){
            JOptionPane.showMessageDialog(this, "Trung 2 ma!");
            cbMaKH.requestFocus();
            return;
        }
        int sl=0;
        int dvtinh=getDVByMa(maDV).getDvtinh();
        int tonggia=0;
        try{
            sl=Integer.parseInt(jTextField4.getText());
            if(sl>dvtinh){
                JOptionPane.showMessageDialog(this, "Khong du dich vu");
                jTextField4.requestFocus();
                return;
            }
            tonggia=sl*getDVByMa(maDV).getGiacuoc();
            HoaDon hd=new HoaDon(getKHByMa(maKH),getDVByMa(maDV), sl, tonggia);
            tm.addRow(hd.toObjects());
            lHDon.add(hd);
            IOFile.viet(fdichvu, ldichvu);
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Nhap so");
            jTextField4.requestFocus();
            return;
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        IOFile.viet(fHDon, lHDon);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbSapxepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSapxepActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbSapxepActionPerformed

    private void cbSapxepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSapxepItemStateChanged
        // TODO add your handling code here:
        if(cbSapxep.getSelectedIndex()==1){
            lHDon.sort(new Comparator<HoaDon>(){
                @Override
                public int compare(HoaDon o1, HoaDon o2) {
                    String[] ten1=o1.getKhachhang().getHoten().split("\\s+");
                    String[] ten2=o2.getKhachhang().getHoten().split("\\s+");
                    if(ten1[ten1.length-1].equalsIgnoreCase(ten2[ten2.length-1])){
                        return o1.getKhachhang().getHoten().compareToIgnoreCase(o2.getKhachhang().getHoten());
                    }
                    else
                        return ten1[ten1.length-1].compareToIgnoreCase(ten2[ten2.length-1]);
                }
            });
        }
        if(cbSapxep.getSelectedIndex()==2){
            lHDon.sort(new Comparator<HoaDon>(){
                @Override
                public int compare(HoaDon o1, HoaDon o2) {
                    return Integer.compare(o2.getDvtinh(), o1.getDvtinh());
                }
                
            });
        }
        tm.setRowCount(0);
        for(HoaDon i:lHDon)
            tm.addRow(i.toObjects());
    }//GEN-LAST:event_cbSapxepItemStateChanged
    private DichVu getDVByMa(int ma){
        
        
            for(DichVu i:ldichvu)
                if(i.getMa()==ma)
                    return i;
        
        return null;
    }
    private KhachHang getKHByMa(int ma){
        String fbdoc="src/controller/KH.dat";
        List<KhachHang> l1=IOFile.doc(fbdoc);
        if(l1!=null){
            for(KhachHang i:l1)
                if(i.getMa()==ma)
                    return i;
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMaDV;
    private javax.swing.JComboBox<String> cbMaKH;
    private javax.swing.JComboBox<String> cbSapxep;
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
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
