package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.RecargaTelefonoControlador;
import controlador.SesionTarjetaControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dto.MovimientoDTO;
import vista.RecargarOtraCantidadTelefonoFrame;
/***
 * Clase que sirve para recargar determinada cantidad en el telefono
 * @author Luis
 *
 */
public class RecargarOtraCantidadTelefonoListener implements ActionListener {
	private RecargarOtraCantidadTelefonoFrame frame;
	private int cantidad;

	public RecargarOtraCantidadTelefonoListener(RecargarOtraCantidadTelefonoFrame frame) {
		this.frame = frame;
	}
	/***
	 * Accion que verifica si la cantidad a extraer es valida y que comprueba si el
	 * saldo es suficiente , despu�s se establece en la cuenta el saldo actualizado y se lo recarga ak telefono 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.cantidad = Integer.parseInt(this.frame.getCantidadSpinner().getValue().toString());
		boolean ingresoValido = this.validarRecarga();
		if (ingresoValido == false) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operaci�n. Debe introducir una cantidad mayor que 0 y m�ltiplo de 5", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			float saldoActual = SesionTarjetaControlador.datosCuenta.getSaldo();
			try {
				float saldoRestante = (saldoActual - this.cantidad);
				if (saldoRestante >= 0) {
					RecargaTelefonoControlador controladorTelefono = new RecargaTelefonoControlador();
					int idTarjeta = SesionTarjetaControlador.datosTarjeta.getId();
					int numeroTelefono = this.frame.getNumeroTelefono();
					controladorTelefono.recargarTelefono(numeroTelefono, this.cantidad, idTarjeta);
					SesionTarjetaControlador.datosCuenta.setSaldo(saldoRestante);
					CuentaDAO cuentaDAO = new CuentaDAO();
					cuentaDAO.actualizarCuenta(SesionTarjetaControlador.datosCuenta);
					MovimientoDAO movimientoDAO = new MovimientoDAO();
					long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
					MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Recarga de tel�fono",
							SesionTarjetaControlador.datosTarjeta.getId());
					movimientoDAO.insertarMovimiento(movimientoDTO);
					JOptionPane.showMessageDialog(null, "Operaci�n realizada correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception error) {
				SesionTarjetaControlador.datosCuenta.setSaldo(saldoActual);
				JOptionPane.showMessageDialog(null, "Error haciendo la operaci�n", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.print(error);
			} finally {
				this.frame.show(false);
			}
		}

	}
/***
 * Metodo que sirve para ver si la cantidad a recargar es mayor que 0 y que sea multiplo de 5
 * @return devuelve booleano
 */
	private boolean validarRecarga() {
		boolean valido = false;
		if (this.cantidad > 0 && this.cantidad % 5 == 0) {
			valido = true;
		}

		return valido;
	}

}
