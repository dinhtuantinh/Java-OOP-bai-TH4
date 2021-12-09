/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class TinhCong implements Serializable{
    private PhongVien phongVien;
    private KieuBaiViet kieuBaiViet;
    private int soKieuBai;

    public PhongVien getPhongVien() {
        return phongVien;
    }

    public KieuBaiViet getKieuBaiViet() {
        return kieuBaiViet;
    }

    public int getSoKieuBai() {
        return soKieuBai;
    }

    public TinhCong(PhongVien phongVien, KieuBaiViet kieuBaiViet, int soKieuBai) {
        this.phongVien = phongVien;
        this.kieuBaiViet = kieuBaiViet;
        this.soKieuBai = soKieuBai;
    }
    
    public Object[] toObjects(){
        return new Object[]{phongVien.getMaPV(),phongVien.getHoTen(),kieuBaiViet.getMaKieuBai(),kieuBaiViet.getTenKieuBai(),soKieuBai};
    }
    
    public boolean trungNhau(TinhCong tinhCong){
        if(tinhCong.phongVien.getMaPV()==this.phongVien.getMaPV()&&tinhCong.getKieuBaiViet().getMaKieuBai()==this.getKieuBaiViet().getMaKieuBai())return true;
        return false;
    }
    
    public boolean dieuKien(TinhCong tinhCong){
        if(tinhCong.phongVien.getMaPV()==this.phongVien.getMaPV()&&tinhCong.getKieuBaiViet().getMaKieuBai()!=this.getKieuBaiViet().getMaKieuBai())return true;
        return false;
    }

    public void setSoKieuBai(int soKieuBai) {
        this.soKieuBai = soKieuBai;
    }

    
    
}
