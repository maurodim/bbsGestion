
package objetos;

import interfaces.Editables;
import interfaces.Transaccionable;
import interfaces.Visibles;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauro
 */
public class RazonesSocial implements Editables,Visibles{
    private Integer id;
    private String nombre;
    private String fecha;
    private Transaccionable tra;
    private ResultSet rr;

    public RazonesSocial() {
        tra=new Conecciones();
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public Boolean AltaObjeto(Object objeto) {
        RazonesSocial razon=new RazonesSocial();
        razon=(RazonesSocial) objeto;
        String sql="insert into empresas (nombre) values ('"+razon.nombre+"')";
        tra.guardarRegistro(sql);
        return true;
        
    }

    @Override
    public Boolean ModificaionObjeto(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean EliminacionDeObjeto(Object objeto) {
         RazonesSocial razon=new RazonesSocial();
        razon=(RazonesSocial) objeto;
        String sql="delete from empresas where id="+razon.id;
        tra.guardarRegistro(sql);
        return true;
    }

    @Override
    public Boolean MovimientoDeAjusteDeCantidades(Object objeto, Double cantidadMovimiento, String observaciones) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarPorSucursal(Object objeto) {
        RazonesSocial razon;
        ArrayList listado=new ArrayList();
        String sql="select id,nombre from empresas order by nombre";
        rr=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rr.next()){
                razon=new RazonesSocial();
                razon.setId(rr.getInt("id"));
                razon.setNombre(rr.getString("nombre"));
                listado.add(razon);
            }
            rr.close();
        } catch (SQLException ex) {
            Logger.getLogger(RazonesSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }

    @Override
    public DefaultComboBoxModel ListadoCombo(ArrayList componentes) {
        DefaultComboBoxModel modelo=new DefaultComboBoxModel();
        Iterator listado=componentes.listIterator();
        RazonesSocial razon=new RazonesSocial();
        while(listado.hasNext()){
            razon=(RazonesSocial)listado.next();
            modelo.addElement(razon.getNombre());
        }
        return modelo;
    }

    @Override
    public DefaultListModel ListadoEnList(ArrayList componentes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel ListadoEnTabla(ArrayList componentes, ArrayList encabezadosColumnas, String formatoTabla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
