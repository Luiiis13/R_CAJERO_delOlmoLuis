package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.dao.UsuarioDAO;

import modelo.dto.UsuarioDTO;
import vista.AdministrarUsuariosFrame;
import vista.ModificarUsuariosAdministradorFrame;

/***
 * Clase que une las distintas funcionalidades de la base de datos con los
 * distintos listeners
 * 
 * @author Luis
 *
 */
public class UsuariosControlador {
	private AdministrarUsuariosFrame frame;
	private UsuarioDAO usuarioDAO;

	public UsuariosControlador() {
		this.usuarioDAO = new UsuarioDAO();

	}

	/***
	 * Metodo que sirve para crear la vista de administrar usuarios
	 */
	public void inicializar() {
		try {
			ArrayList<UsuarioDTO> usuariosBD = this.usuarioDAO.obtenerUsuarios();
			this.frame = new AdministrarUsuariosFrame();
			this.frame.getModelo().agregarDatosDeTabla(usuariosBD);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/***
	 * Metodo que sirve para insertar un usuario en la base de datos
	 * 
	 * @param nuevoUsuario usuario que se insertara en la base de datos
	 * @throws Exception
	 */
	public void insertar(UsuarioDTO nuevoUsuario) throws Exception {
		this.usuarioDAO.insertarUsuario(nuevoUsuario);
	}

	/***
	 * Usuario que se eliminara de la base de datos
	 * 
	 * @param idUsuario parametro de tipo entero que servira para identificar el
	 *                  usuario a eliminar
	 * @throws Exception
	 */
	public void eliminarUsuarios(int idUsuario) throws Exception {
		this.usuarioDAO.eliminarUsuario(idUsuario);
	}

	/***
	 * Metodo que sirve para actualizar los distintos datos del usuario a la hora de
	 * modificarles
	 * 
	 * @param usuarioDTO
	 */
	public void mostrarInterfazEdicion(UsuarioDTO usuarioDTO) {
		ModificarUsuariosAdministradorFrame frameModificar = new ModificarUsuariosAdministradorFrame();
		frameModificar.setContraseñaField(usuarioDTO.getContraseña());
		frameModificar.setNombreTxt(usuarioDTO.getNombre());
		frameModificar.setDniTxt(usuarioDTO.getDni());
		frameModificar.setPrimerApellidoTxt(usuarioDTO.getPrimerApellido());
		frameModificar.setIsAdmin(usuarioDTO.getEsAdmin());
		frameModificar.setIdUsuario(usuarioDTO.getId());
	}

	/***
	 * Metodo que sirve para actualizar un determinado usuario
	 * 
	 * @param usuarioDTO
	 * @throws Exception
	 */
	public void actualizarUsuario(UsuarioDTO usuarioDTO) throws Exception {
		this.usuarioDAO.actualizarUsuario(usuarioDTO);
	}
}
