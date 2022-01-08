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
public class CongNhan implements Serializable{
    private int ma;
    private String ten,dc,ca;
    private static int sma=10000;

    public CongNhan() {
    }

    public CongNhan(int ma, String ten, String dc, String ca) {
        this.ma = ma;
        this.ten = ten;
        this.dc = dc;
        this.ca = ca;
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

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        CongNhan.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
            ma, ten, dc,ca
        };
    }
}
