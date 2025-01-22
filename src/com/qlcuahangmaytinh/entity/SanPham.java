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
public class SanPham {
    private String maSP;
    private String tenSanPham;
    private Date ngaySanXuat;
    private String moTaSanPham;
    private String maLoai;
    private String maNCC;
    private double giaMua;
    private double giaBan;
    private int soLuong;

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public double getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(double giaMua) {
        this.giaMua = giaMua;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public SanPham(String maSP, String tenSanPham, Date ngaySanXuat, String moTaSanPham, String maLoai, String maNCC, double giaMua, double giaBan, int soLuong) {
        this.maSP = maSP;
        this.tenSanPham = tenSanPham;
        this.ngaySanXuat = ngaySanXuat;
        this.moTaSanPham = moTaSanPham;
        this.maLoai = maLoai;
        this.maNCC = maNCC;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }
    
    public SanPham() {
    }
}
