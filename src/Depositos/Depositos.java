/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Depositos;

import Compras.Proveedores;

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
