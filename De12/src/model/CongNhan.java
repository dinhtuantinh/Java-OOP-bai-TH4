/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.deTrongException;
import controller.hoTenException;
import java.io.Serializable;
import java.util.StringTokenizer;

/**
 *
 * @author LENOVO
 */
public class CongNhan implements Serializable{
    private static int maCongNhanCurrent =10000-1;
    private int maCongNhan;
    private String hoTen, diaChi,caSanXuat ;

    public CongNhan(String hoTen, String diaChi, String caSanXuat) throws deTrongException, hoTenException {
        if(hoTen.equals("")||diaChi.equals("")||caSanXuat.equals(""))throw new deTrongException();
        StringTokenizer str=new StringTokenizer(hoTen);
        if(str.countTokens()<=1)throw new hoTenException();
        maCongNhan=++maCongNhanCurrent;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.caSanXuat = caSanXuat;
    }

    public int getMaCongNhan() {
        return maCongNhan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getCaSanXuat() {
        return caSanXuat;
    }

    public static void setMaCongNhanCurrent(int maCongNhanCurrent) {
        CongNhan.maCongNhanCurrent = maCongNhanCurrent;
    }
    
    public Object[] toObjects(){
        return new Object[]{maCongNhan,hoTen,diaChi,caSanXuat};
    }
    
    public boolean trungNhau(CongNhan congNhan){
        if(congNhan.hoTen.equals(this.hoTen)&&congNhan.diaChi.equals(this.diaChi))return true;
        return false;
    }
}
