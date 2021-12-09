/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model35;

import controller35.deTrongException;
import controller35.hoTenException;
import java.io.Serializable;
import java.util.StringTokenizer;

/**
 *
 * @author LENOVO
 */
public class KhachHang implements Serializable{
    private static int maKhachHangCurrent = 10000-1;
    private int maKhachHang;
    private String hoTen,diaChi ,loaiKH;

    public KhachHang(String hoTen, String diaChi, String loaiKH) throws deTrongException, hoTenException {
        if(hoTen.equals("")||diaChi.equals("")||loaiKH.equals(""))throw new deTrongException();
        StringTokenizer str =new StringTokenizer(hoTen);
        if(str.countTokens()<=1)throw new hoTenException();
        while(str.hasMoreTokens()){
            if(!str.nextToken().matches("^[a-zA-Z]*$")){
                throw new hoTenException();
            }
        }
        maKhachHang=++maKhachHangCurrent;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.loaiKH = loaiKH;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public static void setMaKhachHangCurrent(int maKhachHangCurrent) {
        KhachHang.maKhachHangCurrent = maKhachHangCurrent;
    }
    
    public Object[] toObjects(){
        return new Object[]{maKhachHang,hoTen,diaChi,loaiKH};
    }
    
    public boolean trungNhau(KhachHang khachHang){
        if(khachHang.hoTen.equals(this.hoTen)&&khachHang.diaChi.equals(this.diaChi))return true;
        return false;
    }
    
}
