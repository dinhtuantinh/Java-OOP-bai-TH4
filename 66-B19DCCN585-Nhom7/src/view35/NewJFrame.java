/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view35;
import controller35.soLuongSuDungException;
import controller35.hoTenException;
import controller35.trungNhauException;
import controller35.deTrongException;
import controller35.giaCuocException;
import controller35.FileIO;
import model35.KhachHang;
import model35.DichVu;
import model35.HoaDon;
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
    public static final String khachHangFile ="KH.TXT",dichVuFile="DV.TXT",hoaDonFile="HOADON.TXT";
    ArrayList<KhachHang>khachHangsList;
    ArrayList<DichVu>dichVusList;
    ArrayList<HoaDon>hoaDonsList;
    DefaultTableModel khachHangDefaultTableModel,dichVuDefaultTableModel,hoaDonDefaultTableModel;
    public NewJFrame() {
        initComponents();
        khachHangsList=new ArrayList<>();
        dichVusList=new ArrayList<>();
        hoaDonsList=new ArrayList<>();
        khachHangDefaultTableModel=(DefaultTableModel)khachHangTable.getModel();
        dichVuDefaultTableModel=(DefaultTableModel)dichVuTable.getModel();
        hoaDonDefaultTableModel=(DefaultTableModel)hoaDonTable.getModel();
        loadDataToTable();
        loadDataToBox();
        
        themKhachHangBTN.addActionListener((e) -> {
            try {
                String hoTen =hoTenTF.getText();
                String diaChi =diaChiTF.getText();
                String loaiKH=loaiKhachCB.getItemAt(loaiKhachCB.getSelectedIndex());
                
                int temp =khachHangsList.size()-1;
                if(temp!=-1){
                    KhachHang.setMaKhachHangCurrent(khachHangsList.get(temp).getMaKhachHang());
                }
                
                KhachHang khachHang=new KhachHang(hoTen, diaChi, loaiKH);
                for(KhachHang kh:khachHangsList){
                    if(khachHang.trungNhau(kh)){
                        throw new trungNhauException();
                    }
                }
                khachHangDefaultTableModel.addRow(khachHang.toObjects());
                khachHangsList.add(khachHang);
                loadDataToBox();
            } catch (deTrongException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc de trong thong tin");
            } catch (hoTenException ex) {
                JOptionPane.showMessageDialog(null, "ho ten phai nhap day du");
            } catch (trungNhauException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc nhap trung khach hang");
            }
        });
        
        themDichVuBTN.addActionListener((e) -> {
            String tenDV=tenDichVuTF.getText();
            String giaCuoc =giaCuocTF.getText();
            String donVieTinh =donViTinhTF.getText();
            
            int temp=dichVusList.size()-1;
            if(temp!=-1){
                DichVu.setMaDichVuCurrent(dichVusList.get(temp).getMaDichVu());
            }
            
            try{
                double g=Double.parseDouble(giaCuoc);
                DichVu dichVu=new DichVu(tenDV, g, donVieTinh);
                for(DichVu dv:dichVusList){
                    if(dichVu.trungNhau(dv))throw new trungNhauException();
                }
                dichVuDefaultTableModel.addRow(dichVu.toObjects());
                dichVusList.add(dichVu);
                loadDataToBox();
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "gia cuoc la so");
            } catch (giaCuocException ex) {
                JOptionPane.showMessageDialog(null, "gia cuoc >=0");
            } catch (deTrongException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc de trong thong tin");
            } catch (trungNhauException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc nhap trung dich vu");
            }
        });
        
        themHoaDonBTN.addActionListener((e) -> {
            int khachHangNo =maKhachCB.getSelectedIndex();
            int dichVuNo=maDichVuCB.getSelectedIndex();
            KhachHang khachHang=khachHangsList.get(khachHangNo);
            DichVu dichVu=dichVusList.get(dichVuNo);
            
            try{
                int soLuong=Integer.parseInt(soLuongSuDungTF.getText());
                
                HoaDon hoaDon=new HoaDon(khachHang, dichVu, soLuong);
                int count=0,x=0;
                for(HoaDon hd:hoaDonsList){
                    if(hoaDon.trungNhau(hd)){
                        hd.setSoLuongSuDung(soLuong+hd.getSoLuongSuDung());
                        hoaDonDefaultTableModel.setValueAt(hd.getSoLuongSuDung(), count, 4);
                        return;
                    }
                    if(hoaDon.dieuKien(hd)){
                        x++;
                    }
                    count++;
                }
                if(x>=5){
                    JOptionPane.showMessageDialog(null,"moi khach ko duoc su dung qua 5 loai dich vu");
                    return;
                }
                hoaDonDefaultTableModel.addRow(hoaDon.toObjects());
                hoaDonsList.add(hoaDon);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "so luong su dung");
            } catch (soLuongSuDungException ex) {
                JOptionPane.showMessageDialog(null, "so luong su dung >=0");
            }
                    
        });
        
        sortBTN.addActionListener((e) -> {
            String choice=sortCB.getItemAt(sortCB.getSelectedIndex());
            if(choice.equals("theo ho ten khach hang")){
                Collections.sort(hoaDonsList, (o1, o2) -> {
                    return o1.getKhachHang().getHoTen().compareTo(o2.getKhachHang().getHoTen());
                }
                );
            }else{
                Collections.sort(hoaDonsList, new Comparator<HoaDon>() {
                    @Override
                    public int compare(HoaDon o1, HoaDon o2) {
                        int x=o2.getSoLuongSuDung()-o1.getSoLuongSuDung();
                        if(x>0)return 1;
                        else if(x==0)return 0;
                        else return -1;
                    }
                });
            }
            hoaDonDefaultTableModel.setRowCount(0);
            for(HoaDon hoaDon:hoaDonsList){
                hoaDonDefaultTableModel.addRow(hoaDon.toObjects());
            }
        });
        
        tinhTienBTN.addActionListener((e) -> {
            int maKhach =Integer.parseInt(maKhachCB1.getItemAt(maKhachCB1.getSelectedIndex()));
            DefaultTableModel tinhTienDefaultTableModel=(DefaultTableModel)tinhTienTable.getModel();
            tinhTienDefaultTableModel.setRowCount(0);
            int count=0;
            double tongTien=0;
            for(HoaDon hoaDon:hoaDonsList){
                if(hoaDon.getKhachHang().getMaKhachHang()==maKhach){
                    double tien = hoaDon.getSoLuongSuDung()*hoaDon.getDichVu().getGiaCuoc();
                    tongTien+=tien;
                    tinhTienDefaultTableModel.addRow(hoaDon.toObjects());
                    tinhTienDefaultTableModel.setValueAt(tien, count++, 5);
                }
            }
            tongTienLabel.setText(tongTien+"");
        });
        saveDataToFile(luuKhachHangBTN, khachHangsList, khachHangFile);
        saveDataToFile(luuDichVuBTN, dichVusList, dichVuFile);
        saveDataToFile(luuHoaDonBTN, hoaDonsList, hoaDonFile);
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
        loaiKhachCB = new javax.swing.JComboBox<>();
        themKhachHangBTN = new javax.swing.JButton();
        luuKhachHangBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        khachHangTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tenDichVuTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        giaCuocTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        themDichVuBTN = new javax.swing.JButton();
        luuDichVuBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dichVuTable = new javax.swing.JTable();
        donViTinhTF = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        soLuongSuDungTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        maKhachCB = new javax.swing.JComboBox<>();
        themHoaDonBTN = new javax.swing.JButton();
        luuHoaDonBTN = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        hoaDonTable = new javax.swing.JTable();
        maDichVuCB = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        sortCB = new javax.swing.JComboBox<>();
        sortBTN = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        maKhachCB1 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tinhTienTable = new javax.swing.JTable();
        tinhTienBTN = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tongTienLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ho ten");

        jLabel2.setText("dia chi");

        jLabel3.setText("loai khach");

        loaiKhachCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ca nhan", "dai dien don vi hanh chinh", "dai dien don vi kinh doanh" }));

        themKhachHangBTN.setText("them");

        luuKhachHangBTN.setText("luu");

        khachHangTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma khach", "ho ten", "dia chi", "loai khach"
            }
        ));
        jScrollPane1.setViewportView(khachHangTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hoTenTF)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaChiTF, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loaiKhachCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(themKhachHangBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luuKhachHangBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(149, 149, 149)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(305, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hoTenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diaChiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(loaiKhachCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(themKhachHangBTN)
                        .addGap(27, 27, 27)
                        .addComponent(luuKhachHangBTN))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(212, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("khach hang", jPanel1);

        jLabel4.setText("ten dich vu");

        jLabel5.setText("gia cuoc");

        jLabel6.setText("don vi tinh");

        themDichVuBTN.setText("them");

        luuDichVuBTN.setText("luu");

        dichVuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma dich vu", "ten dich vu", "gia cuoc", "don vi tinh"
            }
        ));
        jScrollPane2.setViewportView(dichVuTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenDichVuTF)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(giaCuocTF, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themDichVuBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luuDichVuBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(donViTinhTF))
                .addGap(149, 149, 149)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(305, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tenDichVuTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(giaCuocTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(donViTinhTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(themDichVuBTN)
                        .addGap(27, 27, 27)
                        .addComponent(luuDichVuBTN))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(212, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("dich vu", jPanel2);

        jLabel8.setText("so luong su dung");

        jLabel9.setText("ma khach hang");

        themHoaDonBTN.setText("them");

        luuHoaDonBTN.setText("luu");

        hoaDonTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma khach", "ho ten", "ma dich vu", "ten dich vu", "so luong su dung"
            }
        ));
        jScrollPane3.setViewportView(hoaDonTable);

        jLabel10.setText("ma dich vu");

        sortCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "theo ho ten khach hang", "theo so luong su dung" }));

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
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soLuongSuDungTF, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maKhachCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(themHoaDonBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(luuHoaDonBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maDichVuCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sortCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(109, 109, 109)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(sortBTN)))
                .addContainerGap(270, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(maKhachCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(maDichVuCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soLuongSuDungTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(themHoaDonBTN)
                        .addGap(27, 27, 27)
                        .addComponent(luuHoaDonBTN)
                        .addGap(37, 37, 37)
                        .addComponent(sortCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(sortBTN)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("hoa don", jPanel3);

        jLabel11.setText("ma khach hang");

        tinhTienTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma khach", "ho ten", "ma dich vu", "ten dich vu", "so luong su dung", "tien"
            }
        ));
        jScrollPane4.setViewportView(tinhTienTable);

        tinhTienBTN.setText("tinh tien");

        jLabel7.setText("tong tien: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maKhachCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(tinhTienBTN)))
                .addGap(109, 109, 109)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(374, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tongTienLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(363, 363, 363))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(maKhachCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(tinhTienBTN))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(tongTienLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tinh tien", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
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
    private javax.swing.JTable dichVuTable;
    private javax.swing.JTextField donViTinhTF;
    private javax.swing.JTextField giaCuocTF;
    private javax.swing.JTextField hoTenTF;
    private javax.swing.JTable hoaDonTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable khachHangTable;
    private javax.swing.JComboBox<String> loaiKhachCB;
    private javax.swing.JButton luuDichVuBTN;
    private javax.swing.JButton luuHoaDonBTN;
    private javax.swing.JButton luuKhachHangBTN;
    private javax.swing.JComboBox<String> maDichVuCB;
    private javax.swing.JComboBox<String> maKhachCB;
    private javax.swing.JComboBox<String> maKhachCB1;
    private javax.swing.JTextField soLuongSuDungTF;
    private javax.swing.JButton sortBTN;
    private javax.swing.JComboBox<String> sortCB;
    private javax.swing.JTextField tenDichVuTF;
    private javax.swing.JButton themDichVuBTN;
    private javax.swing.JButton themHoaDonBTN;
    private javax.swing.JButton themKhachHangBTN;
    private javax.swing.JButton tinhTienBTN;
    private javax.swing.JTable tinhTienTable;
    private javax.swing.JLabel tongTienLabel;
    // End of variables declaration//GEN-END:variables

    private void loadDataToTable() {
        FileIO.readToList(khachHangsList, khachHangFile);
        FileIO.readToList(dichVusList, dichVuFile);
        FileIO.readToList(hoaDonsList, hoaDonFile);
        for(KhachHang khachHang:khachHangsList){
            khachHangDefaultTableModel.addRow(khachHang.toObjects());
        }
        for(DichVu dichVu:dichVusList){
            dichVuDefaultTableModel.addRow(dichVu.toObjects());
        }
        for(HoaDon hoaDon:hoaDonsList){
            hoaDonDefaultTableModel.addRow(hoaDon.toObjects());
        }
    }

    private void saveDataToFile(JButton btn ,ArrayList list,String file) {
        btn.addActionListener((e) -> {
            FileIO.writeToFile(list, file);
            JOptionPane.showMessageDialog(null, "da luu thanh cong vao "+file);
        });
    }

    private void loadDataToBox() {
        maDichVuCB.removeAllItems();
        maKhachCB.removeAllItems();
        maKhachCB1.removeAllItems();
        for(KhachHang khachHang:khachHangsList){
            maKhachCB.addItem(khachHang.getMaKhachHang()+"");
            maKhachCB1.addItem(khachHang.getMaKhachHang()+"");
        }
        for(DichVu dichVu:dichVusList){
            maDichVuCB.addItem(dichVu.getMaDichVu()+"");
        }
    }
}
