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
public class BangTC implements Serializable{
    private PhongVien k;
    private KieuBV m;
    private int sl,tien;

    public BangTC() {
    }

    public BangTC(PhongVien k, KieuBV m, int sl, int tien) {
        this.k = k;
        this.m = m;
        this.sl = sl;
        this.tien = tien;
    }

    public PhongVien getK() {
        return k;
    }

    public void setK(PhongVien k) {
        this.k = k;
    }

    public KieuBV getM() {
        return m;
    }

    public void setM(KieuBV m) {
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
