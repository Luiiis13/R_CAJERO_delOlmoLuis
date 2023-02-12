package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.TarjetasControlador;
/***
 * Clase que sirve para sacar la vista de las tarjetas que hay con sus datos 
 * @author Luis
 *
 */
public class AdministrarTarjetasListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		TarjetasControlador tarjetasControlador = new TarjetasControlador();
		tarjetasControlador.inicializar();
	}

}
