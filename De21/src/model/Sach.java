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
public class Sach implements Serializable{
    private int ma;
    private String ten;
    private String tg,cn;
    private int nam;
    private static int sma=10000;
    public Sach(){
        ma=sma++;
    }

    public Sach(int ma, String ten, String tg, String cn, int nam) {
        this.ma = ma;
        this.ten = ten;
        this.tg = tg;
        this.cn = cn;
        this.nam = nam;
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

    public String getTg() {
        return tg;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Sach.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, ten, tg, cn, nam
        };
    }
}
