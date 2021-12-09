/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class QuanLyNhanSu implements Serializable{
    private NhanVien nhanVien;
    private PhongBan phongBan;
    private int soNgayLam;

    public QuanLyNhanSu(NhanVien nhanVien, PhongBan phongBan, int soNgayLam) {
        this.nhanVien = nhanVien;
        this.phongBan = phongBan;
        this.soNgayLam = soNgayLam;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public int getSoNgayLam() {
        return soNgayLam;
    }
    
    public Object[] toObjects(){
        return new Object[]{nhanVien.getMaNV(),nhanVien.getHoTen(),phongBan.getMaPhongBan(),phongBan.getTenPhong(),soNgayLam};
    }
    
    public boolean trungNhau(QuanLyNhanSu quanLyNhanSu){
        if(quanLyNhanSu.nhanVien.getMaNV()==this.nhanVien.getMaNV()&&quanLyNhanSu.phongBan.getMaPhongBan()==this.phongBan.getMaPhongBan())return true;
        return false;
    }
    
    public boolean dieuKien(QuanLyNhanSu quanLyNhanSu){
        if(quanLyNhanSu.nhanVien.getMaNV()==this.nhanVien.getMaNV()&&quanLyNhanSu.phongBan.getMaPhongBan()!=this.phongBan.getMaPhongBan())return true;
        return false;
    }

    public void setSoNgayLam(int soNgayLam) {
        this.soNgayLam = soNgayLam;
    }
    
}
