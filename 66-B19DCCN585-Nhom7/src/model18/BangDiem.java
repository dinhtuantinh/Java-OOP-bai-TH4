/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model18;

import controller18.DiemException;
import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class BangDiem implements Serializable{
    private SinhVien sinhVien;
    private MonHoc monHoc;
    private float diem;

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public BangDiem(SinhVien sinhVien, MonHoc monHoc, float diem) throws DiemException {
        if(diem<0||diem>10)throw new DiemException();
        this.sinhVien = sinhVien;
        this.monHoc = monHoc;
        this.diem = diem;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public float getDiem() {
        return diem;
    }
    
    public Object[] toObjects(){
        return new Object[]{sinhVien.getMaSinhVien(),sinhVien.getHoTen(),monHoc.getMaMon(),monHoc.getTenMon(),diem};
    }
    
    public boolean trungNhau(BangDiem bangDiem){
        if(bangDiem.sinhVien.getMaSinhVien()==this.sinhVien.getMaSinhVien()&&bangDiem.monHoc.getMaMon()==this.monHoc.getMaMon())return true;
        return false;
    }
    
}
