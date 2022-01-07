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
public class Tuyen implements Serializable{
    private int ma,soDiemDung;
    private double kcach;
    private static int sma=100;

    public Tuyen() {
        
    }

    public Tuyen( int soDiemDung, double kcach) {
        
        this.ma = sma++;
        this.soDiemDung = soDiemDung;
        this.kcach = kcach;
    }

    public Tuyen(int ma, int soDiemDung, double kcach) {
        this.ma = ma;
        this.soDiemDung = soDiemDung;
        this.kcach = kcach;
    }

   
   
    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getSoDiemDung() {
        return soDiemDung;
    }

    public void setSoDiemDung(int soDiemDung) {
        this.soDiemDung = soDiemDung;
    }

    public double getKcach() {
        return kcach;
    }

    public void setKcach(double kcach) {
        this.kcach = kcach;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Tuyen.sma = sma;
    }
    public Object[] toObject(){
        return new Object[]{
            ma,kcach,soDiemDung
        };
    }

    
    
}
