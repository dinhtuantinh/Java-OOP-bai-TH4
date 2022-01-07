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
public class KhachHang implements Serializable{

   
    private int ma;
    private String hoten,dchi,loaiKH;
    private static int sma=10000;

    public KhachHang() {
        ma=sma++;
    }

    public KhachHang(int ma, String hoten, String dchi, String loaiKH) {
        this.ma = ma;
        this.hoten = hoten;
        this.dchi = dchi;
        this.loaiKH = loaiKH;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        KhachHang.sma = sma;
    }
    public Object[] toObjects(){
        return new Object[]{
            ma,hoten,dchi,loaiKH
        };
    }
    
}
