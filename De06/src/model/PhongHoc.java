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
public class PhongHoc implements Serializable{
    private int ma;
    private String ten;
    private int soghe;
    private static int sma=10000;

    public PhongHoc() {
    }

    public PhongHoc(int ma, String ten, int soghe) {
        this.ma = ma;
        this.ten = ten;
        this.soghe = soghe;
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

    public int getSoghe() {
        return soghe;
    }

    public void setSoghe(int soghe) {
        this.soghe = soghe;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        PhongHoc.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
            ma, ten, soghe
        };
    }
}
