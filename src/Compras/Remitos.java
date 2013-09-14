/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import interfaces.Comprobable;
import interfaces.Transaccionable;
import java.util.ArrayList;
import java.util.Date;
import objetos.Conecciones;

/**
 *
 * @author mauro
 */
public class Remitos implements Comprobable{
    private Integer numeroId;
    private Integer idProveedor;
    private Date fechaComprobante;
    private Date fechaRecepcion;
    private ArrayList articulos;
    private String numeroRemito;
    private Integer numeroDeposito;

    public Integer getNumeroDeposito() {
        return numeroDeposito;
    }

    public void setNumeroDeposito(Integer numeroDeposito) {
        this.numeroDeposito = numeroDeposito;
    }
    

    public Remitos() {
    }

    public Integer getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(Integer numeroId) {
        this.numeroId = numeroId;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Date getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(Date fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public ArrayList getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList articulos) {
        this.articulos = articulos;
    }

    public String getNumeroRemito() {
        return numeroRemito;
    }

    public void setNumeroRemito(String numeroRemito) {
        this.numeroRemito = numeroRemito;
    }

    @Override
    public Boolean nuevoComprobante(Object objeto) {
        //String sql="CREATE TABLE IF NOT EXISTS `movimientos25` (`numero` int(11) NOT NULL AUTO_INCREMENT,`numeroArticulo` int(11) NOT NULL,`cantidad` int(11) NOT NULL,`condicion` int(11) NOT NULL DEFAULT '0',`numeroUsuario` int(11) NOT NULL,`fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,PRIMARY KEY (`numero`)) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5";
        //String sql="insert into clientes (nombre, direccion, localidad, telefono, mail, condIva, numeroCuit) VALUES (mauro, piedras 6738, santa fe, 155451500, contacto@maurodi.com.ar, 1, 0000000000)";
        String sql="";
        Boolean veri=false;
        Transaccionable tra=new Conecciones();
        if(tra.guardarRegistro(sql))veri=true;
        
        return veri;
    }

    @Override
    public Boolean agregarItem(Object item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean modificarComprobante(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean eliminarComprobante(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object leerComprobante(Integer numero) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList listarComprobantesPorFecha(Date fecha) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList listarComprobantesPorDeposito(Integer numeroDeposito) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList listarComprobantesPorProveedor(Integer numeroProveedor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
