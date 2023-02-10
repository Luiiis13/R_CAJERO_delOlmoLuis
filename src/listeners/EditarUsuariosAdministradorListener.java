package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.UsuariosControlador;
import modelo.dto.UsuarioDTO;
import vista.ModificarUsuariosAdministradorFrame;

public class EditarUsuariosAdministradorListener implements ActionListener {
	private ModificarUsuariosAdministradorFrame editarUsuariosFrame;

	public EditarUsuariosAdministradorListener(ModificarUsuariosAdministradorFrame frame) {
		this.editarUsuariosFrame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			boolean valido = this.validar();
			if (valido == true) {
				UsuariosControlador controladorUsuario = new UsuariosControlador();
				int idUsuario = this.editarUsuariosFrame.getIdUsuario();
				String nombreUsuario = this.editarUsuariosFrame.getNombreTxt().getText();
				String dni = this.editarUsuariosFrame.getDniTxt().getText();
				String primerApellido = this.editarUsuariosFrame.getPrimerApellidoTxt().getText();
				String contraseña = this.editarUsuariosFrame.getContraseñaField().getText();
				boolean esAdmin = this.editarUsuariosFrame.getIsAdmin().isSelected();
				UsuarioDTO usuarioDTO = new UsuarioDTO(idUsuario, nombreUsuario, dni, primerApellido, esAdmin,
						contraseña);
				controladorUsuario.actualizarUsuario(usuarioDTO);
				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
				this.editarUsuariosFrame.limpiarCampos();
				this.editarUsuariosFrame.setVisible(false);
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}
	}

	private boolean validar() {
		boolean valido = true;
		String dni = this.editarUsuariosFrame.getDniTxt().getText();
		if (dni.length() < 9) {
			valido = false;
			JOptionPane.showMessageDialog(null, "Error el dni tiene que tener 9 carácteres", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido;
		}
		String contraseña = this.editarUsuariosFrame.getContraseñaField().getText();
		if (contraseña.length() < 9) {
			valido = false;
			JOptionPane.showMessageDialog(null, "Error la contraseña tiene que tener 9 carácteres", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido;
		}

		return valido;
	}
}
