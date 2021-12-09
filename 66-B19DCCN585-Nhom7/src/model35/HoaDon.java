/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model35;

import controller35.soLuongSuDungException;
import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class HoaDon implements Serializable{
    private KhachHang khachHang;
    private DichVu dichVu;
    private int soLuongSuDung;

    public HoaDon(KhachHang khachHang, DichVu dichVu, int soLuongSuDung) throws soLuongSuDungException {
        if(soLuongSuDung<0)throw new soLuongSuDungException();
        this.khachHang = khachHang;
        this.dichVu = dichVu;
        this.soLuongSuDung = soLuongSuDung;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public int getSoLuongSuDung() {
        return soLuongSuDung;
    }
    
    public Object[] toObjects(){
        return new Object[]{khachHang.getMaKhachHang(),khachHang.getHoTen(),dichVu.getMaDichVu(),dichVu.getTenDV(),soLuongSuDung};
    }
    
    public boolean trungNhau(HoaDon hoaDon){
        if(hoaDon.khachHang.getMaKhachHang()==this.khachHang.getMaKhachHang()&&hoaDon.getDichVu().getMaDichVu()==this.getDichVu().getMaDichVu())return true;
        return false;
    }
    
    public boolean dieuKien(HoaDon hoaDon){
        if(hoaDon.khachHang.getMaKhachHang()==this.khachHang.getMaKhachHang()&&hoaDon.getDichVu().getMaDichVu()!=this.getDichVu().getMaDichVu())return true;
        return false;
    }

    public void setSoLuongSuDung(int soLuongSuDung) {
        this.soLuongSuDung = soLuongSuDung;
    }
}
