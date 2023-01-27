package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.dao.CuentaDAO;
import modelo.dto.CuentaDTO;
import vista.AdministrarCuentasFrame;

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
	public void insertarCuenta(CuentaDTO cuentaDTO) {
		this.cuentaDAO.insertarCuenta(cuentaDTO);
	}
}
