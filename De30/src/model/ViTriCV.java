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
public class ViTriCV implements Serializable{
    private int ma;
    private String ten;
    private int muct;
    private static int sma=100;
    public ViTriCV(){
        ma=sma++;
    }

    public ViTriCV(int ma, String ten, int muct) {
        this.ma = ma;
        this.ten = ten;
        this.muct = muct;
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

    public int getMuct() {
        return muct;
    }

    public void setMuct(int muct) {
        this.muct = muct;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        ViTriCV.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, ten, muct
        };
    }
}
