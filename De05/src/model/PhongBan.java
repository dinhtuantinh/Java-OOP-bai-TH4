/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.deTrongException;
import controller.heSoCongViecExceptioon;
import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class PhongBan implements Serializable{
    private static int maPhongBanCurrent =100-1;
    private int maPhongBan;
    private String tenPhong,moTa;
    private double heSoCongViec;

    public PhongBan(String tenPhong, String moTa, double heSoCongViec) throws deTrongException, heSoCongViecExceptioon {
        if(tenPhong.equals("")||moTa.equals(""))throw new deTrongException();
        if(heSoCongViec<0||heSoCongViec>20)throw new heSoCongViecExceptioon();
        maPhongBan=++maPhongBanCurrent;
        this.tenPhong = tenPhong;
        this.moTa = moTa;
        this.heSoCongViec = heSoCongViec;
    }

    public int getMaPhongBan() {
        return maPhongBan;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public double getHeSoCongViec() {
        return heSoCongViec;
    }

    public static void setMaPhongBanCurrent(int maPhongBanCurrent) {
        PhongBan.maPhongBanCurrent = maPhongBanCurrent;
    }
    
    public Object[] toObjects(){
        return new Object[]{maPhongBan,tenPhong,maPhongBan,heSoCongViec};
    }
    
    public boolean trungNhau(PhongBan phongBan){
        if(phongBan.tenPhong.equals(this.tenPhong)&&phongBan.moTa.equals(this.moTa))return true;
        return false;
    }
    
}
