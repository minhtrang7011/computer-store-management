/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.KhachHang;
import com.qlcuahangmaytinh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangDAO extends SysDAO<KhachHang, String> {

    @Override
    public void insert(KhachHang entity) {
        String sql = "INSERT INTO KhachHang (maKH, hoTen, ngaySinh, gioiTinh, diaChi, sdt, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql,
                entity.getMaKH(),
                entity.getHoTen(),
                entity.getNgaySinh(),
                entity.getGioiTinh(),
                entity.getDiaChi(),
                entity.getSdt(),
                entity.getEmail());

    }

    @Override
    public void update(KhachHang entity) {
        String sql = "UPDATE KhachHang SET hoTen = ?, ngaySinh = ?, gioiTinh = ?, diaChi = ?, sdt = ?, email = ? where maKH = ?";
        XJdbc.update(sql,
                entity.getHoTen(), 
                entity.getNgaySinh(), 
                entity.getGioiTinh(), 
                entity.getDiaChi(),
                entity.getSdt(),
                entity.getEmail(),
                entity.getMaKH());
    }

    @Override
    public void delete(String maKH) {
        String sql = "DELETE FROM KhachHang WHERE maKH = ?";
        XJdbc.update(sql, maKH);
    }

    @Override
    public KhachHang selectById(String maKH) {
        String sql = "SELECT * FROM KhachHang WHERE maKH = ?";
        List<KhachHang> list = selectBySql(sql, maKH);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<KhachHang> selectAll() {
        String sql = "SELECT * FROM KhachHang";
        return selectBySql(sql);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    KhachHang entity = new KhachHang();
                    entity.setMaKH(rs.getString("maKH"));
                    entity.setHoTen(rs.getString("hoTen"));
                    entity.setNgaySinh(rs.getDate("ngaySinh"));
                    entity.setGioiTinh(rs.getBoolean("gioiTinh"));
                    entity.setDiaChi(rs.getString("diaChi"));
                    entity.setSdt(rs.getString("sdt"));
                    entity.setEmail(rs.getString("email"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

}
