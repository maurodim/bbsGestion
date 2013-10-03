/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesPrograma;

import java.util.ArrayList;

/**
 *
 * @author mauro
 */
public interface Cajeables {
    public Object AbrirCaja(Object caja);
    public Boolean CerrarCaja(Object caja);
    public Double SaldoDeCaja(ArrayList listadoBilletes);
    public Boolean NuevoMovimiento(Object factura);
    public Object ModificarMovimiento(Integer idMovimiento);
    public Boolean EliminarMovimiento(Integer idMovimiento);
    public Object ArquearCaja(Object caja);
}
