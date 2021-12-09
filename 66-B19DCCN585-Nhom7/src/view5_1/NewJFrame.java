/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view5_1;
import controller5_1.heSoCongViecExceptioon;
import controller5_1.deTrongException;
import controller5_1.trungNhauException;
import controller5_1.FileIO;
import controller5_1.soDienThoaiException;
import controller5_1.hoTenException;
import model5_1.QuanLyNhanSu;
import model5_1.PhongBan;
import model5_1.NhanVien;
import java.util.ArrayList;
import java.util.Collections;
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
    public static final String nhanVienFile ="NV.TXT",phongBanFile="PB.TXT",quanLyNhanSuFile="QLNS.TXT";
    ArrayList<NhanVien>nhanViensList;
    ArrayList<PhongBan> phongBansList;
    ArrayList<QuanLyNhanSu>quanLyNhanSusList;
    DefaultTableModel nhanVienDefaultTableModel,phongBanDefaultTableModel,quanLyNhanSuDefaultTableModel;
    public NewJFrame() {
        initComponents();
        nhanViensList=new ArrayList<>();
        phongBansList=new ArrayList<>();
        quanLyNhanSusList=new ArrayList<>();
        nhanVienDefaultTableModel=(DefaultTableModel)nhanVienTable.getModel();
        phongBanDefaultTableModel=(DefaultTableModel)phongBanTable.getModel();
        quanLyNhanSuDefaultTableModel=(DefaultTableModel)quanLyNhanSuTable.getModel();
        loadDataToTable();
        loadDataToBox();
        
        themNhanVienBTN.addActionListener((e) -> {
            try {
                String hoTen =hoTenTF.getText();
                String diaChi =diaChiTF.getText();
                String soDT =soDienThoaiTF.getText();
                int bacLuong= bacLuongCB.getSelectedIndex()+1;
                
                int temp=nhanViensList.size()-1;
                if(temp!=-1){
                    NhanVien.setMaNVCurrent(nhanViensList.get(temp).getMaNV());
                }
                
                NhanVien nhanVien=new NhanVien(hoTen, diaChi, soDT, bacLuong);
                for(NhanVien nv:nhanViensList){
                    if(nhanVien.trungNhau(nv)){
                        throw new trungNhauException();
                    }
                }
                nhanVienDefaultTableModel.addRow(nhanVien.toObjects());
                nhanViensList.add(nhanVien);
                loadDataToBox();
            } catch (deTrongException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc de trong");
            } catch (hoTenException ex) {
                JOptionPane.showMessageDialog(null, "ho ten phai day du");
            } catch (soDienThoaiException ex) {
                JOptionPane.showMessageDialog(null, "so dien thoai phai gom 10 chu so va bat dau bang chu so 0");
            } catch (trungNhauException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc nhap trung nhan vien");
            }
        });
        
        themPhongBanBTN.addActionListener((e) -> {
            String tenPhong=tenPhongTF.getText();
            String moTa =moTaTF.getText();
            String heSoCongVIec =heSoCongViecTF.getText();
            
            int temp =phongBansList.size()-1;
            if(temp!=-1){
                PhongBan.setMaPhongBanCurrent(phongBansList.get(temp).getMaPhongBan());
            }
            
            try{
                double h=Double.parseDouble(heSoCongVIec);
                PhongBan phongBan=new PhongBan(tenPhong, moTa, h);
                for(PhongBan pb:phongBansList){
                    if(phongBan.trungNhau(pb)){
                        throw new trungNhauException();
                    }
                }
                phongBanDefaultTableModel.addRow(phongBan.toObjects());
                phongBansList.add(phongBan);
                loadDataToBox();
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "he so cong viec la soo");
                return;
            } catch (deTrongException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc de trong");
            } catch (heSoCongViecExceptioon ex) {
                JOptionPane.showMessageDialog(null, "he so cong viec >=1 va <=20");
            } catch (trungNhauException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc nhap trung phong ban");
            }
        });
        
        themQLNSBTN.addActionListener((e) -> {
            int nhanVienNo =maNhanVienCB.getSelectedIndex();
            int phongBanNo =maPhongBanCB.getSelectedIndex();
            NhanVien nhanVien=nhanViensList.get(nhanVienNo);
            PhongBan phongBan=phongBansList.get(phongBanNo);
            try{
                int soNgayLam =Integer.parseInt(soNgayLamTF.getText());
                if(soNgayLam<0||soNgayLam>30){
                    JOptionPane.showMessageDialog(null, "so ngay lam >=0");
                }
                QuanLyNhanSu quanLyNhanSu=new QuanLyNhanSu(nhanVien, phongBan, soNgayLam);
                int count=0;
                for(QuanLyNhanSu qlns:quanLyNhanSusList){
                    if(quanLyNhanSu.trungNhau(qlns)){
                        int x=soNgayLam+qlns.getSoNgayLam();
                        if(x>30){
                            JOptionPane.showMessageDialog(null, "so ngay lam ko duoc vuot qua 30");
                            return;
                        }else{
                            qlns.setSoNgayLam(x);
                            quanLyNhanSuDefaultTableModel.setValueAt(x, count, 4);
                            return;
                        }
                    }
                    count++;
                    if(quanLyNhanSu.dieuKien(qlns)){
                        JOptionPane.showMessageDialog(null, "cung 1 nhan vien ko the lam o 2 phong ban khac nhau");
                        return;
                    }
                }
                quanLyNhanSuDefaultTableModel.addRow(quanLyNhanSu.toObjects());
                quanLyNhanSusList.add(quanLyNhanSu);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "so ngay lam la so");
            }
        });
        
        sortBTN.addActionListener((e) -> {
            String choice =sortCB.getItemAt(sortCB.getSelectedIndex());
            if(choice.equals("theo ten nhan vien")){
                Collections.sort(quanLyNhanSusList  , (o1, o2) -> {
                    return o1.getNhanVien().getHoTen().compareTo(o2.getNhanVien().getHoTen());
                }
                );
            }
                else{
                Collections.sort(quanLyNhanSusList,(o1, o2) -> {
                    return o1.getPhongBan().getTenPhong().compareTo(o2.getPhongBan().getTenPhong());
                });
            }
            quanLyNhanSuDefaultTableModel.setRowCount(0);
            for(QuanLyNhanSu quanLyNhanSu:quanLyNhanSusList){
                quanLyNhanSuDefaultTableModel.addRow(quanLyNhanSu.toObjects());
            }
        });
        
        tinhLuongBTN.addActionListener((e) -> {
            int maNhanVien = Integer.parseInt(maNhanVienCB1.getItemAt(maNhanVienCB1.getSelectedIndex()));
            DefaultTableModel tinhLuongDefaultTableModel=(DefaultTableModel)tinhLuongTable.getModel();
            tinhLuongDefaultTableModel.setRowCount(0);
            int count=0;
            double tongLuong=0;
            for(QuanLyNhanSu quanLyNhanSu:quanLyNhanSusList){
                if(quanLyNhanSu.getNhanVien().getMaNV()==maNhanVien){
                    double luong=1450000*(2+quanLyNhanSu.getNhanVien().getBacLuong()/3)*quanLyNhanSu.getPhongBan().getHeSoCongViec()*quanLyNhanSu.getSoNgayLam()/22;
                    tongLuong+=luong;
                    tinhLuongDefaultTableModel.addRow(quanLyNhanSu.toObjects());
                    tinhLuongDefaultTableModel.setValueAt(luong, count++, 5);
                }
            }
            tongLuongLabel.setText(tongLuong+"");
        });
        saveDataToFile(luuNhanVienBTN, nhanViensList, nhanVienFile);
        saveDataToFile(luuPhongBanBTN, phongBansList, phongBanFile);
        saveDataToFile(luuQLNSBTN, quanLyNhanSusList, quanLyNhanSuFile);
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
        soDienThoaiTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bacLuongCB = new javax.swing.JComboBox<>();
        themNhanVienBTN = new javax.swing.JButton();
        luuNhanVienBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        nhanVienTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tenPhongTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        moTaTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        heSoCongViecTF = new javax.swing.JTextField();
        themPhongBanBTN = new javax.swing.JButton();
        luuPhongBanBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        phongBanTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        soNgayLamTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        maNhanVienCB = new javax.swing.JComboBox<>();
        themQLNSBTN = new javax.swing.JButton();
        luuQLNSBTN = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        quanLyNhanSuTable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        maPhongBanCB = new javax.swing.JComboBox<>();
        sortCB = new javax.swing.JComboBox<>();
        sortBTN = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        maNhanVienCB1 = new javax.swing.JComboBox<>();
        tinhLuongBTN = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tinhLuongTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        tongLuongLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ho ten");

        jLabel2.setText("dia chi");

        jLabel3.setText("so dien thoai");

        jLabel4.setText("bac luong");

        bacLuongCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        themNhanVienBTN.setText("them");

        luuNhanVienBTN.setText("luu");

        nhanVienTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma nhan vien", "ho ten", "dia chi", "so dien thoai", "bac luong"
            }
        ));
        jScrollPane1.setViewportView(nhanVienTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hoTenTF)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaChiTF, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soDienThoaiTF, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bacLuongCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(themNhanVienBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luuNhanVienBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(85, 85, 85)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hoTenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(diaChiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(soDienThoaiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bacLuongCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(themNhanVienBTN)
                        .addGap(33, 33, 33)
                        .addComponent(luuNhanVienBTN)))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("nhan vien", jPanel1);

        jLabel5.setText("ten phong");

        jLabel6.setText("mo ta");

        jLabel7.setText("he so cong viec");

        themPhongBanBTN.setText("them");

        luuPhongBanBTN.setText("luu");

        phongBanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma phong", "ten phong", "mo ta", "he so cong viec"
            }
        ));
        jScrollPane2.setViewportView(phongBanTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenPhongTF)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moTaTF, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heSoCongViecTF, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(themPhongBanBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luuPhongBanBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(85, 85, 85)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tenPhongTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(moTaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(heSoCongViecTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(themPhongBanBTN)
                        .addGap(33, 33, 33)
                        .addComponent(luuPhongBanBTN)))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("phong ban", jPanel2);

        jLabel11.setText("so ngay lam");

        jLabel12.setText("ma nhan vien");

        themQLNSBTN.setText("them");

        luuQLNSBTN.setText("luu");

        quanLyNhanSuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma nhan vien", "ho ten", "ma phong ban", "ten phong ban", "so ngay lam"
            }
        ));
        jScrollPane3.setViewportView(quanLyNhanSuTable);

        jLabel13.setText("ma phong ban");

        sortCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "theo ten nhan vien", "theo ten phong ban" }));

        sortBTN.setText("sap xep");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soNgayLamTF, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maNhanVienCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(themQLNSBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(luuQLNSBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maPhongBanCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sortCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(sortBTN)))
                .addGap(85, 85, 85)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(maNhanVienCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(maPhongBanCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(soNgayLamTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(themQLNSBTN)
                        .addGap(29, 29, 29)
                        .addComponent(luuQLNSBTN)
                        .addGap(29, 29, 29)
                        .addComponent(sortCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sortBTN)))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("quan ly nhan su", jPanel3);

        jLabel14.setText("ma nhan vien");

        tinhLuongBTN.setText("tinh luong");

        tinhLuongTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma nhan vien", "ho ten", "ma phong ban", "ten phong ban", "so ngay lam", "luong"
            }
        ));
        jScrollPane4.setViewportView(tinhLuongTable);

        jLabel8.setText("tong luong");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maNhanVienCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(tinhLuongBTN)))
                .addGap(93, 93, 93)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tongLuongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(372, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(maNhanVienCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(tinhLuongBTN)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(tongLuongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tinh thu nhap", jPanel4);

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
    private javax.swing.JComboBox<String> bacLuongCB;
    private javax.swing.JTextField diaChiTF;
    private javax.swing.JTextField heSoCongViecTF;
    private javax.swing.JTextField hoTenTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton luuNhanVienBTN;
    private javax.swing.JButton luuPhongBanBTN;
    private javax.swing.JButton luuQLNSBTN;
    private javax.swing.JComboBox<String> maNhanVienCB;
    private javax.swing.JComboBox<String> maNhanVienCB1;
    private javax.swing.JComboBox<String> maPhongBanCB;
    private javax.swing.JTextField moTaTF;
    private javax.swing.JTable nhanVienTable;
    private javax.swing.JTable phongBanTable;
    private javax.swing.JTable quanLyNhanSuTable;
    private javax.swing.JTextField soDienThoaiTF;
    private javax.swing.JTextField soNgayLamTF;
    private javax.swing.JButton sortBTN;
    private javax.swing.JComboBox<String> sortCB;
    private javax.swing.JTextField tenPhongTF;
    private javax.swing.JButton themNhanVienBTN;
    private javax.swing.JButton themPhongBanBTN;
    private javax.swing.JButton themQLNSBTN;
    private javax.swing.JButton tinhLuongBTN;
    private javax.swing.JTable tinhLuongTable;
    private javax.swing.JLabel tongLuongLabel;
    // End of variables declaration//GEN-END:variables

    private void loadDataToTable() {
        FileIO.readToList(nhanViensList, nhanVienFile);
        FileIO.readToList(phongBansList, phongBanFile);
        FileIO.readToList(quanLyNhanSusList, quanLyNhanSuFile);
        for(NhanVien nhanVien:nhanViensList){
            nhanVienDefaultTableModel.addRow(nhanVien.toObjects());
        }
        for(PhongBan pb:phongBansList){
            phongBanDefaultTableModel.addRow(pb.toObjects());
        }
        for(QuanLyNhanSu quanLyNhanSu:quanLyNhanSusList){
            quanLyNhanSuDefaultTableModel.addRow(quanLyNhanSu.toObjects());
        }
    }

    private void saveDataToFile(JButton btn,ArrayList list,String file) {
        btn.addActionListener((e) -> {
            FileIO.writeToFile(list, file);
            JOptionPane.showMessageDialog(null, "da luu vao "+file);
        });
    }

    private void loadDataToBox() {
        maNhanVienCB.removeAllItems();
        maNhanVienCB1.removeAllItems();
        maPhongBanCB.removeAllItems();
        for(NhanVien nhanVien:nhanViensList){
            maNhanVienCB.addItem(nhanVien.getMaNV()+"");
            maNhanVienCB1.addItem(nhanVien.getMaNV()+"");
        }
        for(PhongBan phongBan:phongBansList){
            maPhongBanCB.addItem(phongBan.getMaPhongBan()+"");
        }
    }
}
