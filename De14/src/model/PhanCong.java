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
public class PhanCong implements Serializable{
    private LaiXe lx;
    private Tuyen tuyen;
    private int luot;

    public PhanCong() {
    }

    public PhanCong(LaiXe lx, Tuyen tuyen, int luot) {
        this.lx = lx;
        this.tuyen = tuyen;
        this.luot = luot;
    }

    
    public LaiXe getLx() {
        return lx;
    }

    public void setLx(LaiXe lx) {
        this.lx = lx;
    }

    public Tuyen getTuyen() {
        return tuyen;
    }

    public void setTuyen(Tuyen tuyen) {
        this.tuyen = tuyen;
    }

    public int getLuot() {
        return luot;
    }

    public void setLuot(int luot) {
        this.luot = luot;
    }
    public Object[] toObject(){
        return new Object[]{
            lx.getMa(),lx.getHoten(),tuyen.getMa(),luot
        };
    }

   
}
