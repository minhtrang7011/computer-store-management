/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.NhaCungCap;
import com.qlcuahangmaytinh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhaCungCapDAO extends SysDAO<NhaCungCap, String>{
    
    @Override
    public void insert(NhaCungCap entity) {
        String sql="INSERT INTO NhaCungCap (maNCC, tenNhaCungCap, diaChi, email, sdt) VALUES (?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                entity.getMaNCC(), 
                entity.getTenNhaCungCap(), 
                entity.getDiaChi(), 
                entity.getEmail(), 
                entity.getSdt());
    }

    @Override
    public void update(NhaCungCap entity) {
        String sql="UPDATE NhaCungCap SET maNCC = ?, tenNhaCungCap = ?, diaChi = ?, email = ?, sdt = ?";
        XJdbc.update(sql, 
                entity.getMaNCC(), 
                entity.getTenNhaCungCap(), 
                entity.getDiaChi(), 
                entity.getEmail(), 
                entity.getSdt());
    }

    @Override
    public void delete(String maNCC) {
        String sql="DELETE FROM NhaCungCap WHERE maNCC = ?";
        XJdbc.update(sql, maNCC);
    }

    @Override
    public NhaCungCap selectById(String maNCC) {
        String sql="SELECT * FROM NhaCungCap WHERE maNCC = ?";
        List<NhaCungCap> list = selectBySql(sql, maNCC);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<NhaCungCap> selectAll() {
        String sql="SELECT * FROM NhaCungCap";
        return selectBySql(sql);
    }

    @Override
    protected List<NhaCungCap> selectBySql(String sql, Object... args) {
        List<NhaCungCap> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    NhaCungCap entity=new NhaCungCap();
                    entity.setMaNCC(rs.getString("maNCC"));
                    entity.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
                    entity.setDiaChi(rs.getString("diaChi"));
                    entity.setEmail(rs.getString("email"));
                    entity.setSdt(rs.getString("sdt"));
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
