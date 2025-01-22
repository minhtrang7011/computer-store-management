/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlcuahangmaytinh.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import javax.swing.JFileChooser;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Admin
 */
public class XExcel {
    private JTable table;
    private String sheetName;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }
    
    

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
    
    public void openFile(String file) throws IOException{
        File path = new File(file);
        Desktop.getDesktop().open(path);
    }
    
//    public void openXuatExcel() {
//        String path;
//        try {
//            JFileChooser fc = new JFileChooser();
//            fc.showOpenDialog(null);
//            path = fc.getSelectedFile().getPath();
//            
////        writeToExcel(table, path);
//            
//        } catch (Exception ex) {
//            MsgBox.alert(null, "Bạn đã hủy chọn");
//        }
//    }
    
    public void writeToExcel() throws FileNotFoundException, IOException {
        try{
//            JFileChooser jFileChooser = new JFileChooser();
//            jFileChooser.showSaveDialog(null);
//            File test = jFileChooser.getSelectedFile();
//            System.out.println(test.toString());
            File saveFile;
            Workbook wb;
            Sheet sheet;
             
            SimpleDateFormat formater = new SimpleDateFormat("yyyymmdd-hhmmss");
            String date = formater.format(new Date());
            
            //auto name
            saveFile = new File(System.getProperty("user.home") +"/Desktop/BangThuChi - "+ date +".xlsx");
            wb = new XSSFWorkbook();
            //auto change name sheet
            sheet = wb.createSheet(sheetName);

           Row rowCol = sheet.createRow(0);
           for(int i=0;i<table.getColumnCount();i++){
               Cell cell = rowCol.createCell(i);
               cell.setCellValue(table.getColumnName(i));
           }

           for(int j=0;j<table.getRowCount();j++){
               Row row = sheet.createRow(j+1);
               for(int k=0;k<table.getColumnCount();k++){
                   Cell cell = row.createCell(k);
                   if(table.getValueAt(j, k)!=null){
                       cell.setCellValue(table.getValueAt(j, k).toString());
                   }
               }
           }
            try (FileOutputStream out = new FileOutputStream(new File(saveFile.toString()))) {
                wb.write(out);
                wb.close();
            }
           
           MsgBox.alert(null, "Xuất file thành công!");
           
           openFile(saveFile.toString());
       }catch(FileNotFoundException e){
           System.out.println(e);
       }catch(IOException io){
           System.out.println(io);
       }
    }
}
