package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.UsuariosControlador;
import modelo.dto.UsuarioDTO;
import vista.InsertarUsuarioAdministradorFrame;
/***
 * Clase que sirve para agregar un nuevo usuario a la base de datos 
 * @author Luis
 *
 */
public class AgregarUsuarioAdministradorListener implements ActionListener {
	private InsertarUsuarioAdministradorFrame insertarUsuarioFrame;

	public AgregarUsuarioAdministradorListener(InsertarUsuarioAdministradorFrame frame) {
		this.insertarUsuarioFrame = frame;
	}
/***
 * Accion que sirve para ingresar los distintos datos de un usuario y posteriormente confirmar su inserccion 
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			boolean valido = this.validar();
			if (valido == true) {
				String nombre = this.insertarUsuarioFrame.getNombreTxt().getText();
				String dni = this.insertarUsuarioFrame.getDniTxt().getText();
				String primerApellido = this.insertarUsuarioFrame.getPrimerApellidoTxt().getText();
				String contrase�a = this.insertarUsuarioFrame.getContrase�aField().getText();
				boolean isAdmin = this.insertarUsuarioFrame.getIsAdmin().isSelected();
				UsuarioDTO usuarioDTO = new UsuarioDTO(0, nombre, dni, primerApellido, isAdmin, contrase�a);
				new UsuariosControlador().insertar(usuarioDTO);
				JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");
				this.insertarUsuarioFrame.show(false);
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
/***
 * Metodo que sirve para validar que los campos rellenados son validos 
 * @return 
 */ 
	private boolean validar() {
		boolean valido = true;
		String dni = this.insertarUsuarioFrame.getDniTxt().getText();
		if (dni.length() < 9) {
			valido = false;
			JOptionPane.showMessageDialog(null, "Error el dni tiene que tener 9 car�cteres", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido;
		}
		String contrase�a = this.insertarUsuarioFrame.getContrase�aField().getText();
		if (contrase�a.length() < 9) {
			valido = false;
			JOptionPane.showMessageDialog(null, "Error la contrase�a tiene que tener 9 car�cteres", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido;
		}

		return valido;
	}

}
