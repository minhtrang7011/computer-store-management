/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.HoaDon;
import com.qlcuahangmaytinh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonDAO extends SysDAO<HoaDon, String>{

    @Override
    public void insert(HoaDon entity) {
        String sql="INSERT INTO HoaDon (maHD, ngayLapHD, trangThai, ghiChu, maNV, maKH) VALUES (?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                entity.getMaHD(), 
                entity.getNgayLapHD(), 
                entity.getTrangThai(), 
                entity.getGhiChu(), 
                entity.getMaNV(),
                entity.getMaKH());
    }

    @Override
    public void update(HoaDon entity) {
        String sql="UPDATE HoaDon SET maHD = ?, ngayLapHD = ?, trangThai = ?, ghiChu = ?, maNV = ?, maKH = ?";
        XJdbc.update(sql, 
                entity.getMaHD(), 
                entity.getNgayLapHD(), 
                entity.getTrangThai(), 
                entity.getGhiChu(), 
                entity.getMaNV(),
                entity.getMaKH());
    }

    @Override
    public void delete(String maHD) {
        String sql="DELETE FROM HoaDon WHERE maHD = ?";
        XJdbc.update(sql, maHD);
    }

    @Override
    public HoaDon selectById(String maHD) {
        String sql="SELECT * FROM HoaDon WHERE maHD = ?";
        List<HoaDon> list = selectBySql(sql, maHD);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<HoaDon> selectAll() {
        String sql="SELECT * FROM HoaDon";
        return selectBySql(sql);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    HoaDon entity=new HoaDon();
                    entity.setMaHD(rs.getString("maHD"));
                    entity.setNgayLapHD(rs.getDate("ngayLapHD"));
                    entity.setTrangThai(rs.getString("trangThai"));
                    entity.setGhiChu(rs.getString("ghiChu"));
                    entity.setMaNV(rs.getString("maNV"));
                    entity.setMaKH(rs.getString("maKH"));
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
