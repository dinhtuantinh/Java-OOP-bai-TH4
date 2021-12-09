/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view32;
import controller32.SoBaiVietException;
import controller32.kieuBaiToiDaException;
import controller32.deTrongException;
import controller32.hoTenException;
import controller32.FileIO;
import controller32.donGiaException;
import model32.TinhCong;
import model32.KieuBaiViet;
import model32.PhongVien;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public static final String phongVIenFile ="PV.TXT",kieuBaiFile="KB.TXT",tinhCongFile="TINHCONG.TXT";
    ArrayList<PhongVien>phongViensList;
    ArrayList<KieuBaiViet>kieuBaiVietsList;
    ArrayList<TinhCong>tinhCongsList;
    DefaultTableModel phongVienDefaultTableModel,kieuBaiDefaultTableModel,tinhcongDefaultTableModel;
    
    public NewJFrame() {
        initComponents();
        phongViensList=new ArrayList<>();
        kieuBaiVietsList=new ArrayList<>();
        tinhCongsList=new ArrayList<>();
        phongVienDefaultTableModel=(DefaultTableModel)phongVienTable.getModel();
        kieuBaiDefaultTableModel=(DefaultTableModel)kieuBaiTable.getModel();
        tinhcongDefaultTableModel=(DefaultTableModel)tinhCongTable.getModel();
        loadDataToTable();
        loadDataToBox();
        
        themPhongVienBTN.addActionListener((e) -> {
            try {
                String hoTen =hoTenTF.getText();
                String diaChi =diaChiTF.getText();
                String loaiPV =loaiPVCB.getItemAt(loaiPVCB.getSelectedIndex());
                
                int temp=phongViensList.size()-1;
                if(temp!=-1){
                    PhongVien.setMaPVCurrent(phongViensList.get(temp).getMaPV());
                }
                
                PhongVien phongVien=new PhongVien(hoTen, diaChi, loaiPV);
                phongVienDefaultTableModel.addRow(phongVien.toObjects());
                phongViensList.add(phongVien);
                loadDataToBox();
            } catch (deTrongException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc nhap thieu thong ");
            } catch (hoTenException ex) {
                JOptionPane.showMessageDialog(null, "ho ten phai nhap day du ca ho va ten");
            }
            
        });
        
        themKieuBaiBTN.addActionListener((e) -> {
            try {
                String tenKieuBai =tenKieuBaiTF.getText();
                int donGia =Integer.parseInt(donGiaTF.getText());
                
                int temp=kieuBaiVietsList.size()-1;
                if(temp!=-1){
                    KieuBaiViet.setMaKieuBaiCurrent(kieuBaiVietsList.get(temp).getMaKieuBai());
                }
                
                KieuBaiViet kieuBaiViet=new KieuBaiViet(tenKieuBai, donGia);
                kieuBaiDefaultTableModel.addRow(kieuBaiViet.toObjects());
                kieuBaiVietsList.add(kieuBaiViet);
                loadDataToBox();
                
            } catch (deTrongException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc nhap thieu thong tin");
            } catch (donGiaException ex) {
                JOptionPane.showMessageDialog(null, "don gia ko duoc am");
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "don gia la so");
            }
        });
        
        themTinhCongBTN.addActionListener((e) -> {
            int phongVienNo =maPVCB.getSelectedIndex();
            int kieuBaiNo =maKieuBaiCB.getSelectedIndex();
            
            PhongVien phongVien=phongViensList.get(phongVienNo);
            KieuBaiViet kieuBaiViet=kieuBaiVietsList.get(kieuBaiNo);
            
            try{
                int soBaiViet =Integer.parseInt(soBaiVietTF.getText());
                if(soBaiViet<0)throw new SoBaiVietException();
                TinhCong tinhCong=new TinhCong(phongVien, kieuBaiViet, soBaiViet);
                int count=0;
                int x=0;
                for(TinhCong tc:tinhCongsList){
                    if(tinhCong.trungNhau(tc)){
                        tc.setSoKieuBai(tc.getSoKieuBai()+soBaiViet);
                        tinhcongDefaultTableModel.setValueAt(tc.getSoKieuBai(), x, 4);
                        return;
                    }
                    x++;
                    if(tinhCong.dieuKien(tc)){
                        count++;
                    }
                }
                if(count>=5)throw new kieuBaiToiDaException();
                tinhcongDefaultTableModel.addRow(tinhCong.toObjects());
                tinhCongsList.add(tinhCong);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "so bai viet la so");
            } catch (SoBaiVietException ex) {
                JOptionPane.showMessageDialog(null, "so bai viet >=0");
            } catch (kieuBaiToiDaException ex) {
                JOptionPane.showMessageDialog(null, "kieu bai toi da la 5 cho 1 phong vien");
            }
            
        });
        
        sortBTN.addActionListener((e) -> {
            String choice=sortCB.getItemAt(sortCB.getSelectedIndex());
            
            if(choice.equals("theo ho ten phong vien")){
                Collections.sort(tinhCongsList,(o1, o2) -> {
                    return o1.getPhongVien().getHoTen().compareTo(o2.getPhongVien().getHoTen());
                });
            }
                else{
                Collections.sort(tinhCongsList, new Comparator<TinhCong>() {
                    @Override
                    public int compare(TinhCong o1, TinhCong o2) {
                        int x=o2.getSoKieuBai()-o1.getSoKieuBai();
                        if(x>0)return 1;
                        else if(x==0)return 0;
                        else return -1;
                    }
                });
            }
            
            tinhcongDefaultTableModel.setRowCount(0);
            for(TinhCong tinhCong:tinhCongsList){
                tinhcongDefaultTableModel.addRow(tinhCong.toObjects());
            }
        });
        
        tinhLuongBTN.addActionListener((e) -> {
            int maNhanVien =Integer.parseInt(maPVCB1.getItemAt(maPVCB1.getSelectedIndex()));
            DefaultTableModel tinhLuongDefaultTableModel=(DefaultTableModel)tinhLuongTable.getModel();
            tinhLuongDefaultTableModel.setRowCount(0);
            int count=0;
            double tongLuong=0;
            
            for(TinhCong tinhCong:tinhCongsList){
                if(maNhanVien==tinhCong.getPhongVien().getMaPV()){
                double luong =tinhCong.getKieuBaiViet().getDonGia()*tinhCong.getSoKieuBai();
                tongLuong+=luong;
                tinhLuongDefaultTableModel.addRow(tinhCong.toObjects());
                tinhLuongDefaultTableModel.setValueAt(luong, count++, 5);
                }
            }
            tongLuongLabel.setText(tongLuong+"");
        }
        );
        
        saveDataToFile(luuPVBTN, phongViensList, phongVIenFile);
        saveDataToFile(luuKieuBaiBTN, kieuBaiVietsList, kieuBaiFile);
        saveDataToFile(luuTinhCongBTN, tinhCongsList, tinhCongFile);
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
        loaiPVCB = new javax.swing.JComboBox<>();
        themPhongVienBTN = new javax.swing.JButton();
        luuPVBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        phongVienTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tenKieuBaiTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        donGiaTF = new javax.swing.JTextField();
        themKieuBaiBTN = new javax.swing.JButton();
        luuKieuBaiBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        kieuBaiTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        soBaiVietTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        maPVCB = new javax.swing.JComboBox<>();
        themTinhCongBTN = new javax.swing.JButton();
        luuTinhCongBTN = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tinhCongTable = new javax.swing.JTable();
        maKieuBaiCB = new javax.swing.JComboBox<>();
        sortCB = new javax.swing.JComboBox<>();
        sortBTN = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        maPVCB1 = new javax.swing.JComboBox<>();
        tinhLuongBTN = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tinhLuongTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tongLuongLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ho ten");

        jLabel2.setText("dia chi");

        jLabel3.setText("loai phong vien");

        loaiPVCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "chuyen nghiep", "nghiep du", "cong tac vien" }));

        themPhongVienBTN.setText("them");

        luuPVBTN.setText("luu");

        phongVienTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma phong vien", "ho ten", "dia chi", "loai phong vien"
            }
        ));
        jScrollPane1.setViewportView(phongVienTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hoTenTF)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaChiTF, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loaiPVCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(themPhongVienBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luuPVBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(74, 74, 74)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hoTenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(diaChiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(loaiPVCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(themPhongVienBTN)
                        .addGap(35, 35, 35)
                        .addComponent(luuPVBTN)))
                .addContainerGap(192, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("phong vien", jPanel1);

        jLabel4.setText("ten kieu bai");

        jLabel5.setText("don gia");

        themKieuBaiBTN.setText("them");

        luuKieuBaiBTN.setText("luu");

        kieuBaiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma kieu bai", "ten kieu bai", "don gia"
            }
        ));
        jScrollPane2.setViewportView(kieuBaiTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenKieuBaiTF)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(donGiaTF, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(themKieuBaiBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luuKieuBaiBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(74, 74, 74)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tenKieuBaiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(donGiaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(themKieuBaiBTN)
                        .addGap(35, 35, 35)
                        .addComponent(luuKieuBaiBTN)))
                .addContainerGap(192, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("kieu bai viet", jPanel2);

        jLabel7.setText("ma phong vien");

        jLabel8.setText("ma kieu bai");

        jLabel9.setText("so bai viet");

        themTinhCongBTN.setText("them");

        luuTinhCongBTN.setText("luu");

        tinhCongTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma phong vien", "ho ten", "ma bai viet", "ten kieu bai", "so bai viet"
            }
        ));
        jScrollPane3.setViewportView(tinhCongTable);

        sortCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "theo ho ten phong vien", "theo so luong bai viet" }));

        sortBTN.setText("sap xep");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soBaiVietTF, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maPVCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(themTinhCongBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(luuTinhCongBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maKieuBaiCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sortCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(sortBTN)))
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(maPVCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(maKieuBaiCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(soBaiVietTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(themTinhCongBTN)
                        .addGap(35, 35, 35)
                        .addComponent(luuTinhCongBTN)
                        .addGap(29, 29, 29)
                        .addComponent(sortCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(sortBTN)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tinh cong", jPanel3);

        jLabel10.setText("ma phong vien");

        tinhLuongBTN.setText("tinh luong");

        tinhLuongTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma phong vien", "ho ten", "ma bai viet", "ten kieu bai", "so bai viet", "luong"
            }
        ));
        jScrollPane4.setViewportView(tinhLuongTable);

        jLabel6.setText("tong luong");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maPVCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tinhLuongBTN)
                        .addGap(99, 99, 99)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(368, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tongLuongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(379, 379, 379))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(maPVCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(tinhLuongBTN)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(tongLuongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tinh thu nhap", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
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
    private javax.swing.JTextField diaChiTF;
    private javax.swing.JTextField donGiaTF;
    private javax.swing.JTextField hoTenTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable kieuBaiTable;
    private javax.swing.JComboBox<String> loaiPVCB;
    private javax.swing.JButton luuKieuBaiBTN;
    private javax.swing.JButton luuPVBTN;
    private javax.swing.JButton luuTinhCongBTN;
    private javax.swing.JComboBox<String> maKieuBaiCB;
    private javax.swing.JComboBox<String> maPVCB;
    private javax.swing.JComboBox<String> maPVCB1;
    private javax.swing.JTable phongVienTable;
    private javax.swing.JTextField soBaiVietTF;
    private javax.swing.JButton sortBTN;
    private javax.swing.JComboBox<String> sortCB;
    private javax.swing.JTextField tenKieuBaiTF;
    private javax.swing.JButton themKieuBaiBTN;
    private javax.swing.JButton themPhongVienBTN;
    private javax.swing.JButton themTinhCongBTN;
    private javax.swing.JTable tinhCongTable;
    private javax.swing.JButton tinhLuongBTN;
    private javax.swing.JTable tinhLuongTable;
    private javax.swing.JLabel tongLuongLabel;
    // End of variables declaration//GEN-END:variables

    private void loadDataToTable() {
        FileIO.readToList(phongViensList, phongVIenFile);
        FileIO.readToList(kieuBaiVietsList, kieuBaiFile);
        FileIO.readToList(tinhCongsList, tinhCongFile);
        for(PhongVien pv:phongViensList){
            phongVienDefaultTableModel.addRow(pv.toObjects());
        }
        for(KieuBaiViet kieuBaiViet:kieuBaiVietsList){
            kieuBaiDefaultTableModel.addRow(kieuBaiViet.toObjects());
        }
        for(TinhCong tinhCong:tinhCongsList){
            tinhcongDefaultTableModel.addRow(tinhCong.toObjects());
        }
    }

    private void saveDataToFile(JButton btn ,ArrayList list,String file) {
        btn.addActionListener((e) -> {
            FileIO.writeToFile(list, file);
            JOptionPane.showMessageDialog(null, "da luu thanh cong vao "+file);
        });
        
    }

    private void loadDataToBox() {
        maKieuBaiCB.removeAllItems();
        maPVCB.removeAllItems();
        maPVCB1.removeAllItems();
        for(KieuBaiViet kieuBaiViet:kieuBaiVietsList){
            maKieuBaiCB.addItem(kieuBaiViet.getMaKieuBai()+"");
        }
        for(PhongVien phongVien:phongViensList){
            maPVCB.addItem(phongVien.getMaPV()+"");
            maPVCB1.addItem(phongVien.getMaPV()+"");
        }
    }
}
