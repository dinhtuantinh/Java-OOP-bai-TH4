/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view28;

import controller28.IOFile;
import controller28.TrongException;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model28.BangSX;
import model28.Lop;
import model28.PhongTH;

/**
 *
 * @author Admin
 */
public class FormBangSX extends javax.swing.JPanel {

    DefaultTableModel tm;
    private String fbangsx;
    private List<BangSX> lbangsx;
    private String flop;
    private List<Lop> llop;
    public FormBangSX() {
        initComponents();
        setSize(950,850);
        String[] cols={"Ma phong","Ten phong","SO may","Ma lop","Ten lop",
            "So SV","Kip hoc"};
        tm=new DefaultTableModel(cols, 0);
        jTable1.setModel(tm);
        fbangsx="src/controller/BANGSX.dat";
        flop="src/controller/LOP.dat";
        loadData();
        load2Ma();
    }
    private void loadData(){
        File f=new File(fbangsx);
        if(f.exists()){
            //List<Sach> list=IOFile.doc(fsach);
            lbangsx=IOFile.doc(fbangsx);
        }  
        else{
            lbangsx=new ArrayList<>();
        }
        File fs=new File(flop);
        if(fs.exists()){
            //List<Sach> list=IOFile.doc(fsach);
            llop=IOFile.doc(flop);
        }  
        else{
            llop=new ArrayList<>();
        }
    }
    private void load2Ma(){
        cbMaP.removeAllItems();
        cbMaL.removeAllItems();
        //String fsach="src/controller/sach.txt";
        String fq="src/controller/PH.dat";
        List<PhongTH> l1=IOFile.doc(fq);
        if(l1!=null){
            for(PhongTH i:l1)
                cbMaP.addItem(i.getMa()+"");
        }
        
        
            for(Lop i:llop)
                cbMaL.addItem(i.getMa()+"");
        
    }
    private boolean trungphong(int maP, int kip){
        for(BangSX i:lbangsx)
            if(i.getPhongTH().getMa()==maP && i.getKiphoc()==kip)
                return true;
        return false;
    } 
    private boolean trunggio(int maL, int kip){
        for(BangSX i:lbangsx)
            if(i.getLop().getMa()==maL && i.getKiphoc()==kip)
                return true;
        return false;
    }
    private int demDauSach(int mabd){
        int count=0;
        for(BangSX i:lbangsx)
            if(i.getPhongTH().getMa()==mabd)
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
        cbMaP = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbMaL = new javax.swing.JComboBox<>();
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

        cbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...Lua chon sap xep...", "Ten lop hoc", "Kip hoc" }));
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

        jLabel1.setText("Ma phong");

        cbMaP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaPActionPerformed(evt);
            }
        });

        jLabel2.setText("Ma lop");

        cbMaL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMaL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaLActionPerformed(evt);
            }
        });

        jLabel3.setText("Kip hoc");

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
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(cbMaP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMaL, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(cbMaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void cbMaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaPActionPerformed
        
    }//GEN-LAST:event_cbMaPActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        load2Ma();
    }//GEN-LAST:event_jButton1ActionPerformed
    private Lop getLopByMa(int ma){
            for(Lop i:llop)
                if(i.getMa()==ma)
                    return i;
        
        return null;
    }
    private PhongTH getPhongByMa(int ma){
        String fphong="src/controller/PH.dat";
        List<PhongTH> l1=IOFile.doc(fphong);
        if(l1!=null){
            for(PhongTH i:l1)
                if(i.getMa()==ma)
                    return i;
        }
        return null;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int maphong=Integer.parseInt(cbMaP.getSelectedItem().toString());
        int malop=Integer.parseInt(cbMaL.getSelectedItem().toString());
        int kip=Integer.parseInt(jTextField1.getText());
        if(trungphong(maphong, kip)){
            JOptionPane.showMessageDialog(this, "Trung kip voi lop khac tai phong nay!");
            cbMaP.requestFocus();
            return;
        }
        if(trunggio(malop, kip)){
            JOptionPane.showMessageDialog(this, "Trung gio khong the thuc hanh!");
            cbMaL.requestFocus();
            return;
        }
        int somay=getPhongByMa(maphong).getSomay();
        int soSV=getLopByMa(malop).getSoSV();
        try{
            int kipH=Integer.parseInt(jTextField1.getText());
            if(soSV>somay){
                JOptionPane.showMessageDialog(this, "Khong du may de thuc hanh!!");
                jTextField1.requestFocus();
                return;
            }
            BangSX sx=new BangSX(getPhongByMa(maphong),getLopByMa(malop), kipH);
            tm.addRow(sx.toObjects());
            lbangsx.add(sx);
            IOFile.viet(flop, llop);
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Nhap so");
            jTextField1.requestFocus();
            return;
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        File f=new File(fbangsx);
        if(f.exists()){
            lbangsx=IOFile.doc(fbangsx);
            tm.setRowCount(0);
            for(BangSX i:lbangsx)
                tm.addRow(i.toObjects());
        }  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        IOFile.viet(fbangsx, lbangsx);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbMaLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMaLActionPerformed

    private void cbSapXepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSapXepItemStateChanged
        // TODO add your handling code here:
        if(cbSapXep.getSelectedIndex()==1){
            lbangsx.sort(new Comparator<BangSX>(){
                @Override
                public int compare(BangSX o1, BangSX o2) {
                    String[] ten1=o1.getLop().getTen().split("\\s+");
                    String[] ten2=o2.getLop().getTen().split("\\s+");
                    if(ten1[ten1.length-1].equalsIgnoreCase(ten2[ten2.length-1])){
                        return o1.getLop().getTen().compareToIgnoreCase(o2.getLop().getTen());
                    }
                    else
                        return ten1[ten1.length-1].compareToIgnoreCase(ten2[ten2.length-1]);
                }
            });
        }
        if(cbSapXep.getSelectedIndex()==2){
            lbangsx.sort(new Comparator<BangSX>(){
                @Override
                public int compare(BangSX o1, BangSX o2) {
                    return Integer.compare(o1.getKiphoc(), o2.getKiphoc());
                }
                
            });
        }
        tm.setRowCount(0);
        for(BangSX i:lbangsx)
            tm.addRow(i.toObjects());
    }//GEN-LAST:event_cbSapXepItemStateChanged

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void cbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSapXepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSapXepActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMaL;
    private javax.swing.JComboBox<String> cbMaP;
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
