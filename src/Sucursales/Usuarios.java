/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sucursales;

import Administracion.TipoAcceso;
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
public class Usuarios extends TipoAcceso{
    private int numeroId;
    private String nombre;
    private String direccion;
    private String telefono;
    private String mail;
    private String localidad;
    private String nombreDeUsuario;
    private String clave;
    private int nivelDeAutorizacion;

    public Usuarios(int numero) {
        this.numeroId = numero;
    }

    public Usuarios(String nombreDeUsuario, String clave) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.clave = clave;
        super.setNivel(1);
    }

    public Usuarios() {
       
    }

    public int getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(int numero) {
        this.numeroId = numero;
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

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getNivelDeAutorizacion() {
        return nivelDeAutorizacion;
    }

    public void setNivelDeAutorizacion() {
        this.nivelDeAutorizacion = super.getNivel();
    }
    public ArrayList listarUsuario(){
        ArrayList listadoUsuarios=new ArrayList();
        try {
            
            String sql="select * from usuarios";
            Usuarios us=null;
            Transaccionable traUs=new Conecciones();
            ResultSet rr=traUs.leerConjuntoDeRegistros(sql);
            while(rr.next()){
                us=new Usuarios();
                us.nombre=rr.getString("nombre");
                us.direccion=rr.getString("direccion");
                us.localidad=rr.getString("localidad");
                us.mail=rr.getString("mail");
                us.numeroId=rr.getInt("numero");
                us.telefono=rr.getString("telefono");
                us.nombreDeUsuario=rr.getString("nombreUsuario");
                us.clave=rr.getString("clave");
                us.setNivel(rr.getInt("autorizacion"));
                us.setNivelDeAutorizacion();
                System.err.println("USUARIOS "+us.nombre);
                listadoUsuarios.add(us);
                
            }
            rr.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoUsuarios;
    }

    @Override
    public Boolean registrarIngreso(Object objeto) {
        return super.registrarIngreso(objeto);
    }

    @Override
    public Boolean registrarSalida(Object objeto) {
        return super.registrarSalida(objeto);
    }

    @Override
    public Object validarClave(String usuario, String clave) {
        return super.validarClave(usuario, clave);
    }

    @Override
    public Boolean modificarDatosUsuario(Object objeto) {
        return super.modificarDatosUsuario(objeto);
    }

    @Override
    public Boolean nuevoUsuario(Object objeto) {
        return super.nuevoUsuario(objeto);
    }

    @Override
    public ArrayList listarUsuarios() {
        return super.listarUsuarios();
    }

    @Override
    public Object cargarUsuario(Integer numeroUsuario) {
        return super.cargarUsuario(numeroUsuario);
    }
    
}
