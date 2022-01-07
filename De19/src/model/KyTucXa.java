/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model19;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class KyTucXa implements Serializable{
    private SinhVien sinhvien;
    private Phong phong;
    private String date;
    private long tonggia;

    public KyTucXa() {
    }

    public KyTucXa(Phong phong, SinhVien sinhvien, String date, long tonggia) {
        this.sinhvien = sinhvien;
        this.phong = phong;
        this.date = date;
        this.tonggia = tonggia;
    }
    
    public SinhVien getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(SinhVien sinhvien) {
        this.sinhvien = sinhvien;
    }
    
    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }
    public String getMavaten(){
        return phong.getMa()+"\t"+phong.getTen();
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public long getTonggia() {
        return tonggia;
    }

    public void setTonggia(long tonggia) {
        this.tonggia = tonggia;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            phong.getMa(),
            phong.getTen(),
            sinhvien.getMa(),
            sinhvien.getHoten(),
            date,
            tonggia
        };
    }
}
