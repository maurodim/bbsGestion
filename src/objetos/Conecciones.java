/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;

/**
 *
 * @author mauro
 * AQUI SE VAN A GESTIONAR TODAS LAS CONECCIONES DEL SISTEMA, LOS DATOS COMO OBJETOS
 * Y LAS INTERFACES VAN A GUARDAR, ELIMINAR O ACTUALIZAR LAS TABLAS, SE VA A PASAR EL STRING POR LA INTERFAZ 
 * PARA QUE AQUI SE REALICE LA TRANSACCION
 * 
 */
public class Conecciones {
    private Connection con;

    public Conecciones() {
                MysqlDataSource dataSource=new MysqlDataSource();
		try{
			//Class.forName(driver1).newInstance();
                    dataSource.setUser("root");
                    dataSource.setDatabaseName("bambugestion");
                    dataSource.setPassword("");
                    dataSource.setServerName("localhost");
                    this.con=dataSource.getConnection();
                 }catch(Exception ex){
                    
                String cod1=String.valueOf(ex);
                
			System.out.println("NO SE PUDO CONECTAR A LA BASE "+ex);
		}

        
    }

    }
    

