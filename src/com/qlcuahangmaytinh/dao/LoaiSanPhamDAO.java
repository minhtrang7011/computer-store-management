/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.LoaiSanPham;
import com.qlcuahangmaytinh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LoaiSanPhamDAO extends SysDAO<LoaiSanPham, String>{
    
    @Override
    public void insert(LoaiSanPham entity) {
        String sql="INSERT INTO LoaiSanPham (maLoai, tenLoai) VALUES (?, ?)";
        XJdbc.update(sql, 
                entity.getMaLoai(), 
                entity.getTenLoai());
    }

    @Override
    public void update(LoaiSanPham entity) {
        String sql="UPDATE LoaiSanPham SET maLoai = ?, tenLoai = ?";
        XJdbc.update(sql, 
                entity.getMaLoai(), 
                entity.getTenLoai());
    }

    @Override
    public void delete(String maLoai) {
        String sql="DELETE FROM LoaiSanPham WHERE maLoai = ?";
        XJdbc.update(sql, maLoai);
    }

    @Override
    public LoaiSanPham selectById(String maLoai) {
        String sql="SELECT * FROM LoaiSanPham WHERE maLoai = ?";
        List<LoaiSanPham> list = selectBySql(sql, maLoai);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<LoaiSanPham> selectAll() {
        String sql="SELECT * FROM LoaiSanPham";
        return selectBySql(sql);
    }

    @Override
    protected List<LoaiSanPham> selectBySql(String sql, Object... args) {
        List<LoaiSanPham> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    LoaiSanPham entity=new LoaiSanPham();
                    entity.setMaLoai(rs.getString("maLoai"));
                    entity.setTenLoai(rs.getString("tenLoai"));
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
