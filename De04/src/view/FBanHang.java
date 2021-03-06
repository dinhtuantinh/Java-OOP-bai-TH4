/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view4;
import control4.IOFile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model4.MHang;
import model4.BHang;
import model4.NVien;

 
public class FBanHang extends javax.swing.JPanel {

    /**
     * Creates new form FBanHang
     */
     DefaultTableModel tm;
    List<BHang> list;
    boolean t,s;
    String file = "src/control/bh.dat";
    String fnv = "src/control/nv.dat";
    String fmh = "src/control/mh.dat";
    public FBanHang() {
        initComponents();
         String[] cols={"Ma NV","Ten NV","Ma MH","Ten MH","Nhom MH"};
        tm = new DefaultTableModel(cols,0);
        jTable1.setModel(tm);
        t = s = false;
        buttonTrue();
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        List<MHang> fm = IOFile.doc(fmh);
        List<NVien> fn = IOFile.doc(fnv);
        for(MHang i : fm) jComboBox2.addItem(i.getMa()+"");
        for(NVien i : fn) jComboBox1.addItem(i.getMa()+"");
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        capnhat = new javax.swing.JButton();
        bq = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        them = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        sua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        capnhat.setText("Cap nhat");
        capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatActionPerformed(evt);
            }
        });

        bq.setText("Bo qua");

        jLabel2.setText("Ma MH");

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

        them.setText("Them");
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });

        jButton7.setText("Xoa");

        sua.setText("Sua");

        jLabel1.setText("Ma NV");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Nhom MH");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Ten NV");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Sap xep");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(62, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5)
                            .addComponent(them))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sua)
                                .addGap(75, 75, 75)
                                .addComponent(capnhat))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(bq))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jButton1)
                                .addGap(61, 61, 61)
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton1)))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(them)
                    .addComponent(sua)
                    .addComponent(capnhat)
                    .addComponent(bq))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton6)
                            .addComponent(jButton7)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(16, 16, 16))))
        );
    }// </editor-fold>//GEN-END:initComponents
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
    public boolean tontai(int ma1,int ma2){
        List<BHang> b = IOFile.doc(file);
        for(BHang i : b){
            if(i.getN().getMa()==ma1 && i.getM().getMa()==ma2) return true;
        }
        return false;
    }
    public boolean lonhon5(int ma){
//        List<BHang> b = IOFile.doc(file);
        int dem = 0;
        for(int i=0;i<tm.getRowCount();i++){
            if(Integer.parseInt(tm.getValueAt(i, 0).toString())==ma) dem++;
        }
        if(dem > 5) return true;
        return false;
    }
    private void capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatActionPerformed
        // TODO add your handling code here:
        buttonTrue();
        if(t){
            t = false;
//            int ma = Integer.parseInt(jTextField1.getText());
//            String ten = jTextField2.getText();
//            String dc = jTextField3.getText();
//            String sdt = jTextField4.getText();
            //            String dc = jComboBox1.getSelectedItem().toString();
            //            int gia = Integer.parseInt(jTextField3.getText());
            //            int sl = Integer.parseInt(jTextField4.getText());
            int manv = Integer.parseInt(jComboBox1.getSelectedItem().toString());
            int mamh = Integer.parseInt(jComboBox2.getSelectedItem().toString());
            if(tontai(manv,mamh) || lonhon5(manv)){
                JOptionPane.showMessageDialog(this,"ERROR !");
            }
            else{
                NVien n = getNVByMa(manv);
                MHang m = getMHByMa(mamh);
                tm.addRow((new BHang(n, m)).toObject());
            }
        }
    }//GEN-LAST:event_capnhatActionPerformed
    public NVien getNVByMa(int ma){
        List<NVien> fn = IOFile.doc(fnv);
        for(NVien i : fn) if(i.getMa()==ma) return i;
        return null;
    }
    public MHang getMHByMa(int ma){
        List<MHang> fn = IOFile.doc(fmh);
        for(MHang i : fn) if(i.getMa()==ma) return i;
        return null;
    }
    public List<BHang> getBH(){
        List<BHang> l = new ArrayList<>();
        for (int i = 0; i < tm.getRowCount(); i++) {
            int manv = Integer.parseInt(tm.getValueAt(i, 0).toString());
            int mamh = Integer.parseInt(tm.getValueAt(i, 2).toString());
            NVien n = getNVByMa(manv);
            MHang m = getMHByMa(mamh);
            l.add(new BHang(n,m));
        }
        
        return l;
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        List<BHang> l = getBH();
        IOFile.ghi(file,l);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        tm.setRowCount(0);
        List<BHang> l = IOFile.doc(file);
        for(BHang i : l) tm.addRow(i.toObject());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
        // TODO add your handling code here:
        t = true;
        buttonFalse();
        List<BHang> l = getBH();
//        if(l.size()>0){
//            BHang.setSma(l.get(l.size()-1).getMa() + 1);
//        }
//        
        
    }//GEN-LAST:event_themActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        List<BHang> l = getBH();
        if(jRadioButton1.isSelected()){
            l.sort(new Comparator<BHang>(){
                @Override
                public int compare(BHang o1, BHang o2) {
                    return o1.getM().getNhom().compareToIgnoreCase(o2.getM().getNhom());
                }

            });
        }
        else 
            l.sort(new Comparator<BHang>(){
                @Override
                public int compare(BHang o1, BHang o2) {
                    return o1.getN().getTen().compareToIgnoreCase(o2.getN().getTen());
                }

            });
        tm.setRowCount(0);
        for(BHang i : l) tm.addRow(i.toObject());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed


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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton sua;
    private javax.swing.JButton them;
    // End of variables declaration//GEN-END:variables
}
