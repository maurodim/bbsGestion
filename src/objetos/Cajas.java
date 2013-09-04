/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.Date;

/**
 *
 * @author mauro
 */
public class Cajas {
    private int numero;
    private int tipoMovimiento;
    private static Double saldoInicial;
    private static Date fechaInicio;
    private int numeroDeComprobante;
    private int tipoDeComprobante;
    private Double montoMovimiento;
    private Comprobantes comprobante;

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
    }

    public Cajas() {
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

    public static Double getSaldoInicial() {
        return saldoInicial;
    }

    public static void setSaldoInicial(Double saldoInicial) {
        Cajas.saldoInicial = saldoInicial;
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
    
    
}
