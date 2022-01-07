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
public class LoaiVe implements Serializable{
    private int ma;
    private String mota;
    private int gia;
    private static int sma=100;
    public LoaiVe(){
        ma=sma++;
    }

    public LoaiVe(int ma, String mota, int gia) {
        this.ma = ma;
        this.mota = mota;
        this.gia = gia;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        LoaiVe.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma,mota,gia
        };
    }
}
