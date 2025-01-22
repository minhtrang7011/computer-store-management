/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.entity;

import com.qlcuahangmaytinh.dao.NhanVienDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NguoiDung {
    private String tenDangNhap;
    private String matKhau;
    private String vaiTro;

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public NguoiDung() {
    }

    public NguoiDung(String tenDangNhap, String matKhau, String vaiTro) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }
    
    public boolean isQuanLy() {
        return this.getVaiTro().equals("Quản lý");
    }
    
    public boolean isNVKho(NguoiDung ndTemp) {
        List<NhanVien> listNV = new NhanVienDAO().selectAll();
        for (NhanVien temp : listNV) {
            if (temp.getTenDangNhap().equalsIgnoreCase(ndTemp.getTenDangNhap())) {
                return listNV.get(listNV.indexOf(temp)).getMaKho() != null;
            }
        }
        return false;
    }
}
