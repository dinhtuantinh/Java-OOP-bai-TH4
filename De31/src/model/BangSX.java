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
public class BangSX implements Serializable{
    private KhachHang k;
    private Oto m;
    private int tg,tien;

    public BangSX() {
    }

    public BangSX(KhachHang k, Oto m, int tg, int tien) {
        this.k = k;
        this.m = m;
        this.tg = tg;
        this.tien = tien;
    }

    public KhachHang getK() {
        return k;
    }

    public void setK(KhachHang k) {
        this.k = k;
    }

    public Oto getM() {
        return m;
    }

    public void setM(Oto m) {
        this.m = m;
    }

    public int getTg() {
        return tg;
    }

    public void setTg(int tg) {
        this.tg = tg;
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
            k.getSl(),
            m.getMa(),
            m.getKieu(),
            tg,
            tien
        };
    }
}
