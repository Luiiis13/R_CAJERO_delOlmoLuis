package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.CajeroControlador;
import controlador.UsuariosControlador;
import modelo.tabla.CajeroFila;
import modelo.tabla.UsuarioFila;
import vista.AdministrarCajerosFrame;
import vista.AdministrarUsuariosFrame;

public class EliminiarUsuarioAdministradorListener implements ActionListener{
	private AdministrarUsuariosFrame eliminarUsuariosFrame;

	public EliminiarUsuarioAdministradorListener(AdministrarUsuariosFrame frame) {
				this.eliminarUsuariosFrame = frame;
	}

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
						"¿Está seguro que desea eliminar los usuarios?");
				if (JOptionPane.OK_OPTION == confirmado) {
					this.eliminarCajeros(usuariosSeleccionados);
					JOptionPane.showMessageDialog(null, "Usuarios eliminados correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Operación cancelada");
				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void eliminarCajeros(ArrayList<UsuarioFila> usuariosSeleccionados) {
		UsuariosControlador controladorUsuarios = new UsuariosControlador();
		for (int i = 0; i < usuariosSeleccionados.size(); i++) {
			UsuarioFila filaUsuario = usuariosSeleccionados.get(i);
			int idUsuario = filaUsuario.getId();
			controladorUsuarios.eliminarUsuarios(idUsuario);
		}
	}
}

