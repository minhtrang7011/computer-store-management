/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.Kho;
import com.qlcuahangmaytinh.entity.SanPham;
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
public class KhoDAO extends SysDAO<Kho, String>{
    
    public void insertSPKho(Object soLuong, SanPham entity) {
        String sql = "INSERT INTO ChiTietKho (SoLuong, MaSP, MaKho) VALUES (?, ?, ?)";
        XJdbc.update(sql, 
                soLuong,
                entity.getMaSP(),
                "K001");
    }
    
    @Override
    public void insert(Kho entity) {
        String sql="INSERT INTO Kho (maKho, tenKho, diaChi) VALUES (?, ?, ?)";
        XJdbc.update(sql, 
                entity.getMaKho(), 
                entity.getTenKho(),
                entity.getDiaChi());
    }

    @Override
    public void update(Kho entity) {
        String sql="UPDATE Kho SET maKho = ?, tenKho = ?, diaChi = ?";
        XJdbc.update(sql, 
                entity.getMaKho(), 
                entity.getTenKho(),
                entity.getDiaChi());
    }

    @Override
    public void delete(String maKho) {
        String sql="DELETE FROM Kho WHERE maKho = ?";
        XJdbc.update(sql, maKho);
    }

    @Override
    public Kho selectById(String maKho) {
        String sql="SELECT * FROM Kho WHERE maKho = ?";
        List<Kho> list = selectBySql(sql, maKho);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<Kho> selectAll() {
        String sql="SELECT * FROM Kho";
        return selectBySql(sql);
    }
    
    public HashMap<String, Integer> selectMaSPWithQuantity() {
        String sql = "SELECT * FROM ChiTietKho";
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
    protected List<Kho> selectBySql(String sql, Object... args) {
        List<Kho> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    Kho entity=new Kho();
                    entity.setMaKho(rs.getString("maKho"));
                    entity.setTenKho(rs.getString("tenKho"));
                    entity.setDiaChi(rs.getString("diaChi"));
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
