/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class HoaDon implements Serializable{
    private NguoiMV n;
    private VeTau v;
    private int sl,tien;

    public HoaDon() {
        
    }

    public HoaDon(NguoiMV n, VeTau v, int sl,int tien) {
        this.n = n;
        this.v = v;
        this.sl = sl;
        this.tien=tien;
    }

    public NguoiMV getN() {
        return n;
    }

    public void setN(NguoiMV n) {
        this.n = n;
    }

    public VeTau getV() {
        return v;
    }

    public void setV(VeTau v) {
        this.v = v;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }
    public String getMavaten(){
        return n.getMa()+"\t"+n.getTen();
    }
    public Object[] toObjects(){
        return new Object[]{
          n.getMa(),
            n.getTen(),
            v.getMa(),
            v.getLoai(),
            sl,
            tien
        };
    }
}
