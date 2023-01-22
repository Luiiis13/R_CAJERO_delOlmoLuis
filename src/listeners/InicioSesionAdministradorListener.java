package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.PantallaInicioAdminControlador;
import vista.PantallaInicioFrame;

public class InicioSesionAdministradorListener implements ActionListener {
	private PantallaInicioFrame inicio;

	public InicioSesionAdministradorListener(PantallaInicioFrame frame) {
		this.inicio = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PantallaInicioAdminControlador adminControlador = new PantallaInicioAdminControlador();
		this.inicio.setVisible(false);
	}

}
