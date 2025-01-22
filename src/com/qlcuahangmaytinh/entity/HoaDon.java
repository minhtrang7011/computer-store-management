/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private String maHD;
    private Date ngayLapHD;
    private String trangThai;
    private String ghiChu;
    private String maNV;
    private String maKH;

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(Date ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public HoaDon() {
    }

    public HoaDon(String maHD, Date ngayLapHD, String trangThai, String ghiChu, String maNV, String maKH) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
        this.maKH = maKH;
    }
    
    
}
