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
public class KieuBV implements Serializable{
    private int ma;
    private String ten;
    private int dgia;
    private static int sma=100;
    public KieuBV(){
        ma=sma++;
    }

    public KieuBV(int ma, String ten, int dgia) {
        this.ma = ma;
        this.ten = ten;
        this.dgia = dgia;
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

    public int getDgia() {
        return dgia;
    }

    public void setDgia(int dgia) {
        this.dgia = dgia;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        KieuBV.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, ten, dgia
        };
    }
}
