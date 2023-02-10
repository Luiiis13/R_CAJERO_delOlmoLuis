package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.RecargaTelefonoControlador;
import controlador.SesionUsuarioControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dao.TelefonoDAO;
import modelo.dto.MovimientoDTO;
import modelo.dto.TelefonoDTO;
import vista.RecargarOtraCantidadTelefonoFrame;

public class RecargarOtraCantidadTelefonoListener implements ActionListener {
	private RecargarOtraCantidadTelefonoFrame frame;
	private int cantidad;

	public RecargarOtraCantidadTelefonoListener(RecargarOtraCantidadTelefonoFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.cantidad = Integer.parseInt(this.frame.getCantidadSpinner().getValue().toString());
		boolean ingresoValido = this.validarExtraccion();
		if (ingresoValido == false) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación. Debe introducir una cantidad mayor que 0 y múltiplo de 5", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			float saldoActual = SesionUsuarioControlador.datosCuenta.getSaldo();
			try {
				float saldoRestante = (saldoActual - this.cantidad);
				if (saldoRestante >= 0) {
					RecargaTelefonoControlador controladorTelefono = new RecargaTelefonoControlador();
					int idTarjeta = SesionUsuarioControlador.datosTarjeta.getId();
					int numeroTelefono = this.frame.getNumeroTelefono();
					controladorTelefono.recargarTelefono(numeroTelefono, this.cantidad, idTarjeta);
					SesionUsuarioControlador.datosCuenta.setSaldo(saldoRestante);
					CuentaDAO cuentaDAO = new CuentaDAO();
					cuentaDAO.actualizarCuenta(SesionUsuarioControlador.datosCuenta);
					MovimientoDAO movimientoDAO = new MovimientoDAO();
					long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
					MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Recarga de teléfono",
							SesionUsuarioControlador.datosTarjeta.getId());
					movimientoDAO.insertarMovimiento(movimientoDTO);
					JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception error) {
				SesionUsuarioControlador.datosCuenta.setSaldo(saldoActual);
				JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
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
