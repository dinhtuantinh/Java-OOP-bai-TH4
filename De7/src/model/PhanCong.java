/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.soNgayTHamGiaException;
import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class PhanCong implements Serializable{
    private DuAn duAn;
    private NhanVien nhanVien;
    private int soNgayThamGia;
    private String viTriCongViec;

    public PhanCong(DuAn duAn, NhanVien nhanVien, int soNgayThamGia, String viTriCongViec) throws soNgayTHamGiaException {
        if(soNgayThamGia<0) throw new soNgayTHamGiaException();
        this.duAn = duAn;
        this.nhanVien = nhanVien;
        this.soNgayThamGia = soNgayThamGia;
        this.viTriCongViec = viTriCongViec;
    }

    public DuAn getDuAn() {
        return duAn;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public int getSoNgayThamGia() {
        return soNgayThamGia;
    }

    public String getViTriCongViec() {
        return viTriCongViec;
    }
    
    public Object[] toObjects(){
        return new Object[]{duAn.getMaDuAn(),duAn.getTenDuAn(),nhanVien.getMaNhanVien(),nhanVien.getHoTen(),soNgayThamGia,viTriCongViec};
    }
    
    public boolean dieuKien(PhanCong phanCong){
        if(phanCong.duAn.getMaDuAn()==this.duAn.getMaDuAn()&&phanCong.nhanVien.getMaNhanVien()==this.nhanVien.getMaNhanVien()&&phanCong.getViTriCongViec()!=this.getViTriCongViec())return true;
        return false;
    }
}
