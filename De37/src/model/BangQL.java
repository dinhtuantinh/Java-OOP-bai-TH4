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
    private PhongTH k;
    private MayTinh m;
    private int sl;

    public BangQL() {
    }

    public BangQL(PhongTH k, MayTinh m, int sl) {
        this.k = k;
        this.m = m;
        this.sl = sl;
    }

    public PhongTH getK() {
        return k;
    }

    public void setK(PhongTH k) {
        this.k = k;
    }

    public MayTinh getM() {
        return m;
    }

    public void setM(MayTinh m) {
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
            k.getSl(),
            m.getMa(),
            m.getTen(),
            sl
        };
    }
}
