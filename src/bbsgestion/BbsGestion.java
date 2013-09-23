/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbsgestion;

import Compras.Remitos;
import Sucursales.Usuarios;
import interfaceGraficas.Inicio;
import interfaces.Comprobable;
import java.util.ArrayList;

/**
 *
 * @author mauro
 */
public class BbsGestion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList usuariosList=new ArrayList();
        Usuarios usuarios=new Usuarios();
        usuariosList=usuarios.listarUsuario();
        Inicio in=new Inicio();
        in.setVisible(true);
        in.pack();
    }
}
