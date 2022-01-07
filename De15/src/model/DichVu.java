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
public class DichVu implements Serializable{
    private int ma;
    private String ten;
    private int giacuoc, dvtinh;
    private static int sma=100;

    public DichVu() {
        ma=sma++;
    }

    public DichVu(int ma, String ten, int giacuoc, int dvtinh) {
        this.ma = ma;
        this.ten = ten;
        this.giacuoc = giacuoc;
        this.dvtinh = dvtinh;
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

    public int getGiacuoc() {
        return giacuoc;
    }

    public void setGiacuoc(int giacuoc) {
        this.giacuoc = giacuoc;
    }

    public int getDvtinh() {
        return dvtinh;
    }

    public void setDvtinh(int dvtinh) {
        this.dvtinh = dvtinh;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        DichVu.sma = sma;
    }

    
    
    public Object[] toObjects(){
        return new Object[]{
          ma, ten, giacuoc, dvtinh
        };
    }
}
