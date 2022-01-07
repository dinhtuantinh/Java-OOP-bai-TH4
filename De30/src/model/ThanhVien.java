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
public class ThanhVien implements Serializable{
    private int ma;
    private String ten, tuoi;
    private int mucl;
    private static int sma=100;

    public ThanhVien() {
    }

    public ThanhVien(int ma, String ten, String tuoi, int mucl) {
        this.ma = ma;
        this.ten = ten;
        this.tuoi = tuoi;
        this.mucl = mucl;
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

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public int getMucl() {
        return mucl;
    }

    public void setMucl(int mucl) {
        this.mucl = mucl;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        ThanhVien.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
            ma, ten, tuoi,mucl
        };
    }
}
