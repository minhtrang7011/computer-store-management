/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.NguoiDung;
import com.qlcuahangmaytinh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NguoiDungDAO extends SysDAO<NguoiDung, String>{
    
    @Override
    public void insert(NguoiDung entity) {
        String sql="INSERT INTO NguoiDung (tenDangNhap, matKhau, vaiTro) VALUES (?, ?, ?)";
        XJdbc.update(sql, 
                entity.getTenDangNhap(), 
                entity.getMatKhau(),
                entity.getVaiTro());
    }

    @Override
    public void update(NguoiDung entity) {
        String sql="UPDATE NguoiDung SET matKhau = ?, vaiTro = ? WHERE tenDangNhap = ?";
        XJdbc.update(sql, 
                entity.getMatKhau(),
                entity.getVaiTro(),
                entity.getTenDangNhap());
    }

    @Override
    public void delete(String tenDangNhap) {
        String sql="DELETE FROM NguoiDung WHERE tenDangNhap = ?";
        XJdbc.update(sql, tenDangNhap);
    }

    @Override
    public NguoiDung selectById(String tenDangNhap) {
        String sql="SELECT * FROM NguoiDung WHERE tenDangNhap = ?";
        List<NguoiDung> list = selectBySql(sql, tenDangNhap);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<NguoiDung> selectAll() {
        String sql="SELECT * FROM NguoiDung";
        return selectBySql(sql);
    }

    @Override
    protected List<NguoiDung> selectBySql(String sql, Object... args) {
        List<NguoiDung> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    NguoiDung entity=new NguoiDung();
                    entity.setTenDangNhap(rs.getString("tenDangNhap"));
                    entity.setMatKhau(rs.getString("matKhau"));
                    entity.setVaiTro(rs.getString("vaiTro"));
                    list.add(entity);
                }
            }
            finally{
                if (rs != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
}
