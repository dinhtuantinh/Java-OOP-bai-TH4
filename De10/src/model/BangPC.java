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
    private CauThu k;
    private ViTri m;
    private int st,thuong;

    public BangPC() {
    }

    public BangPC(CauThu k, ViTri m, int st, int thuong) {
        this.k = k;
        this.m = m;
        this.st = st;
        this.thuong = thuong;
    }

    public CauThu getK() {
        return k;
    }

    public void setK(CauThu k) {
        this.k = k;
    }

    public ViTri getM() {
        return m;
    }

    public void setM(ViTri m) {
        this.m = m;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
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
            st,
            thuong
        };
    }
}
