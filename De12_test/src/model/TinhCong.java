/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.soSanPhamException;
import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class TinhCong implements Serializable{
   private CongNhan congNhan;
   private SanPham sanPham;
   private int soSanPham;

    public TinhCong(CongNhan congNhan, SanPham sanPham, int soSanPham) throws soSanPhamException {
        if(soSanPham<0)throw new soSanPhamException();
        this.congNhan = congNhan;
        this.sanPham = sanPham;
        this.soSanPham = soSanPham;
    }

    public CongNhan getCongNhan() {
        return congNhan;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public int getSoSanPham() {
        return soSanPham;
    }
   
   public Object[] toObjects(){
        return new Object[]{congNhan.getMaCongNhan(),congNhan.getHoTen(),sanPham.getMaSanPham(),sanPham.getTenSanPham(),soSanPham};
    }
   
   public boolean trungNhau(TinhCong tinhCong){
       if(tinhCong.getCongNhan().getMaCongNhan()==this.getCongNhan().getMaCongNhan() && tinhCong.getSanPham().getMaSanPham()==this.getSanPham().getMaSanPham())return true;
       return false;
   }
   
   public boolean dieuKien(TinhCong tinhCong){
       if(tinhCong.getCongNhan().getMaCongNhan()==this.getCongNhan().getMaCongNhan() && tinhCong.getSanPham().getMaSanPham()!=this.getSanPham().getMaSanPham())return true;
       return false;
   }

    public void setSoSanPham(int soSanPham) {
        this.soSanPham = soSanPham;
    }
   
}
