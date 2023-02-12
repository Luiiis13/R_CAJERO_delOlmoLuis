package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.ExtraerDineroPrincipalFrame;
/***
 * Clase que sirve para extraer la vista del frame de extraer dinero 
 * @author Luis
 *
 */
public class ExtraerDineroOpcionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		ExtraerDineroPrincipalFrame retirarDinero = new ExtraerDineroPrincipalFrame();
	}

}
