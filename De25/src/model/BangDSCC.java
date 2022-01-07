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
public class BangDSCC implements Serializable{
    private CongNhan cn;
    private XuongSX x;
    private int sngay;
    private double luong;
    public BangDSCC() {
    }

    public BangDSCC(CongNhan cn, XuongSX x, int sngay, double luong) {
        this.cn = cn;
        this.x = x;
        this.sngay = sngay;
        this.luong = luong;
    }

    

    public CongNhan getCn() {
        return cn;
    }

    public void setCn(CongNhan cn) {
        this.cn = cn;
    }

    public XuongSX getX() {
        return x;
    }

    public void setX(XuongSX x) {
        this.x = x;
    }

    public int getSngay() {
        return sngay;
    }

    public void setSngay(int sngay) {
        this.sngay = sngay;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    
    public String getMavaten(){
        return cn.getMa()+"\t"+cn.getTen();
    }


    public Object[] toObjects(){
        return new Object[]{
            cn.getMa(),
            cn.getTen(),
            x.getMa(),
            x.getTen(),
            sngay,
            luong
        };
    }
}
