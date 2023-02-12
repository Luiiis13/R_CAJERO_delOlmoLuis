package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.CajeroControlador;
/***
 * Clase que sirve para sacar la vista de los cajeros que hay con sus datos 
 * @author Luis
 *
 */
public class AdministrarCajerosListener  implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		CajeroControlador cajeroControlador = new CajeroControlador();
		cajeroControlador.inicializar();
		
	}

}
