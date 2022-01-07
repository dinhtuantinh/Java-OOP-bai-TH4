/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class BangQL implements Serializable{
    private CTV k;
    private LoaiCV m;
    private int sl,tien;

    public BangQL() {
    }

    public BangQL(CTV k, LoaiCV m, int sl,int tien) {
        this.k = k;
        this.m = m;
        this.sl = sl;
        this.tien=tien;
    }

    public CTV getK() {
        return k;
    }

    public void setK(CTV k) {
        this.k = k;
    }

    public LoaiCV getM() {
        return m;
    }

    public void setM(LoaiCV m) {
        this.m = m;
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
        return k.getMa()+"\t"+k.getTen();
    }

    public Object[] toObjects(){
        return new Object[]{
            k.getMa(),
            k.getTen(),
            m.getMa(),
            m.getTen(),
            sl,
            tien
        };
    }
}
