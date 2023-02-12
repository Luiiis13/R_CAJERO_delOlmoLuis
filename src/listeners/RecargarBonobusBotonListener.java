package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.RecargarBonobusFrame;
/***
 * Clase que saca la vista del frame con las opciones de recargar el bonobus 
 * @author Luis
 *
 */
public class RecargarBonobusBotonListener implements ActionListener {
	private RecargarBonobusFrame bonobusFrame;

	@Override
	public void actionPerformed(ActionEvent e) {
		bonobusFrame = new RecargarBonobusFrame();
		
	}

}
