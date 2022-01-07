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
public class BaiTap implements Serializable{
    private int ma;
    private String ten;
    private String kieu;
    private int time;
    private static int sma=100;
    public BaiTap(){
        ma=sma++;
    }

    public BaiTap(int ma, String ten, String kieu, int time) {
        this.ma = ma;
        this.ten = ten;
        this.kieu = kieu;
        this.time = time;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        BaiTap.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, ten, kieu,time
        };
    }
}
