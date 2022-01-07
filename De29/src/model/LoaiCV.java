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
public class LoaiCV implements Serializable{
    private int ma;
    private String ten,kieu;
    private int mucphi;
    private static int sma=100;
    public LoaiCV(){
        ma=sma++;
    }

    public LoaiCV(int ma, String ten, String kieu, int mucphi) {
        this.ma = ma;
        this.ten = ten;
        this.kieu = kieu;
        this.mucphi = mucphi;
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

    public String getKieu() {
        return kieu;
    }

    public void setKieu(String kieu) {
        this.kieu = kieu;
    }

    public int getMucphi() {
        return mucphi;
    }

    public void setMucphi(int mucphi) {
        this.mucphi = mucphi;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        LoaiCV.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, ten, kieu,mucphi
        };
    }
}
