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
public class ThietBi implements Serializable{
    private int ma;
    private String ten,xuatxu;
    private int nam;
    private static int sma=10000;
    public ThietBi(){
        ma=sma++;
    }

    public ThietBi(int ma, String ten, String xuatxu, int nam) {
        this.ma = ma;
        this.ten = ten;
        this.xuatxu = xuatxu;
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

    public String getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(String xuatxu) {
        this.xuatxu = xuatxu;
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
        ThietBi.sma = sma;
    }
    
    public Object[] toObjects(){
        return new Object[]{
          ma, ten, xuatxu,nam
        };
    }
}
