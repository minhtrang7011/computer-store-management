/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class CTHoaDon {
    private String maHD;
    private String maSP;
    private Date thoiGian;
    private int soLuong;
    private double thanhTien;

    public CTHoaDon(String maHD, String maSP, Date thoiGian, int soLuong, double thanhTien) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.thoiGian = thoiGian;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    public CTHoaDon(){
        
    }
    
}
