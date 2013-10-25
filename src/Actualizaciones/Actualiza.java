/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Actualizaciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import objetos.Articulos;

/**
 *
 * @author mauro
 */
public class Actualiza extends Thread{
    @Override
    public void run(){
        Timer timer=new Timer(150000,new ActionListener(){ 
            @Override
    public void actionPerformed(ActionEvent e) 
    { 
        
        System.err.println("COMIENZO DEL CICLO DE RELOJ *******************************");
        //ActOt at=new ActOt();
        //at.start();
        Articulos.RecargarMap();
     } 
}); 
        timer.start();
        
        
        
    }    
}
