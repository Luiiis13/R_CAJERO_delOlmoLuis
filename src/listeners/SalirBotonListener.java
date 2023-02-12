package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * Clase que sirve para cerrar la aplicación
 * 
 * @author Luis
 *
 */
public class SalirBotonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
