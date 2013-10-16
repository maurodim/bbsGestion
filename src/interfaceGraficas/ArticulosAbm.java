/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGraficas;

import interfacesPrograma.Facturar;
import java.util.ArrayList;
import java.util.Iterator;
import objetos.Articulos;
import tablas.MiModeloTablaArticulos;

/**
 *
 * @author mauro
 */
public class ArticulosAbm extends javax.swing.JInternalFrame {
    private ArrayList listadoA=new ArrayList();
    
    /**
     * Creates new form ArticulosAbm
     */
    public ArticulosAbm() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Alta, Baja y modificacion de Articulos");

        MiModeloTablaArticulos modelArticulos=new MiModeloTablaArticulos();
        Facturar fact=new Articulos();
        listadoA=fact.listadoBusqueda("");
        Iterator list=listadoA.listIterator();
        jTable1.setModel(modelArticulos);
        modelArticulos.addColumn("CODIGO");
        modelArticulos.addColumn("DESCRIPCION");
        modelArticulos.addColumn("STOCK");
        modelArticulos.addColumn("STOCK MIN");
        modelArticulos.addColumn("COSTO");
        modelArticulos.addColumn("P. VENTA");
        modelArticulos.addColumn("SERVICIO");
        Object[] fila=new Object[7];
        while(list.hasNext()){
            Articulos articulos=(Articulos)list.next();
            fila[0]=articulos.getCodigoAsignado();
            fila[1]=articulos.getDescripcionArticulo();
            fila[2]=articulos.getStockActual();
            fila[3]=articulos.getStockMinimo();
            fila[4]=articulos.getPrecioDeCosto();
            fila[5]=articulos.getPrecioUnitarioNeto();
            fila[6]=articulos.getPrecioServicio();
            modelArticulos.addRow(fila);
        }
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Nuevo Articulo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar Articulo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Alertas");

        jButton4.setText("Modificar Articulo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Articulos articulo=(Articulos)listadoA.get(this.jTable1.getSelectedRow());
        System.out.println(" codigo elegido "+articulo.getCodigoAsignado());
        ArticulosMod articM=new ArticulosMod(articulo);
        Inicio.jDesktopPane1.add(articM);
        articM.setVisible(true);
        articM.toFront();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         Articulos articulo=(Articulos)listadoA.get(this.jTable1.getSelectedRow());
         // pasar le valor de inhabilitado de 0 a 1
         listadoA.remove(this.jTable1.getSelectedRow());
         agregarRenglon();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArticulosMod articMo=new ArticulosMod();
        Inicio.jDesktopPane1.add(articMo);
        articMo.setVisible(true);
        articMo.toFront();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void agregarRenglon(){
        MiModeloTablaArticulos busC=new MiModeloTablaArticulos();
        this.jTable1.removeAll();
        Double montoTotal=0.00;
        //ArrayList listadoPedidos=new ArrayList();
        this.jTable1.setModel(busC);
        Articulos pedidos=null;
        busC.addColumn("CODIGO");
        busC.addColumn("DESCRIPCION");
        busC.addColumn("STOCK");
        busC.addColumn("STOCK MIN");
        busC.addColumn("COSTO");
        busC.addColumn("P VENTA");
        busC.addColumn("SERVICIO");
        Object[] fila=new Object[7];
        Iterator irP=listadoA.listIterator();
        while(irP.hasNext()){
            pedidos=(Articulos) irP.next();
            //fila[0]=pedidos.getCodigo();
            fila[0]=pedidos.getCodigoAsignado();
            fila[1]=pedidos.getDescripcionArticulo();
            fila[2]=pedidos.getStockActual();
            fila[3]=pedidos.getStockMinimo();
            fila[4]=pedidos.getPrecioDeCosto();
            fila[5]=pedidos.getPrecioUnitarioNeto();
            fila[6]=pedidos.getPrecioServicio();
            busC.addRow(fila);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
