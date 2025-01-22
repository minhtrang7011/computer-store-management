/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.entity;

import java.util.Date;

public class CtPhieuXuat {
   private int soLuong;
   private Date thoiGian;
   private String maSP;
   private int maPX;

    public CtPhieuXuat() {
    }

    public CtPhieuXuat(int soLuong, Date thoiGian, String maSP, int maPX) {
        this.soLuong = soLuong;
        this.thoiGian = thoiGian;
        this.maSP = maSP;
        this.maPX = maPX;
    }

    public int getMaPX() {
        return maPX;
    }

    public void setMaPX(int maPX) {
        this.maPX = maPX;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
    
}
