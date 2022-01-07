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
public class PhongVien implements Serializable{
    private static int maPhongVienLast=10000;
    private int maPhongVien;
    private String hoten,diachi,loaiPhongVien;

     public PhongVien() {
    }

    public PhongVien(String hoten, String diachi,String loaiPhongVien) {
        maPhongVien=++maPhongVienLast;
        this.hoten = hoten;
        this.diachi = diachi;
        this.loaiPhongVien = loaiPhongVien;
    }

    public int getMaPhongVien() {
        return maPhongVien;
    }

    public String getHoten() {
        return hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getLoaiPhongVien() {
        return loaiPhongVien;
    }

    public static void setMaPhongVienLast(int maPhongVienLast) {
        PhongVien.maPhongVienLast = maPhongVienLast;
    }

    public void setMaPhongVien(int maPhongVien) {
        this.maPhongVien = maPhongVien;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setLoaiPhongVien(String loaiPhongVien) {
        this.loaiPhongVien = loaiPhongVien;
    }

    public Object[] toObjects(){
        return new Object[]{
            maPhongVien,hoten,diachi,loaiPhongVien
        };
    }
    public boolean trungnhau(PhongVien phongvien){
        if(phongvien.hoten.equals(this.hoten) && phongvien.diachi.equals(this.diachi)
                && phongvien.loaiPhongVien.equals(this.loaiPhongVien)) return true;
        return false;
    }
}
