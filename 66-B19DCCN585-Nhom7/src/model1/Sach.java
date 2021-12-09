/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model1;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Sach implements Serializable{
    private int ma;
    private String ten, tgia, cn;
    private int sluong;
    private static int sma=10000;
    public Sach(){
        ma=sma++;
    }

    public Sach(int ma, String ten, String tgia, String cn, int sluong) {
        this.ma = ma;
        this.ten = ten;
        this.tgia = tgia;
        this.cn = cn;
        this.sluong = sluong;
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

    public String getTgia() {
        return tgia;
    }

    public void setTgia(String tgia) {
        this.tgia = tgia;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public int getSluong() {
        return sluong;
    }

    public void setSluong(int sluong) {
        this.sluong = sluong;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Sach.sma = sma;
    }
    public Object[] toObjects(){
        return new Object[]{
          ma, ten, tgia, cn, sluong
        };
    }
}
