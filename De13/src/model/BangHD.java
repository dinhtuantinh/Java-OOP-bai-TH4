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
public class BangHD implements Serializable{
    private KhachHang kh;
    private MatHang mh;
    //private int sluong;
    private int sl,tien;

    public BangHD() {
    }

    public BangHD(KhachHang kh, MatHang mh, int sl, int tien) {
        this.kh = kh;
        this.mh = mh;
        this.sl = sl;
        this.tien = tien;
    }

    public String getMavaten(){
        return kh.getMa()+"\t"+kh.getHoten();
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public MatHang getMh() {
        return mh;
    }

    public void setMh(MatHang mh) {
        this.mh = mh;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }

    public Object[] toObjects(){
        return new Object[]{
            kh.getMa(),
            kh.getHoten(),
            mh.getMa(),
            mh.getTen(),
            sl,
            tien
        };
    }
}
