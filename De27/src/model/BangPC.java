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
    private SinhVien k;
    private BaiTap m;
    private int tg;

    public BangPC() {
    }

    public BangPC(SinhVien k, BaiTap m, int tg) {
        this.k = k;
        this.m = m;
        this.tg = tg;
    }

    public SinhVien getK() {
        return k;
    }

    public void setK(SinhVien k) {
        this.k = k;
    }

    public BaiTap getM() {
        return m;
    }

    public void setM(BaiTap m) {
        this.m = m;
    }

    public int getTg() {
        return tg;
    }

    public void setTg(int tg) {
        this.tg = tg;
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
            tg
        };
    }
}
