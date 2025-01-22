/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.HoaDon;
import com.qlcuahangmaytinh.entity.GioHang;
import com.qlcuahangmaytinh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GioHangDAO {

    public List<GioHang> selectBySql(String sql, Object... args) {
        List<GioHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    GioHang entity = new GioHang();
                    entity.setMaHD(rs.getString("maHD"));
                    entity.setTrangThai(rs.getNString("trangThai"));
                    entity.setHoTen(rs.getNString("hoTen"));
                    entity.setThoiGian(rs.getDate("thoiGian"));
                    entity.setTenSanPham(rs.getString("tenSanPham"));
                    entity.setSoLuong(rs.getInt("soLuong"));
                    entity.setThanhTien(rs.getDouble("thanhTien"));
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
//    public List<HoaDonCT> selectAll(){
//        String sql="SELECT CTDH.MAHD, HD.TRANGTHAI, KH.HOTEN, CTDH.THOIGIAN, SP.TENSANPHAM, CTDH.THANHTIEN, CTDH.SOLUONG\n" +
//"FROM KHACHHANG KH INNER JOIN HOADON HD on KH.MAKH = HD.MAKH\n" +
//"inner join CTDONHANG CTDH ON CTDH.MAHD = HD.MAHD\n" +
//"inner join SANPHAM sp on CTDH.MASP = SP.MASP";
//        return selectBySql(sql);
//    }
  
    
    public List<GioHang> selectByKeyword(String keyword) {
        String sql = "SELECT CTDH.MAHD,HD.TRANGTHAI, KH.HOTEN, CTDH.THOIGIAN, SP.TENSANPHAM,CTDH.SOLUONG, CTDH.THANHTIEN\n"
                + "FROM KHACHHANG KH INNER JOIN HOADON HD on KH.MAKH = HD.MAKH\n"
                + "inner join CTDONHANG CTDH ON CTDH.MAHD = HD.MAHD\n"
                + "inner join SANPHAM sp on CTDH.MASP = SP.MASP\n"
                + "WHERE KH.MAKH like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
    
    public List<GioHang> selectAll() {
        String sql = "SELECT CTDH.MAHD,HD.TRANGTHAI, KH.HOTEN, CTDH.THOIGIAN, SP.TENSANPHAM,CTDH.SOLUONG, CTDH.THANHTIEN\n" +
                    "FROM KHACHHANG KH INNER JOIN HOADON HD on KH.MAKH = HD.MAKH\n" +
                    "inner join CTDONHANG CTDH ON CTDH.MAHD = HD.MAHD\n" +
                    "inner join SANPHAM sp on CTDH.MASP = SP.MASP";
        return this.selectBySql(sql);
    }
    
}
