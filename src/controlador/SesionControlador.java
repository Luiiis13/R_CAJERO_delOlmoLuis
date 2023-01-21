package controlador;

import listeners.SesionListener;
import modelo.dao.SesionDAO;
import modelo.dto.CuentaDTO;
import modelo.dto.TarjetaDTO;
import modelo.dto.UsuarioDTO;
import vista.Sesion;

/***
 * Clase que tiene como atributos staticos los diferentes datos para poder
 * llamarlos desde otras clases y que cuando das al boton de comenzar se cierra
 * la pantalla inicial y crea un nuevo frame de la clase sesion.
 * 
 * @author Luis
 *
 */
public class SesionControlador {
	private Sesion sesionVista = new Sesion();
	private SesionDAO sesionDAO = new SesionDAO();
	private SesionListener listener;
	public static TarjetaDTO datosTarjeta;
	public static CuentaDTO datosCuenta;
	public static UsuarioDTO datosUsuario;
	public static int intentosFallidos = 0;

	public SesionControlador() {
		this.inicializarListener();
	}

	/***
	 * Metodo que sirve para llamar a esas clases y asi crear la vista y una vez se
	 * ha creado el frame un listener que llama a la logica para poder validar si
	 * estan bien los campos de la clase sesion
	 */
	private void inicializarListener() {
		this.listener = new SesionListener(this.sesionDAO, this.sesionVista);
		this.sesionVista.getValidarbtn().addActionListener(this.listener);
	}
}
