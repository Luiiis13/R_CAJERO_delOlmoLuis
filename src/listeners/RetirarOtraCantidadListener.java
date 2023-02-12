package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.ExtraerDineroPrincipalFrame;
import vista.ExtraerOtraCantidadDineroFrame;

/***
 * Clase que sirve para abrir la vista de retirar otra cantidad
 * 
 * @author Luis
 *
 */
public class RetirarOtraCantidadListener implements ActionListener {
	private ExtraerDineroPrincipalFrame frame;
	public RetirarOtraCantidadListener(ExtraerDineroPrincipalFrame frame) {
		this.frame=frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ExtraerOtraCantidadDineroFrame extraerDinero = new ExtraerOtraCantidadDineroFrame();
		this.frame.setVisible(false);
	}

}
