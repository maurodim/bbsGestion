/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Depositos;

import interfaces.Comprobable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mauro
 */
public class RemitosInternos implements Comprobable{
    private Integer numero;
    private Integer id;
    private Integer idUusuario;
    private Date fecha;
    private String numeroDeFactura;
    private Integer depositoDestino;
    private Integer depositoOrigen;
    private ArrayList articulos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getIdUusuario() {
        return idUusuario;
    }

    public void setIdUusuario(Integer idUusuario) {
        this.idUusuario = idUusuario;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumeroDeFactura() {
        return numeroDeFactura;
    }

    public void setNumeroDeFactura(String numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }

    public Integer getDepositoDestino() {
        return depositoDestino;
    }

    public void setDepositoDestino(Integer depositoDestino) {
        this.depositoDestino = depositoDestino;
    }

    public Integer getDepositoOrigen() {
        return depositoOrigen;
    }

    public void setDepositoOrigen(Integer depositoOrigen) {
        this.depositoOrigen = depositoOrigen;
    }

    public ArrayList getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList articulos) {
        this.articulos = articulos;
    }

    public RemitosInternos() {
    }

    public RemitosInternos(Integer numero, Integer numeroProveedor) {
        this.numero = numero;
        this.idUusuario = numeroProveedor;
    }

    public RemitosInternos(Integer id) {
        this.id = id;
    }

    @Override
    public Integer nuevoComprobante(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
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
