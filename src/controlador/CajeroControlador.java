package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.dao.CajeroDAO;
import modelo.dao.CuentaDAO;
import modelo.dto.CajeroDTO;
import modelo.dto.CuentaDTO;
import vista.AdministrarCajerosFrame;
import vista.AdministrarCuentasFrame;

public class CajeroControlador {
	private AdministrarCajerosFrame frame;
	private CajeroDAO cajeroDAO;
public CajeroControlador() {
	this.cajeroDAO=new CajeroDAO();
	this.inicializar();
	}
private void inicializar() {
	try {
		ArrayList<CajeroDTO> cuentasBD=this.cajeroDAO.obtenerCajeros();
		this.frame = new AdministrarCajerosFrame();
		this.frame.getModelo().agregarDatosDeTabla(cuentasBD);
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
}
