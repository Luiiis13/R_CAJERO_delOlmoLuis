package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.dao.BonobusDAO;
import modelo.dao.TarjetaDAO;
import modelo.dto.BonobusDTO;
import modelo.dto.TarjetaDTO;
import vista.AdministrarTarjetasFrame;
import vista.ModificarTarjetaAdministradorFrame;

/***
 * Clase que une las distintas funcionalidades de la base de datos con los distintos listeners 
 * @author Luis
 *
 */
public class TarjetasControlador {
	private AdministrarTarjetasFrame frame;
	private TarjetaDAO tarjetaDAO;

	public TarjetasControlador() {
		this.tarjetaDAO = new TarjetaDAO();
	}
	/***
	 * Metodo que sirve para crear la vista de administrar tarjeta 
	 */
	public void inicializar() {
		try {
			ArrayList<TarjetaDTO> tarjetasBD = this.tarjetaDAO.obtenerTarjetas();
			this.frame = new AdministrarTarjetasFrame();
			this.frame.getModelo().agregarDatosDeTabla(tarjetasBD);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/***
	 * Metodo que sirve para insertar una tarjeta en la base de datos
	 * 
	 * @param tarjetaDTO tarjeta que se insertara en la base de datos
	 * @throws Exception
	 */
	public void agregarTarjeta(TarjetaDTO tarjetaDTO) throws Exception {
		try {
			this.tarjetaDAO.insertarTarjeta(tarjetaDTO);
			BonobusDTO bonobusDTO = new BonobusDTO(0, 0, tarjetaDTO.getId());
			BonobusDAO bonobusDAO = new BonobusDAO();
			bonobusDAO.insertarbonobus(bonobusDTO);
		} catch (Exception e) {
			throw e;
		}

	}
	/***
	 * tarjeta que se eliminara de la base de datos
	 * 
	 * @param idTarjeta parametro de tipo entero que servira para identificar la
	 *                  tarjeta a eliminar
	 * @throws Exception
	 */
	public void eliminarTarjetas(int idTarjeta) throws Exception {
		this.tarjetaDAO.eliminarTarjeta(idTarjeta);
	}
	/***
	 * Metodo que sirve para actualizar los distintos datos de la tarjeta a la hora de
	 * modificarles
	 * 
	 * @param tarjetaDTO
	 */
	public void mostrarInterfazEdicion(TarjetaDTO tarjetaDTO) {
		ModificarTarjetaAdministradorFrame frameModificar = new ModificarTarjetaAdministradorFrame();
		frameModificar.setNumeroTxt(tarjetaDTO.getNumero());
		frameModificar.setCvvTxt(tarjetaDTO.getCvv());
		frameModificar.setPinTxt(tarjetaDTO.getPin());
		frameModificar.setBloqueadoTxt(tarjetaDTO.isBloqueado());
		frameModificar.setIdTarjeta(tarjetaDTO.getId());
		frameModificar.setIdCuentaAsociada(tarjetaDTO.getIdCuentaAsociada());
		frameModificar.setFechaExpiracionTxt(tarjetaDTO.getFecha_expiracion());
	}
	/***
	 * Metodo que sirve para actualizar una determinada tarjeta
	 * 
	 * @param tarjetaDTO
	 * @throws Exception
	 */
	public void actualizarTarjeta(TarjetaDTO tarjetaDTO) throws Exception {
		try {
			this.tarjetaDAO.actualizarTarjeta(tarjetaDTO);
		} catch (Exception e) {
			throw e;
		}

	}

}
