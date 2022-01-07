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
public class Tour implements Serializable{
    private int ma;
    private String kieu, thongtin;
    private long gia;
    private static int sma=1000;
    public Tour(){
        ma=sma++;
    }

    public Tour(int ma, String kieu, String thongtin, long gia) {
        this.ma = ma;
        this.kieu = kieu;
        this.thongtin = thongtin;
        this.gia = gia;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getKieu() {
        return kieu;
    }

    public void setKieu(String kieu) {
        this.kieu = kieu;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Tour.sma = sma;
    }
    
    public Object[] toObjects(){
        return new Object[]{
          ma, kieu, thongtin, gia
        };
    }
}
