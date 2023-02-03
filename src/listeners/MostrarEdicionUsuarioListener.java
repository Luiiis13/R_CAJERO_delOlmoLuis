package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.CajeroControlador;
import controlador.UsuariosControlador;
import modelo.dto.CajeroDTO;
import modelo.dto.UsuarioDTO;
import modelo.tabla.CajeroFila;
import modelo.tabla.UsuarioFila;
import vista.AdministrarCajerosFrame;
import vista.AdministrarUsuariosFrame;

public class MostrarEdicionUsuarioListener implements ActionListener{
	private AdministrarUsuariosFrame modificarUsuariosFrame;

	public MostrarEdicionUsuarioListener(AdministrarUsuariosFrame frame) {
		this.modificarUsuariosFrame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ArrayList<UsuarioFila> arrayUsuario = this.modificarUsuariosFrame.getModelo().getDatos();
			ArrayList<UsuarioFila> usuariosSeleccionados = new ArrayList<>();
			for (int i = 0; i < arrayUsuario.size(); i++) {
				UsuarioFila filaUsuario = arrayUsuario.get(i);
				if (filaUsuario.isSeleccionable() == true) {
					usuariosSeleccionados.add(filaUsuario);
				}
			}
			if (usuariosSeleccionados.size() > 1) {
				JOptionPane.showMessageDialog(null, "Error debe seleccionar solamente un usuario", "Error", JOptionPane.ERROR_MESSAGE);
			}
			if(usuariosSeleccionados.size()==1) {
				UsuarioFila filaUsuario= usuariosSeleccionados.get(0);
				UsuariosControlador controladorUsuarios = new UsuariosControlador();
				UsuarioDTO usuarioDTO = new UsuarioDTO(filaUsuario.getId(),filaUsuario.getNombre(), filaUsuario.getDni(),filaUsuario.getPrimerApellido(),filaUsuario.getIsAdmin(),filaUsuario.getContraseña());
				controladorUsuarios.mostrarInterfazEdicion(usuarioDTO);
			}
			if(usuariosSeleccionados.size()==0) {
				JOptionPane.showMessageDialog(null, "Error debe seleccionar un usuario", "Error", JOptionPane.ERROR_MESSAGE);

			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}


}
