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
public class PhongBan implements Serializable{
    private int ma;
    private String ten,mota;
    private double heso;
    private static int sma=100;
    public PhongBan(){
        ma=sma++;
    }

    public PhongBan(int ma, String ten, String mota, double heso) {
        this.ma = ma;
        this.ten = ten;
        this.mota = mota;
        this.heso = heso;
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public double getHeso() {
        return heso;
    }

    public void setHeso(double heso) {
        this.heso = heso;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        PhongBan.sma = sma;
    }
    
    public Object[] toObjects(){
        return new Object[]{
          ma, ten, mota,heso
        };
    }
}
