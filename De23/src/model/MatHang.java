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
public class MatHang implements Serializable{
    private int ma;
    private String ten,nhom;
    private double gmua,gban;
    private static int sma=1000;

    public MatHang() {
        ma=sma++;
    }

    public MatHang(int ma, String ten, String nhom, double gmua, double gban) {
        this.ma = ma;
        this.ten = ten;
        this.nhom = nhom;
        this.gmua = gmua;
        this.gban = gban;
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

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

    public double getGmua() {
        return gmua;
    }

    public void setGmua(double gmua) {
        this.gmua = gmua;
    }

    public double getGban() {
        return gban;
    }

    public void setGban(double gban) {
        this.gban = gban;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        MatHang.sma = sma;
    }
    public Object[] toObjects(){
        return new Object[]{
            ma,ten,nhom,gmua,gban
    };
    }
    
}
