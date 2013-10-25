/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversores;

import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author mauro
 */
public class Numeros {
    private static String doble;
    private static String flotante;
    private static String fecha;
    
    public static String ConvertirNumero(Double num){
        DecimalFormat formato=new DecimalFormat("####.#");
        doble=formato.format(num);
        return doble;
    }
    public static String ConvertirFecha(Date ff){
        
        
        return fecha;
    }
    public static Double ConvertirStringADouble(String num){
        num=num.replace(",",".");
        System.out.println(" rsultado "+num);
        Double dd=Double.parseDouble(num);
        return dd;
    }
}
