/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.NhanVien;
import com.qlcuahangmaytinh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienDAO extends SysDAO<NhanVien, String>{
    
    public void insertNguoiDung(String tenDangNhap) {
        String sql = "INSERT INTO NguoiDung (tenDangNhap, matKhau, vaiTro) VALUES (?, ? ,?)";
        XJdbc.update(sql,
                tenDangNhap,
                "123",
                "Nhân viên");
    }
    
    public void deleteNguoiDung(String tenDangNhap) {
        String sql = "DELETE FROM NguoiDung WHERE tenDangNhap = ?";
        XJdbc.update(sql,tenDangNhap);
    }
    
    @Override
    public void insert(NhanVien entity) {
        String sql="INSERT INTO NhanVien (maNV, hoTen, ngaySinh, gioiTinh, diaChi, sdt, email, caLam, tenDangNhap, maKho) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                entity.getMaNV(), 
                entity.getHoTen(), 
                entity.getNgaySinh(), 
                entity.getGioiTinh(), 
                entity.getDiaChi(),
                entity.getSdt(),
                entity.getEmail(),
                entity.getCaLam(),
                entity.getTenDangNhap(),
                entity.getMaKho());

    }

    @Override
    public void update(NhanVien entity) {
        String sql="UPDATE NhanVien SET hoTen = ?, ngaySinh = ?, gioiTinh = ?, diaChi = ?, sdt = ?, email = ?, caLam = ?, tenDangNhap = ?, maKho = ? WHERE maNV = ?";
        XJdbc.update(sql, 
                entity.getHoTen(), 
                entity.getNgaySinh(), 
                entity.getGioiTinh(), 
                entity.getDiaChi(),
                entity.getSdt(),
                entity.getEmail(),
                entity.getCaLam(),
                entity.getTenDangNhap(),
                entity.getMaKho(),
                entity.getMaNV());
    }

    @Override
    public void delete(String maNV) {
        String sql="DELETE FROM NhanVien WHERE maNV = ?";
        XJdbc.update(sql, maNV);
    }

    @Override
    public NhanVien selectById(String maNV) {
        String sql="SELECT * FROM NhanVien WHERE maNV = ?";
        List<NhanVien> list = selectBySql(sql, maNV);
        return !list.isEmpty() ? list.get(0) : null;
    }
    public NhanVien selectByTenDangNhap(String tenDangNhap) {
        String sql="SELECT * FROM NhanVien WHERE tenDangNhap = ?";
        List<NhanVien> list = selectBySql(sql, tenDangNhap);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<NhanVien> selectAll() {
        String sql="SELECT * FROM NhanVien";
        return selectBySql(sql);
    }
    
    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    NhanVien entity= new NhanVien();
                    entity.setMaNV(rs.getString("maNV"));
                    entity.setHoTen(rs.getString("hoTen"));
                    entity.setNgaySinh(rs.getDate("ngaySinh"));
                    entity.setGioiTinh(rs.getBoolean("gioiTinh"));
                    entity.setDiaChi(rs.getString("diaChi"));
                    entity.setSdt(rs.getString("sdt"));
                    entity.setEmail(rs.getString("email"));
                    entity.setCaLam(rs.getInt("CaLam"));
                    entity.setTenDangNhap(rs.getString("tenDangNhap"));
                    entity.setMaKho(rs.getString("maKho"));
                    list.add(entity);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
}
