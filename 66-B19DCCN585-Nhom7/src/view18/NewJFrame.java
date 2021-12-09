/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view18;
import controller18.DiemException;
import controller18.FileIO;
import controller18.DeTrongException;
import controller18.LopException;
import controller18.SoDVHTException;
import controller18.TrungNhauException;
import model18.BangDiem;
import model18.SinhVien;
import model18.MonHoc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author LENOVO
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public static final String sinhVienFile ="SV.TXT",monHocFile ="MH.TXT",bangDiemFile ="BANGDIEM.TXT";
    ArrayList<SinhVien>sinhViensList;
    ArrayList<MonHoc>monHocsList;
    ArrayList<BangDiem>bangDiemsList;
    DefaultTableModel sinhVIenDefaultTableModel,monHocDefaultTableModel,bangDiemDefaultTableModel;
    public NewJFrame() {
        initComponents();
        sinhViensList=new ArrayList<>();
        monHocsList=new ArrayList<>();
        bangDiemsList=new ArrayList<>();
        sinhVIenDefaultTableModel=(DefaultTableModel)sinhVienTable.getModel();
        monHocDefaultTableModel=(DefaultTableModel)monHocTable.getModel();
        bangDiemDefaultTableModel=(DefaultTableModel)bangDiemTable.getModel();
        loadDataToTable();
        loadDataToBox();
        
        themSinhVienBTN.addActionListener((e) -> {
            try {
                String hoTen=hoTenTF.getText();
                String diaChi =diaChiTF.getText();
                String ngaySinh =ngaySinhTF.getText();
                String lop =lopTF.getText();
                
                int temp=sinhViensList.size()-1;
                if(temp!=-1){
                    SinhVien.setMaSinhVienCurrent(sinhViensList.get(temp).getMaSinhVien());
                }
                
                SinhVien sinhVien=new SinhVien(hoTen, diaChi, ngaySinh, lop);
                for(SinhVien sv:sinhViensList){
                    if(sinhVien.trungNhau(sv)){
                        throw new TrungNhauException();
                    }
                }
                sinhVIenDefaultTableModel.addRow(sinhVien.toObjects());
                sinhViensList.add(sinhVien);
                loadDataToBox();
            } catch (DeTrongException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc de trong thong tin");
            } catch (LopException ex) {
                JOptionPane.showMessageDialog(null, "lop phai theo quy tac ptit");
            } catch (TrungNhauException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc nhap trung sinh vien");
            }
            
        });
        
        themMonHocBTN.addActionListener((e) -> {
            String tenMon =tenMonTF.getText();
            String soDVHT =soDVHTTF.getText();
            String loaiMon =loaiMonCB.getItemAt(loaiMonCB.getSelectedIndex());
            
            int temp=monHocsList.size()-1;
            if(temp!=-1){
                MonHoc.setMaMonCurrent(monHocsList.get(temp).getMaMon());
            }
            
            try{
                int s=Integer.parseInt(soDVHT);
                MonHoc monHoc=new MonHoc(tenMon, s, loaiMon);
                for(MonHoc mh:monHocsList){
                    if(monHoc.trungNhau(mh))throw new TrungNhauException();
                }
                monHocDefaultTableModel.addRow(monHoc.toObjects());
                monHocsList.add(monHoc);
                loadDataToBox();
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "so dvht la so");
            } catch (DeTrongException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc de trong thong tin");
            } catch (SoDVHTException ex) {
                JOptionPane.showMessageDialog(null, "so dvht>=0");
            } catch (TrungNhauException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc nhap trung");
            }
        });
        
        themBangDiemBTN.addActionListener((e) -> {
            int sinhVienNo =maSVCB.getSelectedIndex();
            int monHocNo=maMonCB.getSelectedIndex();
            SinhVien sinhVien=sinhViensList.get(sinhVienNo);
            MonHoc monHoc=monHocsList.get(monHocNo);
            
            try{
                float diem=Float.parseFloat(diemTF.getText());
                BangDiem bangDiem=new BangDiem(sinhVien, monHoc, diem);
                int count=0;
                for(BangDiem bd:bangDiemsList){
                    if(bangDiem.trungNhau(bd)){
                        bd.setDiem(diem);
                        bangDiemDefaultTableModel.setValueAt(diem, count, 4);
                        JOptionPane.showMessageDialog(null, "cap nhat thanh cong");
                        return;
                    }
                    count++;
                }
                bangDiemDefaultTableModel.addRow(bangDiem.toObjects());
                bangDiemsList.add(bangDiem);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "diem la so");
            } catch (DiemException ex) {
                JOptionPane.showMessageDialog(null, "diem trong khoang tu 0 den 10");
            }
        });
        
        sortBTN.addActionListener((e) -> {
            String choice =sortCB.getItemAt(sortCB.getSelectedIndex());
            if(choice.equals("theo ho ten sinh vien")){
                Collections.sort(bangDiemsList  , (o1, o2) -> {
                    return o1.getSinhVien().getHoTen().compareTo(o2.getSinhVien().getHoTen());
                }
                );
                
            }
                else{
                Collections.sort(bangDiemsList,(o1, o2) -> {
                    return o1.getMonHoc().getTenMon().compareTo(o2.getMonHoc().getTenMon());
                });
            }
            bangDiemDefaultTableModel.setRowCount(0);
            for(BangDiem bangDiem:bangDiemsList){
                bangDiemDefaultTableModel.addRow(bangDiem.toObjects());
            }
        });
        
        saveDataToFile(luuSinhVienBTN, sinhViensList, sinhVienFile);
        saveDataToFile(luuMonHocBTN, monHocsList, monHocFile);
        saveDataToFile(luuBangDIemBTN, bangDiemsList, bangDiemFile);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hoTenTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        diaChiTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ngaySinhTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lopTF = new javax.swing.JTextField();
        themSinhVienBTN = new javax.swing.JButton();
        luuSinhVienBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sinhVienTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tenMonTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        soDVHTTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        themMonHocBTN = new javax.swing.JButton();
        luuMonHocBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        monHocTable = new javax.swing.JTable();
        loaiMonCB = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        diemTF = new javax.swing.JTextField();
        themBangDiemBTN = new javax.swing.JButton();
        luuBangDIemBTN = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        bangDiemTable = new javax.swing.JTable();
        maSVCB = new javax.swing.JComboBox<>();
        maMonCB = new javax.swing.JComboBox<>();
        sortCB = new javax.swing.JComboBox<>();
        sortBTN = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ho ten");

        jLabel2.setText("dia chi");

        jLabel3.setText("ngay sinh");

        jLabel4.setText("lop");

        themSinhVienBTN.setText("them");

        luuSinhVienBTN.setText("luu");

        sinhVienTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma sinh vien", "ho ten", "dia chi ", "ngay sinh", "lop"
            }
        ));
        jScrollPane1.setViewportView(sinhVienTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hoTenTF)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaChiTF, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngaySinhTF, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lopTF, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(themSinhVienBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luuSinhVienBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(142, 142, 142)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hoTenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(diaChiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ngaySinhTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lopTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(themSinhVienBTN)
                        .addGap(29, 29, 29)
                        .addComponent(luuSinhVienBTN)))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("sinh vien", jPanel1);

        jLabel5.setText("ten mon");

        jLabel6.setText("so dvht");

        jLabel7.setText("loai mon");

        themMonHocBTN.setText("them");

        luuMonHocBTN.setText("luu");

        monHocTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma mon", "ten mon", "so dvht", "loai mon"
            }
        ));
        jScrollPane2.setViewportView(monHocTable);

        loaiMonCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dai cuong", "co so nganh", "chuyen nganh" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenMonTF)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soDVHTTF, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themMonHocBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luuMonHocBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loaiMonCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(146, 146, 146)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(348, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tenMonTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(soDVHTTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(loaiMonCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(themMonHocBTN)
                        .addGap(29, 29, 29)
                        .addComponent(luuMonHocBTN)))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("mon hoc", jPanel2);

        jLabel9.setText("ma sinh vien");

        jLabel10.setText("ma mon hoc");

        jLabel11.setText("diem");

        themBangDiemBTN.setText("them");

        luuBangDIemBTN.setText("luu");

        bangDiemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma sinh vien", "ho ten", "ma mon", "ten mon", "diem"
            }
        ));
        jScrollPane3.setViewportView(bangDiemTable);

        sortCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "theo ho ten sinh vien", "theo ten mon" }));

        sortBTN.setText("sap xep");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diemTF, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(themBangDiemBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(luuBangDIemBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maSVCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maMonCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sortCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(sortBTN)))
                .addGap(142, 142, 142)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(maSVCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(maMonCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(diemTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(themBangDiemBTN)
                        .addGap(33, 33, 33)
                        .addComponent(luuBangDIemBTN)
                        .addGap(36, 36, 36)
                        .addComponent(sortCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sortBTN)))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("bang diem", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1333, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangDiemTable;
    private javax.swing.JTextField diaChiTF;
    private javax.swing.JTextField diemTF;
    private javax.swing.JTextField hoTenTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> loaiMonCB;
    private javax.swing.JTextField lopTF;
    private javax.swing.JButton luuBangDIemBTN;
    private javax.swing.JButton luuMonHocBTN;
    private javax.swing.JButton luuSinhVienBTN;
    private javax.swing.JComboBox<String> maMonCB;
    private javax.swing.JComboBox<String> maSVCB;
    private javax.swing.JTable monHocTable;
    private javax.swing.JTextField ngaySinhTF;
    private javax.swing.JTable sinhVienTable;
    private javax.swing.JTextField soDVHTTF;
    private javax.swing.JButton sortBTN;
    private javax.swing.JComboBox<String> sortCB;
    private javax.swing.JTextField tenMonTF;
    private javax.swing.JButton themBangDiemBTN;
    private javax.swing.JButton themMonHocBTN;
    private javax.swing.JButton themSinhVienBTN;
    // End of variables declaration//GEN-END:variables

    private void loadDataToTable() {
        FileIO.readToList(sinhViensList, sinhVienFile);
        FileIO.readToList(monHocsList, monHocFile);
        FileIO.readToList(bangDiemsList, bangDiemFile);
        for(SinhVien sinhVien:sinhViensList){
            sinhVIenDefaultTableModel.addRow(sinhVien.toObjects());
        }
        for(MonHoc monHoc:monHocsList){
            monHocDefaultTableModel.addRow(monHoc.toObjects());
        }
        for(BangDiem bangDiem:bangDiemsList){
            bangDiemDefaultTableModel.addRow(bangDiem.toObjects());
        }
    }

    private void saveDataToFile(JButton btn ,ArrayList list,String file) {
        btn.addActionListener((e) -> {
            FileIO.writeToFile(list, file);
            JOptionPane.showMessageDialog(null, "da luu vao "+file);
        });
    }

    private void loadDataToBox() {
        maMonCB.removeAllItems();
        maSVCB.removeAllItems();
        for(SinhVien sinhVien:sinhViensList){
            maSVCB.addItem(sinhVien.getMaSinhVien()+"");
        }
        for(MonHoc monHoc:monHocsList){
            maMonCB.addItem(monHoc.getMaMon()+"");
        }
    }
}
