/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model35;

import controller35.deTrongException;
import controller35.giaCuocException;
import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class DichVu implements Serializable{
    private static int maDichVuCurrent = 100-1;
    private int maDichVu;
    private String tenDV;
    private double giaCuoc;
    private String donViTinh;

    public DichVu(String tenDV, double giaCuoc, String donViTinh) throws giaCuocException, deTrongException {
        if(giaCuoc<0)throw new giaCuocException();
        if(tenDV.equals("")||donViTinh.equals(""))throw new deTrongException();
        maDichVu=++maDichVuCurrent;
        this.tenDV = tenDV;
        this.giaCuoc = giaCuoc;
        this.donViTinh = donViTinh;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public String getTenDV() {
        return tenDV;
    }

    public double getGiaCuoc() {
        return giaCuoc;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public static void setMaDichVuCurrent(int maDichVuCurrent) {
        DichVu.maDichVuCurrent = maDichVuCurrent;
    }
    
    public Object[] toObjects(){
        return new Object[]{maDichVu,tenDV,giaCuoc,donViTinh};
    }
    
    public boolean trungNhau(DichVu dichVu){
        if(dichVu.tenDV.equals(this.tenDV))return true;
        return false;
    }
    
}
