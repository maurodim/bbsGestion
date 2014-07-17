/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGraficas;

import Compras.FacturaProveedor;
import Compras.Proveedores;
import Conversores.Numeros;
import Sucursales.Cajas;
import facturacion.clientes.ClientesTango;
import interfaces.Adeudable;
import interfaces.Personalizable;
import interfacesPrograma.Busquedas;
import interfacesPrograma.Cajeables;
import interfacesPrograma.Facturar;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import objetos.Articulos;
import objetos.Comprobantes;
import objetos.Operaciones;
import tablas.MiModeloTablaArticulos;

/**
 *
 * @author mauro
 */
public class CajaAbm extends javax.swing.JInternalFrame {
    private static Double totalVentas;
    private static Double totalGastos;
    private static Double totalEfect;
    private ArrayList listadoP;
    private Integer operacionSelect=0;
    /**
     * Creates new form CajaAbm
     */
    public CajaAbm() {
        Cajeables caj=new Cajas();
        Inicio.caja=(Cajas) caj.ArquearCaja(Inicio.caja);
        
        initComponents();
        this.jLabel5.setText("Saldo Inicial de Caja:"+Inicio.caja.getSaldoInicial());
        //this.jLabel8.setText("Total Efect en Caja :"+Inicio.caja.getSaldoFinal());
    }
    private void AgregarRenglonTabla(){
        this.jTable1.removeAll();
        MiModeloTablaArticulos tablaCaja=new MiModeloTablaArticulos();
        this.jPanel2.setVisible(false);
        Iterator itC=Cajas.getListadoCajas().listIterator();
        totalVentas=0.00;
        totalGastos=0.00;
        totalEfect=0.00;
        Cajas cajj=new Cajas();
        jTable1.setModel(tablaCaja);
        tablaCaja.addColumn("COMPROBANTE");
        tablaCaja.addColumn("MOVIMIENTO");
        tablaCaja.addColumn("MONTO");
        Object[] fila=new Object[3];
        while(itC.hasNext()){
            cajj=(Cajas)itC.next();
            fila[0]=cajj.getNumeroDeComprobante();
            fila[1]=cajj.getDescripcionMovimiento();
            if(cajj.getTipoMovimiento()==1 || cajj.getTipoMovimiento()==7 || cajj.getTipoMovimiento()==13){
            totalVentas=totalVentas + cajj.getMontoMovimiento();
            }else{
            if(cajj.getTipoMovimiento()==9){
                //totalVentas=totalVentas + cajj.getMontoMovimiento();
            }else{

                totalGastos=totalGastos + cajj.getMontoMovimiento();
            }
        }

            fila[2]=cajj.getMontoMovimiento();
            tablaCaja.addRow(fila);
        }
        ModificarLabels();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CAJA");

        MiModeloTablaArticulos tablaCaja=new MiModeloTablaArticulos();
        this.jPanel2.setVisible(false);
        Iterator itC=Cajas.getListadoCajas().listIterator();
        totalVentas=0.00;
        totalGastos=0.00;
        totalEfect=0.00;
        Cajas cajj=new Cajas();
        tablaCaja.addColumn("COMPROBANTE");
        tablaCaja.addColumn("MOVIMIENTO");
        tablaCaja.addColumn("MONTO");
        Object[] fila=new Object[3];
        while(itC.hasNext()){
            cajj=(Cajas)itC.next();
            fila[0]=cajj.getNumeroDeComprobante();
            fila[1]=cajj.getDescripcionMovimiento();
            if(cajj.getTipoMovimiento()==1 || cajj.getTipoMovimiento()==7 || cajj.getTipoMovimiento()==13){
                totalVentas=totalVentas + cajj.getMontoMovimiento();
            }else{
                if(cajj.getTipoMovimiento()==9){

                }else{

                    totalGastos=totalGastos + cajj.getMontoMovimiento();
                }
            }

            fila[2]=cajj.getMontoMovimiento();
            tablaCaja.addRow(fila);
        }
        ModificarLabels();
        jTable1.setModel(tablaCaja);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Seleccione Operacion");

        Iterator ilT=Inicio.caja.getListadoOperaciones().listIterator();
        Operaciones operaciones=null;
        while(ilT.hasNext()){
            operaciones=(Operaciones)ilT.next();
            jComboBox1.addItem(operaciones.getDescripcion());
        }
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jButton2.setText("Guardar Movimiento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel5.setText("Saldo Inicial de Caja:");

        jLabel6.setText("Total Ventas");

        jLabel7.setText("Total Gastos :");

        jLabel8.setText("Total Efect en Caja:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        //this.jPanel2.setVisible(true);
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        
        
        //AgregarRenglonTabla();
        //ModificarLabels();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
       
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
         int posicion=this.jComboBox2.getSelectedIndex();
        switch (operacionSelect){
            case 11:
                Proveedores fact=new Proveedores();
                fact=(Proveedores)listadoP.get(posicion);
                this.jTextField1.setText(String.valueOf(fact.getSaldo()));
                break;
            case 13:
                ClientesTango cliente=new ClientesTango();
                cliente=(ClientesTango)listadoP.get(posicion);
                this.jTextField1.setText(String.valueOf(cliente.getSaldo()));
                break;
            default:
                
                break;
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        this.jPanel2.setVisible(true);
        int posicion=this.jComboBox1.getSelectedIndex();
        Operaciones operaciones=(Operaciones)Inicio.caja.getListadoOperaciones().get(posicion);
        switch(operaciones.getId()){
            case 11:
                ListarProveedores();
                break;
            case 13:
                ListarClientes();
                break;
            default:
                 Inicio.caja.setTipoMovimiento(operaciones.getId());  
                 operacionSelect=operaciones.getId();
                 OtrosMovimientos();
                break;
        }
        operacionSelect=operaciones.getId();
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Cajeables caj=new Cajas();
       Double monto=0.00;
        switch(operacionSelect){
           case 11:
               FacturaProveedor fact=new FacturaProveedor();
               Adeudable ade=new FacturaProveedor();
               Proveedores prov=new Proveedores();
               //Personalizable ade=new Proveedores();
               prov=(Proveedores)listadoP.get(this.jComboBox2.getSelectedIndex());
               fact.setNombreProveedor(prov.getNombre());
            fact.setNumeroProveedor(prov.getNumero());
            fact.setFecha(Date.valueOf(Inicio.fechaDia));
            //fact.setIdRemito(idRemito);
            fact.setIdCaja(Inicio.caja.getNumero());
            fact.setIdUsuario(Inicio.usuario.getNumero());
            fact.setIdSucursal(Inicio.sucursal.getNumero());
            String mmt=this.jTextField1.getText();
            Double montot=Double.parseDouble(this.jTextField1.getText());
            montot=montot * -1;
            fact.setMontoFinal(montot);
               ade.PagarComprobante(fact);
               listadoP.clear();
               operacionSelect=0;
               this.jPanel2.setVisible(false);
                //AgregarRenglonTabla();
                //ModificarLabels();
           case 13:
               Comprobantes comprobantes=new Comprobantes();
               Adeudable adeu=new ClientesTango();
               ClientesTango cliente=new ClientesTango();
               cliente=(ClientesTango)listadoP.get(this.jComboBox2.getSelectedIndex());
               comprobantes.setCliente(cliente);
               comprobantes.setMontoTotal(Double.parseDouble(this.jTextField1.getText()));
               comprobantes.setFechaEmision(Date.valueOf(Inicio.fechaDia));
               adeu.PagarComprobante(comprobantes);
                            listadoP.clear();
               operacionSelect=0;
               this.jPanel2.setVisible(false);
                //AgregarRenglonTabla();
               break;
           case 12:
               monto=Numeros.ConvertirStringADouble(String.valueOf(this.jTextField1.getText()));
               Inicio.caja.setDescripcionMovimiento(this.jTextField2.getText());
               Inicio.caja.setMontoMovimiento(monto);
               
               caj.NuevoGasto(Inicio.caja);
               break;
           case 4:
               monto=Numeros.ConvertirStringADouble(String.valueOf(this.jTextField1.getText()));
               Inicio.caja.setMontoMovimiento(monto);
               
               caj.NuevoGasto(Inicio.caja);
               break;
           case 7:
               monto=Numeros.ConvertirStringADouble(String.valueOf(this.jTextField1.getText()));
               Inicio.caja.setMontoMovimiento(monto);
               
               caj.NuevoMovimiento(Inicio.caja);
               break;
           case 9:
               monto=Numeros.ConvertirStringADouble(String.valueOf(this.jTextField1.getText()));
               Inicio.caja.setMontoMovimiento(monto);
               
               caj.NuevoMovimiento(Inicio.caja);
               break;
       }
        AgregarRenglonTabla();
        this.jTextField2.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        cargarLista();
    }//GEN-LAST:event_jTable1MouseClicked
    private void ModificarLabels(){
        this.jLabel6.setText("T. INGRESOS "+totalVentas);
    this.jLabel7.setText("T. EGRESOS "+totalGastos);
    totalEfect=Inicio.caja.getSaldoInicial()+totalVentas + totalGastos;
    this.jLabel8.setText("T. EFECT EN CAJA "+totalEfect);
    }
    private void ListarProveedores(){
        Proveedores fact=new Proveedores();
        listadoP=new ArrayList();
        //Adeudable ade=new FacturaProveedor();
        Personalizable ade=new Proveedores();
        listadoP=ade.listar();
        Iterator ilP=listadoP.listIterator();
        while(ilP.hasNext()){
            fact=(Proveedores)ilP.next();
            this.jComboBox2.addItem(fact.getNombre());
        }
        this.jLabel2.setText("Seleccione Proveedor");
        this.jLabel3.setText("Monto Adeudado");
        this.jButton2.setText("PAGAR");
        this.jLabel4.setVisible(false);
        this.jTextField2.setVisible(false);
    }
    private void ListarClientes(){
      ClientesTango fact=new ClientesTango();
        listadoP=new ArrayList();
        //Adeudable ade=new FacturaProveedor();
        Busquedas ade=new ClientesTango();
        listadoP=ade.listar("");
        Iterator ilP=listadoP.listIterator();
        while(ilP.hasNext()){
            fact=(ClientesTango)ilP.next();
            this.jComboBox2.addItem(fact.getRazonSocial());
        }
        this.jLabel2.setText("Seleccione Proveedor");
        this.jLabel3.setText("Monto Adeudado");
        this.jButton2.setText("PAGAR");
        this.jLabel4.setVisible(false);
        this.jTextField2.setVisible(false); 
    }
    private void cargarLista(){
    DefaultListModel modelo=new DefaultListModel();
    //ArrayList lista=new ArrayList();
    Cajeables cajea=new Cajas();
   
    //lista=Cajas.getListadoCajas();
    int posic=this.jTable1.getSelectedRow();
    Cajas caaj=new Cajas();
    caaj=(Cajas)Cajas.getListadoCajas().get(posic);
    modelo=cajea.LeerComprobante(caaj.getNumeroDeComprobante(),caaj.getTipoDeComprobante(),caaj.getTipoMovimiento());
    
    ListadoComprobantes listadoDeArticulos=new ListadoComprobantes(caaj.getNumeroDeComprobante(),caaj.getTipoMovimiento(),caaj.getTipoDeComprobante());
    listadoDeArticulos.jList1.setModel(modelo);
    listadoDeArticulos.setVisible(true);
    int posicion=listadoDeArticulos.jList1.getSelectedIndex();
    
    }
    private void OtrosMovimientos(){
        //System.err.println("operacion elegida :"+operacionSelect);
        this.jLabel2.setVisible(false);
        this.jComboBox2.setVisible(false);
        this.jLabel3.setText("MONTO");
        if(operacionSelect==12){
        this.jLabel4.setText("MOTIVO");
        this.jLabel4.setVisible(true);
        this.jTextField2.setVisible(true);
        }else{
            this.jLabel4.setVisible(false);
            this.jTextField2.setVisible(false);
        }
        
        this.jButton2.setText("GUARDAR MOVIMIENTO");
        this.jTextField1.requestFocus();
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
