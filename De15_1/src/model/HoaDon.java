/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class HoaDon implements Serializable{
    private KhachHang kh;
    private DichVu dv;

    public HoaDon() {
    }

    public HoaDon(KhachHang kh, DichVu dv) {
        this.kh = kh;
        this.dv = dv;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public DichVu getDv() {
        return dv;
    }

    public void setDv(DichVu dv) {
        this.dv = dv;
    }
    public Object[] toObjects(){
        return new Object[]{
            kh.getMa(),kh.getHoten(),dv.getMa(),dv.getTenDV()
        };
    }

   
    
}
