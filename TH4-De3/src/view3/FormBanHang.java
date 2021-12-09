/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view3;

import control3.IOFile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model3.BanHang;
import model3.KHang;
import model3.MHang;

/**
 *
 * @author Pham Thanh
 */
public class FormBanHang extends javax.swing.JPanel {

    /**
     * Creates new form FormBanHang
     */
    private List<BanHang> list;
    DefaultTableModel tm;
    boolean t,s;
    private String file;
    public FormBanHang() {
        initComponents();
        String[] cols = {"Ma KH","Ten KH","Ma MH","Ten MH","So luong"};
        tm = new DefaultTableModel(cols,0);
        jTable1.setModel(tm);
        buttonTrue();
        t = s = false;
        file = "src/control/muahang.dat";
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
//        jComboBox3.removeAllItems();
        List<KHang> lkh = IOFile.doc("src/control/kh.dat");
//        IOFile.doc("src/control/kh.dat",l1);
        for(KHang i : lkh){
            jComboBox1.addItem(i.getMa()+"");
        }
        List<MHang> lmh = IOFile.doc("src/control/mh.dat");
//        IOFile.doc("src/control/kh.dat",l1);
        for(MHang j : lmh){
            jComboBox2.addItem(j.getMa()+"");
        }

  
        
    }
    public void buttonTrue(){
        them.setEnabled(true);
        sua.setEnabled(true);
        capnhat.setEnabled(false);
        bq.setEnabled(false);
    }
    public void buttonFalse(){
        them.setEnabled(false);
        sua.setEnabled(false);
        capnhat.setEnabled(true);
        bq.setEnabled(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        capnhat = new javax.swing.JButton();
        bq = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        them = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        sua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        capnhat.setText("Cap Nhat");
        capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatActionPerformed(evt);
            }
        });

        bq.setText("Bo Qua");

        jButton5.setText("Luu file");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Hien Thi");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Xoa");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        them.setText("Them");
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        sua.setText("Sua");

        jLabel1.setText("Ma KH");

        jLabel2.setText("Ma MH");

        jLabel3.setText("SL");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jButton1.setText("Sap xep");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Ten KH");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Ten MH");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(them)
                            .addComponent(jButton5))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sua)
                            .addComponent(jButton6))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(capnhat)
                            .addComponent(jButton7))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bq)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(49, 49, 49)
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(them)
                    .addComponent(sua)
                    .addComponent(capnhat)
                    .addComponent(bq))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    public KHang getKHByMa(int ma){
        List<KHang> lkh = IOFile.doc("src/control/kh.dat");
        for(KHang i : lkh) 
            if(ma == i.getMa()) return i;
        return null;
    }
    public MHang getMHByMa(int ma){
        List<MHang> lkh = IOFile.doc("src/control/mh.dat");
        for(MHang i : lkh) 
            if(ma == i.getMa()) return i;
        return null;
    }
    
    public boolean tontai(int makh,int mamh){
        List<BanHang> l = IOFile.doc("src/control/muahang.dat");
        for(BanHang i : l){
            if(i.getK().getMa()==makh && i.getM().getMa()==mamh) return true;
        }
        return false;
    }
    private void capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatActionPerformed
        // TODO add your handling code here:
        if(t){
            t = false;
//            int ma = Integer.parseInt(jTextField1.getText());
//            String ten = jTextField2.getText();
//            String loai = jComboBox1.getSelectedItem().toString();
//            String gai = jTextField3.getText();
//            BanHang m = new BanHang(ma, ten, loai, gai);
//            tm.addRow(m.toObject());
            int makh = Integer.parseInt(jComboBox1.getSelectedItem().toString());
            int mamh = Integer.parseInt(jComboBox2.getSelectedItem().toString());
            if(tontai(makh, mamh)){
                JOptionPane.showMessageDialog(this, "Trung ma");
            }
            else{
                KHang k = getKHByMa(makh);
                MHang m = getMHByMa(mamh);
                int sl = Integer.parseInt(jComboBox3.getSelectedItem().toString());
                tm.addRow((new BanHang(k, m, sl)).toObject());
            } 
                
        }
        //        if(s){
            //
            //        }
        buttonTrue();
    }//GEN-LAST:event_capnhatActionPerformed
    public List<BanHang> getBH(){
        List<BanHang> l = new ArrayList<>();
        for (int i = 0; i < tm.getRowCount(); i++) {
            int makh = Integer.parseInt(tm.getValueAt(i, 0).toString());
//            String tenkh = tm.getValueAt(i,1).toString();
//            String tenmh = tm.getValueAt(i,3).toString();
            int mamh = Integer.parseInt(tm.getValueAt(i, 2).toString());
            int sl = Integer.parseInt(tm.getValueAt(i, 4).toString());
            KHang k = getKHByMa(makh);
                MHang m = getMHByMa(mamh);
//                int sl = Integer.parseInt(jComboBox3.getSelectedItem().toString());
                l.add((new BanHang(k, m, sl)));
//            l.add(new BanHang(k, m, sl))
        }
        return l;
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        List<BanHang> l = getBH();
        IOFile.ghi(file,l);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        tm.setRowCount(0);
        List<BanHang> list = IOFile.doc(file);
        for(BanHang i : list){
            tm.addRow(i.toObject());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int r =jTable1.getSelectedRow();
        if(r<0 || r>tm.getRowCount()){
            JOptionPane.showMessageDialog(this,"Chon dong can xoa");
        }
        else tm.removeRow(r);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
        // TODO add your handling code here:
        t = true;
        
        buttonFalse();
    }//GEN-LAST:event_themActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        List<BanHang> l = getBH();
        if(jRadioButton1.isSelected()){
            l.sort(new Comparator<BanHang>(){
                @Override
                public int compare(BanHang o1, BanHang o2) {
                    return o1.getK().getTen().compareToIgnoreCase(o2.getK().getTen());
                }
                
            });
        }
        else 
            l.sort(new Comparator<BanHang>(){
                @Override
                public int compare(BanHang o1, BanHang o2) {
                    return o1.getM().getTen().compareToIgnoreCase(o2.getM().getTen());
                }
                
            });
        tm.setRowCount(0);
        for(BanHang i : l) tm.addRow(i.toObject());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bq;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton capnhat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton sua;
    private javax.swing.JButton them;
    // End of variables declaration//GEN-END:variables
}