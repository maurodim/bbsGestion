/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauro
 */
public class Usuarios {
    private int numero;
    private String nombre;
    private String direccion;
    private String telefono;
    private String mail;
    private String localidad;
    private String nombreDeUsuario;
    private String clave;
    private int nivelDeAutorizacion;

    public Usuarios(int numero) {
        this.numero = numero;
    }

    public Usuarios(String nombreDeUsuario, String clave) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.clave = clave;
    }

    public Usuarios() {
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

    public void setNivelDeAutorizacion(int nivelDeAutorizacion) {
        this.nivelDeAutorizacion = nivelDeAutorizacion;
    }
    public ArrayList listarUsuario(){
        ArrayList listadoUsuarios=new ArrayList();
        try {
            
            String sql="select * from usuarios";
            Usuarios us=null;
            Transaccionable traUs=(Transaccionable) new Usuarios();
            ResultSet rr=traUs.leerConjuntoDeRegistros(sql);
            while(rr.next()){
                us=new Usuarios();
                us.nombre=rr.getString("nombre");
                us.direccion=rr.getString("direccion");
                us.localidad=rr.getString("localidad");
                us.mail=rr.getString("mail");
                us.numero=rr.getInt("numero");
                us.telefono=rr.getString("telefono");
                us.nombreDeUsuario=rr.getString("nombreDeUsuario");
                us.clave=rr.getString("clave");
                us.nivelDeAutorizacion=rr.getInt("nivelAutorizacion");
                listadoUsuarios.add(us);
                
            }
            rr.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoUsuarios;
    }
    
}
