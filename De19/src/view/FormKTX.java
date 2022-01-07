/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view19;

import controller19.IOFile;
import controller19.NhapDateException;
import controller19.TrongException;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model19.KyTucXa;
import model19.Phong;
import model19.SinhVien;

/**
 *
 * @author Admin
 */
public class FormKTX extends javax.swing.JPanel {

    DefaultTableModel tm;
    private String fktx;
    private List<KyTucXa> lktx;
    private String fsinhvien;
    private List<SinhVien> lsinhvien;
    public FormKTX() {
        initComponents();
        setSize(950,850);
        String[] cols={"Ma phong","Ten phong","Ma SV","Ten SV","Ngay vao"};
        tm=new DefaultTableModel(cols, 0);
        jTable1.setModel(tm);
        fktx="src/controller/DSKTX.dat";
        fsinhvien="src/controller/SV.dat";
        loadData();
        load2Ma();
    }

    private void loadData(){
        File f=new File(fktx);
        if(f.exists()){
            //List<Sach> list=IOFile.doc(fsach);
            lktx=IOFile.doc(fktx);
        }  
        else{
            lktx=new ArrayList<>();
        }
        File fdv=new File(fsinhvien);
        if(fdv.exists()){
            //List<Sach> list=IOFile.doc(fsach);
            lsinhvien=IOFile.doc(fsinhvien);
        }  
        else{
            lsinhvien=new ArrayList<>();
        }
    }
    private void load2Ma(){
        cbMaPhong.removeAllItems();
        cbMaSV.removeAllItems();
        //String fsach="src/controller/sach.txt";
        String fp="src/controller/PHONG.dat";
        List<Phong> l1=IOFile.doc(fp);
        if(l1!=null){
            for(Phong i:l1)
                cbMaPhong.addItem(i.getMa()+"");
        }
        
        
            for(SinhVien i:lsinhvien)
                cbMaSV.addItem(i.getMa()+"");
        
    }
    private boolean trung2Ma(int maphong, int masv){
        for(KyTucXa i:lktx)
            if(i.getPhong().getMa()==maphong && i.getSinhvien().getMa()==masv)
                return true;
        return false;
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
        cbMaPhong = new javax.swing.JComboBox<>();
        cbMaSV = new javax.swing.JComboBox<>();
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

        jLabel1.setText("Ma phong");

        jLabel2.setText("Ma sinh vien");

        jLabel3.setText("Ngay vao o");

        jButton1.setText("Lam moi hai ma");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbMaPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbMaSV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                            .addComponent(cbMaPhong, 0, 114, Short.MAX_VALUE)
                            .addComponent(cbMaSV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        cbSapxep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lua chon sap xep", "Ho ten sinh vien", "Ten phong" }));
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
        File f=new File(fktx);
        if(f.exists()){
            lktx=IOFile.doc(fktx);
            tm.setRowCount(0);
            for(KyTucXa i:lktx)
                tm.addRow(i.toObjects());
        }  
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int maP=Integer.parseInt(cbMaPhong.getSelectedItem().toString());
        int maSV=Integer.parseInt(cbMaSV.getSelectedItem().toString());
        if(trung2Ma(maP, maSV)){
            JOptionPane.showMessageDialog(this, "Trung 2 ma!");
            cbMaPhong.requestFocus();
            return;
        }
        String nvao;
        long tonggia=0;
        try{
            nvao=jTextField4.getText();
            if(nvao.length()!=10) throw new NhapDateException();
            long day=(nvao.charAt(0)-'0')*10+nvao.charAt(1)-'0';
            long month=(nvao.charAt(3)-'0')*10+(nvao.charAt(4)-'0');
            long year=(nvao.charAt(6)-'0')*1000+(nvao.charAt(7)-'0')*100+(nvao.charAt(8)-'0')*10+(nvao.charAt(9)-'0');
            long tngayvao=day+month*30+year*365;
            long tngayhientai=6+12*30+2021*365;
            long gialoaiphong=0;
            String loaiphong=getPByMa(maP).getLphong();
            if(loaiphong.equalsIgnoreCase("Phòng VIP")) gialoaiphong=1000;
            else if(loaiphong.equalsIgnoreCase("Chất lượng cao")) gialoaiphong=500;
            else gialoaiphong=300;
            tonggia=((tngayhientai-tngayvao)/30)*gialoaiphong;
            KyTucXa q=new KyTucXa(getPByMa(maP),getSVByMa(maSV),nvao,tonggia);
            tm.addRow(q.toObjects());
            lktx.add(q);
            IOFile.viet(fktx, lktx);
            
        }catch(NhapDateException e){
            JOptionPane.showMessageDialog(this, "Nhap dinh dang dd/mm/yyyy");
            jTextField4.requestFocus();
            return;
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        IOFile.viet(fktx, lktx);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbSapxepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSapxepActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbSapxepActionPerformed

    private void cbSapxepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSapxepItemStateChanged
        // TODO add your handling code here:
        if(cbSapxep.getSelectedIndex()==1){
            lktx.sort(new Comparator<KyTucXa>(){
                @Override
                public int compare(KyTucXa o1, KyTucXa o2) {
                    String[] ten1=o1.getSinhvien().getHoten().split("\\s+");
                    String[] ten2=o2.getSinhvien().getHoten().split("\\s+");
                    if(ten1[ten1.length-1].equalsIgnoreCase(ten2[ten2.length-1])){
                        return o1.getSinhvien().getHoten().compareToIgnoreCase(o2.getSinhvien().getHoten());
                    }
                    else
                        return ten1[ten1.length-1].compareToIgnoreCase(ten2[ten2.length-1]);
                }
            });
        }
        if(cbSapxep.getSelectedIndex()==2){
            lktx.sort(new Comparator<KyTucXa>(){
                @Override
                public int compare(KyTucXa o1, KyTucXa o2) {
                    return Integer.compare(o1.getPhong().getTen(), o2.getPhong().getTen());
                }
                
            });
        }
        tm.setRowCount(0);
        for(KyTucXa i:lktx)
            tm.addRow(i.toObjects());
    }//GEN-LAST:event_cbSapxepItemStateChanged
    private SinhVien getSVByMa(int ma){
        
        
            for(SinhVien i:lsinhvien)
                if(i.getMa()==ma)
                    return i;
        
        return null;
    }
    private Phong getPByMa(int ma){
        String fbdoc="src/controller/PHONG.dat";
        List<Phong> l1=IOFile.doc(fbdoc);
        if(l1!=null){
            for(Phong i:l1)
                if(i.getMa()==ma)
                    return i;
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMaPhong;
    private javax.swing.JComboBox<String> cbMaSV;
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
