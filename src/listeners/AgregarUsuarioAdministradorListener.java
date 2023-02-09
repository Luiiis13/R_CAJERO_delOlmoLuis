package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.UsuariosControlador;
import modelo.dto.UsuarioDTO;
import vista.InsertarUsuarioAdministradorFrame;

public class AgregarUsuarioAdministradorListener implements ActionListener {
	private InsertarUsuarioAdministradorFrame insertarUsuarioFrame;

	public AgregarUsuarioAdministradorListener(InsertarUsuarioAdministradorFrame frame) {
		this.insertarUsuarioFrame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			boolean valido = this.validar();
			if (valido == true) {
				String nombre = this.insertarUsuarioFrame.getNombreTxt().getText();
				String dni = this.insertarUsuarioFrame.getDniTxt().getText();
				String primerApellido = this.insertarUsuarioFrame.getPrimerApellidoTxt().getText();
				String contraseña = this.insertarUsuarioFrame.getContraseñaField().getText();
				boolean isAdmin = this.insertarUsuarioFrame.getIsAdmin().isSelected();
				UsuarioDTO usuarioDTO = new UsuarioDTO(0, nombre, dni, primerApellido, isAdmin, contraseña);
				new UsuariosControlador().insertar(usuarioDTO);
				JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");
				this.insertarUsuarioFrame.show(false);
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private boolean validar() {
		boolean valido = true;
		String dni = this.insertarUsuarioFrame.getDniTxt().getText();
		if (dni.length() < 9) {
			valido = false;
			JOptionPane.showMessageDialog(null, "Error el dni tiene que tener 9 carácteres", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido;
		}
		String contraseña = this.insertarUsuarioFrame.getContraseñaField().getText();
		if (contraseña.length() < 9) {
			valido = false;
			JOptionPane.showMessageDialog(null, "Error la contraseña tiene que tener 9 carácteres", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido;
		}

		return valido;
	}

}
