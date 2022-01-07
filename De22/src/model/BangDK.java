/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class BangDK implements Serializable{
    private GiangVien k;
    private MonHoc m;
    private int sl;
    private Date date;

    public BangDK() {
    }

    public BangDK(GiangVien k, MonHoc m, int sl, Date date) {
        this.k = k;
        this.m = m;
        this.sl = sl;
        this.date = date;
    }

    public GiangVien getK() {
        return k;
    }

    public void setK(GiangVien k) {
        this.k = k;
    }

    public MonHoc getM() {
        return m;
    }

    public void setM(MonHoc m) {
        this.m = m;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
            date
        };
    }
}
