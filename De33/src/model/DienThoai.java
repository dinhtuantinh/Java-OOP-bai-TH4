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
public class DienThoai implements Serializable{
    private int ma;
    private String hang,mau;
    private int gia;
    private static int sma=10000;

    public DienThoai() {
        ma=sma++;
    }

    public DienThoai(int ma, String hang, String mau, int gia) {
        this.ma = ma;
        this.hang = hang;
        this.mau = mau;
        this.gia = gia;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        DienThoai.sma = sma;
    }
    
    public Object[] toObjects(){
        return new Object[]{
          ma, hang, mau, gia
        };
    }
}
