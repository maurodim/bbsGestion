package Impresiones;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sucursales.Cajas;
import interfaceGraficas.Inicio;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.imageio.ImageIO;




/**
 *
 * @author hernan
 */
public class Impresora {

    Font fuente = new Font("Arial", Font.PLAIN, 9);
    Font fuente1=new Font("Arial",Font.BOLD,16);
    Font fuente3 = new Font("Arial", Font.PLAIN, 7);
    Font fuente4 = new Font("Arial", Font.BOLD,7);
    Font fuente5=new Font("Arial",Font.PLAIN,16);
    Font fuente6 = new Font("Arial", Font.BOLD, 9);
    Font fuente7=new Font("Sans Serif", Font.BOLD,7);
    Font fuente8=new Font("Arial",Font.PLAIN,8);
    Font fuente9 = new Font("Arial", Font.BOLD, 5);
    Font fuente10 = new Font("Arial", Font.PLAIN, 6);
	PrintJob pj;	
	Graphics pagina;
	

	/********************************************************************
	*	A continuación el constructor de la clase. Aquí lo único que	*
	*	hago es tomar un objeto de impresion.							*
	********************************************************************/
	public Impresora()
	{
		pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
               
	}
			
	/********************************************************************
	*	A continuación el método "imprimir(String)", el encargado de 	*
	*	colocar en el objeto gráfico la cadena que se le pasa como 		*
	*	parámetro y se imprime.											*
	********************************************************************/
        

    
    public void ImprimirRetiroDeEfectivo(Object factura) throws IOException{
        Cajas caja=(Cajas) factura;
        Calendar fecha=new GregorianCalendar();
        int dia=fecha.get(Calendar.DAY_OF_MONTH);
        int mes=fecha.get(Calendar.MONTH);
        mes++;
        int ano=fecha.get(Calendar.YEAR);
        int hora=fecha.get(Calendar.HOUR_OF_DAY);
        int minuto=fecha.get(Calendar.MINUTE);
        int segundo=fecha.get(Calendar.SECOND);
        String fec=dia+"/"+mes+"/"+ano;
        String hrs=hora+","+minuto+":"+segundo;
        // formulario izquierdo
        
        pagina = pj.getGraphics();
        try{
        BufferedImage imagen= ImageIO.read(new File("C://Gestion//imagen//logo.png"));
        pagina.drawImage(imagen,63,20,174,93,null);
        pagina.setFont(fuente6);
        pagina.setColor(Color.black);
        pagina.drawString("COMPROBANTE N° 00"+Inicio.sucursal.getNumero()+"-000"+caja.getNumeroDeComprobante(),20,130);
        pagina.setFont(fuente);
        pagina.drawString("FECHA :"+fec, 20,140);
        pagina.drawString("SUCURSAL :"+Inicio.sucursal.getDescripcion(),20,150);
        pagina.drawString("CAJERO :"+Inicio.usuario.getNombre(),20,160);
        pagina.setFont(fuente6);
        Double monto=caja.getMontoMovimiento()* -1;
        pagina.drawString("MONTO : $ "+monto,20,190);
        pagina.setFont(fuente);
        pagina.drawString("CAJA N°: "+Inicio.caja.getNumero(),20,200);
        pagina.drawString("HORA :"+hrs,20,210);
        pagina.setFont(fuente1);
        pagina.drawString("RETIRO DE EFECTIVO ", 50,280);
        //formulario derecho
        
        pagina.drawImage(imagen,363,20,174,93,null);
        pagina.setFont(fuente6);
        pagina.setColor(Color.black);
        pagina.drawString("COMPROBANTE N° 00"+Inicio.sucursal.getNumero()+"-000"+caja.getNumeroDeComprobante(),320,130);
        pagina.setFont(fuente);
        pagina.drawString("FECHA :"+fec, 320,140);
        pagina.drawString("SUCURSAL :"+Inicio.sucursal.getDescripcion(),320,150);
        pagina.drawString("CAJERO :"+Inicio.usuario.getNombre(),320,160);
        pagina.setFont(fuente6);
        pagina.drawString("MONTO : $ "+monto,320,190);
        pagina.setFont(fuente);
        pagina.drawString("CAJA N°: "+Inicio.caja.getNumero(),320,200);
        pagina.drawString("HORA :"+hrs,320,210);
        pagina.setFont(fuente1);
        pagina.drawString("RETIRO DE EFECTIVO ", 350,280);
        
        
        pagina.dispose();
        pj.end();
        }catch(Exception e)
	{
		System.out.println("LA IMPRESION HA SIDO CANCELADA..."+e);
	}

    }
    public void ImprimirCierreDeCaja(ArrayList listado){
        Calendar fecha=new GregorianCalendar();
        int dia=fecha.get(Calendar.DAY_OF_MONTH);
        int mes=fecha.get(Calendar.MONTH);
        mes++;
        int ano=fecha.get(Calendar.YEAR);
        int hora=fecha.get(Calendar.HOUR_OF_DAY);
        int minuto=fecha.get(Calendar.MINUTE);
        int segundo=fecha.get(Calendar.SECOND);
        String fec=dia+"/"+mes+"/"+ano;
        String hrs=hora+","+minuto+":"+segundo;
        // formulario izquierdo
        
        pagina = pj.getGraphics();
        try{
        pagina.setFont(fuente7);
        pagina.drawString("CIERRE DE CAJA ", 150,10);
        pagina.setFont(fuente3);
        pagina.setColor(Color.black);
        pagina.drawString("FECHA :"+fec, 20,30);
        pagina.drawString("SUCURSAL :"+Inicio.sucursal.getDescripcion(),170,30);
        pagina.drawString("CAJERO :"+Inicio.usuario.getNombre(),20,40);
        pagina.drawString("CAJA N°: "+Inicio.caja.getNumero(),170,40);
        pagina.drawString("HORA :"+hrs,250,40);
        pagina.setFont(fuente7);
        pagina.drawString("DETALLE", 20, 50);
        pagina.setFont(fuente10);
        int renglon=50;
        Double totalVentas=0.00;
        Double totalGtos=0.00;
        Double saldoInicial=0.00;
        Double totalRetiros=0.00;
        Double saldoCaja=0.00;
        Double pagoProveedores=0.00;
        Iterator it=listado.listIterator();
        while(it.hasNext()){
            Cajas caja=(Cajas)it.next();
            switch (caja.getTipoMovimiento()){
                case 1:
                    totalVentas=totalVentas + caja.getMontoMovimiento();
                    break;
                case 4:
                    totalRetiros=totalRetiros + caja.getMontoMovimiento();
                    break;
                case 11:
                    pagoProveedores=pagoProveedores + caja.getMontoMovimiento();
                    break;
                case 12:
                    totalGtos=totalGtos + caja.getMontoMovimiento();
                    break;
                case 10:
                    saldoCaja=saldoCaja + caja.getMontoMovimiento();
                    break;
                case 9:
                    saldoInicial=saldoInicial + caja.getMontoMovimiento();
                    break;
                default:
                    break;
            }
            if(caja.getTipoMovimiento()==1){
                
            }else{
            renglon=renglon + 10;
            pagina.drawString(caja.getNumeroDeComprobante()+" - "+caja.getDescripcionMovimiento()+" $"+caja.getMontoMovimiento(),20,renglon);
            }
        }
        pagina.setFont(fuente);
        pagina.drawString("SALDO INICIAL : $"+saldoInicial,320,50);
        pagina.drawString("TOTAL VENTAS : $"+totalVentas,320,60);
        pagina.drawString("TOTAL GASTOS : $"+totalGtos,320,70);
        pagina.drawString("TOTAL RETIROS EFECTIVO : $"+totalRetiros, 320, 80);
        pagina.drawString("TOTAL PAGO A PROVEEDORES : $"+pagoProveedores,320,90);
        pagina.drawString("SALDO DE CAJA : $"+saldoCaja,320,100);
        Double saldo=saldoInicial +totalVentas +totalGtos +pagoProveedores + saldoCaja+totalRetiros;
        pagina.setFont(fuente6);
        pagina.drawString("QUEDA EN CAJA : $"+saldo, 320,120);
        
        
        
        
        
        
        pagina.dispose();
        pj.end();
        }catch(Exception e)
	{
		System.out.println("LA IMPRESION HA SIDO CANCELADA..."+e);
	}
    }
    
					
}//FIN DE LA CLASE Impresora

 

