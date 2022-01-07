/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class VeTau implements Serializable{
    private int ma;
    private String loai;
    private int gia;
    private static int sma=10000;

    public VeTau() {
        ma=sma++;
    }

    public VeTau(int ma, String loai, int gia) {
        this.ma = ma;
        this.loai = loai;
        this.gia = gia;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        VeTau.sma = sma;
    }

    public Object[] toObjects(){
        return new Object[]{
          ma,loai ,gia
        };
    }
}
