/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model38;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class KhachHang implements Serializable{
    private int ma;
    private String hoten, kieuKH;
    private static int sma=100;

    public KhachHang() {
    }

    public KhachHang(int ma, String hoten, String kieuKH) {
        this.ma = ma;
        this.hoten = hoten;
        this.kieuKH = kieuKH;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getKieuKH() {
        return kieuKH;
    }

    public void setKieuKH(String kieuKH) {
        this.kieuKH = kieuKH;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        KhachHang.sma = sma;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            ma, hoten, kieuKH
        };
    }
}
