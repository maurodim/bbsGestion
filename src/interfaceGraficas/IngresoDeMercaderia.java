/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGraficas;

import Compras.FacturaProveedor;
import Compras.Proveedores;
import Compras.Remitos;
import Conversores.Numeros;
import Depositos.RemitosInternos;
import interfaces.Comprobable;
import interfaces.Personalizable;
import interfacesPrograma.Facturar;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import objetos.Articulos;
import objetos.Comprobantes;
import tablas.MiModeloTablaFacturacion;

/**
 *
 * @author mauro
 */
public class IngresoDeMercaderia extends javax.swing.JInternalFrame {
    private RemitosInternos remito;
    private FacturaProveedor facturaProveedor;
    private ArrayList listadoArt=new ArrayList();
    private ArrayList listaProv=new ArrayList();
    private Articulos arti;
    private Proveedores proveedor;
    /**
     * Creates new form IngresoDeMercaderia
     */
    public IngresoDeMercaderia() {
        //Articulos.CargarMap();
        remito=new RemitosInternos();
        facturaProveedor=new FacturaProveedor();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ingreso de Mercadería");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jLabel1.setText("Seleccione Proveedor");

        Proveedores proveedor=new Proveedores();
        listaProv=new ArrayList();
        Personalizable per=new Proveedores();
        listaProv=per.listar();
        Iterator ilProv=listaProv.listIterator();
        while(ilProv.hasNext()){
            proveedor=(Proveedores)ilProv.next();
            jComboBox1.addItem(proveedor.getNombre());
        }

        /*
        Cobradores cob=new Cobradores();
        Procesos pr=new Procesos();
        ArrayList listaCob=new ArrayList();
        //List comb=new List();
        try{
            listaCob=pr.listarCobradores();
        }catch(Exception ex){
            System.out.println("no se accedio al listado "+ex);
        }
        Iterator il=listaCob.listIterator();
        while(il.hasNext()){
            cob=(Cobradores)il.next();
            jComboBox1.addItem(cob.getNombre());
        }
        */
        jComboBox1.setName("jProveedores");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Incluye Factura?");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jTextField1.setEnabled(false);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel2.setText("Numero de Factura");

        jLabel3.setText("Monto");

        jTextField2.setEnabled(false);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jLabel4.setText("Ingrese cod de Barra");

        jTextField3.setToolTipText("presione enter para confirmar o F1 para consultar");
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        jLabel5.setText("Cantidad");

        jTextField4.setText("1.00");
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jButton1.setText("Guardar y Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nuevo Proveedor");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Precio");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });

        jLabel8.setText("Numero de Remto");

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });

        jLabel9.setText("equiv");

        jTextField7.setText("1.00");
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });

        jButton4.setText("Nuevo Articulo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Guardar Precio de Venta ?");

        jCheckBox4.setText("Paga?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField2)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox4))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox3))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText(" ");

        jButton3.setText("Eliminar Item");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           facturaProveedor.setNumero(this.jTextField1.getText());
           
           this.jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        Boolean factura=jCheckBox1.isSelected();
        if(factura){
        this.jTextField1.setEnabled(true);
        this.jTextField2.setEnabled(true);
        this.jTextField1.requestFocus();
        }else{           
        this.jTextField1.setEnabled(false);
        this.jTextField2.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Double monto=Double.parseDouble(this.jTextField2.getText());
            facturaProveedor.setMontoFinal(monto);
            this.jCheckBox4.setSelected(true);
            this.jTextField3.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
            if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            System.out.println("ENTRO CON EL ENTER¡¡¡¡¡¡");
            arti=new Articulos();
            Facturar fart=new Articulos();
            arti=(Articulos)fart.cargarPorCodigoDeBarra(jTextField3.getText());
            if(arti.getCodigoDeBarra().equals("")){
                
             jTextField3.setText("");   
            }else{
            jTextField3.setText(arti.getCodigoAsignado());
            //jTextField2.setText("1");
            this.jTextField5.setText(String.valueOf(arti.getPrecioDeCosto()));
            this.jTextField4.selectAll();
            this.jTextField4.requestFocus();
            }
        }
            if(evt.getKeyCode()==KeyEvent.VK_F1){
                cargarLista();
            }
        
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Double cantidad=Double.parseDouble(this.jTextField4.getText());
            arti.setCantidad(cantidad);
            //this.jTextField3.setText("");
            this.jTextField5.selectAll();
            this.jTextField5.requestFocus();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
            this.jTextField7.selectAll();
           this.jTextField7.requestFocus(); 
        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int posicion=this.jTable1.getSelectedRow();
        listadoArt.remove(posicion);
        //detalleDelPedido.clear();
        agregarRenglonTabla();
        this.jTextField3.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        DecimalFormat fr=new DecimalFormat("00");
        Calendar c1=Calendar.getInstance();
	Calendar c2=new GregorianCalendar();
	String dia=Integer.toString(c2.get(Calendar.DAY_OF_MONTH));
	String mes=Integer.toString(c2.get(Calendar.MONTH));
	String ano=Integer.toString(c2.get(Calendar.YEAR));
	
        int da=Integer.parseInt(dia);
        int me=Integer.parseInt(mes);
        me++;
        dia=fr.format(da);
        mes=fr.format(me);
        String fecha=dia+"/"+mes+"/"+ano;
        String fecha2=ano+"-"+mes+"-"+dia;
        
        Remitos comprobante=new Remitos();
        comprobante.setArticulos(listadoArt);
        comprobante.setGuardaPrecioDeVenta(this.jCheckBox3.isSelected());
        comprobante.setFechaComprobante(Date.valueOf(fecha2));
        comprobante.setFechaRecepcion(Date.valueOf(fecha2));
        if(facturaProveedor.getNumeroProveedor()==0){
           facturaProveedor.setNumeroProveedor(1);
           Personalizable per=new Proveedores();
           proveedor=(Proveedores) per.buscarPorNumero(1); 
        }
        comprobante.setIdProveedor(proveedor.getNumero());
        comprobante.setNumeroDeposito(Inicio.deposito.getNumero());
        String numRem="";
        if(this.jTextField6.getText().equals("")){
            numRem="0";
        }else{
            numRem=this.jTextField6.getText();
        }
       
        comprobante.setNumeroRemito(numRem);
        comprobante.setIdUsuario(Inicio.usuario.getNumero());
        Comprobable comp=new Remitos();
        Integer idRemito=0;
        idRemito=comp.nuevoComprobante(comprobante);
        if(this.jCheckBox1.isSelected()){
            
            facturaProveedor.setNombreProveedor(proveedor.getNombre());
            facturaProveedor.setNumeroProveedor(proveedor.getNumero());
            facturaProveedor.setFecha(Date.valueOf(fecha2));
            facturaProveedor.setIdRemito(idRemito);
            facturaProveedor.setIdCaja(Inicio.caja.getNumero());
            facturaProveedor.setIdUsuario(Inicio.usuario.getNumero());
            facturaProveedor.setIdSucursal(Inicio.sucursal.getNumero());
            Double monto=Double.parseDouble(this.jTextField2.getText());
            facturaProveedor.setMontoFinal(monto);
            Comprobable fac=new FacturaProveedor();
            Integer idFactura=0;
            idFactura=fac.nuevoComprobante(facturaProveedor);
            facturaProveedor.setId(idFactura);
            Facturar fact=new FacturaProveedor();
            if(this.jCheckBox4.isSelected()){
                
                facturaProveedor.setPagada(1);
                facturaProveedor.setFecha(Date.valueOf(fecha2));
                facturaProveedor.setIdCaja(Inicio.numeroCajaAdministradora);
                fact.guardar(facturaProveedor);
            }else{
                facturaProveedor.setPagada(0);
                facturaProveedor.setFecha(Date.valueOf(fecha2));
                facturaProveedor.setIdCaja(Inicio.numeroCajaAdministradora);
                fact.guardar(facturaProveedor);

            }
            
  
        }
            this.jTextField1.setText("");
            this.jTextField2.setText("");
            this.jTextField3.setText("");
            this.jTextField4.setText("1.00");
            this.jTextField5.setText("");
            this.jTextField6.setText("");
            this.jLabel7.setText("1.00");
            listadoArt.clear();
            agregarRenglonTabla();
            this.jTable1.removeAll();
            this.jTextField3.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        Proveedores prov=(Proveedores)listaProv.get(this.jComboBox1.getSelectedIndex());
        facturaProveedor.setNumeroProveedor(prov.getNumero());
        Personalizable per=new Proveedores();
        proveedor=(Proveedores) per.buscarPorNumero(facturaProveedor.getNumeroProveedor());
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.jTextField3.requestFocus();
        }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Double equiv=Double.parseDouble(this.jTextField7.getText());
            Double precio=Double.parseDouble(this.jTextField5.getText());
            Double cantidad=Double.parseDouble(this.jTextField4.getText());
            
            Double resultado=equiv * cantidad;
            arti.setCantidad(resultado);
            //precio=precio * arti.getRecargo();
            if(equiv > 1)precio=precio / equiv;
            //this.jTextField4.setText(String.valueOf(resultado));
            arti.setPrecioDeCosto(precio);
            precio=precio * arti.getRecargo();
            arti.setPrecioUnitario(precio);
            this.jTextField3.setText("");
            listadoArt.add(arti);
            
            agregarRenglonTabla();
            this.jTextField7.setText("1.00");
            this.jTextField4.setText("1.00");
            this.jTextField5.setText("");
            this.jTextField3.requestFocus();
        }
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ProveedoresAbm provA=new ProveedoresAbm();
        Inicio.jDesktopPane1.add(provA);
        provA.setVisible(true);
        provA.toFront();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        
        System.out.println("INGRESO AL TENER EL FOCO ");
    }//GEN-LAST:event_formFocusGained

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        recargarBox();
        System.out.println("INGRESO AL TENER EL shown 1");
    }//GEN-LAST:event_formComponentShown

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ArticulosMod articMo=new ArticulosMod();
        Inicio.jDesktopPane1.add(articMo);
        articMo.setVisible(true);
        articMo.toFront();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusLost
       int pos=this.jTable1.getSelectedRow();
       String montoMod=(String) this.jTable1.getValueAt(pos,4);
       System.out.println(" monto corregidoooooooooo "+montoMod);
       arti=(Articulos)listadoArt.get(pos);
       arti.setPrecioUnitario(Numeros.ConvertirStringADouble(montoMod));
    }//GEN-LAST:event_jTable1FocusLost
private void agregarRenglonTabla(){
        MiModeloTablaFacturacion busC=new MiModeloTablaFacturacion();
        this.jTable1.removeAll();
        Double montoTotal=0.00;
        //ArrayList listadoPedidos=new ArrayList();
        this.jTable1.setModel(busC);
        Articulos pedidos=arti;
        busC.addColumn("CODIGO");
        busC.addColumn("DESCRIPCION");
        busC.addColumn("CANTIDAD");
        busC.addColumn("PRECIO COSTO");
        busC.addColumn("PRECIO VTA");
        busC.addColumn("PRECIO VTA ACT.");
        busC.addColumn("STOCK ACT");
        Object[] fila=new Object[7];
        Iterator irP=listadoArt.listIterator();
        Double cost=0.00;
        while(irP.hasNext()){
            pedidos=(Articulos) irP.next();
            //fila[0]=pedidos.getCodigo();
            fila[0]=pedidos.getCodigoAsignado();
            fila[1]=pedidos.getDescripcionArticulo();
            fila[2]=pedidos.getCantidad();
            Double precioUnitario=1.00;
            Double valor=pedidos.getPrecioUnitario() * pedidos.getCantidad();
            System.err.println("precio neto "+pedidos.getPrecioUnitario());
            //precioUnitario= pedidos.getPrecioUnitario() * cliT.getCoeficienteListaDeprecios();
            //Double valor=(pedidos.getCantidad() * precioUnitario);
            //valor=valor * cliT.getCoeficienteListaDeprecios();
            montoTotal=montoTotal + valor;
            cost=(Double)pedidos.getPrecioDeCosto();
            fila[3]=Numeros.ConvertirNumero(cost);
            cost=pedidos.getPrecioUnitario();
            fila[4]=Numeros.ConvertirNumero(cost);
            Double cantTotal=0.00;
            cantTotal=pedidos.getStockActual()+pedidos.getCantidad();
            System.err.println(" actual "+pedidos.getStockActual()+" agregar "+pedidos.getCantidad()+" total "+cantTotal);
            cost=pedidos.getPrecioUnitarioNeto();
            fila[5]=Numeros.ConvertirNumero(cost);
            fila[6]=Numeros.ConvertirNumero(cantTotal);
            busC.addRow(fila);
        }
        String total=String.valueOf(montoTotal);
        this.jLabel7.setText("");
}
public void recargarBox(){
    //jComboBox1 = new javax.swing.JComboBox();
    jComboBox1.removeAllItems();
    Proveedores proveedor=new Proveedores();
    ArrayList listaProv=new ArrayList();
    Personalizable per=new Proveedores();
    listaProv=per.listar();
    Iterator ilProv=listaProv.listIterator();
    while(ilProv.hasNext()){
        proveedor=(Proveedores)ilProv.next();
        jComboBox1.addItem(proveedor.getNombre());
    }

}
private void cargarLista(){
    DefaultListModel modelo=new DefaultListModel();
    ArrayList lista=new ArrayList();
    Facturar fact=new Articulos();
    lista=fact.listadoBusqueda(this.jTextField3.getText());
    Iterator il=lista.listIterator();
    Articulos art=new Articulos();
    while(il.hasNext()){
        art=(Articulos)il.next();
        System.out.println("DESCRIPCION "+art.getDescripcionArticulo());
        modelo.addElement(art.getCodigoAsignado()+" "+art.getDescripcionArticulo());
    }
    ListadoDeArticulos listadoDeArticulos=new ListadoDeArticulos();
    listadoDeArticulos.jList1.setModel(modelo);
    listadoDeArticulos.setVisible(true);
    listadoDeArticulos.jList1.requestFocus();
    int posicion=listadoDeArticulos.jList1.getSelectedIndex();
    System.out.println(" POSICION LISTA "+posicion);
    this.jTextField3.setText("");
    arti=(Articulos)lista.get(posicion);
    jTextField3.setText(arti.getCodigoAsignado());
            //jTextField2.setText("1");
            this.jTextField5.setText(String.valueOf(arti.getPrecioDeCosto()));
            this.jTextField4.selectAll();
            this.jTextField4.requestFocus();
}
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
