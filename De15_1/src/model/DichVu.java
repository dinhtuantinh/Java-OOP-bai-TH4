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
public class DichVu implements Serializable{

    public static void getSma(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int ma;
    private String tenDV,dvt;
    private double gia;
    private static int sma=100;

    public DichVu() {
        ma=sma++;
    }

    public DichVu(int ma, String tenDV, String dvt, double gia) {
        this.ma = ma;
        this.tenDV = tenDV;
        this.dvt = dvt;
        this.gia = gia;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        DichVu.sma = sma;
    }

   
    public Object[] toObjects(){
        return new Object[]{
            ma,tenDV,gia,dvt
        };
    }
    
}
