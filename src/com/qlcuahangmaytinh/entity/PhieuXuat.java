/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.entity;

/**
 *
 * @author Admin
 */
public class PhieuXuat {
    private String maPhieuXuat;
    private String maKho;

    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public PhieuXuat() {
    }

    public PhieuXuat(String maPhieuXuat, String maKho) {
        this.maPhieuXuat = maPhieuXuat;
        this.maKho = maKho;
    }
    
    
}
