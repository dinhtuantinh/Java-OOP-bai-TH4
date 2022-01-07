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
public class BangKKGD implements Serializable{
    private GiangVien k;
    private MonHoc m;
    private int lop,luong;

    public BangKKGD() {
    }

    public BangKKGD(GiangVien k, MonHoc m, int lop, int luong) {
        this.k = k;
        this.m = m;
        this.lop = lop;
        this.luong = luong;
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

    public int getLop() {
        return lop;
    }

    public void setLop(int lop) {
        this.lop = lop;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
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
            m.getStiet(),
            lop,
            luong
        };
    }
}
