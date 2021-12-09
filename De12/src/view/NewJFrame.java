/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controller.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;
/**
 *
 * @author LENOVO
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public static final String congNhanFile ="CN.TXT",sanPhamFile="SP.TXT",tinhCongFile="TINHCONG.TXT";
    ArrayList<CongNhan> congNhansList;
    ArrayList<SanPham> sanPhamsList;
    ArrayList<TinhCong>tinhCongsList;
    DefaultTableModel congNhanDefaultTableModel,sanPhamDefaultTableModel,tinhCongDefaultTableModel;
    public NewJFrame() {
        initComponents();
        congNhansList=new ArrayList<>();
        sanPhamsList=new ArrayList<>();
        tinhCongsList=new ArrayList<>();
        congNhanDefaultTableModel=(DefaultTableModel)congNhanTable.getModel();
        sanPhamDefaultTableModel=(DefaultTableModel)sanPhamTable.getModel();
        tinhCongDefaultTableModel=(DefaultTableModel)tinhCongTable.getModel();
        loadDataToTable();
        loadDataToBox();
        
        themCongNhanBTN.addActionListener((e) -> {
            try {
                String hoTen =hoTenTF.getText();
                String diaChi =diaChiTF.getText();
                String caSanXuat =caSanXuatCB.getItemAt(caSanXuatCB.getSelectedIndex());
                
                int temp=congNhansList.size()-1;
                if(temp!=-1){
                    CongNhan.setMaCongNhanCurrent(congNhansList.get(temp).getMaCongNhan());
                }
                
                CongNhan congNhan=new CongNhan(hoTen, diaChi, caSanXuat);
                for(CongNhan cn:congNhansList){
                    if(congNhan.trungNhau(cn)){
                        throw new trungNhauException();
                    }
                }
                congNhanDefaultTableModel.addRow(congNhan.toObjects());
                congNhansList.add(congNhan);
                loadDataToBox();
            } catch (deTrongException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc de trong thong tin");
            } catch (hoTenException ex) {
                JOptionPane.showMessageDialog(null, "phai co day du ca ho va ten");
            } catch (trungNhauException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc nhap trung cong nhan");
            }
        });
        
        themSanPhamBTN.addActionListener((e) -> {
            String tenSanPham=tenSanPhamTF.getText();
            String donGia =donGiaTF.getText();
            
//            if(!tenSanPham.matches("[^A-Za-z0-9]+")){//\\d{2}/\\d{2}/\\d{4}
//                JOptionPane.showMessageDialog(null, "TEST");
//                return;
//            }
            
            int temp=sanPhamsList.size()-1;
            if(temp!=-1){
                SanPham.setMaSanPhamCurrent((sanPhamsList.get(temp).getMaSanPham()));
            }
            
            try{
                double d=Double.parseDouble(donGia);
                SanPham sanPham=new SanPham(tenSanPham, d);
                for(SanPham sp:sanPhamsList){
                    if(sanPham.trungNhau(sp)){
                        throw new trungNhauException();
                    }
                }
                sanPhamDefaultTableModel.addRow(sanPham.toObjects());
                sanPhamsList.add(sanPham);
                loadDataToBox();
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "don gia la so");
            } catch (deTrongException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc de trong thong tin");
            } catch (donGiaException ex) {
                JOptionPane.showMessageDialog(null, "don gia >=0");
            } catch (trungNhauException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc nhap trung san pham");
            }
        });
        
        themTinhCongBTN.addActionListener((e) -> {
            int congNhanNo=maCongNhanCB.getSelectedIndex();
            int sanPhamNo =maSanPhamCB.getSelectedIndex();
            
            CongNhan congNhan=congNhansList.get(congNhanNo);
            SanPham sanPham=sanPhamsList.get(sanPhamNo);
            
            try{
                int soSanPham =Integer.parseInt(soSanPhamTF.getText());
                TinhCong tinhCong=new TinhCong(congNhan, sanPham, soSanPham);
                int count=0;
                int x=0;
                for(TinhCong tc:tinhCongsList){
                    if(tinhCong.trungNhau(tc)){
                        tc.setSoSanPham(soSanPham+tc.getSoSanPham());
                        tinhCongDefaultTableModel.setValueAt(tc.getSoSanPham(), count, 4);
                        return;
                    }
                    count++;
                    if(tinhCong.dieuKien(tc)){
                        x++;
                    }
                }
                if(x>=5){
                    JOptionPane.showMessageDialog(null, "1 cong nhan chi duoc tham gia san xuat toi da 5 loai sp");
                    return;
                }
                tinhCongDefaultTableModel.addRow(tinhCong.toObjects());
                tinhCongsList.add(tinhCong);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "so san pham la so");
            } catch (soSanPhamException ex) {
                JOptionPane.showMessageDialog(null, "so san pham >=0");
            }
        });
        
        sortBTN.addActionListener((e) -> {
            String choice =sortCB.getItemAt(sortCB.getSelectedIndex());
            if(choice.equals("theo ho ten cong nhan")){
                Collections.sort(tinhCongsList, (o1, o2) -> {
                    return o1.getCongNhan().getHoTen().compareTo(o2.getCongNhan().getHoTen());
                });
            }
                else{
                Collections.sort(tinhCongsList,new Comparator<TinhCong>() {
                    @Override
                    public int compare(TinhCong o1, TinhCong o2) {
                        int x=o2.getSoSanPham()-o1.getSoSanPham();
                        if(x>0)return 1;
                        else if(x==0)return 0;
                        else return -1;
                    }
                });
            }
            tinhCongDefaultTableModel.setRowCount(0);
            for(TinhCong tinhCong:tinhCongsList){
                tinhCongDefaultTableModel.addRow(tinhCong.toObjects());
            }
        });
        
        tinhLuongBTN.addActionListener((e) -> {
            int maCongNhan =Integer.parseInt(maCongNhanCB1.getItemAt(maCongNhanCB1.getSelectedIndex()));
            DefaultTableModel tinhLuongDefaultTableModel=(DefaultTableModel)tinhLuongTable.getModel();
            tinhLuongDefaultTableModel.setRowCount(0);
            int count=0;
            double tongLuong=0;
            
            for(TinhCong tinhCong:tinhCongsList){
                if(tinhCong.getCongNhan().getMaCongNhan()==maCongNhan){
                    double luong=tinhCong.getSoSanPham()*tinhCong.getSanPham().getDonGia();
                    tongLuong+=luong;
                    tinhLuongDefaultTableModel.addRow(tinhCong.toObjects());
                    tinhLuongDefaultTableModel.setValueAt(luong, count++, 5);
                }
            }
            tongLuongLabel.setText(tongLuong+"");
        });
        saveDataToFile(luuCongNhanBTN, congNhansList, congNhanFile);
        saveDataToFile(luuSanPhamBTN, sanPhamsList, sanPhamFile);
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
        caSanXuatCB = new javax.swing.JComboBox<>();
        themCongNhanBTN = new javax.swing.JButton();
        luuCongNhanBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        congNhanTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tenSanPhamTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        donGiaTF = new javax.swing.JTextField();
        themSanPhamBTN = new javax.swing.JButton();
        luuSanPhamBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        sanPhamTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        soSanPhamTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        maCongNhanCB = new javax.swing.JComboBox<>();
        themTinhCongBTN = new javax.swing.JButton();
        luuTinhCongBTN = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tinhCongTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        maSanPhamCB = new javax.swing.JComboBox<>();
        sortCB = new javax.swing.JComboBox<>();
        sortBTN = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        maCongNhanCB1 = new javax.swing.JComboBox<>();
        tinhLuongBTN = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tinhLuongTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tongLuongLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ho ten");

        jLabel2.setText("dia chi");

        jLabel3.setText("ca san xuat");

        caSanXuatCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ca sang", "ca chieu", "ca dem" }));

        themCongNhanBTN.setText("them");

        luuCongNhanBTN.setText("luu");

        congNhanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma cong nhan", "ho ten", "dia chi", "ca san xuat"
            }
        ));
        jScrollPane1.setViewportView(congNhanTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hoTenTF)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaChiTF, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caSanXuatCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(themCongNhanBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luuCongNhanBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(124, 124, 124)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(346, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(hoTenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(diaChiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(caSanXuatCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(themCongNhanBTN)
                        .addGap(32, 32, 32)
                        .addComponent(luuCongNhanBTN)))
                .addContainerGap(199, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("cong nhan", jPanel1);

        jLabel4.setText("ten san pham");

        jLabel5.setText("don gia");

        themSanPhamBTN.setText("them");

        luuSanPhamBTN.setText("luu");

        sanPhamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma san pham", "ten san pham", "don gia"
            }
        ));
        jScrollPane2.setViewportView(sanPhamTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenSanPhamTF)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(donGiaTF, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(themSanPhamBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luuSanPhamBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(124, 124, 124)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(346, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tenSanPhamTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(donGiaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(themSanPhamBTN)
                        .addGap(32, 32, 32)
                        .addComponent(luuSanPhamBTN)))
                .addContainerGap(199, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("san pham", jPanel2);

        jLabel8.setText("so san pham");

        jLabel9.setText("ma cong nhan");

        themTinhCongBTN.setText("them");

        luuTinhCongBTN.setText("luu");

        tinhCongTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma cong nhan", "ho ten", "ma san pham", "ten san pham", "so san pham"
            }
        ));
        jScrollPane3.setViewportView(tinhCongTable);

        jLabel10.setText("ma san pham");

        sortCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "theo ho ten cong nhan", "theo so san pham" }));

        sortBTN.setText("sap xep");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soSanPhamTF, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maCongNhanCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(themTinhCongBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(luuTinhCongBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maSanPhamCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sortCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(sortBTN)))
                .addGap(121, 121, 121)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(maCongNhanCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(maSanPhamCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(soSanPhamTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(themTinhCongBTN)
                        .addGap(32, 32, 32)
                        .addComponent(luuTinhCongBTN)
                        .addGap(32, 32, 32)
                        .addComponent(sortCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sortBTN))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(199, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tinh cong", jPanel3);

        jLabel11.setText("ma cong nhan");

        tinhLuongBTN.setText("tinh thu nhap");
        tinhLuongBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinhLuongBTNActionPerformed(evt);
            }
        });

        tinhLuongTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma cong nhan", "ho ten", "ma san pham", "ten san pham", "so san pham", "luong"
            }
        ));
        jScrollPane4.setViewportView(tinhLuongTable);

        jLabel6.setText("tong luong: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(maCongNhanCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tinhLuongBTN))
                .addGap(153, 153, 153)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tongLuongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(409, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(maCongNhanCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(tinhLuongBTN))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(tongLuongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("thu nhap", jPanel4);

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

    private void tinhLuongBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinhLuongBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tinhLuongBTNActionPerformed

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
    private javax.swing.JComboBox<String> caSanXuatCB;
    private javax.swing.JTable congNhanTable;
    private javax.swing.JTextField diaChiTF;
    private javax.swing.JTextField donGiaTF;
    private javax.swing.JTextField hoTenTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JButton luuCongNhanBTN;
    private javax.swing.JButton luuSanPhamBTN;
    private javax.swing.JButton luuTinhCongBTN;
    private javax.swing.JComboBox<String> maCongNhanCB;
    private javax.swing.JComboBox<String> maCongNhanCB1;
    private javax.swing.JComboBox<String> maSanPhamCB;
    private javax.swing.JTable sanPhamTable;
    private javax.swing.JTextField soSanPhamTF;
    private javax.swing.JButton sortBTN;
    private javax.swing.JComboBox<String> sortCB;
    private javax.swing.JTextField tenSanPhamTF;
    private javax.swing.JButton themCongNhanBTN;
    private javax.swing.JButton themSanPhamBTN;
    private javax.swing.JButton themTinhCongBTN;
    private javax.swing.JTable tinhCongTable;
    private javax.swing.JButton tinhLuongBTN;
    private javax.swing.JTable tinhLuongTable;
    private javax.swing.JLabel tongLuongLabel;
    // End of variables declaration//GEN-END:variables

    private void loadDataToTable() {
        FileIO.readToList(congNhansList, congNhanFile);
        FileIO.readToList(sanPhamsList, sanPhamFile);
        FileIO.readToList(tinhCongsList, tinhCongFile);
        for(CongNhan congNhan:congNhansList){
            congNhanDefaultTableModel.addRow(congNhan.toObjects());
        }
        for(SanPham sanPham:sanPhamsList){
            sanPhamDefaultTableModel.addRow(sanPham.toObjects());
        }
        for(TinhCong tinhCong:tinhCongsList){
            tinhCongDefaultTableModel.addRow(tinhCong.toObjects());
        }
    }

    private void saveDataToFile(JButton btn ,ArrayList list,String file) {
        btn.addActionListener((e) -> {
            FileIO.writeToFile(list, file);
            JOptionPane.showMessageDialog(null, "da luu vao "+file);
        });
    }

    private void loadDataToBox() {
        maCongNhanCB.removeAllItems();
        maCongNhanCB1.removeAllItems();
        maSanPhamCB.removeAllItems();
        for(CongNhan congNhan:congNhansList){
            maCongNhanCB.addItem(congNhan.getMaCongNhan()+"");
            maCongNhanCB1.addItem(congNhan.getMaCongNhan()+"");
        }
        for(SanPham sanPham:sanPhamsList){
            maSanPhamCB.addItem(sanPham.getMaSanPham()+"");
        }
    }
}
