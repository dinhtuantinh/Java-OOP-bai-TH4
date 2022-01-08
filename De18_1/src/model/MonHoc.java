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
public class MonHoc implements Serializable{
    private int ma;
    private String ten;
    private String sodvht,loai;
    private static int sma=100;
    public MonHoc(){
        ma=sma++;
    }

    public MonHoc(int ma, String ten, String sodvht, String loai) {
        this.ma = ma;
        this.ten = ten;
        this.sodvht = sodvht;
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

    public String getSodvht() {
        return sodvht;
    }

    public void setSodvht(String sodvht) {
        this.sodvht = sodvht;
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
        MonHoc.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, ten, sodvht,loai
        };
    }
}
