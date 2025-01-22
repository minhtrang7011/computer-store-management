/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.PhieuXuat;
import com.qlcuahangmaytinh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhieuXuatDAO extends SysDAO<PhieuXuat, String>{
    
    @Override
    public void insert(PhieuXuat entity) {
        String sql="INSERT INTO PhieuXuat (maPhieuXuat, maKho) VALUES (?, ?)";
        XJdbc.update(sql, 
                entity.getMaPhieuXuat(), 
                entity.getMaKho());
    }

    @Override
    public void update(PhieuXuat entity) {
        String sql="UPDATE PhieuXuat SET maPhieuXuat = ?, maKho = ?";
        XJdbc.update(sql, 
                entity.getMaPhieuXuat(), 
                entity.getMaKho());
    }

    @Override
    public void delete(String maPhieuXuat) {
        String sql="DELETE FROM PhieuXuat WHERE maPhieuXuat = ?";
        XJdbc.update(sql, maPhieuXuat);
    }

    @Override
    public PhieuXuat selectById(String maPhieuXuat) {
        String sql="SELECT * FROM PhieuXuat WHERE maPhieuXuat = ?";
        List<PhieuXuat> list = selectBySql(sql, maPhieuXuat);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<PhieuXuat> selectAll() {
        String sql="SELECT * FROM PhieuXuat";
        return selectBySql(sql);
    }
    
    public HashMap<String, Integer> selectMaSPWithQuantity() {
        String sql = "SELECT * FROM CTPX";
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
    protected List<PhieuXuat> selectBySql(String sql, Object... args) {
        List<PhieuXuat> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    PhieuXuat entity=new PhieuXuat();
                    entity.setMaPhieuXuat(rs.getString("maPhieuXuat"));
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
