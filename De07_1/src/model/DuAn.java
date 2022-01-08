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
public class DuAn implements Serializable{
    private int ma;
    private String ten;
    private String kieu;
    private int tongkp;
    private static int sma=10000;
    public DuAn(){
        ma=sma++;
    }

    public DuAn(int ma, String ten, String kieu, int tongkp) {
        this.ma = ma;
        this.ten = ten;
        this.kieu = kieu;
        this.tongkp = tongkp;
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

    public int getTongkp() {
        return tongkp;
    }

    public void setTongkp(int tongkp) {
        this.tongkp = tongkp;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        DuAn.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, ten, kieu,tongkp
        };
    }
}
