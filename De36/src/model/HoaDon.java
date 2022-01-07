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
public class HoaDon implements Serializable {
    private NguoiMuaVe nguoiMuaVe;
    private LoaiVe loaiVe;
    private int soLuong;

    public HoaDon() {
    }

    public HoaDon(NguoiMuaVe nguoiMuaVe, LoaiVe loaiVe, int soLuong) {
        this.nguoiMuaVe = nguoiMuaVe;
        this.loaiVe = loaiVe;
        this.soLuong = soLuong;
    }

    public NguoiMuaVe getNguoiMuaVe() {
        return nguoiMuaVe;
    }

    public void setNguoiMuaVe(NguoiMuaVe nguoiMuaVe) {
        this.nguoiMuaVe = nguoiMuaVe;
    }

    public LoaiVe getLoaiVe() {
        return loaiVe;
    }

    public void setLoaiVe(LoaiVe loaiVe) {
        this.loaiVe = loaiVe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public Object[] toObjects() {
        return new Object[] {
            nguoiMuaVe.getMa(), nguoiMuaVe.getTen(), loaiVe.getMa(), soLuong
        };
    }
}
