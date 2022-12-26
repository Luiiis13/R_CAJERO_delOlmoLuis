package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.dao.UsuarioDAO;
import modelo.dto.CuentaDTO;
import modelo.dto.MovimientoDTO;
import modelo.dto.UsuarioDTO;
import vista.AdministrarUsuariosFrame;
import vista.MovimientosFrame;

public class UsuariosControlador {
	private AdministrarUsuariosFrame frame;
	private UsuarioDAO usuarioDAO;
	public UsuariosControlador() {
		this.usuarioDAO=new UsuarioDAO();
		this.inicializar();
	}
	private void inicializar() {
		try {
			ArrayList<UsuarioDTO> usuariosBD=this.usuarioDAO.obtenerUsuarios();
			this.frame = new AdministrarUsuariosFrame();
			this.frame.getModelo().agregarDatosDeTabla(usuariosBD);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
