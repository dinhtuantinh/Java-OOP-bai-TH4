/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model19;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Phong implements Serializable{
    private int ma;
    private int ten;
    private String Lphong;
    private static int sma=100;

    public Phong() {

    }

    public Phong(int ma, int ten, String Lphong) {
        this.ma = ma;
        this.ten = ten;
        this.Lphong = Lphong;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public String getLphong() {
        return Lphong;
    }

    public void setLphong(String Lphong) {
        this.Lphong = Lphong;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Phong.sma = sma;
    }
    
    public Object[] toObjects(){
        return new Object[]{
          ma, ten, Lphong
        };
    }
}
