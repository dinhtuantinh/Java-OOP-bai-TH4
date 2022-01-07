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
public class Phong implements Serializable {
    private int ma;
    private String ten, Loai;
    private static int sma = 100;

    public Phong() {
        ma =sma++;
    }

    public Phong(int ma, String ten, String Loai) {
        this.ma = ma;
        this.ten = ten;
        this.Loai = Loai;
    }
    
    public Object[] toObject() {
        return new Object[] {
          ma, ten,Loai
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
        Phong.sma = sma;
    }
    
}
