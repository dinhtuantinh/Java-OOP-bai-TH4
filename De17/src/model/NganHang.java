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
public class NganHang implements Serializable{
    private int ma;
    private String ten;
    private double lsuat;
    private static int sma=100;
    public NganHang(){
        ma=sma++;
    }

    public NganHang(int ma, String ten, double lsuat) {
        this.ma = ma;
        this.ten = ten;
        this.lsuat = lsuat;
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

    public double getLsuat() {
        return lsuat;
    }

    public void setLsuat(double lsuat) {
        this.lsuat = lsuat;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        NganHang.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, ten, lsuat
        };
    }
}
