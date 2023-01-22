package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.SesionAdministradorControlador;
import vista.PantallaInicioAdministradorFrame;

public class SesionAdministradorListener implements ActionListener {
	private SesionAdministradorControlador sesionAdministradorControlador = new SesionAdministradorControlador();
	private PantallaInicioAdministradorFrame administradorFrame;

	public SesionAdministradorListener(PantallaInicioAdministradorFrame frame) {
		this.administradorFrame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String dni = this.administradorFrame.getDniTxt().getText();
			String contraseña = this.administradorFrame.getContraseñaField().getText();
			boolean sesionValida = this.sesionAdministradorControlador.validarSesionAdministrador(dni, contraseña);
			if (sesionValida == true) {
				JOptionPane.showMessageDialog(null, "Credenciales válidas");
				this.administradorFrame.setVisible(false);
				this.sesionAdministradorControlador.mostrarOpcionesAdministrador();
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
