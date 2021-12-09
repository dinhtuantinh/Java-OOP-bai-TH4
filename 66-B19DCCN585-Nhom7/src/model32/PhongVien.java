/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model32;

import controller32.deTrongException;
import controller32.hoTenException;
import java.io.Serializable;
import java.util.StringTokenizer;

/**
 *
 * @author LENOVO
 */
public class PhongVien implements Serializable{
    private static int maPVCurrent =10000-1;
    private int maPV;
    private String hoTen,diaChi,loaiPV;

    public PhongVien(String hoTen, String diaChi, String loaiPV) throws deTrongException, hoTenException {
        if(hoTen.equals("")||diaChi.equals("")||loaiPV.equals(""))throw new deTrongException();
        StringTokenizer str=new StringTokenizer(hoTen);
        if(str.countTokens()<=1)throw new hoTenException();
        maPV=++maPVCurrent;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.loaiPV = loaiPV;
    }

    public int getMaPV() {
        return maPV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getLoaiPV() {
        return loaiPV;
    }

    public static void setMaPVCurrent(int maPVCurrent) {
        PhongVien.maPVCurrent = maPVCurrent;
    }
    
    public Object[] toObjects(){
        return new Object[]{maPV,hoTen,diaChi,loaiPV};
    }
    
    
    
}
