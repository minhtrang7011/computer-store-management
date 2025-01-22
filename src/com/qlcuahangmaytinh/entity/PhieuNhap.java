/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.entity;

/**
 *
 * @author Admin
 */
public class PhieuNhap {
    private String maPhieuNhap;
    private String maKho;

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public PhieuNhap() {
    }

    public PhieuNhap(String maPhieuNhap, String maKho) {
        this.maPhieuNhap = maPhieuNhap;
        this.maKho = maKho;
    }
    
    
}
