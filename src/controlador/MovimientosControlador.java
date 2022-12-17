package controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dto.CuentaDTO;
import vista.MovimientosFrame;

public class MovimientosControlador {
	private MovimientosFrame frame;
	private CuentaDAO cuentaDAO;
	private MovimientoDAO movimientoDAO;

	public MovimientosControlador() {

		this.movimientoDAO = new MovimientoDAO();
		this.cuentaDAO = new CuentaDAO();
		this.inicializar();
	}

	private void inicializar() {
		try {
			int idCuenta = SesionControlador.datosCuenta.getId();
			CuentaDTO cuentaDTO = cuentaDAO.obtenerCuenta(idCuenta);
			this.frame = new MovimientosFrame();
			String textolblSaldo = this.frame.getSaldolbl().getText();
			textolblSaldo += cuentaDTO.getSaldo() + "€";
			this.frame.getSaldolbl().setText(textolblSaldo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
