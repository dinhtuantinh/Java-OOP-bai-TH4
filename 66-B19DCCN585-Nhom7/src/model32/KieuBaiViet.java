/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model32;

import controller32.deTrongException;
import controller32.donGiaException;
import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class KieuBaiViet implements Serializable{
    private static int maKieuBaiCurrent =100-1;
    private int maKieuBai;
    private String tenKieuBai;
    private double donGia;

    public KieuBaiViet( String tenKieuBai, double donGia) throws deTrongException, donGiaException {
        if(tenKieuBai.equals(""))throw new deTrongException();
        if(donGia<0)throw new donGiaException();
        maKieuBai=++maKieuBaiCurrent;
        this.maKieuBai = maKieuBai;
        this.tenKieuBai = tenKieuBai;
        this.donGia = donGia;
    }

    public int getMaKieuBai() {
        return maKieuBai;
    }

    public String getTenKieuBai() {
        return tenKieuBai;
    }

    public double getDonGia() {
        return donGia;
    }

    public static void setMaKieuBaiCurrent(int maKieuBaiCurrent) {
        KieuBaiViet.maKieuBaiCurrent = maKieuBaiCurrent;
    }
    
    public Object[] toObjects(){
        return new Object[]{maKieuBai,tenKieuBai,donGia};
    }
    
    
}
