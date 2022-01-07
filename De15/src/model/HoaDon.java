/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class HoaDon implements Serializable{
    private KhachHang khachhang;
    private DichVu dichvu;
    private int dvtinh, tonggia;

    public HoaDon() {
    }

    public HoaDon(KhachHang khachhang, DichVu dichvu, int dvtinh, int tonggia) {
        this.khachhang = khachhang;
        this.dichvu = dichvu;
        this.dvtinh = dvtinh;
        this.tonggia = tonggia;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }

    public String getMavaten(){
        return khachhang.getMa()+"\t"+khachhang.getHoten();
    }
    public DichVu getDichvu() {
        return dichvu;
    }

    public void setDichvu(DichVu dichvu) {
        this.dichvu = dichvu;
    }

    public int getDvtinh() {
        return dvtinh;
    }

    public void setDvtinh(int dvtinh) {
        this.dvtinh = dvtinh;
    }

    public int getTonggia() {
        return tonggia;
    }

    public void setTonggia(int tonggia) {
        this.tonggia = tonggia;
    }

    
    public Object[] toObjects(){
        return new Object[]{
            khachhang.getMa(),
            khachhang.getHoten(),
            dichvu.getMa(),
            dichvu.getTen(),
            dvtinh,
            tonggia
        };
    }
}
