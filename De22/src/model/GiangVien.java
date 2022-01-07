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
    private String ten;
    private int sdt;
    private String khoa;
    private static int sma=10000;

    public GiangVien() {
    }

    public GiangVien(int ma, String ten, int sdt, String khoa) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.khoa = khoa;
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

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        GiangVien.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
            ma, ten, sdt,khoa
        };
    }
}
