/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import interfaces.Transaccionable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauro
 * AQUI SE VAN A GESTIONAR TODAS LAS CONECCIONES DEL SISTEMA, LOS DATOS COMO OBJETOS
 * Y LAS INTERFACES VAN A GUARDAR, ELIMINAR O ACTUALIZAR LAS TABLAS, SE VA A PASAR EL STRING POR LA INTERFAZ 
 * PARA QUE AQUI SE REALICE LA TRANSACCION
 * 
 */
public class Conecciones implements Transaccionable{
    private Connection con;
    private Statement st;

    public Conecciones() {
                MysqlDataSource dataSource=new MysqlDataSource();
		try{
			//Class.forName(driver1).newInstance();
                    dataSource.setUser("root");
                    dataSource.setDatabaseName("bambugestion");
                    dataSource.setPassword("");
                    dataSource.setServerName("localhost:82");
                    this.con=dataSource.getConnection();
                    Statement st=this.con.createStatement();
                 }catch(Exception ex){
                    
                String cod1=String.valueOf(ex);
                
			System.out.println("NO SE PUDO CONECTAR A LA BASE "+ex);
		}

        
    }

    @Override
    public Boolean guardarRegistro(String sql) {
        Boolean coneccion=true;
        try {
            
            this.st.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
            coneccion=false;
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
                this.st.executeUpdate(sql);
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
            this.st.execute(sql);
            rs=this.st.getResultSet();
        } catch (SQLException ex) {
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

   

    }
    
