package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.SesionControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dto.MovimientoDTO;

public class IngresarCantidadDineroListener implements ActionListener {
	private int ingreso;

	public IngresarCantidadDineroListener(int ingreso) {
		this.ingreso = ingreso;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean ingresoValido = this.validarIngreso();
		if (ingresoValido == false) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación. Debe introducir una cantidad mayor que 0 y múltiplo de 5", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			float saldoActual = SesionControlador.datosCuenta.getSaldo();
			float saldoTotalIngresado = (saldoActual + this.ingreso);
			try {
				SesionControlador.datosCuenta.setSaldo(saldoTotalIngresado);
				CuentaDAO cuentaDAO = new CuentaDAO();
				cuentaDAO.actualizarCuenta(SesionControlador.datosCuenta);
				MovimientoDAO movimientoDAO = new MovimientoDAO();
				long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
				MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Ingreso de dinero",
						SesionControlador.datosCuenta.getId());
				movimientoDAO.insertarMovimiento(movimientoDTO);
				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			} catch (Exception error) {
				SesionControlador.datosCuenta.setSaldo(saldoActual);
				JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.print(error);
			}
		}
	}

	private boolean validarIngreso() {
		boolean valido = false;
		if (this.ingreso > 0 && this.ingreso % 5 == 0) {
			valido = true;
		}

		return valido;
	}
}
