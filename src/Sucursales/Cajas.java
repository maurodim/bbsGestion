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
    private static ArrayList listBilletes=new ArrayList();
    private static ArrayList listadoOperaciones=new ArrayList();
    private static ArrayList listOperaciones=new ArrayList();
    private static ArrayList listadoCajas=new ArrayList();
    private String descripcionMovimiento;
   

    public String getDescripcionMovimiento() {
        return descripcionMovimiento;
    }

    public void setDescripcionMovimiento(String descripcionMovimiento) {
        this.descripcionMovimiento = descripcionMovimiento;
    }
    

    public static ArrayList getListadoCajas() {
        return listadoCajas;
    }

    
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
       if(listBilletes.size()==0){
            Billetes.cargarLista();
            listBilletes=Billetes.getListadoBill();
        }
        if(listadoOperaciones.size()==0){
        Operaciones.cargarArrayCaja();
        listadoOperaciones=Operaciones.getListadoOp();
        }
        if(listOperaciones.size()==0){
        Operaciones.cargarArray();
        listOperaciones=Operaciones.getListOp();
        }    }

    public Cajas() {

        //Billetes.cargarLista();
        if(listBilletes.size()==0){
            Billetes.cargarLista();
            listBilletes=Billetes.getListadoBill();
        }
        if(listadoOperaciones.size()==0){
        Operaciones.cargarArrayCaja();
        listadoOperaciones=Operaciones.getListadoOp();
        }
        if(listOperaciones.size()==0){
        Operaciones.cargarArray();
        listOperaciones=Operaciones.getListOp();
        }
        this.cambioEnCaja=0.00;
        this.numeroDeComprobante=0;
        this.tipoDeComprobante=0;
        this.tipoMovimiento=0;
    }

    public Cajas(int numero) {

        this.numero = numero;
       if(listBilletes.size()==0){
            Billetes.cargarLista();
            listBilletes=Billetes.getListadoBill();
        }
        if(listadoOperaciones.size()==0){
        Operaciones.cargarArrayCaja();
        listadoOperaciones=Operaciones.getListadoOp();
        }
        if(listOperaciones.size()==0){
        Operaciones.cargarArray();
        listOperaciones=Operaciones.getListOp();
        }
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
        if(listadoCajas.size() > 0)listadoCajas.clear();
        //listadoCajas.clear();
        Cajas cajaNueva=(Cajas) caja;
        String sql="insert into caja (numeroSucursal,numeroUsuario,tipoMovimiento,saldoInicial) values ("+Inicio.sucursal.getNumero()+","+Inicio.usuario.getNumero()+",9,"+cajaNueva.saldoInicial+")";
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
            sql="insert into movimientoscaja (numeroUsuario,numeroSucursal,monto,tipoMovimiento,idCaja) values ("+Inicio.usuario.getNumeroId()+","+Inicio.sucursal.getNumero()+","+cajaNueva.getSaldoInicial()+",9,"+cajaNueva.getNumero()+")";
            tra.guardarRegistro(sql);
            int pos=cajaNueva.getTipoMovimiento() -1;
            Operaciones operacion=(Operaciones)listOperaciones.get(pos);
            String desc=operacion.getDescripcion();
            cajaNueva.setDescripcionMovimiento(desc);
        } catch (SQLException ex) {
            Logger.getLogger(Cajas.class.getName()).log(Level.SEVERE, null, ex);
        }
        listadoCajas.add(cajaNueva);
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
        Cajas caj=(Cajas)factura;
        Boolean ch=false;
        listadoCajas.add(caj);
        System.err.println(Inicio.usuario.getNumeroId()+","+Inicio.sucursal.getNumero()+","+caj.getNumeroDeComprobante()+","+caj.getTipoDeComprobante()+","+caj.getMontoMovimiento()+","+caj.getTipoMovimiento()+","+caj.getNumero()+",0,");
        String sql="insert into movimientoscaja (numeroUsuario,numeroSucursal,numeroComprobante,tipoComprobante,monto,tipoMovimiento,idCaja,idCliente,tipoCliente,pagado) values ("+Inicio.usuario.getNumeroId()+","+Inicio.sucursal.getNumero()+","+caj.getNumeroDeComprobante()+","+caj.getTipoDeComprobante()+","+caj.getMontoMovimiento()+","+caj.getTipoMovimiento()+","+caj.getNumero()+",0,0,1)";
        Transaccionable tra=new Conecciones();
        ch=tra.guardarRegistro(sql);
        
        return ch;
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
        if(listadoCajas.size() > 0)listadoCajas.clear();
        Cajas cajas=(Cajas)caja;
        Cajas cajass=null;
        Double saldoFinal=cajas.saldoInicial;
        String sql="select * from movimientoscaja where idCaja="+cajas.numero;
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                cajass=new Cajas();
                cajass.setNumero(rs.getInt("numero"));
                cajass.setNumeroDeComprobante(rs.getInt("numeroComprobante"));
                cajass.setTipoMovimiento(rs.getInt("tipoMovimiento"));
                cajass.setMontoMovimiento(rs.getDouble("monto"));
                saldoFinal= saldoFinal + rs.getDouble("monto");
                int pos=cajass.getTipoMovimiento() -1;
                Operaciones operacion=(Operaciones)listOperaciones.get(pos);
                 String desc=operacion.getDescripcion();
                cajass.setDescripcionMovimiento(desc);
                listadoCajas.add(cajass);
                
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

    @Override
    public Object NuevoGasto(Object factura) {
       Cajas caj=(Cajas)factura;
        //Boolean ch=false;
        listadoCajas.add(caj);
        Double monto=caj.getMontoMovimiento() * (-1);
        String sql="insert into movimientoscaja (numeroUsuario,numeroSucursal,numeroComprobante,tipoComprobante,monto,tipoMovimiento,idCaja,idCliente,tipoCliente,pagado,observaciones) values ("+Inicio.usuario.getNumeroId()+","+Inicio.sucursal.getNumero()+","+caj.getNumeroDeComprobante()+","+caj.getTipoDeComprobante()+","+monto+","+caj.getTipoMovimiento()+","+caj.getNumero()+",0,2,0,'"+caj.getDescripcionMovimiento()+"')";
        Transaccionable tra=new Conecciones();
        tra.guardarRegistro(sql);
        
        return caj;
    }
    
    
}
