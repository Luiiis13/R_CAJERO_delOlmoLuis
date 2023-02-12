package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.UsuariosControlador;
import modelo.dto.UsuarioDTO;
import vista.ModificarUsuariosAdministradorFrame;

/***
 * Clase que sirve para editar los datos de un usuario y actualizarlo
 * 
 * @author Luis
 *
 */
public class EditarUsuariosAdministradorListener implements ActionListener {
	private ModificarUsuariosAdministradorFrame editarUsuariosFrame;

	public EditarUsuariosAdministradorListener(ModificarUsuariosAdministradorFrame frame) {
		this.editarUsuariosFrame = frame;
	}

	/***
	 * Accion que sirve para actualizar los datos del usuario a modificar
	 */
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
				String contrase�a = this.editarUsuariosFrame.getContrase�aField().getText();
				boolean esAdmin = this.editarUsuariosFrame.getIsAdmin().isSelected();
				UsuarioDTO usuarioDTO = new UsuarioDTO(idUsuario, nombreUsuario, dni, primerApellido, esAdmin,
						contrase�a);
				controladorUsuario.actualizarUsuario(usuarioDTO);
				JOptionPane.showMessageDialog(null, "Operaci�n realizada correctamente");
				this.editarUsuariosFrame.limpiarCampos();
				this.editarUsuariosFrame.setVisible(false);
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operaci�n", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}
	}

	/***
	 * Metodo que sirve para validar que los datos a insertar en los campos son
	 * correctos
	 * 
	 * @return devuelve un booleano
	 */
	private boolean validar() {
		boolean valido = true;
		String dni = this.editarUsuariosFrame.getDniTxt().getText();
		if (dni.length() < 9) {
			valido = false;
			JOptionPane.showMessageDialog(null, "Error el dni tiene que tener 9 car�cteres", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido;
		}
		String contrase�a = this.editarUsuariosFrame.getContrase�aField().getText();
		if (contrase�a.length() < 9) {
			valido = false;
			JOptionPane.showMessageDialog(null, "Error la contrase�a tiene que tener 9 car�cteres", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido;
		}

		return valido;
	}
}
