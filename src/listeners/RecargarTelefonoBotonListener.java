package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.RecargarTelefonoFrame;
/***
 * Clase que saca la vista del frame de recargar otra cantidad 
 * @author Luis
 *
 */
public class RecargarTelefonoBotonListener implements ActionListener {
	private RecargarTelefonoFrame telefonoFrame;

	@Override
	public void actionPerformed(ActionEvent e) {
		this.telefonoFrame = new RecargarTelefonoFrame();
	}

}
