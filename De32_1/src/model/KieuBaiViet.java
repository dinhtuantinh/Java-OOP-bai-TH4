/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model32_1;

import java.io.Serializable;

/**
 *
 * @author duymanh
 */
public class KieuBaiViet implements Serializable{
    private static int maKieuBailast=100;
    private int maKieuBai;
    private String tenKieuBai;
    private double dongia;

    public KieuBaiViet(String tenKieuBai, double dongia) {
        maKieuBai=++maKieuBailast;
        this.tenKieuBai = tenKieuBai;
        this.dongia = dongia;
    }

    public static int getMaKieuBailast() {
        return maKieuBailast;
    }

    public int getMaKieuBai() {
        return maKieuBai;
    }

    public String getTenKieuBai() {
        return tenKieuBai;
    }

    public double getDongia() {
        return dongia;
    }


    public void setMaKieuBai(int maKieuBai) {
        this.maKieuBai = maKieuBai;
    }
    public Object[] toObjects(){
        return new Object[]{
            maKieuBai,tenKieuBai,dongia
        };
    }

    public static void setMaKieuBailast(int maKieuBailast) {
        KieuBaiViet.maKieuBailast = maKieuBailast;
    }

    public void setTenKieuBai(String tenKieuBai) {
        this.tenKieuBai = tenKieuBai;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }
    public boolean trungnhau(KieuBaiViet kieubaiviet){
        if(kieubaiviet.tenKieuBai.equals(this.tenKieuBai)) return true;
        return false;
    }
    
}
