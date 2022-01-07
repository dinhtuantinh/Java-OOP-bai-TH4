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
    public static final String duAnFile ="DA.TXT",nhanVienFile="NV.TXT",phanCongFile="PHANCONG.TXT";
    ArrayList<DuAn>duAnsList;
    ArrayList<NhanVien>nhanViensList;
    ArrayList<PhanCong>phanCongsList;
    DefaultTableModel duAnDefaultTableModel,nhanVienDefaultTableModel,phanCongDefaultTableModel;
    public NewJFrame() {
        initComponents();
        duAnsList=new ArrayList<>();
        nhanViensList=new ArrayList<>();
        phanCongsList=new ArrayList<>();
        duAnDefaultTableModel=(DefaultTableModel)duAnTable.getModel();
        nhanVienDefaultTableModel=(DefaultTableModel)nhanVienTable.getModel();
        phanCongDefaultTableModel=(DefaultTableModel)phanCongTable.getModel();
        loadDataToTable();
        loadDataToBox();
        themDuAnBTN.addActionListener((e) -> {
            String tenDuAn =tenDuAnTF.getText();
            String kieuDuAn =kieuDuAnCB.getItemAt(kieuDuAnCB.getSelectedIndex());
            String tongKinhPhi =tongKinhPhiTF.getText();
            
            int temp=duAnsList.size()-1;
            if(temp!=-1){
                DuAn.setMaDuAnLast(duAnsList.get(temp).getMaDuAn());
            }
            
            try{
                double t=Double.parseDouble(tongKinhPhi);
                DuAn duAn=new DuAn(tenDuAn, kieuDuAn, t);
                for(DuAn da:duAnsList){
                    if(duAn.trungNhau(da)){
                        throw new trungNhauException();
                    }
                }
                duAnDefaultTableModel.addRow(duAn.toObjects());
                duAnsList.add(duAn);
                loadDataToBox();
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "tong kinh phi la so");
            } catch (deTrongException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc de trong thong tin");
            } catch (tongKinhPhiException ex) {
                JOptionPane.showMessageDialog(null, "tong kinh phi >=0");
            } catch (trungNhauException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc nhap trung du an");
            }
        });
        
        themNhanVienBTN.addActionListener((e) -> {
            try {
                String hoTen=hoTenTF.getText();
                String diaChi =diaCHiTF.getText();
                String chuyenMon=chuyenMonTF.getText();
                
                int temp=nhanViensList.size()-1;
                if(temp!=-1){
                    NhanVien.setMaNhanVienLast(nhanViensList.get(temp).getMaNhanVien());
                }
                
                NhanVien nhanVien=new NhanVien(hoTen, diaChi, chuyenMon);
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
                JOptionPane.showMessageDialog(null, "ho ten phai co ca ho va ten");
            } catch (trungNhauException ex) {
                JOptionPane.showMessageDialog(null, "ko duoc nhap trung nhan vien");
            }
            
        });
        
        themPhanCongBTN.addActionListener((e) -> {
            int duAnNo=maDuAnCB.getSelectedIndex();
            int nhanVienNo=maNhanVienCB.getSelectedIndex();
            
            DuAn duAn=duAnsList.get(duAnNo);
            NhanVien nhanVien=nhanViensList.get(nhanVienNo);
            
            try{
                int soNgayTHamGia =Integer.parseInt(soNgayTHamGiaTF.getText());
                String viTriCongViec =viTriCongViecTF.getText();
                PhanCong pc=new PhanCong(duAn, nhanVien, soNgayTHamGia, viTriCongViec);
                for(PhanCong phanCong:phanCongsList){
                    if(phanCong.dieuKien(pc)){
                        JOptionPane.showMessageDialog(null,"1 nhan vien o cung 1 du an thi khong the tham gia cung luc vao 2 vi tri");
                        return;
                    }
                }
                phanCongDefaultTableModel.addRow(pc.toObjects());
                phanCongsList.add(pc);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "so ngay tham gia la so");
            } catch (soNgayTHamGiaException ex) {
                JOptionPane.showMessageDialog(null, "so ngay tham gia >=0");
            }
            
        });
        
        sortBTN.addActionListener((e) -> {
            String choice =sortCB.getItemAt(sortCB.getSelectedIndex());
            if(choice.equals("theo ho ten nhan vien")){
                Collections.sort(phanCongsList  , (o1, o2) -> {
                    return o1.getNhanVien().getHoTen().compareTo(o2.getNhanVien().getHoTen());
                }
                );
            }
                else{
                Collections.sort(phanCongsList, new Comparator<PhanCong>() {
                    @Override
                    public int compare(PhanCong o1, PhanCong o2) {
                        int x=o2.getSoNgayThamGia()-o1.getSoNgayThamGia();
                        if(x>0)return 1;
                        else if(x==0)return 0;
                        else return -1;
                    }
                });
            }
            phanCongDefaultTableModel.setRowCount(0);
            for(PhanCong phanCong:phanCongsList){
                phanCongDefaultTableModel.addRow(phanCong.toObjects());
            }
        });
        
        timKiemBTN.addActionListener((e) -> {
            String choice = timKiemCB.getItemAt(timKiemCB.getSelectedIndex());
            String timKiemContent =timKiemTF.getText();
            DefaultTableModel timKiemDefaultTableModel=(DefaultTableModel)timKiemTable.getModel();
            timKiemDefaultTableModel.setRowCount(0);
            if(choice.equals("theo ten nhan vien")){
                for(PhanCong phanCong:phanCongsList){
                    if(phanCong.getNhanVien().getHoTen().contains(timKiemContent)){
                        timKiemDefaultTableModel.addRow(phanCong.toObjects());
                    }
                }
            }else{
                for(PhanCong pc:phanCongsList){
                    if(pc.getDuAn().getTenDuAn().contains(timKiemContent)){
                        timKiemDefaultTableModel.addRow(pc.toObjects());
                    }
                }
            }
        });
        
        saveDataToTable(luuNhanVienBTN, nhanViensList, nhanVienFile);
        saveDataToTable(luuDuAnBTN, duAnsList, duAnFile);
        saveDataToTable(luuPhanCongBTN, phanCongsList, phanCongFile);
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
        tenDuAnTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tongKinhPhiTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        kieuDuAnCB = new javax.swing.JComboBox<>();
        themDuAnBTN = new javax.swing.JButton();
        luuDuAnBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        duAnTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        hoTenTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        chuyenMonTF = new javax.swing.JTextField();
        themNhanVienBTN = new javax.swing.JButton();
        luuNhanVienBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        nhanVienTable = new javax.swing.JTable();
        diaCHiTF = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        maNhanVienCB = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        soNgayTHamGiaTF = new javax.swing.JTextField();
        themPhanCongBTN = new javax.swing.JButton();
        luuPhanCongBTN = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        phanCongTable = new javax.swing.JTable();
        maDuAnCB = new javax.swing.JComboBox<>();
        viTriCongViecTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        sortCB = new javax.swing.JComboBox<>();
        sortBTN = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        timKiemCB = new javax.swing.JComboBox<>();
        timKiemBTN = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        timKiemTable = new javax.swing.JTable();
        timKiemTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ten du an");

        jLabel2.setText("kieu du an");

        jLabel3.setText("tong kinh phi");

        kieuDuAnCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nho", "trung binh", "lon" }));

        themDuAnBTN.setText("them");

        luuDuAnBTN.setText("luu");

        duAnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma du an", "ten du an", "kieu du an", "tong kinh phi"
            }
        ));
        jScrollPane1.setViewportView(duAnTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenDuAnTF)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tongKinhPhiTF, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kieuDuAnCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(themDuAnBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luuDuAnBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(152, 152, 152)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(348, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tenDuAnTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16)
                        .addComponent(kieuDuAnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tongKinhPhiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(themDuAnBTN)
                        .addGap(31, 31, 31)
                        .addComponent(luuDuAnBTN)))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("du an", jPanel1);

        jLabel4.setText("ho ten");

        jLabel5.setText("dia chi");

        jLabel6.setText("chuyen mon");

        themNhanVienBTN.setText("them");

        luuNhanVienBTN.setText("luu");

        nhanVienTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma nhan vien", "ho ten", "dia chi", "chuyen mon"
            }
        ));
        jScrollPane2.setViewportView(nhanVienTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hoTenTF)
                        .addComponent(chuyenMonTF, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(themNhanVienBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(luuNhanVienBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(diaCHiTF))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(152, 152, 152)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(348, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hoTenTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(diaCHiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chuyenMonTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(themNhanVienBTN)
                        .addGap(31, 31, 31)
                        .addComponent(luuNhanVienBTN)))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("nhan vien", jPanel2);

        jLabel7.setText("ma du an");

        jLabel8.setText("ma nhan vien");

        jLabel9.setText("so ngay tham gia");

        themPhanCongBTN.setText("them");

        luuPhanCongBTN.setText("luu");

        phanCongTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma du an", "ten du an", "ma nhan vien", "ho ten", "so ngay tham gia", "vi tri cong viec"
            }
        ));
        jScrollPane3.setViewportView(phanCongTable);

        jLabel10.setText("vi tri cong viec");

        sortCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "theo ho ten nhan vien", "theo so ngay tham gia" }));

        sortBTN.setText("sap xep");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soNgayTHamGiaTF, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maNhanVienCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(themPhanCongBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(luuPhanCongBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maDuAnCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viTriCongViecTF, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sortCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(sortBTN)))
                .addGap(59, 59, 59)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(308, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(16, 16, 16)
                        .addComponent(maDuAnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(16, 16, 16)
                        .addComponent(maNhanVienCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(soNgayTHamGiaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viTriCongViecTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(themPhanCongBTN)
                        .addGap(18, 18, 18)
                        .addComponent(luuPhanCongBTN)
                        .addGap(18, 18, 18)
                        .addComponent(sortCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(sortBTN)))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("phan cong", jPanel3);

        timKiemCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "theo ten nhan vien", "theo ten du an" }));

        timKiemBTN.setText("tim kiem");

        timKiemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma du an", "ten du an", "ma nhan vien", "ho ten", "so ngay tham gia", "vi tri cong viec"
            }
        ));
        jScrollPane4.setViewportView(timKiemTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(timKiemBTN))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(timKiemCB, 0, 177, Short.MAX_VALUE)
                            .addComponent(timKiemTF))))
                .addGap(99, 99, 99)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(330, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(timKiemCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timKiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(timKiemBTN))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(209, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tim kiem", jPanel4);

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
    private javax.swing.JTextField chuyenMonTF;
    private javax.swing.JTextField diaCHiTF;
    private javax.swing.JTable duAnTable;
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
    private javax.swing.JComboBox<String> kieuDuAnCB;
    private javax.swing.JButton luuDuAnBTN;
    private javax.swing.JButton luuNhanVienBTN;
    private javax.swing.JButton luuPhanCongBTN;
    private javax.swing.JComboBox<String> maDuAnCB;
    private javax.swing.JComboBox<String> maNhanVienCB;
    private javax.swing.JTable nhanVienTable;
    private javax.swing.JTable phanCongTable;
    private javax.swing.JTextField soNgayTHamGiaTF;
    private javax.swing.JButton sortBTN;
    private javax.swing.JComboBox<String> sortCB;
    private javax.swing.JTextField tenDuAnTF;
    private javax.swing.JButton themDuAnBTN;
    private javax.swing.JButton themNhanVienBTN;
    private javax.swing.JButton themPhanCongBTN;
    private javax.swing.JButton timKiemBTN;
    private javax.swing.JComboBox<String> timKiemCB;
    private javax.swing.JTextField timKiemTF;
    private javax.swing.JTable timKiemTable;
    private javax.swing.JTextField tongKinhPhiTF;
    private javax.swing.JTextField viTriCongViecTF;
    // End of variables declaration//GEN-END:variables

    private void loadDataToTable() {
        FileIO.readToList(duAnsList, duAnFile);
        FileIO.readToList(nhanViensList, nhanVienFile);
        FileIO.readToList(phanCongsList, phanCongFile);
        for(DuAn duAn:duAnsList){
            duAnDefaultTableModel.addRow(duAn.toObjects());
        }
        for(NhanVien nhanVien:nhanViensList){
            nhanVienDefaultTableModel.addRow(nhanVien.toObjects());
        }
        for(PhanCong pc:phanCongsList){
            phanCongDefaultTableModel.addRow(pc.toObjects());
        }
    }

    private void saveDataToTable(JButton btn ,ArrayList list,String file) {
        btn.addActionListener((e) -> {
            FileIO.writeToFile(list, file);
            JOptionPane.showMessageDialog(null  , "da luu thanh cong vao "+file);
        });
        
    }

    private void loadDataToBox() {
        maDuAnCB.removeAllItems();
        maNhanVienCB.removeAllItems();
        for(DuAn duAn:duAnsList){
            maDuAnCB.addItem(duAn.getMaDuAn()+"");
        }
        for(NhanVien nhanVien:nhanViensList){
            maNhanVienCB.addItem(nhanVien.getMaNhanVien()+"");
        }
    }
}
