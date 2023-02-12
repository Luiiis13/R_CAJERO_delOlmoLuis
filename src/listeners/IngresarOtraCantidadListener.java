package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.IngresarDineroPrincipalFrame;
import vista.IngresarOtraCantidadFrame;
/***
 * Clase que sirve para sacar la vista del frame para sacar otra cantidad 
 * @author Luis
 *
 */
public class IngresarOtraCantidadListener implements ActionListener{
private IngresarDineroPrincipalFrame dineroFrame;
public IngresarOtraCantidadListener(IngresarDineroPrincipalFrame frame) {
	this.dineroFrame=frame;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		IngresarOtraCantidadFrame ingresarDinero = new IngresarOtraCantidadFrame();
		this.dineroFrame.setVisible(false);
	}
}
