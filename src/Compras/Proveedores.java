/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import interfaces.Personalizable;
import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Conecciones;

/**
 *
 * @author mauro
 */
public class Proveedores implements Personalizable{
    private int numero;
    private String nombre;
    private String direccion;
    private String telefono;
    private String mail;
    private String localidad;
    private int condicionDeIva;
    private String numeroDeCuit;
    private int condicionIngresosBrutos;
    private String numeroIngresosBrutos;

    public Proveedores(int numero) {
        this.numero = numero;
    }

    public Proveedores() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCondicionDeIva() {
        return condicionDeIva;
    }

    public void setCondicionDeIva(int condicionDeIva) {
        this.condicionDeIva = condicionDeIva;
    }

    public String getNumeroDeCuit() {
        return numeroDeCuit;
    }

    public void setNumeroDeCuit(String numeroDeCuit) {
        this.numeroDeCuit = numeroDeCuit;
    }

    public int getCondicionIngresosBrutos() {
        return condicionIngresosBrutos;
    }

    public void setCondicionIngresosBrutos(int condicionIngresosBrutos) {
        this.condicionIngresosBrutos = condicionIngresosBrutos;
    }

    public String getNumeroIngresosBrutos() {
        return numeroIngresosBrutos;
    }

    public void setNumeroIngresosBrutos(String numeroIngresosBrutos) {
        this.numeroIngresosBrutos = numeroIngresosBrutos;
    }

    @Override
    public Boolean agregar(Object objeto) {
       Proveedores prov=(Proveedores)objeto;
       Boolean veri=false;
       String sql="insert into proveedores (nombre,direccion,localidad,telefono,mail,condicionIva,numeroCuit,condicionIb,numeroIb) values ('"+prov.getNombre()+"','"+prov.getDireccion()+"','"+prov.getLocalidad()+"','"+prov.getTelefono()+"','"+prov.getMail()+"',"+prov.getCondicionDeIva()+",'"+prov.getNumeroDeCuit()+"',"+prov.getCondicionIngresosBrutos()+",'"+prov.getNumeroIngresosBrutos()+")";
       Transaccionable tra=new Conecciones();
       if(tra.guardarRegistro(sql)){}else{
           veri=false;
       }
       
       
       return veri;
    }

    @Override
    public Boolean modificar(Object objeto) {
       Boolean veri=false;
       Proveedores prov=(Proveedores)objeto;
       String sql="update proveedores set nombre='"+prov.getNombre()+"',direccion='"+prov.getDireccion()+"',localidad='"+prov.getLocalidad()+"',telefono='"+prov.getTelefono()+"',mail='"+prov.getMail()+"',condicionIva="+prov.getCondicionDeIva()+",numeroCuit='"+prov.getNumeroDeCuit()+"',condicionIb="+prov.getCondicionIngresosBrutos()+",numeroIb='"+prov.getNumeroIngresosBrutos()+"' where numero="+prov.getNumero();
       Transaccionable tra=new Conecciones();
       if(tra.guardarRegistro(sql)){}else{
           veri=false;
       }
       
       return veri;
    }

    @Override
    public Boolean eliminar(Object objeto) {
        Boolean veri=false;
        Proveedores prov=(Proveedores)objeto;
        String sql="delete from proveedores where numero="+prov.getNumero();
        Transaccionable tra=new Conecciones();
        if(tra.guardarRegistro(sql)){}else{
            veri=false;
        }
        
        return veri;
    }

    @Override
    public Object buscarPorNumero(Integer id) {
        Proveedores prov=new Proveedores();
        try {
            String sql="select * from proveedores where numero="+id+" and INHABILITADO=0";
            Transaccionable tra=new Conecciones();
            ResultSet rr=tra.leerConjuntoDeRegistros(sql);
            while(rr.next()){
                prov.setNumero(rr.getInt("ID"));
                prov.setNombre(rr.getString("nombre"));
                prov.setDireccion(rr.getString("DOMICILIO"));
                prov.setLocalidad(rr.getString("LOCALIDAD"));
                prov.setMail(rr.getString("mail"));
                prov.setTelefono(rr.getString("TELEFONO"));
                //prov.setCondicionDeIva(rr.getInt("condicionIva"));
                //prov.setNumeroDeCuit(rr.getString("numeroCuit"));
                //prov.setCondicionIngresosBrutos(rr.getInt("condicionIb"));
                //prov.setNumeroIngresosBrutos(rr.getString("numeroIb"));
            }
            rr.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prov;
    }

    @Override
    public Object buscarPorNombre(String nombre) {
        Proveedores prov=new Proveedores();
        try {
            String sql="select * from proveedores where nombre like '%"+nombre+"%' order by nombre";
            Transaccionable tra=new Conecciones();
            ResultSet rr=tra.leerConjuntoDeRegistros(sql);
            while(rr.next()){
                prov.setNumero(rr.getInt("numero"));
                prov.setNombre(rr.getString("nombre"));
                prov.setDireccion(rr.getString("direccion"));
                prov.setLocalidad(rr.getString("localidad"));
                prov.setMail(rr.getString("mail"));
                prov.setTelefono(rr.getString("telefono"));
                prov.setCondicionDeIva(rr.getInt("condicionIva"));
                prov.setNumeroDeCuit(rr.getString("numeroCuit"));
                prov.setCondicionIngresosBrutos(rr.getInt("condicionIb"));
                prov.setNumeroIngresosBrutos(rr.getString("numeroIb"));
            }
            rr.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prov;
    }

    @Override
    public Object buscarPorCuit(String cuit) {
        Proveedores prov=new Proveedores();
        try {
            String sql="select * from proveedores where cuit like '"+cuit+"%'";
            Transaccionable tra=new Conecciones();
            ResultSet rr=tra.leerConjuntoDeRegistros(sql);
            while(rr.next()){
                prov.setNumero(rr.getInt("numero"));
                prov.setNombre(rr.getString("nombre"));
                prov.setDireccion(rr.getString("direccion"));
                prov.setLocalidad(rr.getString("localidad"));
                prov.setMail(rr.getString("mail"));
                prov.setTelefono(rr.getString("telefono"));
                prov.setCondicionDeIva(rr.getInt("condicionIva"));
                prov.setNumeroDeCuit(rr.getString("numeroCuit"));
                prov.setCondicionIngresosBrutos(rr.getInt("condicionIb"));
                prov.setNumeroIngresosBrutos(rr.getString("numeroIb"));
            }
            rr.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prov;
    }

    @Override
    public ArrayList listar() {
        ArrayList listado=new ArrayList();
        try {
            String sql="select * from proveedores order by nombre";
            Transaccionable tra=new Conecciones();
            ResultSet rr=tra.leerConjuntoDeRegistros(sql);
            while(rr.next()){
                Proveedores prov=new Proveedores();
                prov.setNumero(rr.getInt("numero"));
                prov.setNombre(rr.getString("nombre"));
                prov.setDireccion(rr.getString("DOMICILIO"));
                prov.setLocalidad(rr.getString("LOCALIDAD"));
                //prov.setMail(rr.getString("mail"));
                prov.setTelefono(rr.getString("TELEFONO"));
                //prov.setCondicionDeIva(rr.getInt("condicionIva"));
                //prov.setNumeroDeCuit(rr.getString("numeroCuit"));
                //prov.setCondicionIngresosBrutos(rr.getInt("condicionIb"));
                //prov.setNumeroIngresosBrutos(rr.getString("numeroIb"));
                listado.add(prov);
            }
            rr.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }

    @Override
    public ArrayList listarPorNombre(String nombre) {
        ArrayList listado=new ArrayList();
        try {
            String sql="select * from proveedores where nombre like '%"+nombre+"%' order by nombre";
            Transaccionable tra=new Conecciones();
            ResultSet rr=tra.leerConjuntoDeRegistros(sql);
            while(rr.next()){
                Proveedores prov=new Proveedores();
                prov.setNumero(rr.getInt("numero"));
                prov.setNombre(rr.getString("nombre"));
                prov.setDireccion(rr.getString("direccion"));
                prov.setLocalidad(rr.getString("localidad"));
                prov.setMail(rr.getString("mail"));
                prov.setTelefono(rr.getString("telefono"));
                prov.setCondicionDeIva(rr.getInt("condicionIva"));
                prov.setNumeroDeCuit(rr.getString("numeroCuit"));
                prov.setCondicionIngresosBrutos(rr.getInt("condicionIb"));
                prov.setNumeroIngresosBrutos(rr.getString("numeroIb"));
                listado.add(prov);
            }
            rr.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }

    @Override
    public ArrayList listarPorCuit(String cuit) {
        ArrayList listado=new ArrayList();
        try {
            String sql="select * from proveedores where cuit like '"+cuit+"%' order by nombre";
            Transaccionable tra=new Conecciones();
            ResultSet rr=tra.leerConjuntoDeRegistros(sql);
            while(rr.next()){
                Proveedores prov=new Proveedores();
                prov.setNumero(rr.getInt("numero"));
                prov.setNombre(rr.getString("nombre"));
                prov.setDireccion(rr.getString("direccion"));
                prov.setLocalidad(rr.getString("localidad"));
                prov.setMail(rr.getString("mail"));
                prov.setTelefono(rr.getString("telefono"));
                prov.setCondicionDeIva(rr.getInt("condicionIva"));
                prov.setNumeroDeCuit(rr.getString("numeroCuit"));
                prov.setCondicionIngresosBrutos(rr.getInt("condicionIb"));
                prov.setNumeroIngresosBrutos(rr.getString("numeroIb"));
                listado.add(prov);
            }
            rr.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }
    
    
}
