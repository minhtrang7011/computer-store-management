/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.entity;

import java.util.Date;

/**
 *
 * @author minhtrang
 */
public class CtPhieuNhap {

    private int soLuong;
    private Date thoiGian;
    private String maSP;
    private int maPN;
    
    public CtPhieuNhap() {
    }

    public CtPhieuNhap(int soLuong, Date thoiGian, String maSP, int maPN) {
        this.soLuong = soLuong;
        this.thoiGian = thoiGian;
        this.maSP = maSP;
        this.maPN = maPN;
    }

    public int getMaPN() {
        return maPN;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
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

    