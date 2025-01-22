/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.CtPhieuNhap;
import com.qlcuahangmaytinh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minhtrang
 */
public class CtPhieuNhapDAO extends SysDAO<CtPhieuNhap, Integer> {

    public void insertPhieuNhap() {
        String sql = "INSERT INTO PhieuNhap (MAKHO) VALUES (?)";
        XJdbc.update(sql,
                "K001");
    }
    public void deletePhieuNhap(Integer maPN) {
        String sql = "DELETE FROM PHIEUNHAP WHERE MAPHIEUNHAP = ?";
        XJdbc.update(sql,maPN);
    }

    @Override
    public void insert(CtPhieuNhap entity) {
        String sql = "INSERT INTO CTPN (SOLUONG, THOIGIAN, MASP) VALUES (?,?,?)";
        XJdbc.update(sql,
                entity.getSoLuong(),
                entity.getThoiGian(),
                entity.getMaSP()
        );
    }

    @Override
    public void update(CtPhieuNhap entity) {
        String sql = "UPDATE CTPN set SOLUONG = ?, THOIGIAN = ?, MASP = ? WHERE MAPHIEUNHAP =?;";
        XJdbc.update(sql,
                entity.getSoLuong(),
                entity.getThoiGian(),
                entity.getMaSP(),
                entity.getMaPN()
                );
    }

    @Override
    public void delete(Integer maPN) {
         String sql = "DELETE FROM CTPN WHERE MAPHIEUNHAP = ?";
        XJdbc.update(sql,maPN);
    }

    @Override
    public CtPhieuNhap selectById(Integer maPN) {
        String sql = "SELECT * FROM CTPN WHERE MAPHIEUNHAP = ?";
        List<CtPhieuNhap> list = selectBySql(sql, maPN);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<CtPhieuNhap> selectAll() {
        String sql = "SELECT * FROM CTPN";
        return selectBySql(sql);
    }

    @Override
    protected List<CtPhieuNhap> selectBySql(String sql, Object... args) {
        List<CtPhieuNhap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    CtPhieuNhap entity = new CtPhieuNhap();
                    entity.setMaPN(rs.getInt("maPhieuNhap"));
                    entity.setMaSP(rs.getString("maSP"));
                    entity.setThoiGian(rs.getDate("thoiGian"));
                    entity.setSoLuong(rs.getInt("soLuong"));
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
