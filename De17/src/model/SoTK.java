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
public class SoTK implements Serializable{
    private KhachHang kh;
    private NganHang nh;
    //private int sluong;
    private int tiengui;

    public SoTK() {
    }

    public SoTK(KhachHang kh, NganHang nh, int tiengui) {
        this.kh = kh;
        this.nh = nh;
        this.tiengui = tiengui;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public NganHang getNh() {
        return nh;
    }

    public void setNh(NganHang nh) {
        this.nh = nh;
    }

    public int getTiengui() {
        return tiengui;
    }

    public void setTiengui(int tiengui) {
        this.tiengui = tiengui;
    }

    public String getMavaten(){
        return kh.getMa()+"\t"+kh.getHoten();
    }

    public Object[] toObjects(){
        return new Object[]{
            kh.getMa(),
            kh.getHoten(),
            nh.getMa(),
            nh.getTen(),
            tiengui,
        };
    }
}
