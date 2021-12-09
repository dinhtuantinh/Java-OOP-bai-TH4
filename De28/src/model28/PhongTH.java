/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model28;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class PhongTH implements Serializable{
    private int ma;
    private String ten;
    private int somay;
    private String kieuP;
    private static int sma=10000;

    public PhongTH() {
    }

    public PhongTH(int ma, String ten, int somay, String kieuP) {
        this.ma = ma;
        this.ten = ten;
        this.somay = somay;
        this.kieuP = kieuP;
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

    public int getSomay() {
        return somay;
    }

    public void setSomay(int somay) {
        this.somay = somay;
    }

    public String getKieuP() {
        return kieuP;
    }

    public void setKieuP(String kieuP) {
        this.kieuP = kieuP;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        PhongTH.sma = sma;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            ma, ten, somay, kieuP
        };
    }
}
