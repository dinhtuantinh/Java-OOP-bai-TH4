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
    private NhanVien cn;
    private PhongBan x;
    private int sngay;
    private int luong;
    public BangDSCC() {
    }

    public BangDSCC(NhanVien cn, PhongBan x, int sngay, int luong) {
        this.cn = cn;
        this.x = x;
        this.sngay = sngay;
        this.luong = luong;
    }

    

    public NhanVien getCn() {
        return cn;
    }

    public void setCn(NhanVien cn) {
        this.cn = cn;
    }

    public PhongBan getX() {
        return x;
    }

    public void setX(PhongBan x) {
        this.x = x;
    }

    public int getSngay() {
        return sngay;
    }

    public void setSngay(int sngay) {
        this.sngay = sngay;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
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
