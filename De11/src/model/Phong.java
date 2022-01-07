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
public class Phong implements Serializable{
    private int ma;
    private String kieu;
    private int gia,sphong;
    private static int sma=100;
    public Phong(){
        ma=sma++;
    }

    public Phong(int ma, String kieu, int gia, int sphong) {
        this.ma = ma;
        this.kieu = kieu;
        this.gia = gia;
        this.sphong = sphong;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getKieu() {
        return kieu;
    }

    public void setKieu(String kieu) {
        this.kieu = kieu;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSphong() {
        return sphong;
    }

    public void setSphong(int sphong) {
        this.sphong = sphong;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Phong.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, kieu, gia, sphong
        };
    }
}
