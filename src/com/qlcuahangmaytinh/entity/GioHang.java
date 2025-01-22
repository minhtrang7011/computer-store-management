/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.entity;

import java.util.Date;

/**
 *
 * @author nqgba
 */
public class GioHang  {
    private String maHD;
    private Date thoiGian;
    private String trangThai;
    private String hoTen;
    private String tenSanPham;
    private int soLuong;
    private double thanhTien;

    public GioHang(String maHD, Date thoiGian, String trangThai, String hoTen, String tenSanPham, int soLuong, double thanhTien) {
        this.maHD = maHD;
        this.thoiGian = thoiGian;
        this.trangThai = trangThai;
        this.hoTen = hoTen;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
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

    public GioHang() {
    }

    

}