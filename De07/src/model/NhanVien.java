/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.deTrongException;
import controller.hoTenException;
import java.io.Serializable;
import java.util.StringTokenizer;

/**
 *
 * @author LENOVO
 */
public class NhanVien implements Serializable{
    private static int maNhanVienLast=10000-1;
    private int maNhanVien;
    private String hoTen,diaChi,chuyenMon;

    public NhanVien(String hoTen, String diaChi, String chuyenMon) throws deTrongException, hoTenException {
        if(hoTen.equals("")||diaChi.equals("")||chuyenMon.equals(""))throw new deTrongException();
        StringTokenizer str=new StringTokenizer(hoTen);
        if(str.countTokens()<=1)throw new hoTenException();
        maNhanVien=++maNhanVienLast;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.chuyenMon = chuyenMon;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public static void setMaNhanVienLast(int maNhanVienLast) {
        NhanVien.maNhanVienLast = maNhanVienLast;
    }
    
    public Object[] toObjects(){
        return new Object[]{maNhanVien,hoTen,diaChi,chuyenMon};
    }
    
    public boolean trungNhau(NhanVien nhanVien){
        if(nhanVien.hoTen.equals(this.hoTen)&&nhanVien.diaChi.equals(this.diaChi))return true;
        return false;
    }
    
    
    
}
