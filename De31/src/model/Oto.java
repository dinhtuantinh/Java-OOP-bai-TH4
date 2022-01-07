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
public class Oto implements Serializable{
    private int ma;
    private String kieu;
    private int mucthue,soxe;
    private static int sma=100;
    public Oto(){
        ma=sma++;
    }

    public Oto(int ma, String kieu, int mucthue, int soxe) {
        this.ma = ma;
        this.kieu = kieu;
        this.mucthue = mucthue;
        this.soxe = soxe;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getKieu() {
        return kieu;
    }

    public void setKieu(String kieu) {
        this.kieu = kieu;
    }

    public int getMucthue() {
        return mucthue;
    }

    public void setMucthue(int mucthue) {
        this.mucthue = mucthue;
    }

    public int getSoxe() {
        return soxe;
    }

    public void setSoxe(int soxe) {
        this.soxe = soxe;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Oto.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, kieu,mucthue,soxe
        };
    }
}
