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
public class NguoiMuaVe implements Serializable {
    private int ma;
    private String ten, diaChi, loai;
    private static int sma = 10000;

    public NguoiMuaVe() {
        ma = sma++;
    }

    public NguoiMuaVe(int ma, String ten, String diaChi, String loai) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.loai = loai;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        NguoiMuaVe.sma = sma;
    }
    
    public Object[] toObject() {
        return new Object[] {
          ma, ten, diaChi, loai
        };
    }
}
