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
public class BangPC implements Serializable{
    private ThanhVien k;
    private ViTriCV m;
    private int tg,thuong;

    public BangPC() {
    }

    public BangPC(ThanhVien k, ViTriCV m, int tg, int thuong) {
        this.k = k;
        this.m = m;
        this.tg = tg;
        this.thuong = thuong;
    }

    public ThanhVien getK() {
        return k;
    }

    public void setK(ThanhVien k) {
        this.k = k;
    }

    public ViTriCV getM() {
        return m;
    }

    public void setM(ViTriCV m) {
        this.m = m;
    }

    public int getTg() {
        return tg;
    }

    public void setTg(int tg) {
        this.tg = tg;
    }

    public int getThuong() {
        return thuong;
    }

    public void setThuong(int thuong) {
        this.thuong = thuong;
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
            tg,
            thuong
        };
    }
}
