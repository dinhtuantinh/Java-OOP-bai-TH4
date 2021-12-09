/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model32_1;

import java.io.Serializable;


/**
 *
 * @author duymanh
 */
public class TinhCong implements  Serializable{
    private PhongVien phongvien;
    private KieuBaiViet kieubaiviet;
    private int soLuong;

    public TinhCong() {
    }

    public TinhCong(PhongVien phongvien, KieuBaiViet kieubaiviet, int soLuong) {
        this.phongvien = phongvien;
        this.kieubaiviet = kieubaiviet;
        this.soLuong = soLuong;
    }

    public PhongVien getPhongvien() {
        return phongvien;
    }

    public void setPhongvien(PhongVien phongvien) {
        this.phongvien = phongvien;
    }

    public KieuBaiViet getKieubaiviet() {
        return kieubaiviet;
    }

    public void setKieubaiviet(KieuBaiViet kieubaiviet) {
        this.kieubaiviet = kieubaiviet;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public Object[] toObjects(){
        return new Object[]{
            phongvien.getMaPhongVien(),phongvien.getHoten(),kieubaiviet.getMaKieuBai(),
            kieubaiviet.getTenKieuBai(),soLuong
        };
    }
    public boolean trungnhau(TinhCong tinhcong){
        if(tinhcong.phongvien.getMaPhongVien()==this.phongvien.getMaPhongVien() && 
                tinhcong.kieubaiviet.getMaKieuBai() == this.kieubaiviet.getMaKieuBai()) return true;
        return false;
    }
    public boolean dieukien(TinhCong tinhcong){
        if(tinhcong.phongvien.getMaPhongVien()==this.phongvien.getMaPhongVien() && 
                tinhcong.kieubaiviet.getMaKieuBai() != this.kieubaiviet.getMaKieuBai()) return true;
        return false;
    }
}
