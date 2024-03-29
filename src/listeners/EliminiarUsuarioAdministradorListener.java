package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.UsuariosControlador;
import modelo.tabla.UsuarioFila;
import vista.AdministrarUsuariosFrame;

/***
 * Clase que sirve para eliminar un determinado usuario
 * 
 * @author Luis
 *
 */
public class EliminiarUsuarioAdministradorListener implements ActionListener {
	private AdministrarUsuariosFrame eliminarUsuariosFrame;

	public EliminiarUsuarioAdministradorListener(AdministrarUsuariosFrame frame) {
		this.eliminarUsuariosFrame = frame;
	}

	/***
	 * Accion que obtiene el/los usuarios a eliminar con sus datos y se muestra un
	 * panel de confirmacion y si acepta se elimina al usuario
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			ArrayList<UsuarioFila> arrayUsuario = this.eliminarUsuariosFrame.getModelo().getDatos();
			ArrayList<UsuarioFila> usuariosSeleccionados = new ArrayList<>();
			for (int i = 0; i < arrayUsuario.size(); i++) {
				UsuarioFila filaUsuario = arrayUsuario.get(i);
				if (filaUsuario.isSeleccionable() == true) {
					usuariosSeleccionados.add(filaUsuario);
				}
			}
			if (usuariosSeleccionados.size() > 0) {
				int confirmado = JOptionPane.showConfirmDialog(this.eliminarUsuariosFrame,
						"�Est� seguro que desea eliminar los usuarios?");
				if (JOptionPane.OK_OPTION == confirmado) {
					this.eliminarUsuariosFrame.setVisible(false);
					this.eliminarUsuarios(usuariosSeleccionados);
					JOptionPane.showMessageDialog(null, "Usuarios eliminados correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Operaci�n cancelada");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Error debe seleccionar un usuario", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error haciendo la operaci�n", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/***
	 * Metodo que sirve para recoger el usuario determinado y eliminarlo
	 * 
	 * @param usuariosSeleccionados parametro para recoger el usuario
	 * @throws Exception
	 */
	private void eliminarUsuarios(ArrayList<UsuarioFila> usuariosSeleccionados) throws Exception {
		UsuariosControlador controladorUsuarios = new UsuariosControlador();
		for (int i = 0; i < usuariosSeleccionados.size(); i++) {
			UsuarioFila filaUsuario = usuariosSeleccionados.get(i);
			int idUsuario = filaUsuario.getId();
			controladorUsuarios.eliminarUsuarios(idUsuario);
		}
	}
}
