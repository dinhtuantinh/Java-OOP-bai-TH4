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
public class KhachHang implements Serializable{
    private int ma;
    private String hoten,dchi,nhomKH;
    private static int sma=10000;

    public KhachHang() {
    }

    public KhachHang(int ma, String hoten, String dchi, String nhomKH) {
        this.ma = ma;
        this.hoten = hoten;
        this.dchi = dchi;
        this.nhomKH = nhomKH;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public String getNhomKH() {
        return nhomKH;
    }

    public void setNhomKH(String nhomKH) {
        this.nhomKH = nhomKH;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        KhachHang.sma = sma;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            ma, hoten, dchi, nhomKH
        };
    }
}
