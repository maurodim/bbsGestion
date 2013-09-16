/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

/**
 *
 * @author mauro
 */
public class TipoAcceso {
    private Integer numero;
    private String descripcion;
    private Integer nivel;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public TipoAcceso() {
        this.numero=0;
        this.descripcion="Basico";
        this.nivel=1;
    }
    
    
    
}
