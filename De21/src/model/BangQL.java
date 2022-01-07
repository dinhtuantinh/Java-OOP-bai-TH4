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
    private KeSach k;
    private Sach s;
    private int sl;
    private String tt;

    public BangQL() {
    }

    public BangQL(KeSach k, Sach s,int sl, String tt) {
        this.k = k;
        this.s = s;
        this.sl = sl;
        this.tt = tt;
    }

    public KeSach getK() {
        return k;
    }

    public void setK(KeSach k) {
        this.k = k;
    }

    public Sach getS() {
        return s;
    }

    public void setS(Sach s) {
        this.s = s;
    }
    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    public String getMavaten(){
        return k.getMa()+"\t"+k.getTen();
    }

    public Object[] toObjects(){
        return new Object[]{
            k.getMa(),
            k.getTen(),
            s.getMa(),
            s.getTen(),
            s.getCn(),
            sl,
            tt
        };
    }
}
