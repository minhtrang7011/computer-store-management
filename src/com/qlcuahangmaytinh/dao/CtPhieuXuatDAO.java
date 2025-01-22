/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.CtPhieuXuat;
import com.qlcuahangmaytinh.utils.XJdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.HashMap;

/**
 *
 * @author nqgba
 */
public class CtPhieuXuatDAO extends SysDAO<CtPhieuXuat, Integer> {

    public void insertPhieuXuat() {
        String sql = "INSERT INTO PhieuXuat (MAKHO) VALUES (?)";
        XJdbc.update(sql,
                "K001");
    }
    public void deletePhieuXuat(Integer maPX) {
        String sql = "DELETE FROM PHIEUXUAT WHERE MAPHIEUXUAT = ?";
        XJdbc.update(sql,maPX);
    }

    @Override
    public void insert(CtPhieuXuat entity) {
        String sql = "INSERT INTO CTPX (SOLUONG, THOIGIAN, MASP) VALUES (?,?,?)";
        XJdbc.update(sql,
                entity.getSoLuong(),
                entity.getThoiGian(),
                entity.getMaSP()
        );
    }

    @Override
    public void update(CtPhieuXuat entity) {
        String sql = "UPDATE CTPX set SOLUONG = ?, THOIGIAN = ?, MASP = ? WHERE MAPHIEUXUAT =?;";
        XJdbc.update(sql,
                entity.getSoLuong(),
                entity.getThoiGian(),
                entity.getMaSP(),
                entity.getMaPX()
                );
    }

    @Override
    public void delete(Integer maPX) {
         String sql = "DELETE FROM CTPX WHERE MAPHIEUXUAT = ?";
        XJdbc.update(sql,maPX);
    }

    @Override
    public CtPhieuXuat selectById(Integer maPhieuXuat) {
        String sql = "SELECT * FROM CTPX WHERE MAPHIEUXUAT = ?";
        List<CtPhieuXuat> list = selectBySql(sql, maPhieuXuat);
        return !list.isEmpty() ? list.get(0) : null;
    }
    
    public HashMap<String, Integer> selectSPWithQuantityInStorage() {
        String sql = "SELECT MASP, SUM(SOLUONG) AS SOLUONG FROM CTPX GROUP BY MASP";
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql);
                while(rs.next()){
                    hashMap.put(rs.getString("maSP"), rs.getInt("soLuong"));
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return hashMap;
    }

    @Override
    public List<CtPhieuXuat> selectAll() {
        String sql = "SELECT * FROM CTPX";
        return selectBySql(sql);
    }

    @Override
    protected List<CtPhieuXuat> selectBySql(String sql, Object... args) {
        List<CtPhieuXuat> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    CtPhieuXuat entity = new CtPhieuXuat();
                    entity.setMaPX(rs.getInt("maPhieuXuat"));
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
