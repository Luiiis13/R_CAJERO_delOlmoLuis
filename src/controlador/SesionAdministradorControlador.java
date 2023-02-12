package controlador;

import javax.swing.JOptionPane;

import modelo.dao.SesionDAO;
import modelo.dto.SesionAdministradorDTO;
import vista.AdministradorMenuFrame;
/***
 * Clase que une las distintas funcionalidades de la base de datos con los distintos listeners 
 * @author Luis
 *
 */
public class SesionAdministradorControlador {
	private SesionDAO sesionDAO = new SesionDAO();
	public static SesionAdministradorDTO sesionAdminDTO;

	public SesionAdministradorControlador() {

	}
/***
 * metodo que sirve para verificar que los datos para iniciar la sesion como administrador son correctos 
 * @param dni
 * @param contraseña
 * @return
 */
	public boolean validarSesionAdministrador(String dni, String contraseña) {
		boolean valido = false;
		SesionAdministradorDTO sesionAdminDTO = this.sesionDAO.verificarSesionAdministrador(dni);
		if (sesionAdminDTO.getId() == 0) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación: No existe ningún usuario con ese dni",
					"Error", JOptionPane.ERROR_MESSAGE);
			return valido;
		}
		if (sesionAdminDTO.getContraseña().equalsIgnoreCase(contraseña)==false ) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación: credenciales no válidas", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido;
		}
		SesionAdministradorControlador.sesionAdminDTO = sesionAdminDTO;// Para acceder desde otras clases
		valido = true;
		return valido;
	}
	/***
	 * Metodo que sirve para mostrar las distintas opciones de administrador 
	 */
	public void mostrarOpcionesAdministrador() {
		AdministradorMenuFrame frameMenu=new AdministradorMenuFrame();
	}

}
