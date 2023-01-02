package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.PantallaInicioAdminControlador;

public class InicioSesionAdministradorListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		PantallaInicioAdminControlador adminControlador = new PantallaInicioAdminControlador();

	}

}
