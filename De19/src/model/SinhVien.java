/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model19;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class SinhVien implements Serializable{
    private int ma;
    private String hoten,dchi,nsinh,lop;
    private static int sma=10000;

    public SinhVien() {
        ma=sma++;
    }

    public SinhVien(int ma, String hoten, String dchi, String nsinh, String lop) {
        this.ma = ma;
        this.hoten = hoten;
        this.dchi = dchi;
        this.nsinh = nsinh;
        this.lop = lop;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public String getNsinh() {
        return nsinh;
    }

    public void setNsinh(String nsinh) {
        this.nsinh = nsinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        SinhVien.sma = sma;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            ma, hoten, dchi, nsinh, lop
        };
    }
}
