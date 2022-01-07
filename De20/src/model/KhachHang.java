/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class KhachHang implements Serializable {
    private int ma;
    private String ten, diaChi, Sdt, Loai;
    private static int sma = 10000;

    public KhachHang() {
        ma =sma++;
    }

    public KhachHang(int ma, String ten, String diaChi, String Sdt, String Loai) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.Sdt = Sdt;
        this.Loai = Loai;
    }
    public Object[] toObject() {
        return new Object[] {
          ma, ten,diaChi,Sdt,Loai
        };
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        KhachHang.sma = sma;
    }
    
}
