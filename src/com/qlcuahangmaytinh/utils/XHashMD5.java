/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.utils;

import com.qlcuahangmaytinh.dao.NguoiDungDAO;
import com.qlcuahangmaytinh.entity.NguoiDung;
import java.security.MessageDigest;
import java.util.List;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Admin
 */
public class XHashMD5 {
    public void MD5HashingAll() {
        NguoiDungDAO dao = new NguoiDungDAO();
        try{
            List<NguoiDung> list = dao.selectAll();
            String password;
            for (NguoiDung nv : list) {
                password = nv.getMatKhau();
                if (password.length() == 32) {
                    continue;
                }
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                byte[] digest = md.digest();
                String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
                nv.setMatKhau(myHash);
                dao.update(nv);
            }
        }
        catch (NoSuchAlgorithmException e){
            MsgBox.alert(null, "Lỗi Hash!");
        }
    }
    public String MD5Hashing(String password) {
        String myHash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        }
        catch (NoSuchAlgorithmException e) {
            MsgBox.alert(null, "Lỗi Hash!");
        }
        return myHash;
    }
}
