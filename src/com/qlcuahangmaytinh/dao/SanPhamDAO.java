/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.SanPham;
import com.qlcuahangmaytinh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamDAO extends SysDAO<SanPham, String>{
    
    @Override
    public void insert(SanPham entity) {
        String sql="INSERT INTO SanPham (maSP, tenSanPham, ngaySanXuat, moTaSanPham, maLoai, maNCC, giaMua, giaBan) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                entity.getMaSP(), 
                entity.getTenSanPham(), 
                entity.getNgaySanXuat(), 
                entity.getMoTaSanPham(), 
                entity.getMaLoai(),
                entity.getMaNCC(),
                entity.getGiaMua(),
                entity.getGiaBan());

    }

    @Override
    public void update(SanPham entity) {
        String sql="UPDATE SanPham SET tenSanPham = ?, ngaySanXuat = ?, moTaSanPham = ?, maLoai = ?, maNCC = ?, giaMua = ?, giaBan = ? WHERE maSP = ?";
        XJdbc.update(sql, 
                entity.getTenSanPham(), 
                entity.getNgaySanXuat(), 
                entity.getMoTaSanPham(), 
                entity.getMaLoai(),
                entity.getMaNCC(),
                entity.getGiaMua(),
                entity.getGiaBan(),
                entity.getMaSP())
;
    }

    @Override
    public void delete(String maSP) {
        String sql="DELETE FROM SanPham WHERE maSP = ?";
        XJdbc.update(sql, maSP);
    }

    @Override
    public SanPham selectById(String maSP) {
        String sql="SELECT * FROM SanPham WHERE maSP = ?";
        List<SanPham> list = selectBySql(sql, maSP);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<SanPham> selectAll() {
        String sql="SELECT * FROM SanPham";
        return selectBySql(sql);
    }
       public List<SanPham> selectmanhinh() {
        String sql="SELECT * FROM SanPham where maloai = 'L003'";
        return selectBySql(sql);
    }
       public List<SanPham> selectlaptop() {
        String sql="SELECT * FROM SanPham where maloai = 'L001'";
        return selectBySql(sql);
    }
       public List<SanPham> selectcpu() {
        String sql="SELECT * FROM SanPham where maloai = 'L002'";
        return selectBySql(sql);
    }
           
            
    
    public List<SanPham> selectFromCuaHang() {
        String sql = "SELECT S.* FROM PhieuXuat P, CTPX C, SanPham S WHERE P.MaPhieuXuat = C.MaPhieuXuat AND S.MaSP = C.MaSP";
        return selectBySql(sql);
    }
    
    public List<SanPham> selectFromKho() {
        String sql = "SELECT S.* FROM PhieuXuat P, CTPX C, SanPham S WHERE P.MaPhieuXuat = C.MaPhieuXuat AND S.MaSP = C.MaSP";
        return selectBySql(sql);
    }

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    SanPham entity=new SanPham();
                    entity.setMaSP(rs.getString("maSP"));
                    entity.setTenSanPham(rs.getString("tenSanPham"));
                    entity.setNgaySanXuat(rs.getDate("ngaySanXuat"));
                    entity.setMoTaSanPham(rs.getString("moTaSanPham"));
                    entity.setMaLoai(rs.getString("maLoai"));
                    entity.setMaNCC(rs.getString("maNCC"));
                    entity.setGiaMua(rs.getDouble("giaMua"));
                    entity.setGiaBan(rs.getDouble("giaBan"));
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
