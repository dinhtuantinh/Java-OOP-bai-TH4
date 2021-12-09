/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view5;

import contrl5.IOFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model5.CCong;
import model5.NVien;
import model5.PBan;

/**
 *
 * @author Admin
 */
public class FCCong extends javax.swing.JPanel {

    DefaultTableModel tm;
    private String fcCong;
    private List<CCong> lcCong;
    private String fnv;
    private List<NVien> lnv;
    public FCCong() {
        initComponents();
        String[] cols={"Ma NV","Ten NV","Ma PB","Ten PB","So ngay"};
        tm = new DefaultTableModel(cols,0);
        jTable1.setModel(tm);
        fcCong="src/contrl/cCong.dat";
        fnv="src/contrl/nv.dat";
        loadData();
        load2Ma();
    }

    private void loadData(){
        File f=new File(fcCong);
        if(f.exists()){
            //List<Sach> list=IOFile.doc(fsach);
            lcCong=IOFile.doc(fcCong);
        }  
        else{
            lcCong=new ArrayList<>();
        }
        File fs=new File(fnv);
        if(fs.exists()){
            //List<Sach> list=IOFile.doc(fsach);
            lnv=IOFile.doc(fnv);
        }  
        else{
            lnv=new ArrayList<>();
        }
    }
    private void load2Ma(){
        cbnv.removeAllItems();
        cbpb.removeAllItems();
        //String fsach="src/controller/sach.txt";
        String fpb="src/contrl/pb.dat";
        List<PBan> l1=IOFile.doc(fpb);
        if(l1!=null){
            for(PBan i:l1)
                cbpb.addItem(i.getMa()+"");
        }
        
        
            for(NVien i:lnv)
                cbnv.addItem(i.getMa()+"");
        
    }
    private boolean trung2Ma(int mabd, int mas){
        for(CCong i:lcCong)
            if(i.getP().getMa()==mabd && i.getN().getMa()==mas)
                return true;
        return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbnv = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbpb = new javax.swing.JComboBox<>();
        them = new javax.swing.JButton();
        capnhat = new javax.swing.JButton();
        bq = new javax.swing.JButton();
        sua = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cbSapXep = new javax.swing.JComboBox<>();

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

        jLabel1.setText("Ma NV");

        cbnv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Ma phong");

        cbpb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        them.setText("Them");
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });

        capnhat.setText("Cap nhat");

        bq.setText("Bo qua");

        sua.setText("Sua");

        jButton5.setText("Luu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Hien thi");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Xoa");

        jLabel3.setText("So ngay cong");

        jButton1.setText("Lam tuoi 2 ma");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lua chon sap xep", "Nhan vien", "Phong ban" }));
        cbSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSapXepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(cbnv, 0, 99, Short.MAX_VALUE)
                            .addComponent(cbpb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbSapXep, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(90, 90, 90))))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(them)
                    .addComponent(jButton5))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(capnhat)
                    .addComponent(jButton6))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bq)
                    .addComponent(jButton7))
                .addGap(54, 54, 54)
                .addComponent(sua)
                .addContainerGap(304, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(cbpb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94)
                        .addComponent(jButton1)))
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(them)
                    .addComponent(bq)
                    .addComponent(capnhat)
                    .addComponent(sua)
                    .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
        private NVien getNVienByMa(int ma){
        
        
            for(NVien i:lnv)
                if(i.getMa()==ma)
                    return i;
        
        return null;
    }
    private PBan getPBanByMa(int ma){
        String fpb="src/contrl/pb.dat";
        List<PBan> l1=IOFile.doc(fpb);
        if(l1!=null){
            for(PBan i:l1)
                if(i.getMa()==ma)
                    return i;
        }
        return null;
    }
    
    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
        // TODO add your handling code here:
        int mapb=Integer.parseInt(cbpb.getSelectedItem().toString());
        int manv=Integer.parseInt(cbnv.getSelectedItem().toString());
        if(trung2Ma(mapb, manv)){
            JOptionPane.showMessageDialog(this, "Trung 2 ma!");
            cbnv.requestFocus();
            return;
        }
        int sngay=0;
        try{
            sngay=Integer.parseInt(jTextField1.getText());
            CCong ql=new CCong(getNVienByMa(manv),getPBanByMa(mapb),sngay);
            tm.addRow(ql.toObject());
            lcCong.add(ql);
            
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Nhap so");
            jTextField1.requestFocus();
            return;
        }
    }//GEN-LAST:event_themActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        load2Ma();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        File f=new File(fcCong);
        if(f.exists()){
            lcCong=IOFile.doc(fcCong);
            tm.setRowCount(0);
            for(CCong i:lcCong)
                tm.addRow(i.toObject());
        }  
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        IOFile.ghi(fcCong, lcCong);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSapXepActionPerformed
        // TODO add your handling code here:
        if(cbSapXep.getSelectedIndex()==1){
            lcCong.sort(new Comparator<CCong>(){
                @Override
                public int compare(CCong o1, CCong o2) {
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
        if(cbSapXep.getSelectedIndex()==2){
            lcCong.sort(new Comparator<CCong>(){
                @Override
                public int compare(CCong o1, CCong o2) {
                    String[] ten1=o1.getP().getTen().split("\\s+");
                    String[] ten2=o2.getP().getTen().split("\\s+");
                    if(ten1[ten1.length-1].equalsIgnoreCase(ten2[ten2.length-1])){
                        return o1.getP().getTen().compareToIgnoreCase(o2.getP().getTen());
                    }
                    else
                        return ten1[ten1.length-1].compareToIgnoreCase(ten2[ten2.length-1]);
                }
                
            });
        }
        tm.setRowCount(0);
        for(CCong i:lcCong)
            tm.addRow(i.toObject());
    }//GEN-LAST:event_cbSapXepActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bq;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton capnhat;
    private javax.swing.JComboBox<String> cbSapXep;
    private javax.swing.JComboBox<String> cbnv;
    private javax.swing.JComboBox<String> cbpb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton sua;
    private javax.swing.JButton them;
    // End of variables declaration//GEN-END:variables

}
