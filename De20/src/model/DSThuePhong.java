/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class DSThuePhong implements Serializable {
    private KhachHang khachHang;
    private Phong phong;
    private String ngayThue;

    public DSThuePhong() {
    }

    public DSThuePhong(KhachHang khachHang, Phong phong, String ngayThue) {
        this.khachHang = khachHang;
        this.phong = phong;
        this.ngayThue = ngayThue;
    }
    
    public Object[] toObject() {
        return new Object[] {
          khachHang.getMa(),khachHang.getTen(),phong.getMa(),phong.getTen(),ngayThue
        };
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(String ngayThue) {
        this.ngayThue = ngayThue;
    }

}
