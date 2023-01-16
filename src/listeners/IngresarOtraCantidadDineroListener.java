package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.SesionControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dto.MovimientoDTO;
import vista.IngresarOtraCantidadFrame;

public class IngresarOtraCantidadDineroListener implements ActionListener {
	private IngresarOtraCantidadFrame otraCantidadFrame;
	private int ingresoUsuario;

	public IngresarOtraCantidadDineroListener(IngresarOtraCantidadFrame frame) {
		this.otraCantidadFrame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.ingresoUsuario = Integer.parseInt(this.otraCantidadFrame.getCantidadSpinner().getValue().toString());
		boolean ingresoValido = this.validarIngreso();
		if (ingresoValido == false) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación. Debe introducir una cantidad mayor que 0 y múltiplo de 5", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			float saldoActual = SesionControlador.datosCuenta.getSaldo();
			float saldoTotalIngresado = (saldoActual + this.ingresoUsuario);
			try {
				SesionControlador.datosCuenta.setSaldo(saldoTotalIngresado);
				CuentaDAO cuentaDAO = new CuentaDAO();
				cuentaDAO.actualizarCuenta(SesionControlador.datosCuenta);
				MovimientoDAO movimientoDAO = new MovimientoDAO();
				long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
				MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Ingreso de dinero",
						SesionControlador.datosTarjeta.getId());
				movimientoDAO.insertarMovimiento(movimientoDTO);
				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			} catch (Exception error) {
				SesionControlador.datosCuenta.setSaldo(saldoActual);
				JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.print(error);
			} finally {
				this.otraCantidadFrame.show(false);

			}
		}
	}

	private boolean validarIngreso() {
		boolean valido = false;
		if (this.ingresoUsuario > 0 && this.ingresoUsuario % 5 == 0) {
			valido = true;
		}

		return valido;
	}
}
