package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.dao.CajeroDAO;
import modelo.dto.CajeroDTO;
import vista.AdministrarCajerosFrame;
import vista.ModificarCajerosAdministradorFrame;
/***
 * Clase que une las distintas funcionalidades de la base de datos con los distintos listeners 
 * @author Luis
 *
 */
public class CajeroControlador {
	private AdministrarCajerosFrame frame;
	private CajeroDAO cajeroDAO;

	public CajeroControlador() {
		this.cajeroDAO = new CajeroDAO();
	}
	/***
	 * Metodo que sirve para inicializar el frame de administrar las cajero 
	 *  
	 */
	public void inicializar() {
		try {
			ArrayList<CajeroDTO> cuentasBD = this.cajeroDAO.obtenerCajeros();
			this.frame = new AdministrarCajerosFrame();
			this.frame.getModelo().agregarDatosDeTabla(cuentasBD);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	/***
	 * Metodo que sirve para insertar un cajero en la base de datos 
	 * @param cajeroDTO
	 * @throws Exception
	 */
	public void insertarCajero(CajeroDTO cajeroDTO) throws Exception {
		this.cajeroDAO.insertarCajero(cajeroDTO);
	}
	/***
	 * Metodo que sirve para eliminar un determinado cajero de la base de datos 
	 * @param idCajero
	 * @throws Exception
	 */
	public void eliminarCajero(int idCajero) throws Exception {
		this.cajeroDAO.eliminarCajero(idCajero);
	}
	/***
	 * Metodo que sirve para actualizar los distintos datos de un cajero a la hora de
	 * modificarles
	 * 
	 * @param cajeroDTO
	 */
	public void mostrarInterfazEdicion(CajeroDTO cajeroDTO) {
		ModificarCajerosAdministradorFrame frameModificar=new ModificarCajerosAdministradorFrame();
		frameModificar.setUbicacion(cajeroDTO.getUbicacion());
		frameModificar.setIdCajero(cajeroDTO.getId());
	}
	/***
	 * Metodo que sirve para actualizar un determinado cajero
	 * 
	 * @param cajeroDTO
	 * @throws Exception
	 */
	public void actualizarCajero(CajeroDTO cajeroDTO) throws Exception {
		this.cajeroDAO.actualizarCajero(cajeroDTO);
	}
}
