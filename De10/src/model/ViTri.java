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
public class ViTri implements Serializable{
    private int ma;
    private String ten;
    private int muc;
    private static int sma=100;
    public ViTri(){
        ma=sma++;
    }

    public ViTri(int ma, String ten, int muc) {
        this.ma = ma;
        this.ten = ten;
        this.muc = muc;
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

    public int getMuc() {
        return muc;
    }

    public void setMuc(int muc) {
        this.muc = muc;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        ViTri.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, ten, muc
        };
    }
}
