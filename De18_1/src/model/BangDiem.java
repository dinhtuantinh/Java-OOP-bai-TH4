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
public class BangDiem implements Serializable{
    private SinhVien k;
    private MonHoc m;
    private int diem;

    public BangDiem() {
    }

    public BangDiem(SinhVien k, MonHoc m, int diem) {
        this.k = k;
        this.m = m;
        this.diem = diem;
    }

    public SinhVien getK() {
        return k;
    }

    public void setK(SinhVien k) {
        this.k = k;
    }

    public MonHoc getM() {
        return m;
    }

    public void setM(MonHoc m) {
        this.m = m;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
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
            diem
        };
    }
}
