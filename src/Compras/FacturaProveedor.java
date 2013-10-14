/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import Administracion.TipoComprobante;
import interfaces.Comprobable;
import interfaces.Transaccionable;
import interfacesPrograma.Facturar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Conecciones;

/**
 *
 * @author mauro
 */
public class FacturaProveedor implements Comprobable,Facturar{
    private Integer id;
    private String numeroFactura;
    private Integer numeroProveedor;
    private String nombreProveedor;
    private Double montoFinal;
    private Integer idRemito;
    private Integer idCaja;
    private Date fecha;
    private Integer pagada;
    private Integer idUsuario;

    public Integer getPagada() {
        return pagada;
    }

    public void setPagada(Integer pagada) {
        this.pagada = pagada;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    public FacturaProveedor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumero(String numero) {
        this.numeroFactura = numero;
    }

    public Integer getNumeroProveedor() {
        return numeroProveedor;
    }

    public void setNumeroProveedor(Integer numeroProveedor) {
        this.numeroProveedor = numeroProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(Double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public Integer getIdRemito() {
        return idRemito;
    }

    public void setIdRemito(Integer idRemito) {
        this.idRemito = idRemito;
    }

    public Integer getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(Integer idCaja) {
        this.idCaja = idCaja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    

    public void setPagada(int pagada) {
        this.pagada = pagada;
    }

    @Override
    public Integer nuevoComprobante(Object objeto) {
        FacturaProveedor fact=(FacturaProveedor)objeto;
        Integer idFactura=0;
        String sql="insert into movimientosproveedores (numeroProveedor,monto,numeroComprobante,idRemito,idUsuario,tipoComprobante) values ("+fact.getNumeroProveedor()+","+fact.getMontoFinal()+",'"+fact.getNumeroFactura()+"',"+fact.getIdRemito()+","+fact.getIdUsuario()+",5)";
        Transaccionable tra=new Conecciones();
        if(tra.guardarRegistro(sql)){
            sql="select LAST_INSERT_ID()";
            ResultSet rs=tra.leerConjuntoDeRegistros(sql);
            try {
                while(rs.next()){
                    idFactura=rs.getInt(1);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(FacturaProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return idFactura;
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

    @Override
    public Boolean guardar(Object oob) {
        Boolean verif=false;
        FacturaProveedor fact=(FacturaProveedor)oob;
        // ACA VOY A GUARDAR EN MOVIEMINTOS DE CAJA Y MODIFICAR EN MOVIMIENTOS DE PROVEEDORES
        
        
        return verif;
    }

    @Override
    public Boolean modificar(Object oob) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean nuevo(Object oob) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object leer(Object oob) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void imprimirComprobante(int tipoComprobante, Object oob) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList listadoBusqueda(String criterio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean guardarNuevoCliente(Object cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean modificarDatosDelCliente(Object cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList listarClientes(String nombre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object cargarPorCodigoDeBarra(String codigoDeBarra) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
