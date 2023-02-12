package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.dao.CuentaDAO;
import modelo.dto.CuentaDTO;
import vista.AdministrarCuentasFrame;
import vista.ModificarCuentaAdministradorFrame;
/***
 * Clase que une las distintas funcionalidades de la base de datos con los
 * distintos listeners
 * 
 * @author Luis
 *
 */
public class CuentasControlador {
	private AdministrarCuentasFrame frame;
	private CuentaDAO cuentaDAO;

	public CuentasControlador() {
		this.cuentaDAO = new CuentaDAO();
	}
	/***
	 * Metodo que sirve para inicializar el frame de administrar las cuentas 
	 *  
	 */
	public void inicializar() {
		try {
			ArrayList<CuentaDTO> cuentasBD = this.cuentaDAO.obtenerCuentas();
			this.frame = new AdministrarCuentasFrame();
			this.frame.getModelo().agregarDatosDeTabla(cuentasBD);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
/***
 * Metodo que sirve para obtener una determinada cuenta 
 * @param numero
 * @return
 */
	public CuentaDTO obtenerCuentaDadoNumero(String numero) {
		return this.cuentaDAO.obtenerCuentaDadoNumero(numero);
	}
	/***
	 * Metodo que sirve para insertar una cuenta en la base de datos 
	 * @param cuentaDTO
	 * @throws Exception
	 */
	public void insertarCuenta(CuentaDTO cuentaDTO) throws Exception {
		this.cuentaDAO.insertarCuenta(cuentaDTO);
	}
	/***
	 * Metodo que sirve para eliminar una determinada cuenta de la base de datos 
	 * @param idCuenta
	 * @throws Exception
	 */
	public void eliminarCuenta(int idCuenta) throws Exception {
		this.cuentaDAO.eliminarCuenta(idCuenta);
	}
	/***
	 * Metodo que sirve para actualizar los distintos datos de la cuenta a la hora de
	 * modificarles
	 * 
	 * @param cuentaDTO
	 */
	public void mostrarInterfazEdicion(CuentaDTO cuentaDTO) {
		ModificarCuentaAdministradorFrame frameModificar = new ModificarCuentaAdministradorFrame();
		frameModificar.setNumeroTxt(cuentaDTO.getNumero());
		frameModificar.setIbanTxt(cuentaDTO.getIban());
		frameModificar.setSaldoTxt(cuentaDTO.getSaldo());
		frameModificar.setId_usuarioTxt(cuentaDTO.getId_usuario());
		frameModificar.setIdCuenta(cuentaDTO.getId());
	}
	/***
	 * Metodo que sirve para actualizar una determinada cuenta
	 * 
	 * @param cuentaDTO
	 * @throws Exception
	 */
	public void actualizarCuenta(CuentaDTO cuentaDTO) throws Exception {
		this.cuentaDAO.actualizarCuenta(cuentaDTO);
	}

}
