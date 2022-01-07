/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class NguoiMV implements Serializable{
    private int ma;
    private String ten,dc,loai;
    private static int sma=10000;

    public NguoiMV() {
        ma=sma++;
    }

    public NguoiMV(int ma, String ten, String dc, String loai) {
        this.ma = ma;
        this.ten = ten;
        this.dc = dc;
        this.loai = loai;
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

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        NguoiMV.sma = sma;
    }
    public Object[] toObjects(){
        return new Object[]{
          ma,ten,dc,loai  
        };
    }
}
