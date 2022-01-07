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
public class BangSX implements Serializable{
    private KhachHang kh;
    private Phong p;
    //private int sluong;
    private int sngay,gia;

    public BangSX() {
    }

    public BangSX(KhachHang kh, Phong p,int sngay, int gia) {
        this.kh = kh;
        this.p = p;
        //this.sluong = sluong;
        this.sngay = sngay;
        this.gia=gia;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public Phong getP() {
        return p;
    }

    public void setP(Phong p) {
        this.p = p;
    }

    public int getSngay() {
        return sngay;
    }

    public void setSngay(int sngay) {
        this.sngay = sngay;
    }
    
    public String getMavaten(){
        return kh.getMa()+"\t"+kh.getHoten();
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            kh.getMa(),
            kh.getHoten(),
            kh.getSluong(),
            p.getMa(),
            p.getKieu(),
            sngay,
            gia
        };
    }
}
