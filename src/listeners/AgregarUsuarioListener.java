package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.UsuariosControlador;
import modelo.dto.UsuarioDTO;
import vista.InsertarAdministradorUsuarioFrame;

public class AgregarUsuarioListener implements ActionListener {
	private InsertarAdministradorUsuarioFrame insertarUsuarioFrame;

	public AgregarUsuarioListener(InsertarAdministradorUsuarioFrame frame) {
		this.insertarUsuarioFrame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String nombre = this.insertarUsuarioFrame.getNombreTxt().getText();
			int edad = Integer.parseInt(this.insertarUsuarioFrame.getEdadTxt().getText());
			String primerApellido = this.insertarUsuarioFrame.getPrimerApellidoTxt().getText();
			String contraseña = this.insertarUsuarioFrame.getContraseñaField().getText();
			boolean isAdmin = this.insertarUsuarioFrame.getIsAdmin().isSelected();
			UsuarioDTO usuarioDTO = new UsuarioDTO(0, nombre, edad, primerApellido, isAdmin, contraseña);
			new UsuariosControlador().insertar(usuarioDTO);
			JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");
			this.insertarUsuarioFrame.show(false);

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
