/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Depositos;

import Compras.Proveedores;
import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Conecciones;

/**
 *
 * @author mauro
 */
public class Depositos {
    private int numero;
    private String descripcion;
    private String telefono;
    private String direccion;
    private Proveedores proveedores;

    public Depositos() {
    }

    public Depositos(int numero) {
        this.numero = numero;
        Transaccionable tra=new Conecciones();
        String sql1="select * from depositos where numero ="+numero;
        ResultSet rr=tra.leerConjuntoDeRegistros(sql1);
        try {
            while(rr.next()){
                this.descripcion=rr.getString("descripcion");
                this.direccion=rr.getString("direccion");
                this.telefono=rr.getString("telefono");
                
            }
            rr.close();
        } catch (SQLException ex) {
            Logger.getLogger(Depositos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
