package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controlador.SesionUsuarioControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dto.MovimientoDTO;
import vista.ExtraerOtraCantidadDineroFrame;

public class ExtraerOtraCantidadDineroListener implements ActionListener {
	private ExtraerOtraCantidadDineroFrame frame;
	private int extraido;

	public ExtraerOtraCantidadDineroListener(ExtraerOtraCantidadDineroFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.extraido = Integer.parseInt(this.frame.getCantidadSpinner().getValue().toString());
		boolean ingresoValido = this.validarExtraccion();
		if (ingresoValido == false) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operaci�n. Debe introducir una cantidad mayor que 0 y m�ltiplo de 5", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			float saldoActual = SesionUsuarioControlador.datosCuenta.getSaldo();
			try {
				float saldoRestante = (saldoActual - this.extraido);
				if (saldoRestante >= 0) {
					SesionUsuarioControlador.datosCuenta.setSaldo(saldoRestante);
					CuentaDAO cuentaDAO = new CuentaDAO();
					cuentaDAO.actualizarCuenta(SesionUsuarioControlador.datosCuenta);
					MovimientoDAO movimientoDAO = new MovimientoDAO();
					long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
					MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis),
							"Extracci�n de dinero", SesionUsuarioControlador.datosTarjeta.getId());
					movimientoDAO.insertarMovimiento(movimientoDTO);
					JOptionPane.showMessageDialog(null, "Operaci�n realizada correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception error) {
				SesionUsuarioControlador.datosCuenta.setSaldo(saldoActual);
				JOptionPane.showMessageDialog(null, "Error haciendo la operaci�n", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.print(error);
			} finally {
				this.frame.show(false);
			}
		}

	}

	private boolean validarExtraccion() {
		boolean valido = false;
		if (this.extraido > 0 && this.extraido % 5 == 0) {
			valido = true;
		}

		return valido;
	}

}
