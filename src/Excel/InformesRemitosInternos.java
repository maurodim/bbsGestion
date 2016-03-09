/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import interfaces.Transaccionable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Conecciones;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 *
 * @author mauro
 */
public class InformesRemitosInternos {
    public void GenerarInforme(String desde,String hasta) throws SQLException, FileNotFoundException, IOException{
              HSSFWorkbook libro=new HSSFWorkbook();
        HSSFSheet hoja=libro.createSheet("Resumen");
        
        /*
         * GENERAR LAS SIGUIENTES HOJAS
         * 1- DETALLE DE MOVIMIENTOS DE CAJA - LEE EN MOVIMIENTOS CAJA INDENTIFICANDO EL TIPO DE MOVIMIENTO, USUARIOS Y 
         * NUMERO DE CAJA
         * 2- DETALLE DE ARTICULOS VENDIDOS: LISTADO DE MOVIEMIENTOS DE ARTICULOS, CON USUARIOS Y CAJA
         * 3- DETALLE DE GASTOS : MOVIMIENTOS DE CAJA DETALLANDO LOS GASTOS
         * 
         */
        
        String ttx="celda numero :";
        HSSFRow fila=null;
        HSSFCell celda;
        HSSFCell celda1;
        HSSFCell celda2;
        HSSFCell celda3;
        HSSFCell celda4;
        HSSFCell celda5;
        HSSFCell celda6;
        HSSFCell celda7;
        HSSFCell celda8;
        HSSFFont fuente=libro.createFont();
        //fuente.setFontHeight((short)21);
        fuente.setFontName(fuente.FONT_ARIAL);
        fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        String form=null;
        String sql="SELECT *,(select depositos.descripcion from depositos where depositos.numero=movimientosdesucursales.depOrigen)as depor,(select depositos.descripcion from depositos where depositos.numero=movimientosdesucursales.depDestino)as depod,(select articulos.NOMBRE from articulos where articulos.ID=movimientosdesucursales.idArticulo)as descA,(select articulos.COSTO from articulos where articulos.ID=movimientosdesucursales.idArticulo)as costo  FROM movimientosdesucursales where fecha between '"+desde+"' and '"+hasta+"'";
        System.out.println(sql);
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        HSSFCellStyle titulo=libro.createCellStyle();
        titulo.setFont(fuente);
        //titulo.setFillBackgroundColor((short)22);
        titulo.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        titulo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //for(int a=0;a < 100;a++){
        int col=0;
        int a=0;
        Double total=0.00;
            if(a==0){
                fila=hoja.createRow(a);
            celda=fila.createCell(0);
            celda.setCellStyle(titulo);
            celda.setCellValue("Codigo");
            celda1=fila.createCell(1);
            celda1.setCellStyle(titulo);
            celda1.setCellValue("Articulo");
            celda2=fila.createCell(2);
            celda2.setCellStyle(titulo);
            celda2.setCellValue("Cantidad");
            celda3=fila.createCell(3);
            celda3.setCellStyle(titulo);
            celda3.setCellValue("Costo");
            celda4=fila.createCell(4);
            celda4.setCellStyle(titulo);
            celda4.setCellValue("Remito");
            celda5=fila.createCell(5);
            celda5.setCellStyle(titulo);
            celda5.setCellValue("Origen");
            celda6=fila.createCell(6);
            celda6.setCellStyle(titulo);
            celda6.setCellValue("Destino");
            celda7=fila.createCell(7);
            celda7.setCellStyle(titulo);
            celda7.setCellValue("Fecha");
            celda8=fila.createCell(8);
            celda8.setCellStyle(titulo);
            celda8.setCellValue("Total");
            }
            while(rs.next()){
            a++;
            //col=rs.getInt("tipoMovimiento");
            switch(col){
                case 1:
                    
                    break;
                default:
                    
                    break;
            }
            fila=hoja.createRow(a);
            celda=fila.createCell(0);
            ttx=ttx;
            total=0.00;
            celda.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda.setCellValue(rs.getString("idArticulo"));
            celda1=fila.createCell(1);
            ttx=ttx;
            celda1.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda1.setCellValue(rs.getString("descA"));
            celda2=fila.createCell(2);
            celda2.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda2.setCellValue(rs.getInt("cantidad"));
            celda3=fila.createCell(3);
            celda3.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda3.setCellValue(rs.getDouble("costo"));
            total=rs.getInt("cantidad") * rs.getDouble("costo");
            celda4=fila.createCell(4);
            celda4.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda4.setCellValue(rs.getInt("numeroRemito"));
            
           
            celda5=fila.createCell(5);
            //celda5.setCellFormula(rs.getString("observaciones"));
            celda5.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda5.setCellValue(rs.getString("depor"));
            //celda5.setCellValue(rs.getDate("fecha"));
            celda6=fila.createCell(6);
            celda6.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda6.setCellValue(rs.getString("depod"));
            celda7=fila.createCell(7);
            celda7.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda7.setCellValue(rs.getString("fecha"));
            celda8=fila.createCell(8);
            celda8.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda8.setCellValue(total);
        }
            
        rs.close();
        //texto+="\r\n";
        String ruta="C://Informes//informedeRemitosInternos.xls";
        try {
            FileOutputStream elFichero=new FileOutputStream(ruta);
            try {
                libro.write(elFichero);
                elFichero.close();
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ruta);
            } catch (IOException ex) {
                Logger.getLogger(InformesRemitosInternos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InformesRemitosInternos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
