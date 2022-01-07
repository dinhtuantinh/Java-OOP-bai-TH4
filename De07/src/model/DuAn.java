/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.deTrongException;
import controller.tongKinhPhiException;
import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class DuAn implements Serializable{
    private static int maDuAnLast=10000-1;
    private int maDuAn;
    private String tenDuAn,kieuDuAn ;
    private double tongKinhPhi;

    public DuAn(String tenDuAn, String kieuDuAn, double tongKinhPhi) throws deTrongException, tongKinhPhiException {
        if(tenDuAn.equals("")||kieuDuAn.equals(""))throw new deTrongException();
        if(tongKinhPhi<0)throw new tongKinhPhiException();
        maDuAn=++maDuAnLast;
        this.tenDuAn = tenDuAn;
        this.kieuDuAn = kieuDuAn;
        this.tongKinhPhi = tongKinhPhi;
    }

    public int getMaDuAn() {
        return maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public String getKieuDuAn() {
        return kieuDuAn;
    }

    public double getTongKinhPhi() {
        return tongKinhPhi;
    }

    public static void setMaDuAnLast(int maDuAnLast) {
        DuAn.maDuAnLast = maDuAnLast;
    }
    
    public Object[] toObjects(){
        return new Object[]{maDuAn,tenDuAn,kieuDuAn,tongKinhPhi};
    }
    
    public boolean trungNhau(DuAn da){
        if(da.tenDuAn.equals(this.tenDuAn)&&da.kieuDuAn.equals(this.kieuDuAn))return true;
        return false;
    }
    
    
}
