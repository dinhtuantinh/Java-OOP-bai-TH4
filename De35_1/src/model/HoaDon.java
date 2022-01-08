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
public class HoaDon implements Serializable{
    private KhachHang k;
    private LoaiDV m;
    private int sl,tien;

    public HoaDon() {
    }

    public HoaDon(KhachHang k, LoaiDV m, int sl, int tien) {
        this.k = k;
        this.m = m;
        this.sl = sl;
        this.tien = tien;
    }

    public KhachHang getK() {
        return k;
    }

    public void setK(KhachHang k) {
        this.k = k;
    }

    public LoaiDV getM() {
        return m;
    }

    public void setM(LoaiDV m) {
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
