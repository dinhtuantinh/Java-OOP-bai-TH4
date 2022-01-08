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
    private NhanVien k;
    private DuAn m;
    private int sn;
    private String vt;

    public BangPC() {
    }

    public BangPC(NhanVien k, DuAn m, int sn, String vt) {
        this.k = k;
        this.m = m;
        this.sn = sn;
        this.vt = vt;
    }

    public NhanVien getK() {
        return k;
    }

    public void setK(NhanVien k) {
        this.k = k;
    }

    public DuAn getM() {
        return m;
    }

    public void setM(DuAn m) {
        this.m = m;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getVt() {
        return vt;
    }

    public void setVt(String vt) {
        this.vt = vt;
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
            sn,
            vt
        };
    }
}
