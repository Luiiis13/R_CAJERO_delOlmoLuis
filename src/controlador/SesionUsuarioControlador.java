package controlador;

import listeners.SesionTarjetaListener;
import modelo.dao.SesionDAO;
import modelo.dto.CuentaDTO;
import modelo.dto.TarjetaDTO;
import modelo.dto.UsuarioDTO;
import vista.SesionTarjetaFrame;

/***
 * Clase que tiene como atributos staticos los diferentes datos para poder
 * llamarlos desde otras clases y que cuando das al boton de comenzar se cierra
 * la pantalla inicial y crea un nuevo frame de la clase sesion.
 * 
 * @author Luis
 *
 */
public class SesionUsuarioControlador {
	private SesionTarjetaFrame sesionVista = new SesionTarjetaFrame();
	private SesionDAO sesionDAO = new SesionDAO();
	private SesionTarjetaListener listener;
	public static TarjetaDTO datosTarjeta;
	public static CuentaDTO datosCuenta;
	public static int intentosFallidos = 0;

	public SesionUsuarioControlador() {
		this.inicializarListener();
	}

	/***
	 * Metodo que sirve para llamar a esas clases y asi crear la vista y una vez se
	 * ha creado el frame un listener que llama a la logica para poder validar si
	 * estan bien los campos de la clase sesion
	 */
	private void inicializarListener() {
		this.listener = new SesionTarjetaListener(this.sesionDAO, this.sesionVista);
		this.sesionVista.getValidarbtn().addActionListener(this.listener);
	}
}
