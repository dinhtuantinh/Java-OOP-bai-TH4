/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model38;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class BangTour implements Serializable{
    private KhachHang khachhang;
    private Tour tour;
    private long songuoi;
    private String ngay;
    private long tongtien;

    public BangTour() {
    }

    public BangTour(KhachHang khachhang, Tour tour, long songuoi, String ngay, long tongtien) {
        this.khachhang = khachhang;
        this.tour = tour;
        this.songuoi = songuoi;
        this.ngay = ngay;
        this.tongtien = tongtien;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }
    public String getMavaten(){
        return khachhang.getMa()+"\t"+khachhang.getHoten();
    }
    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public long getSonguoi() {
        return songuoi;
    }

    public void setSonguoi(long songuoi) {
        this.songuoi = songuoi;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            khachhang.getMa(),
            khachhang.getHoten(),
            khachhang.getKieuKH(),
            tour.getMa(),
            tour.getKieu(),
            songuoi,
            ngay,
            tongtien
        };
    }
}
