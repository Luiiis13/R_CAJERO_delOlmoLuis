package controlador;

import listeners.SesionListener;
import modelo.dao.SesionDAO;
import modelo.dto.CuentaDTO;
import modelo.dto.TarjetaDTO;
import modelo.dto.UsuarioDTO;
import vista.Sesion;

public class SesionControlador {
	private Sesion sesionVista = new Sesion();
	private SesionDAO sesionDAO = new SesionDAO();
	private SesionListener listener;
	public static TarjetaDTO datosTarjeta;
	public static CuentaDTO datosCuenta;
	public static UsuarioDTO datosUsuario;


	public SesionControlador() {

		this.inicializarListener();
	}

	private void inicializarListener() {

		this.listener = new SesionListener(this.sesionDAO, this.sesionVista);
		this.sesionVista.getAceptarbtn().addActionListener(this.listener);

	}
}
