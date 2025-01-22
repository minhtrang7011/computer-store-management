/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.PhieuNhap;
import com.qlcuahangmaytinh.entity.SanPham;
import com.qlcuahangmaytinh.utils.XDate;
import com.qlcuahangmaytinh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhieuNhapDAO extends SysDAO<PhieuNhap, String>{
    
    public void nhapKho(SanPham entity, int soLuong) {
        String sql = "INSERT INTO PhieuNhap (maKho) VALUES (?)";
        XJdbc.update(sql, 
                "K001");
        sql = "INSERT INTO CTPN (soLuong, thoiGian, maSP) VALUES (?, ?, ?)";
        XJdbc.update(sql, 
                soLuong,
                XDate.toString(new Date(), "YYYY/MM/dd"),
                entity.getMaSP());
    }
    
    public void suaKho(SanPham entity, int soLuong) {
        
    }
    
    @Override
    public void insert(PhieuNhap entity) {
        String sql="INSERT INTO PhieuNhap (maKho) VALUES (?, ?)";
        XJdbc.update(sql, 
                entity.getMaPhieuNhap(), 
                entity.getMaKho());
    }

    @Override
    public void update(PhieuNhap entity) {
        String sql="UPDATE PhieuNhap SET maPhieuNhap = ?, maKho = ?";
        XJdbc.update(sql, 
                entity.getMaPhieuNhap(), 
                entity.getMaKho());
    }

    @Override
    public void delete(String maPhieuNhap) {
        String sql="DELETE FROM PhieuNhap WHERE maPhieuNhap = ?";
        XJdbc.update(sql, maPhieuNhap);
    }

    @Override
    public PhieuNhap selectById(String maPhieuNhap) {
        String sql="SELECT * FROM PhieuNhap WHERE maPhieuNhap = ?";
        List<PhieuNhap> list = selectBySql(sql, maPhieuNhap);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<PhieuNhap> selectAll() {
        String sql="SELECT * FROM PhieuNhap";
        return selectBySql(sql);
    }

    @Override
    protected List<PhieuNhap> selectBySql(String sql, Object... args) {
        List<PhieuNhap> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    PhieuNhap entity=new PhieuNhap();
                    entity.setMaPhieuNhap(rs.getString("maPhieuNhap"));
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
