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
public class KeSach implements Serializable{
    private int ma;
    private String ten, loai;
    private int sluong;
    private static int sma=100;

    public KeSach() {
    }

    public KeSach(int ma, String ten, String loai, int sluong) {
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
        this.sluong = sluong;
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
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getSluong() {
        return sluong;
    }

    public void setSluong(int sluong) {
        this.sluong = sluong;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        KeSach.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
            ma, ten, loai, sluong
        };
    }
}
