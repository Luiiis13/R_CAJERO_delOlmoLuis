package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.dao.CuentaDAO;
import modelo.dto.CuentaDTO;
import modelo.dto.TarjetaDTO;
import vista.AdministrarCuentasFrame;
import vista.ModificarCuentaAdministradorFrame;
import vista.ModificarTarjetaAdministradorFrame;

public class CuentasControlador {
	private AdministrarCuentasFrame frame;
	private CuentaDAO cuentaDAO;

	public CuentasControlador() {
		this.cuentaDAO = new CuentaDAO();
	
	}

	public void inicializar() {
		try {
			ArrayList<CuentaDTO> cuentasBD = this.cuentaDAO.obtenerCuentas();
			this.frame = new AdministrarCuentasFrame();
			this.frame.getModelo().agregarDatosDeTabla(cuentasBD);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public CuentaDTO obtenerCuentaDadoNumero(String numero) {
		return this.cuentaDAO.obtenerCuentaDadoNumero(numero);
	}
	public void insertarCuenta(CuentaDTO cuentaDTO) throws Exception {
		this.cuentaDAO.insertarCuenta(cuentaDTO);
	}
	public void eliminarCuenta(int idCuenta) throws Exception {
		this.cuentaDAO.eliminarCuenta(idCuenta);
	}
	public void mostrarInterfazEdicion(CuentaDTO cuentaDTO) {
		ModificarCuentaAdministradorFrame frameModificar = new ModificarCuentaAdministradorFrame();
		frameModificar.setNumeroTxt(cuentaDTO.getNumero());
		frameModificar.setIbanTxt(cuentaDTO.getIban());
		frameModificar.setSaldoTxt(cuentaDTO.getSaldo());
		frameModificar.setId_usuarioTxt(cuentaDTO.getId_usuario());
		frameModificar.setIdCuenta(cuentaDTO.getId());
	}

	public void actualizarCuenta(CuentaDTO cuentaDTO) throws Exception {
		this.cuentaDAO.actualizarCuenta(cuentaDTO);
	}

}
