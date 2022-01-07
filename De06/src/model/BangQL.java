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
public class BangQL implements Serializable{
    private PhongHoc k;
    private ThietBi m;
    private int sl;

    public BangQL() {
    }

    public BangQL(PhongHoc k, ThietBi m, int sl) {
        this.k = k;
        this.m = m;
        this.sl = sl;
    }

    public PhongHoc getK() {
        return k;
    }

    public void setK(PhongHoc k) {
        this.k = k;
    }

    public ThietBi getM() {
        return m;
    }

    public void setM(ThietBi m) {
        this.m = m;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
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
            sl
        };
    }
}
