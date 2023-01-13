package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.SesionControlador;
import modelo.dao.BonobusDAO;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dao.TelefonoDAO;
import modelo.dto.BonobusDTO;
import modelo.dto.MovimientoDTO;
import modelo.dto.TelefonoDTO;
import vista.RecargarOtraCantidadBonobusFrame;

public class RecargarOtraCantidadBonobusListener implements ActionListener {
	private RecargarOtraCantidadBonobusFrame frame;
	private int cantidad;

	public RecargarOtraCantidadBonobusListener(RecargarOtraCantidadBonobusFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.cantidad = Integer.parseInt(this.frame.getCantidadSpinner().getValue().toString());
		boolean ingresoValido = this.validarExtraccion();
		if (ingresoValido == false) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operaci�n. Debe introducir una cantidad mayor que 0 y m�ltiplo de 5", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			float saldoActual = SesionControlador.datosCuenta.getSaldo();
			try {
				float saldoRestante = (saldoActual - this.cantidad);
				if (saldoRestante >= 0) {
					BonobusDAO bonobusDAO = new BonobusDAO();
					int idCuenta = SesionControlador.datosCuenta.getId();
					BonobusDTO datosBonobus = bonobusDAO.obtenerBonobus(idCuenta);
					datosBonobus.setSaldo(this.cantidad + datosBonobus.getSaldo());
					bonobusDAO.actualizarBonobus(datosBonobus);
					SesionControlador.datosCuenta.setSaldo(saldoRestante);
					CuentaDAO cuentaDAO = new CuentaDAO();
					cuentaDAO.actualizarCuenta(SesionControlador.datosCuenta);
					MovimientoDAO movimientoDAO = new MovimientoDAO();
					long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
					MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Recarga de bonobus",
							SesionControlador.datosCuenta.getId());
					movimientoDAO.insertarMovimiento(movimientoDTO);
					JOptionPane.showMessageDialog(null, "Operaci�n realizada correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception error) {
				SesionControlador.datosCuenta.setSaldo(saldoActual);
				JOptionPane.showMessageDialog(null, "Error haciendo la operaci�n", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.print(error);
			} finally {
				this.frame.show(false);
			}
		}

	}

	private boolean validarExtraccion() {
		boolean valido = false;
		if (this.cantidad > 0 && this.cantidad % 5 == 0) {
			valido = true;
		}

		return valido;
	}

}
