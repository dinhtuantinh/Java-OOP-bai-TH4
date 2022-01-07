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
    private int stiet,lythuyet,kinhphi;
    private static int sma=100;
    public MonHoc(){
        ma=sma++;
    }

    public MonHoc(int ma, String ten, int stiet, int lythuyet, int kinhphi) {
        this.ma = ma;
        this.ten = ten;
        this.stiet = stiet;
        this.lythuyet = lythuyet;
        this.kinhphi = kinhphi;
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

    public int getStiet() {
        return stiet;
    }

    public void setStiet(int stiet) {
        this.stiet = stiet;
    }

    public int getLythuyet() {
        return lythuyet;
    }

    public void setLythuyet(int lythuyet) {
        this.lythuyet = lythuyet;
    }

    public int getKinhphi() {
        return kinhphi;
    }

    public void setKinhphi(int kinhphi) {
        this.kinhphi = kinhphi;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        MonHoc.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, ten, stiet,lythuyet,kinhphi
        };
    }
}
