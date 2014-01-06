/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import interfaceGraficas.Inicio;
import interfaces.Transaccionable;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauro
 */
public class ConeccionLocal implements Transaccionable{
    private Connection con;
    private Statement st;
    private String driver1="org.apache.derby.jdbc.EmbeddedDriver";

    public ConeccionLocal() {
              Connection dbConnection = null;
 String strUrl = "jdbc:derby://localhost:1527/respaldo;create=true";
            try {
                Class.forName(driver1).newInstance();
                dbConnection = DriverManager.getConnection (strUrl,"maurodim","mau*2012");
                st=dbConnection.createStatement();
            } catch (InstantiationException ex) {
            Logger.getLogger(ConeccionLocal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConeccionLocal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConeccionLocal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                Logger.getLogger(ConeccionLocal.class.getName()).log(Level.SEVERE, null, ex);
            }

        
    }

    @Override
    public Boolean guardarRegistro(String sql) {
        Boolean coneccion=true;
        try {
            System.out.println("SENTENCIA "+sql);
            st.executeUpdate(sql);
            //this.st.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
            coneccion=false;
            FileWriter fichero=null;
            PrintWriter pw=null;
            try {
                fichero = new FileWriter("C:\\Gestion\\"+Inicio.fechaDia+" - erroresDeConeccion.txt",true);
                pw=new PrintWriter(fichero);
                pw.println(sql);
            } catch (IOException ex1) {
                Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex1);
            }finally{
                         try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
            }
            
        }
        return coneccion;
    }

    @Override
    public Boolean guardarRegistros(ArrayList listadoDeSentencias) {
        String sql="";
        Boolean coneccionCorrecta=true;
        Iterator il=listadoDeSentencias.listIterator();
        while(il.hasNext()){
            sql=(String)il.next();
            try {
                st.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
                coneccionCorrecta=false;
            }
        }
        
        return coneccionCorrecta;
    }

    @Override
    public ResultSet leerConjuntoDeRegistros(String sql) {
        ResultSet rs=null;
        try {
            st.execute(sql);
            rs=st.getResultSet();
        } catch (SQLException ex) {
            System.out.println("NO SE CONECTA, ACA CARGA LOS OBJETOS");
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NO ENTRO LA CONECCION");
        }
        return rs;
    }
    
}
