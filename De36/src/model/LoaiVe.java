/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class LoaiVe implements Serializable {
    private int ma;
    private String loai;
    private double gia;
    private static int sma = 10000;

    public LoaiVe() {
        ma = sma++;
    }

    public LoaiVe(int ma, String loai, double gia) {
        this.ma = ma;
        this.loai = loai;
        this.gia = gia;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        LoaiVe.sma = sma;
    }

    
    public Object[] toObject() {
        return new Object[] {
          ma, loai, gia
        };
    }
}
