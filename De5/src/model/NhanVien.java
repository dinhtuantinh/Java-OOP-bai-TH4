/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.deTrongException;
import controller.hoTenException;
import controller.soDienThoaiException;
import java.io.Serializable;
import java.util.StringTokenizer;

/**
 *
 * @author LENOVO
 */
public class NhanVien implements Serializable{
    private static int maNVCurrent = 1000-1;
    private int maNV;
    private String hoTen ,diaChi ,soDienThoai;
    private int bacLuong;

    public int getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public int getBacLuong() {
        return bacLuong;
    }

    public static void setMaNVCurrent(int maNVCurrent) {
        NhanVien.maNVCurrent = maNVCurrent;
    }

    public NhanVien(String hoTen, String diaChi, String soDienThoai, int bacLuong) throws deTrongException, hoTenException, soDienThoaiException {
        if(hoTen.equals("")||diaChi.equals("")||soDienThoai.equals(""))throw new deTrongException();
        StringTokenizer str =new StringTokenizer(hoTen);
        
        if(str.countTokens()<=1)throw new hoTenException();
        
        if(!soDienThoai.matches("0\\d{9}"))throw new soDienThoaiException();
        maNV=++maNVCurrent;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.bacLuong = bacLuong;
    }
    
    public Object[] toObjects(){
        return new Object[]{maNV,hoTen,diaChi,soDienThoai,bacLuong};
    }
    
    public boolean trungNhau(NhanVien nhanVien){
        if(nhanVien.hoTen.equals(this.hoTen)&&nhanVien.soDienThoai.equals(this.soDienThoai))return true;
        return false;
    }
    
    
}
