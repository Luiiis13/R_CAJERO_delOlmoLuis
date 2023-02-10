package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import listeners.MostrarEdicionCajerosListener;
import modelo.dao.CajeroDAO;
import modelo.dao.CuentaDAO;
import modelo.dto.CajeroDTO;
import modelo.dto.CuentaDTO;
import modelo.tabla.CajeroFila;
import vista.AdministrarCajerosFrame;
import vista.AdministrarCuentasFrame;
import vista.ModificarCajerosAdministradorFrame;

public class CajeroControlador {
	private AdministrarCajerosFrame frame;
	private CajeroDAO cajeroDAO;

	public CajeroControlador() {
		this.cajeroDAO = new CajeroDAO();

	}

	public void inicializar() {
		try {
			ArrayList<CajeroDTO> cuentasBD = this.cajeroDAO.obtenerCajeros();
			this.frame = new AdministrarCajerosFrame();
			this.frame.getModelo().agregarDatosDeTabla(cuentasBD);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void insertarCajero(CajeroDTO cajeroDTO) throws Exception {
		this.cajeroDAO.insertarCajero(cajeroDTO);
	}
	
	public void eliminarCajero(int idCajero) throws Exception {
		this.cajeroDAO.eliminarCajero(idCajero);
	}
	public void mostrarInterfazEdicion(CajeroDTO cajeroDTO) {
		ModificarCajerosAdministradorFrame frameModificar=new ModificarCajerosAdministradorFrame();
		frameModificar.setUbicacion(cajeroDTO.getUbicacion());
		frameModificar.setIdCajero(cajeroDTO.getId());
	}
	public void actualizarCajero(CajeroDTO cajeroDTO) throws Exception {
		this.cajeroDAO.actualizarCajero(cajeroDTO);
	}
}
