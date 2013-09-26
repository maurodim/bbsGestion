/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import interfacesPrograma.Facturar;
import java.util.ArrayList;

/**
 *
 * @author mauro
 */
public class Articulos implements Facturar{
    private String codigoDeBarra;
    private String codigoAsignado;
    private Integer rubro;
    private Integer numeroId;
    private String descripcionArticulo;
    private Double cantidad;
    private Double precioUnitario;
    private Double precioIva;
    private Double precioUnitarioNeto;

    public Articulos() {
    }

    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }

    public String getCodigoAsignado() {
        return codigoAsignado;
    }

    public void setCodigoAsignado(String codigoAsignado) {
        this.codigoAsignado = codigoAsignado;
    }

    public Integer getRubro() {
        return rubro;
    }

    public void setRubro(Integer rubro) {
        this.rubro = rubro;
    }

    public Integer getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(Integer numeroId) {
        this.numeroId = numeroId;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioIva() {
        return precioIva;
    }

    public void setPrecioIva(Double precioIva) {
        this.precioIva = precioIva;
    }

    public Double getPrecioUnitarioNeto() {
        return precioUnitarioNeto;
    }

    public void setPrecioUnitarioNeto(Double precioUnitarioNeto) {
        this.precioUnitarioNeto = precioUnitarioNeto;
    }
    

    @Override
    public Boolean guardar(Object oob) {
        throw new UnsupportedOperationException("Not supported yet.");
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
    
    
}
