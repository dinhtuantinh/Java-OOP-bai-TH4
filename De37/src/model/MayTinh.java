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
public class MayTinh implements Serializable{
    private int ma;
    private String ten,xx;
    private int nam;
    private String cauh;
    private static int sma=10000;
    public MayTinh(){
        ma=sma++;
    }

    public MayTinh(int ma, String ten, String xx, int nam, String cauh) {
        this.ma = ma;
        this.ten = ten;
        this.xx = xx;
        this.nam = nam;
        this.cauh = cauh;
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

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getCauh() {
        return cauh;
    }

    public void setCauh(String cauh) {
        this.cauh = cauh;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        MayTinh.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma, ten,xx,nam,cauh
        };
    }
}
