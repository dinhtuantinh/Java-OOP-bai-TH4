/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model18;

import controller18.DeTrongException;
import controller18.SoDVHTException;
import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class MonHoc implements Serializable{
    private static int maMonCurrent=100;
    private int maMon;
    private String tenMon;
    private int soDVHT;
    private String loaiMon;

    public MonHoc(String tenMon, int soDVHT, String loaiMon) throws DeTrongException, SoDVHTException {
        if(tenMon.equals("")||loaiMon.equals(""))throw new DeTrongException();
        if(soDVHT<0)throw new  SoDVHTException();
        maMon=++maMonCurrent;
        this.tenMon = tenMon;
        this.soDVHT = soDVHT;
        this.loaiMon = loaiMon;
    }

    public int getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public int getSoDVHT() {
        return soDVHT;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    public static void setMaMonCurrent(int maMonCurrent) {
        MonHoc.maMonCurrent = maMonCurrent;
    }
    
    public Object[] toObjects(){
        return new Object[]{maMon,tenMon,soDVHT,loaiMon};
    }
    
    public boolean trungNhau(MonHoc monHoc){
        if(monHoc.tenMon.equals(this.tenMon)&&monHoc.loaiMon.equals(this.loaiMon))return true;
        return false;
    }
}
