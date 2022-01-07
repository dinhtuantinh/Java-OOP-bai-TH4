/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model33;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class HoaDon implements Serializable{
    private KhachHang khachhang;
    private DienThoai dienthoai;
    private int sl, gia;

    public HoaDon() {
    }

    public HoaDon(KhachHang khachhang, DienThoai dienthoai, int sl, int gia) {
        this.khachhang = khachhang;
        this.dienthoai = dienthoai;
        this.sl = sl;
        this.gia = gia;
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
    public DienThoai getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(DienThoai dienthoai) {
        this.dienthoai = dienthoai;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            khachhang.getMa(),
            khachhang.getHoten(),
            dienthoai.getMa(),
            dienthoai.getHang(),
            sl,
            gia
        };
    }
}
