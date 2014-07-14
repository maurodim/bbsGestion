/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import interfaceGraficas.Inicio;
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
import java.util.concurrent.ConcurrentHashMap;
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
    private Double precioServicio=0.00;
    private Boolean confirmado;
    private Double recargo;
    private Boolean modificaPrecio;
    private static ConcurrentHashMap listadoBarr=new ConcurrentHashMap();
    private static ConcurrentHashMap listadoNom=new ConcurrentHashMap();
    private static ConcurrentHashMap listadoCodigo=new ConcurrentHashMap();
    private Double diferenciaRemitida;
    private Boolean modificaServicio;
    private Double precioServicio1=0.00;
    private static ConcurrentHashMap listadoBarr1=new ConcurrentHashMap();
    private static ConcurrentHashMap listadoNom1=new ConcurrentHashMap();
    private static ConcurrentHashMap listadoCodigo1=new ConcurrentHashMap();

    public Double getPrecioServicio1() {
        return precioServicio1;
    }

    public void setPrecioServicio1(Double precioServicio1) {
        this.precioServicio1 = precioServicio1;
    }
    

    public Boolean getModificaServicio() {
        return modificaServicio;
    }

    public void setModificaServicio(Boolean modificaServicio) {
        this.modificaServicio = modificaServicio;
    }

    
    public Double getDiferenciaRemitida() {
        return diferenciaRemitida;
    }

    public void setDiferenciaRemitida(Double diferenciaRemitida) {
        this.diferenciaRemitida = diferenciaRemitida;
    }
    
    

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
        if(precioServicio==null){
            precioServicio=0.00;
        }
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
        //System.err.println("RECIBIDO "+precioUnitarioNeto+" resultado "+this.precioUnitarioNeto+" recargo "+this.recargo+"\n");
    }
    
    public static void CargarMap(){
        // ACA SE CARGA EL MAP PARA TENER ACCESO A LOS ARTICULOS SIN ESTAR CONECTADO , LA CLAVE EL CODIGO DE BARRA
        listadoBarr.clear();
             listadoNom.clear();
             listadoCodigo.clear();
        Transaccionable tra;
        //ArrayList resultado=new ArrayList();
        String sql="";
        Articulos articulo=null;
        /*
        if(listadoBarr.size()==0){
            tra=new Conecciones();
            sql="select *,(select stockart.stock from stockart where stockart.id=articulos.ID)as stock,(select rubros.recargo from rubros where rubros.id=articulos.idRubro)as recargo from articulos where INHABILITADO=0";
            
        }else{
         */
            tra=new ConeccionLocal();
            
            sql="select articulos.ID,articulos.NOMBRE,articulos.BARRAS,articulos.recargo,articulos.PRECIO,articulos.equivalencia,articulos.COSTO,articulos.MINIMO,(articulos.STOCK) as stock,articulos.SERVICIO, articulos.modificaPrecio,articulos.modificaServicio,articulos.SERVICIO1 from articulos where INHABILITADO=0";
            
        //}
        
        
        ResultSet rr=tra.leerConjuntoDeRegistros(sql);
        String codA="";
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
                articulo.setModificaServicio(rr.getBoolean("modificaServicio"));
                articulo.setPrecioServicio1(rr.getDouble("servicio1"));
                listadoBarr.putIfAbsent(articulo.getCodigoDeBarra(),articulo);
                codA=articulo.getCodigoAsignado();
                listadoCodigo.putIfAbsent(codA,articulo);
                
                //resultado.add(articulo);
            }
                  } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("ACA DEBE LEER EN LE ARCHIVO");
            
        }
        /*
        if(Inicio.coneccionRemota){
        sql="select *,(select stockart.stock from stockart where stockart.id=articulos.ID)as stock,(select rubros.recargo from rubros where rubros.id=articulos.idRubro)as recargo from articulos where INHABILITADO=0 order by NOMBRE";
        }else{
        */ 
            sql="select articulos.ID,articulos.NOMBRE,articulos.BARRAS,articulos.recargo,articulos.PRECIO,articulos.equivalencia,articulos.COSTO,articulos.MINIMO,(articulos.STOCK) as stock,articulos.SERVICIO, articulos.modificaPrecio,articulos.modificaServicio,articulos.servicio1 from articulos where INHABILITADO=0 order by NOMBRE";
        //}
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
                articulo.setModificaServicio(rr.getBoolean("modificaServicio"));
                articulo.setPrecioServicio1(rr.getDouble("SERVICIO1"));
                String nom=rr.getString("NOMBRE");
                listadoNom.putIfAbsent(nom,articulo);
                //resultado.add(articulo);
            }
            rr.close();
            //System.out.println(" CANTIDAD MAP inicial "+listadoBarr.size());
           
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        //if(Inicio.coneccionRemota)BackapearMap();
    }
    public static synchronized void RecargarMap(){
        

        //System.out.println(" CANTIDAD MAP 1 - "+listadoBarr1.size());
        // ACA SE CARGA EL MAP PARA TENER ACCESO A LOS ARTICULOS SIN ESTAR CONECTADO , LA CLAVE EL CODIGO DE BARRA
        Transaccionable tra=new Conecciones();
        //ArrayList resultado=new ArrayList();
        Articulos articulo=null;
        
        /*
        String sql="select *,(select stockart.stock from stockart where stockart.id=articulos.ID)as stock,(select rubros.recargo from rubros where rubros.id=articulos.idRubro)as recargo from articulos where INHABILITADO=0 and actualizacion=0";
        ResultSet rr=tra.leerConjuntoDeRegistros(sql);
        try {
            listadoBarr1.clear();
             listadoNom1.clear();
             listadoCodigo1.clear();
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
//                System.out.println(Inicio.sucursal.getDireccion());
                try{
                if(Inicio.sucursal.getDireccion().equals("1")){
                articulo.setPrecioServicio(rr.getDouble("SERVICIO"));
                }else{
                    articulo.setPrecioServicio(rr.getDouble("SERVICIO1"));
                }
                }catch(NullPointerException nEx){
                    articulo.setPrecioServicio(rr.getDouble("SERVICIO"));
                    articulo.setPrecioServicio1(rr.getDouble("SERVICIO1"));
                }
                articulo.setModificaPrecio(rr.getBoolean("modificaPrecio"));
                articulo.setModificaServicio(rr.getBoolean("modificaServicio"));
                listadoBarr1.putIfAbsent(articulo.getCodigoDeBarra(),articulo);
               listadoCodigo1.putIfAbsent(articulo.getCodigoAsignado(),articulo);
                //resultado.add(articulo);
            }
                  } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        String sql="select *,(select stockart.stock from stockart where stockart.id=articulos.ID)as stock,(select rubros.recargo from rubros where rubros.id=articulos.idRubro)as recargo from articulos where INHABILITADO=0 and actualizacion=0 order by NOMBRE";
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
                try{
                if(Inicio.sucursal.getDireccion().equals("1")){
                articulo.setPrecioServicio(rr.getDouble("SERVICIO"));
                }else{
                    articulo.setPrecioServicio(rr.getDouble("SERVICIO1"));
                }
                }catch(NullPointerException nEx){
                    articulo.setPrecioServicio(rr.getDouble("SERVICIO"));
                    articulo.setPrecioServicio1(rr.getDouble("SERVICIO1"));
                }
                articulo.setModificaPrecio(rr.getBoolean("modificaPrecio"));
                articulo.setModificaServicio(rr.getBoolean("modificaServicio"));
                String nom=rr.getString("NOMBRE");
                listadoNom1.putIfAbsent(nom,articulo);
                //resultado.add(articulo);
            }
            rr.close();
            sql="update actualizaciones set estado=1 where iddeposito="+Inicio.deposito.getNumero()+" and idobjeto=1";
            tra.guardarRegistro(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static synchronized void BackapearMap(){
        Transaccionable tt=new ConeccionLocal();
        System.out.println(" CANTIDAD MAP back "+listadoBarr1.size());
        String sql="";
//String sql="delete from articulos";
        //tt.guardarRegistro(sql);
        String criterio="";
        Articulos articulo=null;
        criterio=criterio.toUpperCase();
        Enumeration<Articulos> elementos=listadoNom1.elements();
        while(elementos.hasMoreElements()){
            articulo=(Articulos)elementos.nextElement();
            int pos=articulo.getDescripcionArticulo().indexOf(criterio);
            int mod=0;
            int serv=0;
            if(articulo.getModificaPrecio())mod=1;
            if(articulo.getModificaServicio())serv=1;
            if(articulo.getDescripcionArticulo().equals(""))articulo.setDescripcionArticulo("--");
            //sql="update articulos (nombre,barras,servicio,costo,precio,minimo,stock,equivalencia,modificaprecio,modificaservicio,recargo,inhabilitado,idrubro,servicio1) values ('"+articulo.getDescripcionArticulo()+"','"+articulo.getCodigoDeBarra()+"',"+articulo.getPrecioServicio()+","+articulo.getPrecioDeCosto()+","+articulo.getPrecioUnitarioNeto()+","+articulo.getStockMinimo()+","+articulo.getStockActual()+","+articulo.getEquivalencia()+","+mod+","+serv+","+articulo.getRecargo()+",0,0,"+articulo.getPrecioServicio1()+")";
            sql="update articulos set nombre='"+articulo.getDescripcionArticulo()+"',barras='"+articulo.getCodigoDeBarra()+"',servicio="+articulo.getPrecioServicio()+",costo="+articulo.getPrecioDeCosto()+",precio="+articulo.getPrecioUnitarioNeto()+",minimo="+articulo.getStockMinimo()+",stock="+articulo.getStockActual()+",equivalencia="+articulo.getEquivalencia()+",modificaprecio="+mod+",modificaservicio="+serv+",recargo="+articulo.getRecargo()+",inhabilitado=0,idrubro=0,servicio1="+articulo.getPrecioServicio1()+" where id="+articulo.getNumeroId();
            System.out.println("hash "+sql);
            tt.guardarRegistro(sql);
            
            
        }
        //CargarMap();
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
        String sql="select * from articulos where nombre like '%"+criterio+"%'";
        Transaccionable tra=new ConeccionLocal();
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
                try{
                    if(Inicio.sucursal.getDireccion().equals("1")){
                        articulo.setPrecioServicio(rr.getDouble("SERVICIO"));
                    }else{
                        articulo.setPrecioServicio(rr.getDouble("SERVICIO1"));
                    }
                }catch(NullPointerException nEx){
                    articulo.setPrecioServicio(rr.getDouble("SERVICIO"));
                    articulo.setPrecioServicio1(rr.getDouble("SERVICIO1"));
                }
                articulo.setModificaPrecio(rr.getBoolean("modificaPrecio"));
                articulo.setModificaServicio(rr.getBoolean("modificaServicio"));
                String nom=rr.getString("NOMBRE");
                resultado.add(articulo);
            }
            rr.close();
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
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
        //Articulos articulo;
        //articulo=(Articulos)listadoBarr.get(codigoDeBarra);
        
        String sql="select id,nombre,barras,precio,equivalencia,costo,minimo,stock,servicio,servicio1,modificaprecio,modificaservicio,stock,recargo from articulos where BARRAS like '"+codigoDeBarra+"' and INHABILITADO=0";
        Transaccionable tra=new ConeccionLocal();
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
                articulo.setEquivalencia(rr.getDouble("equivalencia"));
                articulo.setPrecioDeCosto(rr.getDouble("COSTO"));
                articulo.setStockMinimo(rr.getDouble("MINIMO"));
                articulo.setStockActual(rr.getDouble("stock"));
                
                        articulo.setPrecioServicio(rr.getDouble("SERVICIO"));
                
                articulo.setModificaPrecio(rr.getBoolean("modificaPrecio"));
                articulo.setModificaServicio(rr.getBoolean("modificaServicio"));
                String nom=rr.getString("NOMBRE");
            }
            rr.close();
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return articulo;
    }

    @Override
    public Boolean AltaObjeto(Object objeto) {
        Articulos articulo=(Articulos)objeto;
        Boolean ch=false;
        //String sql="insert into articulos (NOMBRE='"+articulo.getDescripcionArticulo()+"',SERVICIO="+articulo.getPrecioServicio()+",COSTO="+articulo.getPrecioDeCosto()+",PRECIO="+articulo.getPrecioUnitarioNeto()+",MINIMO="+articulo.getStockMinimo()+",BARRAS ='"+articulo.getCodigoDeBarra()+"',modificaPrecio="+articulo.getModificaPrecio()+" where ID="+articulo.getNumeroId();
        String sql="insert into articulos (NOMBRE,SERVICIO,COSTO,PRECIO,MINIMO,BARRAS,modificaPrecio,modificaServicio,SERVICIO1) values ('"+articulo.getDescripcionArticulo()+"',"+articulo.getPrecioServicio()+","+articulo.getPrecioDeCosto()+","+articulo.getPrecioUnitarioNeto()+","+articulo.getStockMinimo()+",'"+articulo.getCodigoDeBarra()+"',"+articulo.getModificaPrecio()+","+articulo.getModificaServicio()+","+articulo.getPrecioServicio1()+")";
        Transaccionable tra=new Conecciones();
        ch=tra.guardarRegistro(sql);
         sql="insert into actualizaciones (iddeposito,idobjeto) values (1,1),(2,1),(3,1),(4,1)";
        tra.guardarRegistro(sql);
        return ch;
    }

    @Override
    public Boolean ModificaionObjeto(Object objeto) {
        Articulos articulo=(Articulos)objeto;
        Boolean ch=false;
        String sql="update articulos set NOMBRE='"+articulo.getDescripcionArticulo()+"',SERVICIO="+articulo.getPrecioServicio()+",SERVICIO1="+articulo.getPrecioServicio1()+",COSTO="+articulo.getPrecioDeCosto()+",PRECIO="+articulo.getPrecioUnitarioNeto()+",MINIMO="+articulo.getStockMinimo()+",BARRAS ='"+articulo.getCodigoDeBarra()+"',modificaPrecio="+articulo.getModificaPrecio()+",modificaServicio="+articulo.getModificaServicio()+",actualizacion=0 where ID="+articulo.getNumeroId();
        Transaccionable tra=new Conecciones();
        ch=tra.guardarRegistro(sql);
        sql="insert into actualizaciones (iddeposito,idobjeto) values (1,1),(2,1),(3,1),(4,1)";
        tra.guardarRegistro(sql);
        return ch;
    }

    @Override
    public Boolean EliminacionDeObjeto(Object objeto) {
        Articulos articulo=(Articulos)objeto;
        Boolean verif=false;
        String sql="update articulos set INHABILITADO=1 where ID="+articulo.getNumeroId();
        Transaccionable tra=new Conecciones();
        verif=tra.guardarRegistro(sql);
        
        return verif;
    }

    @Override
    public Integer leerNumeroDeComprobanteSiguiente(Integer numeroComprobante) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object cargarPorCodigoAsignado(Integer id) {
        Articulos articulo;
        String idd=String.valueOf(id);
        articulo=(Articulos)listadoCodigo.get(idd);
        return articulo;
    }

    @Override
    public Boolean MovimientoDeAjusteDeCantidades(Object objeto, Double cantidadMovimiento, String observaciones) {
        Articulos articulo=(Articulos)objeto;
        Boolean verif=false;
        String sql="insert into movimientosarticulos (tipoMovimiento,idArticulo,cantidad,numeroDeposito,tipoComprobante,numeroComprobante,numeroCliente,fechaComprobante,numerousuario,precioDeCosto,precioDeVenta,precioServicio,observaciones,idcaja) values (14,"+articulo.getNumeroId()+","+cantidadMovimiento+","+Inicio.deposito.getNumero()+",18,(select tipocomprobantes.numeroActivo + 1 from tipocomprobantes where tipocomprobantes.numero=18),1,'"+Inicio.fechaDia+"',"+Inicio.usuario.getNumeroId()+","+articulo.getPrecioDeCosto()+","+articulo.getPrecioUnitarioNeto()+","+articulo.getPrecioServicio()+",'"+observaciones+"',"+Inicio.caja.getNumero()+")";
        Transaccionable tra=new Conecciones();
        verif=tra.guardarRegistro(sql);
        sql="update tipocomprobantes set numeroActivo=numeroActivo + 1 where numero=18";
        tra.guardarRegistro(sql);
        return verif;
    }
    
    
}
