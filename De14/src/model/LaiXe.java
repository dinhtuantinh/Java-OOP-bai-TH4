/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import view.TrongException;

/**
 *
 * @author Admin
 */
public class LaiXe implements Serializable{
    private int ma;
    private String hoten,dchi,trinhDo;
    private static int sma=10000;

    public LaiXe() {
       
    }

    public LaiXe( String hoten, String dchi, String trinhDo) throws TrongException {
        Exception TrongException;
        if(hoten.isEmpty()||dchi.isEmpty()) throw new TrongException();
        this.ma = sma++;
        this.hoten = hoten;
        this.dchi = dchi;
        this.trinhDo = trinhDo;
    }

    public LaiXe(int ma, String hoten, String dchi, String trinhDo) {
        this.ma = ma;
        this.hoten = hoten;
        this.dchi = dchi;
        this.trinhDo = trinhDo;
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

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        LaiXe.sma = sma;
    }
    public Object[] toObjects(){
        return new Object[]{
            ma,hoten,dchi,trinhDo
        };
    }
    
}
