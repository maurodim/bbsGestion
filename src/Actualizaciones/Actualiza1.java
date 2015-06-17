/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Actualizaciones;

import interfaceGraficas.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import javax.swing.Timer;

/**
 *
 * @author mauro
 */
public class Actualiza1 extends SwingWorker{
    
        Timer timer; 

    public Actualiza1() {
        
    }
        

        @Override
    protected Object doInBackground() throws Exception {
        this.timer = new Timer(600000,new ActionListener(){ 
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
                
                
                Runtime aplicacion=Runtime.getRuntime();
                try {
                    aplicacion.exec("java -jar C:/Gestor/Actualizador.jar");
                } catch (IOException ex) {
                    Logger.getLogger(Actualiza1.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null,"error al ejecutar actualizacion "+ex);
                }
                
            }
           // timer.start();
            
        }); 
        timer.start();
        return null;
    }

    

    
        
        
}

