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
public class Lop implements Serializable{
    private int ma;
    private String ten;
    private int soSV;
    private static int sma=100;
    public Lop(){
        ma=sma++;
    }

    public Lop(int ma, String ten, int soSV) {
        this.ma = ma;
        this.ten = ten;
        this.soSV = soSV;
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

    public int getSoSV() {
        return soSV;
    }

    public void setSoSV(int soSV) {
        this.soSV = soSV;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Lop.sma = sma;
    }
    
    public Object[] toObjects(){
        return new Object[]{
          ma, ten, soSV
        };
    }
}
