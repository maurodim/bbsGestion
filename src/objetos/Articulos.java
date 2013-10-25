/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import interfaces.Editables;
import interfaces.Transaccionable;
import interfacesPrograma.Facturar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauro
 */
public class Articulos implements Facturar,Editables{
    private String codigoDeBarra;
    private String codigoAsignado;
    private Integer rubro;
    private String nrubro;
    private Integer numeroId;
    private String descripcionArticulo;
    private Double cantidad;
    private Double precioUnitario;
    private Double precioIva;
    private Double precioUnitarioNeto;
    private Double equivalencia;
    private Double precioDeCosto;
    private Double stockMinimo;
    private Double stockActual;
    private Double precioServicio;
    private Boolean confirmado;
    private Double recargo;
    private Boolean modificaPrecio;
    private static Hashtable listadoBarr=new Hashtable();
    private static Hashtable listadoNom=new Hashtable();
    

    public Boolean getModificaPrecio() {
        return modificaPrecio;
    }

    public void setModificaPrecio(Boolean modificaPrecio) {
        this.modificaPrecio = modificaPrecio;
    }
    
    public Double getRecargo() {
        return recargo;
    }

    public void setRecargo(Double recargo) {
        this.recargo = recargo;
    }
    
    

    public Boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }
    

    public Double getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(Double precioServicio) {
        this.precioServicio = precioServicio;
    }
    

    public Double getStockActual() {
        return stockActual;
    }

    public void setStockActual(Double stockActual) {
        this.stockActual = stockActual;
        /*
         * codigo vista stockart
         * select articulos.id,(select sum(movimientosarticulos.cantidad) from movimientosarticulos where movimientosarticulos.idArticulo=articulos.id)as stock from articulos order by id
         */
    }
    
    public Double getPrecioDeCosto() {
        return precioDeCosto;
    }

    public void setPrecioDeCosto(Double precioDeCosto) {
        this.precioDeCosto = precioDeCosto;
    }

    public Double getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Double stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    

    public Double getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(Double equivalencia) {
        this.equivalencia = equivalencia;
    }
    

    public String getNrubro() {
        return nrubro;
    }

    public void setNrubro(String nrubro) {
        this.nrubro = nrubro;
    }

    public Articulos() {
    }

    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }

    public String getCodigoAsignado() {
        return codigoAsignado;
    }

    public void setCodigoAsignado(String codigoAsignado) {
        this.codigoAsignado = codigoAsignado;
    }

    public Integer getRubro() {
        return rubro;
    }

    public void setRubro(Integer rubro) {
        this.rubro = rubro;
    }

    public Integer getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(Integer numeroId) {
        this.numeroId = numeroId;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioIva() {
        return precioIva;
    }

    public void setPrecioIva(Double precioIva) {
        this.precioIva = precioIva;
    }

    public Double getPrecioUnitarioNeto() {
        
        return precioUnitarioNeto;
    }

    public void setPrecioUnitarioNeto(Double precioUnitarioNeto) {
      
        this.precioUnitarioNeto = precioUnitarioNeto;
        System.err.println("RECIBIDO "+precioUnitarioNeto+" resultado "+this.precioUnitarioNeto+" recargo "+this.recargo+"\n");
    }
    
    public static void CargarMap(){
        // ACA SE CARGA EL MAP PARA TENER ACCESO A LOS ARTICULOS SIN ESTAR CONECTADO , LA CLAVE EL CODIGO DE BARRA
        Transaccionable tra=new Conecciones();
        //ArrayList resultado=new ArrayList();
        Articulos articulo=null;
        String sql="select *,(select stockart.stock from stockart where stockart.id=articulos.ID)as stock,(select rubros.recargo from rubros where rubros.id=articulos.idRubro)as recargo from articulos where INHABILITADO=0";
        ResultSet rr=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rr.next()){
                articulo=new Articulos();
                articulo.setCodigoAsignado(rr.getString("ID"));
                articulo.setDescripcionArticulo(rr.getString("NOMBRE"));
                articulo.setNumeroId(rr.getInt("ID"));
                articulo.setCodigoDeBarra(rr.getString("BARRAS"));
                articulo.setRecargo(rr.getDouble("recargo"));
                articulo.setPrecioUnitarioNeto(rr.getDouble("PRECIO"));
                articulo.setEquivalencia(rr.getDouble("equivalencia"));
                articulo.setPrecioDeCosto(rr.getDouble("COSTO"));
                articulo.setStockMinimo(rr.getDouble("MINIMO"));
                articulo.setStockActual(rr.getDouble("stock"));
                articulo.setPrecioServicio(rr.getDouble("SERVICIO"));
                articulo.setModificaPrecio(rr.getBoolean("modificaPrecio"));
                listadoBarr.put(articulo.getCodigoDeBarra(),articulo);
                
                //resultado.add(articulo);
            }
                  } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sql="select *,(select stockart.stock from stockart where stockart.id=articulos.ID)as stock,(select rubros.recargo from rubros where rubros.id=articulos.idRubro)as recargo from articulos where INHABILITADO=0 order by ID";
        rr=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rr.next()){
                articulo=new Articulos();
                articulo.setCodigoAsignado(rr.getString("ID"));
                articulo.setDescripcionArticulo(rr.getString("NOMBRE"));
                articulo.setNumeroId(rr.getInt("ID"));
                articulo.setCodigoDeBarra(rr.getString("BARRAS"));
                articulo.setRecargo(rr.getDouble("recargo"));
                articulo.setPrecioUnitarioNeto(rr.getDouble("PRECIO"));
                articulo.setEquivalencia(rr.getDouble("equivalencia"));
                articulo.setPrecioDeCosto(rr.getDouble("COSTO"));
                articulo.setStockMinimo(rr.getDouble("MINIMO"));
                articulo.setStockActual(rr.getDouble("stock"));
                articulo.setPrecioServicio(rr.getDouble("SERVICIO"));
                articulo.setModificaPrecio(rr.getBoolean("modificaPrecio"));
                listadoNom.put(articulo.descripcionArticulo,articulo);
                //resultado.add(articulo);
            }
            rr.close();
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void RecargarMap(){
        listadoBarr.clear();
        listadoNom.clear();
        System.out.println(" CANTIDAD MAP "+listadoBarr.size());
        // ACA SE CARGA EL MAP PARA TENER ACCESO A LOS ARTICULOS SIN ESTAR CONECTADO , LA CLAVE EL CODIGO DE BARRA
        Transaccionable tra=new Conecciones();
        //ArrayList resultado=new ArrayList();
        Articulos articulo=null;
        String sql="select *,(select stockart.stock from stockart where stockart.id=articulos.ID)as stock,(select rubros.recargo from rubros where rubros.id=articulos.idRubro)as recargo from articulos where INHABILITADO=0";
        ResultSet rr=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rr.next()){
                articulo=new Articulos();
                articulo.setCodigoAsignado(rr.getString("ID"));
                articulo.setDescripcionArticulo(rr.getString("NOMBRE"));
                articulo.setNumeroId(rr.getInt("ID"));
                articulo.setCodigoDeBarra(rr.getString("BARRAS"));
                articulo.setRecargo(rr.getDouble("recargo"));
                articulo.setPrecioUnitarioNeto(rr.getDouble("PRECIO"));
                articulo.setEquivalencia(rr.getDouble("equivalencia"));
                articulo.setPrecioDeCosto(rr.getDouble("COSTO"));
                articulo.setStockMinimo(rr.getDouble("MINIMO"));
                articulo.setStockActual(rr.getDouble("stock"));
                articulo.setPrecioServicio(rr.getDouble("SERVICIO"));
                articulo.setModificaPrecio(rr.getBoolean("modificaPrecio"));
                listadoBarr.put(articulo.getCodigoDeBarra(),articulo);
               
                //resultado.add(articulo);
            }
                  } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sql="select *,(select stockart.stock from stockart where stockart.id=articulos.ID)as stock,(select rubros.recargo from rubros where rubros.id=articulos.idRubro)as recargo from articulos where INHABILITADO=0 order by ID";
        rr=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rr.next()){
                articulo=new Articulos();
                articulo.setCodigoAsignado(rr.getString("ID"));
                articulo.setDescripcionArticulo(rr.getString("NOMBRE"));
                articulo.setNumeroId(rr.getInt("ID"));
                articulo.setCodigoDeBarra(rr.getString("BARRAS"));
                articulo.setRecargo(rr.getDouble("recargo"));
                articulo.setPrecioUnitarioNeto(rr.getDouble("PRECIO"));
                articulo.setEquivalencia(rr.getDouble("equivalencia"));
                articulo.setPrecioDeCosto(rr.getDouble("COSTO"));
                articulo.setStockMinimo(rr.getDouble("MINIMO"));
                articulo.setStockActual(rr.getDouble("stock"));
                articulo.setPrecioServicio(rr.getDouble("SERVICIO"));
                articulo.setModificaPrecio(rr.getBoolean("modificaPrecio"));
                listadoNom.put(articulo.descripcionArticulo,articulo);
                //resultado.add(articulo);
            }
            rr.close();
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public Boolean guardar(Object oob) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean modificar(Object oob) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean nuevo(Object oob) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object leer(Object oob) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void imprimirComprobante(int tipoComprobante, Object oob) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList listadoBusqueda(String criterio) {
        ArrayList resultado=new ArrayList();
        Articulos articulo=null;
        criterio=criterio.toUpperCase();
        Enumeration<Articulos> elementos=listadoNom.elements();
        while(elementos.hasMoreElements()){
            articulo=(Articulos)elementos.nextElement();
            int pos=articulo.getDescripcionArticulo().indexOf(criterio);
            System.out.println("hash "+articulo.getDescripcionArticulo()+" "+pos);
            if(pos==-1){
                
            }else{
                resultado.add(articulo);
            }
        }
        /*
        Transaccionable tra=new Conecciones();
        ArrayList resultado=new ArrayList();
        Articulos articulo=null;
        String sql="select *,(select stockart.stock from stockart where stockart.id=articulos.ID)as stock,(select rubros.recargo from rubros where rubros.id=articulos.idRubro)as recargo from articulos where NOMBRE like '"+criterio+"%' and INHABILITADO=0";
        ResultSet rr=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rr.next()){
                articulo=new Articulos();
                articulo.setCodigoAsignado(rr.getString("ID"));
                articulo.setDescripcionArticulo(rr.getString("NOMBRE"));
                articulo.setNumeroId(rr.getInt("ID"));
                articulo.setCodigoDeBarra(rr.getString("BARRAS"));
                articulo.setRecargo(rr.getDouble("recargo"));
                articulo.setPrecioUnitarioNeto(rr.getDouble("PRECIO"));
                articulo.setEquivalencia(rr.getDouble("equivalencia"));
                articulo.setPrecioDeCosto(rr.getDouble("COSTO"));
                articulo.setStockMinimo(rr.getDouble("MINIMO"));
                articulo.setStockActual(rr.getDouble("stock"));
                articulo.setPrecioServicio(rr.getDouble("SERVICIO"));
                articulo.setModificaPrecio(rr.getBoolean("modificaPrecio"));
                resultado.add(articulo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        return resultado;
    }

    @Override
    public Boolean guardarNuevoCliente(Object cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean modificarDatosDelCliente(Object cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList listarClientes(String nombre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object cargarPorCodigoDeBarra(String codigoDeBarra) {
        Articulos articulo;
        articulo=(Articulos)listadoBarr.get(codigoDeBarra);
        /*
        String sql="select *,(select stockart.stock from stockart where stockart.id=articulos.ID)as stock,(select rubros.recargo from rubros where rubros.id=articulos.idRubro)as recargo from articulos where BARRAS like '"+codigoDeBarra+"' and INHABILITADO=0";
        Transaccionable tra=new Conecciones();
        ResultSet rr=tra.leerConjuntoDeRegistros(sql);
        Articulos articulo=new Articulos();
        
        try {
            while(rr.next()){
                articulo.setCodigoAsignado(rr.getString("ID"));
                articulo.setDescripcionArticulo(rr.getString("NOMBRE"));
                articulo.setNumeroId(rr.getInt("ID"));
                articulo.setCodigoDeBarra(rr.getString("BARRAS"));
                articulo.setRecargo(rr.getDouble("recargo"));
                articulo.setPrecioUnitarioNeto(rr.getDouble("PRECIO"));
                articulo.setNrubro(rr.getString("RUBRON"));
                articulo.setEquivalencia(rr.getDouble("equivalencia"));
                articulo.setPrecioDeCosto(rr.getDouble("COSTO"));
                articulo.setStockMinimo(rr.getDouble("MINIMO"));
                articulo.setStockActual(rr.getDouble("stock"));
                articulo.setPrecioServicio(rr.getDouble("SERVICIO"));
                articulo.setModificaPrecio(rr.getBoolean("modificaPrecio"));
            }
            rr.close();
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        */ 
        return articulo;
    }

    @Override
    public Boolean AltaObjeto(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean ModificaionObjeto(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean EliminacionDeObjeto(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer leerNumeroDeComprobanteSiguiente(Integer numeroComprobante) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
