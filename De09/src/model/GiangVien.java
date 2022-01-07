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
public class GiangVien implements Serializable{
    private int ma;
    private String ten, dc,trdo;
    private static int sma=100;

    public GiangVien() {
    }

    public GiangVien(int ma, String ten, String dc, String trdo) {
        this.ma = ma;
        this.ten = ten;
        this.dc = dc;
        this.trdo = trdo;
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

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getTrdo() {
        return trdo;
    }

    public void setTrdo(String trdo) {
        this.trdo = trdo;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        GiangVien.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
            ma, ten, dc,trdo
        };
    }
}
