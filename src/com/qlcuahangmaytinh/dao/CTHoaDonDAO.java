/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.dao;

import com.qlcuahangmaytinh.entity.CTHoaDon;
import com.qlcuahangmaytinh.utils.XJdbc;

/**
 *
 * @author ADMIN
 */
public class CTHoaDonDAO {
    public void insert(CTHoaDon entity) {
        String sql="INSERT INTO CTDonHang (soluong, thanhtien,  thoigian, mahd, masp) VALUES (?, ?, ?, ?, ?)"
                ;
        XJdbc.update(sql, 
                entity.getSoLuong(), 
                entity.getThanhTien(), 
                entity.getThoiGian(), 
                entity.getMaHD(), 
                entity.getMaSP()
                
        );
    }
    
    
}
