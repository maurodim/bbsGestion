/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Actualizaciones;

import Sucursales.Sucursales;
import Sucursales.Usuarios;
import interfaceGraficas.Inicio;
import interfaces.Backpeable;
import interfaces.Transaccionable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import objetos.ConeccionLocal;
import objetos.Menus;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 *
 * @author mauro
 */
public class BkDeConeccion implements Backpeable{
    private long elements;
    private long attributes;
    private long caracteres;
    private long espaciosEnBlanco;
    

    @Override
    public Hashtable leerArticulos() {
        Hashtable art=new Hashtable();
        
        return art;
    }

    @Override
    public Hashtable leerProveedores() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Hashtable leerClientes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object leerDeposito() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean backapearObjetos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object leerUsuarios(String nombre, String clave) {
         Usuarios usu=new Usuarios();
        try {
           Inicio.coneccionRemota=false;
       Transaccionable tras=new ConeccionLocal();
                       String sql="select * from usuarios where nombreUsuario like '"+nombre+"' and clave like '"+clave+"'";
                       System.out.println(sql);
                       ResultSet rs=tras.leerConjuntoDeRegistros(sql);
                   
                           
                      
                        while(rs.next()){
                        usu=new Usuarios();
                        usu.setNivelDeAutorizacion(rs.getInt("autorizacion"));
                        usu.setNombre(rs.getString("nombre"));
                        usu.setNumero(rs.getInt("numero"));
                        usu.setNumeroId(rs.getInt("numero"));
                        usu.setSucursal(new Sucursales(rs.getInt("sucursal")));
                        
                             
                        }
                        sql="select * from tipoacceso where numero="+usu.getNivelDeAutorizacion();
                        rs=tras.leerConjuntoDeRegistros(sql);
                        while(rs.next()){
                               usu.setMenu(new Menus(rs.getBoolean("menu1"),rs.getBoolean("menu2"),rs.getBoolean("menu3"),rs.getBoolean("menu4"),rs.getBoolean("menu5"),rs.getBoolean("menu6"),rs.getBoolean("menu7")));                    
                           
                        }
                        rs.close();
                        
        } catch (SQLException ex) {
            Logger.getLogger(BkDeConeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
         return usu;
    }
    }

