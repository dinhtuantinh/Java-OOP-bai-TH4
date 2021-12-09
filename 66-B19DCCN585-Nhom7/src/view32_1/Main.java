/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view32_1;
import controller32_1.FileIO;
import controller32_1.deTrongException;
import model32_1.KieuBaiViet;
import model32_1.PhongVien;
import model32_1.TinhCong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duymanh
 */
public class Main extends javax.swing.JFrame {

    public  static final String phongVienFIle="src/controller/PV.txt",kieuBaiVietFile="src/controller/KB.txt",
            tinhCongFile="src/controller/TC.txt";
    ArrayList<PhongVien>phongvienList;
    ArrayList<KieuBaiViet>kieubaivietList;
    ArrayList<TinhCong>tinhcongList;
    DefaultTableModel phongVienDefaultTableModel,kieuBaiVietDefaultTableModel,tinhCongDefaultTableModel;
    public Main() {
        initComponents();
        phongvienList=new ArrayList<>();
        kieubaivietList=new ArrayList<>();
        tinhcongList=new ArrayList<>();
        phongVienDefaultTableModel=(DefaultTableModel)phongvienTable.getModel();
        kieuBaiVietDefaultTableModel=(DefaultTableModel)kieubaiTable.getModel();
        tinhCongDefaultTableModel=(DefaultTableModel)tinhcongTable.getModel();
        loadDataToTable();
        loadDataToBox();
        themphongvienBT.addActionListener((e) -> {
            String hoten=hotenPhongVienTF.getText();
            String diachi=diachiPhongVienTF.getText();
            String loai=loaipvCB.getItemAt(loaipvCB.getSelectedIndex());
            if(hoten.equals("") && diachi.equals("") && loai.equals("")){
                JOptionPane.showMessageDialog(null,"Khong duoc de trong");
            }
            int temp=phongvienList.size()-1;
            if(temp!=-1){
                PhongVien.setMaPhongVienLast(phongvienList.get(temp).getMaPhongVien());
            }
            PhongVien phongvien=new PhongVien(hoten, diachi, loai);
            for(PhongVien i:phongvienList){
                if(phongvien.trungnhau(i)){
                    JOptionPane.showMessageDialog(null, "Khong duoc nhap trung");
                    return;
                }
            }
            phongvienList.add(phongvien);
            phongVienDefaultTableModel.addRow(phongvien.toObjects());
            loadDataToBox();
        });
        themKieuBaiBT.addActionListener((e) -> {
            String tenkieubai=tenkieubaiTF.getText();
            String dongia=dongiaKieuBaiTF.getText();
            if(tenkieubai.equals("") || dongia.equals("")){
                JOptionPane.showMessageDialog(null, "Khong de trong");
                return;
            }
            int temp=kieubaivietList.size()-1;
            if(temp!=-1){
                KieuBaiViet.setMaKieuBailast(kieubaivietList.get(temp).getMaKieuBai());
            }
            try{
                Double d=Double.parseDouble(dongia);
                KieuBaiViet kieubaiviet=new KieuBaiViet(tenkieubai,d);
                for(KieuBaiViet kbv:kieubaivietList){
                    if(kieubaiviet.trungnhau(kbv)){
                        JOptionPane.showMessageDialog(null, "Khong duoc nhap trung");
                    }
                }
                kieubaivietList.add(kieubaiviet);
                kieuBaiVietDefaultTableModel.addRow(kieubaiviet.toObjects());
                loadDataToBox();
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Don Gia Phai La so!");
                return;
            }
        });
        themTCBT.addActionListener((e) -> {
            int Mapv=MaPVtinhcongCB.getSelectedIndex();
            int MaBV=maKBtinhcongCB.getSelectedIndex();
            String sl=soluongbaiTF.getText();
            if(sl.equals("")){
                JOptionPane.showMessageDialog(null, "Khong de trong!");
            }
            PhongVien pv=phongvienList.get(Mapv);
            KieuBaiViet kbv=kieubaivietList.get(MaBV);
            try{
                int count=0;
                int n=Integer.parseInt(sl);
                TinhCong tc=new TinhCong(pv, kbv, n);
                for(TinhCong i:tinhcongList){
                    if(tc.trungnhau(i)){
                        JOptionPane.showMessageDialog(null, "Khong Nhap Trung");
                        return;
                    }
                    if(tc.dieukien(i)){
                        count++;
                    }
                }
                if(count>=5){
                    JOptionPane.showMessageDialog(null,"Mot Phong Vien Khong Co qua 5 kieu bai");
                    return;
                }
                tinhcongList.add(tc);
                tinhCongDefaultTableModel.addRow(tc.toObjects());
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Nhap Vao So");
                return;
            }
            
        });
        sapxepBT1.addActionListener((e) -> {
            String choice=sapxepCB1.getItemAt(sapxepCB1.getSelectedIndex());
            if(choice.equals("Theo Ten")){
                Collections.sort(tinhcongList, (o1, o2) -> {
                    String[] ten1=o1.getPhongvien().getHoten().split("\\s+");
                    String[] ten2=o2.getPhongvien().getHoten().split("\\s+");
                    if(ten1[ten1.length-1].equalsIgnoreCase(ten2[ten2.length-1])){
                        return o1.getPhongvien().getHoten().compareToIgnoreCase(o2.getPhongvien().getHoten());
                    }else
                        return ten1[ten1.length-1].compareToIgnoreCase(ten2[ten2.length-1]);
                });
            }
            if(choice.equals("Theo So Luong Bai")){
                Collections.sort(tinhcongList,new Comparator<TinhCong>() {
                    @Override
                    public int compare(TinhCong o1, TinhCong o2) {
                        //giam
//                        return o2.getSoLuong()-o1.getSoLuong();
                        //tang
                        return Integer.compare(o1.getSoLuong(), o2.getSoLuong());
                    }
                });
            }
            tinhCongDefaultTableModel.setRowCount(0);
            for(TinhCong i:tinhcongList)
                tinhCongDefaultTableModel.addRow(i.toObjects());
        });
        
        TinhLuongBT.addActionListener((e) -> {
            int mPV=Integer.parseInt(MaPVThuNhapCB1.getItemAt(MaPVThuNhapCB1.getSelectedIndex()));
            DefaultTableModel tinhluongDefaultTableModel=(DefaultTableModel) TongLuongTable.getModel();
            tinhluongDefaultTableModel.setRowCount(0);
            int tong=0;
            int count=0;
            for(TinhCong tc:tinhcongList){
                if(mPV==tc.getPhongvien().getMaPhongVien()){
                    tinhluongDefaultTableModel.addRow(tc.toObjects());
                    double luong=tc.getKieubaiviet().getDongia()*tc.getSoLuong();
                    tong+=luong;
                    tinhluongDefaultTableModel.setValueAt(luong,count++,5);
                }
            }
            TongLuongLB.setText(tong+"");
            
        });
        saveDataToFile(luuPhongVienBT,phongvienList,phongVienFIle);
        saveDataToFile(luuKieuBaiBT,kieubaivietList,kieuBaiVietFile);
        saveDataToFile(luuTCBT,tinhcongList,tinhCongFile);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hotenPhongVienTF = new javax.swing.JTextField();
        diachiPhongVienTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loaipvCB = new javax.swing.JComboBox<>();
        themphongvienBT = new javax.swing.JButton();
        luuPhongVienBT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        phongvienTable = new javax.swing.JTable();
        SuaPVBT = new javax.swing.JButton();
        XoaPVBT = new javax.swing.JButton();
        MaPVTF1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tenkieubaiTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dongiaKieuBaiTF = new javax.swing.JTextField();
        themKieuBaiBT = new javax.swing.JButton();
        luuKieuBaiBT = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        kieubaiTable = new javax.swing.JTable();
        SuaBVBT = new javax.swing.JButton();
        XoaBVBT = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        soluongbaiTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        maKBtinhcongCB = new javax.swing.JComboBox<>();
        themTCBT = new javax.swing.JButton();
        luuTCBT = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tinhcongTable = new javax.swing.JTable();
        MaPVtinhcongCB = new javax.swing.JComboBox<>();
        sapxepCB1 = new javax.swing.JComboBox<>();
        sapxepBT1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        TimkiemTF = new javax.swing.JTextField();
        TimKiemBT = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        MaPVThuNhapCB1 = new javax.swing.JComboBox<>();
        TinhLuongBT = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TongLuongTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TongLuongLB = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ho Ten");

        jLabel2.setText("Dia Chi");

        jLabel3.setText("Loai PV");

        loaipvCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chuyen Nghiep", "Nghiep Du", "Cong Tac Vien" }));

        themphongvienBT.setText("Them");

        luuPhongVienBT.setText("Luu");

        phongvienTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma PV", "Ho Ten", "Dia Chi", "Loai pV"
            }
        ));
        phongvienTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phongvienTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(phongvienTable);

        SuaPVBT.setText("Sua");
        SuaPVBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaPVBTActionPerformed(evt);
            }
        });

        XoaPVBT.setText("Xoa");
        XoaPVBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaPVBTActionPerformed(evt);
            }
        });

        jLabel13.setText("ma");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hotenPhongVienTF)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(diachiPhongVienTF, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(loaipvCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(themphongvienBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(luuPhongVienBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SuaPVBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(XoaPVBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(MaPVTF1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(hotenPhongVienTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diachiPhongVienTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loaipvCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(themphongvienBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(luuPhongVienBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SuaPVBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(XoaPVBT)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MaPVTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phong Vien", jPanel1);

        jLabel4.setText("Ten Kieu Bai");

        jLabel5.setText("Don Gia");

        themKieuBaiBT.setText("Them");

        luuKieuBaiBT.setText("Luu");

        kieubaiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma Kieu Bai", "Ten Kieu bai", "Don Gia"
            }
        ));
        kieubaiTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kieubaiTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(kieubaiTable);

        SuaBVBT.setText("Sua");
        SuaBVBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaBVBTActionPerformed(evt);
            }
        });

        XoaBVBT.setText("Xoa");
        XoaBVBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaBVBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tenkieubaiTF)
                    .addComponent(dongiaKieuBaiTF)
                    .addComponent(themKieuBaiBT, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(luuKieuBaiBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SuaBVBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(XoaBVBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tenkieubaiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dongiaKieuBaiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(themKieuBaiBT)
                        .addGap(27, 27, 27)
                        .addComponent(luuKieuBaiBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SuaBVBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(XoaBVBT))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kieu Bai Viet", jPanel3);

        jLabel7.setText("Ma PV");

        jLabel8.setText("Ma Kieu Bai");

        jLabel9.setText("So Luong Bai");

        themTCBT.setText("Them");

        luuTCBT.setText("Luu");

        tinhcongTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma PV", "Ho Ten", "Ma Kieu Bai", "Ten Kieu Bai", "So Luong Bai"
            }
        ));
        jScrollPane3.setViewportView(tinhcongTable);

        sapxepCB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----- Sap Xep -----", "Theo Ten", "Theo So Luong Bai" }));

        sapxepBT1.setText("Sap Xep");

        jLabel12.setText("Tim kiem Theo Ten");

        TimkiemTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimkiemTFActionPerformed(evt);
            }
        });

        TimKiemBT.setText("Tim kiem");
        TimKiemBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(sapxepBT1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(soluongbaiTF)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maKBtinhcongCB, 0, 210, Short.MAX_VALUE)
                            .addComponent(MaPVtinhcongCB, 0, 210, Short.MAX_VALUE)
                            .addComponent(themTCBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(luuTCBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sapxepCB1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TimkiemTF))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(TimKiemBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(MaPVtinhcongCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(maKBtinhcongCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(soluongbaiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(themTCBT)
                        .addGap(18, 18, 18)
                        .addComponent(luuTCBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sapxepCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sapxepBT1)
                        .addGap(6, 6, 6))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(TimkiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TimKiemBT)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tinh Cong", jPanel4);

        jLabel10.setText("Ma PV");

        TinhLuongBT.setText("Tinh Luong");

        TongLuongTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma PV", "Ho Ten", "Ma Kieu Bai", "Ten Kieu Bai", "So Luong Bai", "Luong"
            }
        ));
        jScrollPane4.setViewportView(TongLuongTable);

        jLabel6.setText("Tong Luong");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MaPVThuNhapCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(TinhLuongBT)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(106, 106, 106))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TongLuongLB, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(22, 22, 22)
                        .addComponent(MaPVThuNhapCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(TinhLuongBT))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TongLuongLB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tinh Thu Nhap", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void XoaBVBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaBVBTActionPerformed
        int row=kieubaiTable.getSelectedRow();
        if(row<0 || row>kieubaiTable.getRowCount()-1)
        JOptionPane.showMessageDialog(this, "Chon Bai Viet xoa");
        else{
            kieuBaiVietDefaultTableModel.removeRow(row);
            kieubaivietList.remove(row);
            JOptionPane.showMessageDialog(null,"Xoa Thanh Cong!");
            loadDataToBox();
            return;
        }
    }//GEN-LAST:event_XoaBVBTActionPerformed

    private void SuaBVBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaBVBTActionPerformed
        String ten;
        try{
            ten=tenkieubaiTF.getText();
            int row=kieubaiTable.getSelectedRow();
            if(tenkieubaiTF.getText().equals("") ||dongiaKieuBaiTF.getText().equals("")) throw new deTrongException();
            double gia=Double.parseDouble(dongiaKieuBaiTF.getText());
            KieuBaiViet kbv=new KieuBaiViet(ten,gia);
            kieuBaiVietDefaultTableModel.setValueAt(ten, row, 1);
            kieuBaiVietDefaultTableModel.setValueAt(gia, row, 2);
            kieubaivietList.set(row, kbv);
            JOptionPane.showMessageDialog(null,"Sua Thanh Cong!");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Nhap so!");
        }catch(deTrongException e){
            JOptionPane.showMessageDialog(null, "Khong De Trong!");
        }
    }//GEN-LAST:event_SuaBVBTActionPerformed

    private void kieubaiTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kieubaiTableMouseClicked
        int row=kieubaiTable.getSelectedRow();
        if(row<0 || row>kieubaiTable.getRowCount()-1)
        JOptionPane.showMessageDialog(this,"chon bai viet!");
        else{
            tenkieubaiTF.setText(kieuBaiVietDefaultTableModel.getValueAt(row,1).toString());
            dongiaKieuBaiTF.setText(kieuBaiVietDefaultTableModel.getValueAt(row,2).toString());
            tenkieubaiTF.requestFocus();
        }
    }//GEN-LAST:event_kieubaiTableMouseClicked

    private void XoaPVBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaPVBTActionPerformed
        int row=phongvienTable.getSelectedRow();
        if(row<0 || row>phongvienTable.getRowCount()-1)
        JOptionPane.showMessageDialog(this, "Chon Phong Vien xoa");
        else{
            phongVienDefaultTableModel.removeRow(row);
            phongvienList.remove(row);
            JOptionPane.showMessageDialog(null,"Xoa Thanh Cong!");
            loadDataToBox();
            //saveDataToFile(SuaPVBT,phongvienList,phongVienFIle);
            return;
        }
    }//GEN-LAST:event_XoaPVBTActionPerformed

    private void SuaPVBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaPVBTActionPerformed
        String ten,dc;
        try{
            ten=hotenPhongVienTF.getText();
            dc=diachiPhongVienTF.getText();
            String cn=loaipvCB.getSelectedItem().toString();
            if(hotenPhongVienTF.getText().equals("") || diachiPhongVienTF.getText().equals("")) throw new deTrongException();
            int row=phongvienTable.getSelectedRow();
            PhongVien pv=new PhongVien(ten, dc,cn);
            phongVienDefaultTableModel.setValueAt(ten, row, 1);
            phongVienDefaultTableModel.setValueAt(dc, row, 2);
            phongVienDefaultTableModel.setValueAt(cn, row, 3);
            phongvienList.set(row, pv);
            JOptionPane.showMessageDialog(null,"Sua Thanh Cong!");
        }catch(deTrongException e){
            JOptionPane.showMessageDialog(null, "Khong De trong!");
        }
    }//GEN-LAST:event_SuaPVBTActionPerformed

    private void phongvienTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phongvienTableMouseClicked
        int row=phongvienTable.getSelectedRow();
        if(row<0 || row>phongvienTable.getRowCount()-1)
        JOptionPane.showMessageDialog(this,"chon ban doc!");
        else{
            hotenPhongVienTF.setText(phongVienDefaultTableModel.getValueAt(row,1).toString());
            diachiPhongVienTF.setText(phongVienDefaultTableModel.getValueAt(row,2).toString());
            String cn=phongVienDefaultTableModel.getValueAt(row, 3).toString();
            for(int i=0;i<loaipvCB.getItemCount();i++){
                if(loaipvCB.getItemAt(i).toString().equals(cn)){
                    loaipvCB.setSelectedIndex(i);
                    break;
                }
            }
            hotenPhongVienTF.requestFocus();
        }
    }//GEN-LAST:event_phongvienTableMouseClicked

    private void TimkiemTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimkiemTFActionPerformed
    }//GEN-LAST:event_TimkiemTFActionPerformed

    private void TimKiemBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBTActionPerformed
        List<TinhCong> lseach=new ArrayList<>();
        String s=TimkiemTF.getText().trim().toLowerCase();
        for(TinhCong i:tinhcongList){
            if(i.getPhongvien().getHoten().toLowerCase().contains(s) || 
                    i.getKieubaiviet().getTenKieuBai().toLowerCase().contains(s)){
                lseach.add(i);
            }
        }
        tinhCongDefaultTableModel.setRowCount(0);
        for(TinhCong i:lseach)
                tinhCongDefaultTableModel.addRow(i.toObjects());
    }//GEN-LAST:event_TimKiemBTActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MaPVTF1;
    private javax.swing.JComboBox<String> MaPVThuNhapCB1;
    private javax.swing.JComboBox<String> MaPVtinhcongCB;
    private javax.swing.JButton SuaBVBT;
    private javax.swing.JButton SuaPVBT;
    private javax.swing.JButton TimKiemBT;
    private javax.swing.JTextField TimkiemTF;
    private javax.swing.JButton TinhLuongBT;
    private javax.swing.JLabel TongLuongLB;
    private javax.swing.JTable TongLuongTable;
    private javax.swing.JButton XoaBVBT;
    private javax.swing.JButton XoaPVBT;
    private javax.swing.JTextField diachiPhongVienTF;
    private javax.swing.JTextField dongiaKieuBaiTF;
    private javax.swing.JTextField hotenPhongVienTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable kieubaiTable;
    private javax.swing.JComboBox<String> loaipvCB;
    private javax.swing.JButton luuKieuBaiBT;
    private javax.swing.JButton luuPhongVienBT;
    private javax.swing.JButton luuTCBT;
    private javax.swing.JComboBox<String> maKBtinhcongCB;
    private javax.swing.JTable phongvienTable;
    private javax.swing.JButton sapxepBT1;
    private javax.swing.JComboBox<String> sapxepCB1;
    private javax.swing.JTextField soluongbaiTF;
    private javax.swing.JTextField tenkieubaiTF;
    private javax.swing.JButton themKieuBaiBT;
    private javax.swing.JButton themTCBT;
    private javax.swing.JButton themphongvienBT;
    private javax.swing.JTable tinhcongTable;
    // End of variables declaration//GEN-END:variables

    private void loadDataToTable() {
        FileIO.readToList(phongvienList,phongVienFIle);
        FileIO.readToList(kieubaivietList, kieuBaiVietFile);
        FileIO.readToList(tinhcongList, tinhCongFile);
        for(PhongVien i:phongvienList){
            phongVienDefaultTableModel.addRow(i.toObjects());
        }
        for(KieuBaiViet i:kieubaivietList){
            kieuBaiVietDefaultTableModel.addRow(i.toObjects());
        }
        for(TinhCong i:tinhcongList){
            tinhCongDefaultTableModel.addRow(i.toObjects());
        }
    }

    private void saveDataToFile(JButton btn,ArrayList list,String file) {
        btn.addActionListener((e) -> {
            FileIO.writeToFile(list, file);
            JOptionPane.showMessageDialog(null, "Da Luu thanh cong vao file!");
        });
    }

    private void loadDataToBox() {
        maKBtinhcongCB.removeAllItems();
        MaPVtinhcongCB.removeAllItems();
        MaPVThuNhapCB1.removeAllItems();
        for(PhongVien i:phongvienList){
            MaPVtinhcongCB.addItem(i.getMaPhongVien()+"");
            MaPVThuNhapCB1.addItem(i.getMaPhongVien()+"");
        }
        for(KieuBaiViet i:kieubaivietList){
            maKBtinhcongCB.addItem(i.getMaKieuBai()+"");
        }
    }
}
