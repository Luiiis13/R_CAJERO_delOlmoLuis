package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.CambiarNumeroSecretoFrame;
/***
 * Clase que saca la vista de la opción cambiar numero secreto  
 * @author Luis
 *
 */
public class CambiarNumeroSecretoOpcionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		CambiarNumeroSecretoFrame cambiarNumero = new CambiarNumeroSecretoFrame();
	}
}
