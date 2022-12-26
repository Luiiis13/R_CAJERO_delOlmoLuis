package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.SesionControlador;
import vista.PantallaInicioFrame;

public class PantallaInicioListener implements ActionListener {

	private PantallaInicioFrame frame;

	public PantallaInicioListener(PantallaInicioFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SesionControlador sesionControlador = new SesionControlador();
		this.frame.setVisible(false);
	}

}
