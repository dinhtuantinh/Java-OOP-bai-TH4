/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model28;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class BangSX implements Serializable{
    private PhongTH phongTH;
    private Lop lop;
    private int kiphoc;

    public BangSX() {
    }

    public BangSX(PhongTH phongTH, Lop lop, int kiphoc) {
        this.phongTH = phongTH;
        this.lop = lop;
        this.kiphoc = kiphoc;
    }

    public PhongTH getPhongTH() {
        return phongTH;
    }

    public void setPhongTH(PhongTH phongTH) {
        this.phongTH = phongTH;
    }
    public String getMavaten(){
        return phongTH.getMa()+"\t"+phongTH.getTen();
    }
    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public int getKiphoc() {
        return kiphoc;
    }

    public void setKiphoc(int kiphoc) {
        this.kiphoc = kiphoc;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            phongTH.getMa(),
            phongTH.getTen(),
            phongTH.getSomay(),
            lop.getMa(),
            lop.getTen(),
            lop.getSoSV(),
            kiphoc
        };
    }
}
