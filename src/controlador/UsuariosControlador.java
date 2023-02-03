package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;

import modelo.dao.UsuarioDAO;
import modelo.dto.CajeroDTO;
import modelo.dto.CuentaDTO;
import modelo.dto.MovimientoDTO;
import modelo.dto.UsuarioDTO;
import vista.AdministrarUsuariosFrame;
import vista.ModificarCajerosAdministradorFrame;
import vista.ModificarUsuariosAdministradorFrame;
import vista.MovimientosFrame;

public class UsuariosControlador {
	private AdministrarUsuariosFrame frame;
	private UsuarioDAO usuarioDAO;

	public UsuariosControlador() {
		this.usuarioDAO = new UsuarioDAO();

	}

	public void inicializar() {
		try {
			ArrayList<UsuarioDTO> usuariosBD = this.usuarioDAO.obtenerUsuarios();
			this.frame = new AdministrarUsuariosFrame();
			this.frame.getModelo().agregarDatosDeTabla(usuariosBD);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void insertar(UsuarioDTO nuevoUsuario) {
		this.usuarioDAO.insertarUsuario(nuevoUsuario);
	}

	public void eliminarUsuarios(int idUsuario) {
		this.usuarioDAO.eliminarUsuario(idUsuario);
	}

	public void mostrarInterfazEdicion(UsuarioDTO usuarioDTO) {
		ModificarUsuariosAdministradorFrame frameModificar = new ModificarUsuariosAdministradorFrame();
		frameModificar.setContraseñaField(usuarioDTO.getContraseña());
		frameModificar.setNombreTxt(usuarioDTO.getNombre());
		frameModificar.setDniTxt(usuarioDTO.getDni());
		frameModificar.setPrimerApellidoTxt(usuarioDTO.getPrimerApellido());
		frameModificar.setIsAdmin(usuarioDTO.getEsAdmin());
	}
}
