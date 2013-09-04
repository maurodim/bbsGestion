/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author mauro
 */
public class Comprobantes {
    private int numero;
    private String descripcion;
    private int destinatarioCondicion;
    private int descargaStock;

    public Comprobantes(int numero) {
        this.numero = numero;
    }

    public Comprobantes() {
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

    public int getDestinatarioCondicion() {
        return destinatarioCondicion;
    }

    public void setDestinatarioCondicion(int destinatarioCondicion) {
        this.destinatarioCondicion = destinatarioCondicion;
    }

    public int getDescargaStock() {
        return descargaStock;
    }

    public void setDescargaStock(int descargaStock) {
        this.descargaStock = descargaStock;
    }
    
    
}
