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
        Timer timer=new Timer(200000,new ActionListener(){ 
            @Override
    public void actionPerformed(ActionEvent e) 
    { 
        
        System.err.println("COMIENZO DEL CICLO DE RELOJ *******************************");
        //ActOt at=new ActOt();
        //at.start();
        
            //Inicio.coneccionRemota=true;
            //VerificarErrores();
        
            //carga la lista remota
            //Proveedores.cargarListadoProv1();
       
        if(Inicio.actualizable==1){
          //  Articulos.RecargarMap();
        
        //Articulos.BackapearMap();
        Inicio.actualizable=0;
        }
        /*
         * Usuarios
         * Sucursales
         * Depositos
         * Comprobante
         * ACTUALIZAR EL NUMERO DE CAJA ADMINISTRADORA
         */
      
     } 
}); 
        timer.start();
        
        
        
    }  
}
