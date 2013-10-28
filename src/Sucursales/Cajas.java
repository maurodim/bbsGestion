/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sucursales;

import interfaceGraficas.Inicio;
import interfaces.Transaccionable;
import interfacesPrograma.Cajeables;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Comprobantes;
import objetos.Conecciones;
import objetos.Operaciones;

/**
 *
 * @author mauro
 */
public class Cajas extends Sucursales implements Cajeables{
    private int numero;
    private int tipoMovimiento;
    private Double saldoInicial;
    private static Date fechaInicio;
    private int numeroDeComprobante;
    private int tipoDeComprobante;
    private Double montoMovimiento;
    private Comprobantes comprobante;
    private Double cambioEnCaja;
    private Double saldoFinal;
    private ArrayList listBilletes;
    private ArrayList listadoOperaciones;

    public ArrayList getListadoOperaciones() {
        return listadoOperaciones;
    }

    
    public ArrayList getListBilletes() {
        return listBilletes;
    }

    public void setListBilletes(ArrayList listBilletes) {
        this.listBilletes = listBilletes;
    }

    public Double getCambioEnCaja() {
        return cambioEnCaja;
    }

    public void setCambioEnCaja(Double cambioEnCaja) {
        this.cambioEnCaja = cambioEnCaja;
    }

    public Double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }
    

    public Comprobantes getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobantes comprobante) {
        this.comprobante = comprobante;
    }

    public Cajas(int tipoMovimiento, int numeroDeComprobante, int tipoDeComprobante, Double montoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
        this.numeroDeComprobante = numeroDeComprobante;
        this.tipoDeComprobante = tipoDeComprobante;
        this.montoMovimiento = montoMovimiento;
        Billetes.cargarLista();
        this.listBilletes=Billetes.getListadoBill();
        Operaciones.cargarArrayCaja();
        this.listadoOperaciones=Operaciones.getListadoOp();
    }

    public Cajas() {
        Billetes.cargarLista();
        this.listBilletes=Billetes.getListadoBill();
        Operaciones.cargarArrayCaja();
        this.listadoOperaciones=Operaciones.getListadoOp();
    }

    public Cajas(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public static Date getFechaInicio() {
        return fechaInicio;
    }

    public static void setFechaInicio(Date fechaInicio) {
        Cajas.fechaInicio = fechaInicio;
    }

    public int getNumeroDeComprobante() {
        return numeroDeComprobante;
    }

    public void setNumeroDeComprobante(int numeroDeComprobante) {
        this.numeroDeComprobante = numeroDeComprobante;
    }

    public int getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    public void setTipoDeComprobante(int tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }

    public Double getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(Double montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    @Override
    public Object AbrirCaja(Object caja) {
        Cajas cajaNueva=(Cajas) caja;
        String sql="insert into caja (numeroSucursal,numeroUsuario,tipoMovimiento,saldoInicial) values ("+Inicio.sucursal.getNumero()+","+Inicio.usuario.getNumero()+",8,"+cajaNueva.saldoInicial+")";
        Transaccionable tra=new Conecciones();
        tra.guardarRegistro(sql);
        sql="select LAST_INSERT_ID()";
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                cajaNueva.numero=rs.getInt(1);
                System.out.println("ID CAJA "+cajaNueva.numero);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cajas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cajaNueva;
    }

    @Override
    public Boolean CerrarCaja(Object caja) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Double SaldoDeCaja(ArrayList listadoBilletes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean NuevoMovimiento(Object factura) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object ModificarMovimiento(Integer idMovimiento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean EliminarMovimiento(Integer idMovimiento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object ArquearCaja(Object caja) {
        Cajas cajas=(Cajas)caja;
        Double saldoFinal=cajas.saldoInicial;
        String sql="select movimientoscaja.monto from movimientoscaja where idCaja="+cajas.numero;
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                saldoFinal= saldoFinal + rs.getDouble("monto");
                
            }
            rs.close();
            cajas.saldoFinal=saldoFinal;
        } catch (SQLException ex) {
            Logger.getLogger(Cajas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cajas;
    }

    @Override
    public Boolean VerificarCaja(int numeroDeUsuario, int numeroDeSucursal, String fecha) {
        Boolean verifi=false;
        String sql="select * from caja where numeroUsuario ="+numeroDeUsuario+" and numeroSucursal="+numeroDeSucursal+" and fecha like '"+fecha+"%'";
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
            verifi=true;
                
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cajas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return verifi;
    }

    @Override
    public Object CargarCaja(int numeroDeUsuario, int numeroDeSucursal, String fecha) {
        Cajas cajas=new Cajas();
        String sql="select * from caja where numeroUsuario ="+numeroDeUsuario+" and numeroSucursal="+numeroDeSucursal+" and fecha like '"+fecha+"%'";
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                cajas.numero=rs.getInt("numero");
                cajas.saldoInicial=rs.getDouble("saldoInicial");
                
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cajas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cajas;
    }
    
    
}
