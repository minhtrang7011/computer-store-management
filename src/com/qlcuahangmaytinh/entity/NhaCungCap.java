/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.entity;

/**
 *
 * @author Admin
 */
public class NhaCungCap {
    private String maNCC;
    private String tenNhaCungCap;
    private String diaChi;
    private String email;
    private String sdt;

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public NhaCungCap(String maNCC, String tenNhaCungCap, String diaChi, String email, String sdt) {
        this.maNCC = maNCC;
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
    }

    public NhaCungCap() {
    }
}
