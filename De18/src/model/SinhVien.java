/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.DeTrongException;
import controller.LopException;
import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class SinhVien implements Serializable{
    private static int maSinhVienCurrent = 10000-1;
    private int maSinhVien;
    private String hoTen,diaChi,ngaySinh ,lop ;

    public SinhVien(String hoTen, String diaChi, String ngaySinh, String lop) throws DeTrongException, LopException {
        if(hoTen.equals("")||diaChi.equals("")||ngaySinh.equals("")||lop.equals(""))throw new DeTrongException();
        if(!lop.matches("D\\d{2}CQ(CN||AT||VT||KT)\\d{2}-B"))throw new LopException();
        
        maSinhVien=++maSinhVienCurrent;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getLop() {
        return lop;
    }

    public static void setMaSinhVienCurrent(int maSinhVienCurrent) {
        SinhVien.maSinhVienCurrent = maSinhVienCurrent;
    }
    
    public Object[] toObjects(){
        return new Object[]{maSinhVien,hoTen,diaChi,ngaySinh,lop};
    }
    
    public boolean trungNhau(SinhVien sinhVien){
        if(sinhVien.hoTen.equals(this.hoTen)&&sinhVien.diaChi.equals(this.diaChi))return true;
        return false;
    }
}
