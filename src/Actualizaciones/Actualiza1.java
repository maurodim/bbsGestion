/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Actualizaciones;

import Compras.Proveedores;
import Depositos.Depositos;
import Sucursales.Cajas;
import Sucursales.ListasDePrecios;
import Sucursales.Sucursales;
import Sucursales.Usuarios;
import facturacion.clientes.ClientesTango;
import interfaceGraficas.Inicio;
import interfaces.Transaccionable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import objetos.Articulos;
import objetos.Conecciones;

/**
 *
 * @author mauro
 */
public class Actualiza1 extends Thread{
     @Override
    public void run(){
        Timer timer=new Timer(400000,new ActionListener(){ 
            @Override
    public void actionPerformed(ActionEvent e) 
    { 
        Inicio.actualizable=0;
        System.err.println("COMIENZO DEL CICLO DE RELOJ *******************************");
        //ActOt at=new ActOt();
        //at.start();
        
            //Inicio.coneccionRemota=true;
            //VerificarErrores();
        
            //carga la lista remota
            //Proveedores.cargarListadoProv1();
        
        /*
        Runtime aplicacion=Runtime.getRuntime();
                try {
                    aplicacion.exec("java -jar C:/Gestor/Actualizador.jar");
                } catch (IOException ex) {
                    Logger.getLogger(Actualiza1.class.getName()).log(Level.SEVERE, null, ex);
                }
        */
     } 
}); 
        timer.start();
        
        
        
    }  
}
