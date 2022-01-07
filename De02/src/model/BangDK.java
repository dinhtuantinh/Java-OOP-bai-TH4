/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class BangDK implements Serializable{
    private SinhVien sv;
    private MonHoc mon;
    private Date tgian;

    public BangDK() {
    }

    public BangDK(SinhVien sv, MonHoc mon, Date tgian) {
        this.sv = sv;
        this.mon = mon;
        this.tgian = tgian;
    }


    public String getMavaten(){
        return sv.getMa()+"\t"+sv.getHoten();
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public MonHoc getMon() {
        return mon;
    }

    public void setMon(MonHoc mon) {
        this.mon = mon;
    }

    public Date getTgian() {
        return tgian;
    }

    public void setTgian(Date tgian) {
        this.tgian = tgian;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            sv.getMa(),
            sv.getHoten(),
            mon.getMa(),
            mon.getTen(),
            mon.getStiet(),
            tgian
        };
    }
}
