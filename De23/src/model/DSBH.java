/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class DSBH implements Serializable{
    private NVBanHang nv;
    private MatHang mh;
    private int sl;

    public DSBH() {
    }

    public DSBH(NVBanHang nv, MatHang mh, int sl) {
        this.nv = nv;
        this.mh = mh;
        this.sl = sl;
    }

    public NVBanHang getNv() {
        return nv;
    }

    public void setNv(NVBanHang nv) {
        this.nv = nv;
    }

    public MatHang getMh() {
        return mh;
    }

    public void setMh(MatHang mh) {
        this.mh = mh;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
    
    
    public Object[] toObjects(){
        return new Object[]{
            nv.getMa(),nv.getTen(),mh.getMa(),mh.getTen(),mh.getNhom()
    };
    }
    
}
