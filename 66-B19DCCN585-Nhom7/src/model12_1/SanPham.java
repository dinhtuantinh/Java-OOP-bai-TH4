/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model12_1;

import controller12_1.deTrongException;
import controller12_1.donGiaException;
import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class SanPham implements Serializable{
    private static int maSanPhamCurrent =10000-1;
    private int maSanPham;
    private String tenSanPham ;
    private double donGia ;

    public SanPham(String tenSanPham, double donGia) throws deTrongException, donGiaException {
        if(tenSanPham.equals(""))throw new deTrongException();
        if(donGia<0)throw new donGiaException();
        maSanPham=++maSanPhamCurrent;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public double getDonGia() {
        return donGia;
    }

    public static void setMaSanPhamCurrent(int maSanPhamCurrent) {
        SanPham.maSanPhamCurrent = maSanPhamCurrent;
    }
    
    public Object[] toObjects(){
        return new Object[]{maSanPham,tenSanPham,donGia};
    }
    
    public boolean trungNhau(SanPham sanPham){
        if(sanPham.tenSanPham.equals(this.tenSanPham))return true;
        return false;
    }
}
