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
public class SanPham implements Serializable{
    private int ma;
    private String ten;
    private int dongia;
    private static int sma=10000;
    public SanPham(){
        ma=sma++;
    }

    public SanPham(int ma, String ten, int dongia) {
        this.ma = ma;
        this.ten = ten;
        this.dongia = dongia;
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

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        SanPham.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, ten, dongia
        };
    }
}
