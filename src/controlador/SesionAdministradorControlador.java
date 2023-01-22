package controlador;

import javax.swing.JOptionPane;

import modelo.dao.SesionDAO;
import modelo.dto.SesionAdministradorDTO;
import vista.AdministradorMenuFrame;

public class SesionAdministradorControlador {
	private SesionDAO sesionDAO = new SesionDAO();
	public static SesionAdministradorDTO sesionAdminDTO;

	public SesionAdministradorControlador() {

	}

	public boolean validarSesionAdministrador(String dni, String contrase�a) {
		boolean valido = false;
		SesionAdministradorDTO sesionAdminDTO = this.sesionDAO.verificarSesionAdministrador(dni);
		if (sesionAdminDTO.getId() == 0) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operaci�n: No existe ning�n usuario con ese dni",
					"Error", JOptionPane.ERROR_MESSAGE);
			return valido;
		}
		if (sesionAdminDTO.getContrase�a().equalsIgnoreCase(contrase�a)==false ) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operaci�n: credenciales no v�lidas", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido;
		}
		SesionAdministradorControlador.sesionAdminDTO = sesionAdminDTO;// Para acceder desde otras clases
		valido = true;
		return valido;
	}
	public void mostrarOpcionesAdministrador() {
		AdministradorMenuFrame frameMenu=new AdministradorMenuFrame();
	}

}
