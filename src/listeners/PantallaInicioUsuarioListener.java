package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.SesionTarjetaControlador;
import vista.PantallaInicioFrame;
/***
 * Clase que implementa la llamada de un action listener del boton comenzar de la clase PantallaInicioFrame 
 * Se le pasa el frame en el que estabamos para que pueda ponerse invisible 
 * El actionPerformed crea un nuevo objeto de SesionControlador
 * @author Luis
 *
 */
public class PantallaInicioUsuarioListener implements ActionListener {

	private PantallaInicioFrame frame;

	public PantallaInicioUsuarioListener(PantallaInicioFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SesionTarjetaControlador sesionControlador = new SesionTarjetaControlador();
		this.frame.setVisible(false);
	}

}
