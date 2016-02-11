
package interfaces;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauro
 */
public interface Visibles {
    public DefaultComboBoxModel ListadoCombo(ArrayList componentes);
    public DefaultListModel ListadoEnList(ArrayList componentes);
    public DefaultTableModel ListadoEnTabla(ArrayList componentes,ArrayList encabezadosColumnas,String formatoTabla);
}
