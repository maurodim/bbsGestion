/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbsgestion;

import Compras.Remitos;
import interfaces.Comprobable;

/**
 *
 * @author mauro
 */
public class BbsGestion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Comprobable comp=new Remitos();
        Remitos rem=new Remitos();
        comp.nuevoComprobante(rem);
    }
}
