package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.SesionTarjetaControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dto.MovimientoDTO;

/***
 * Clase que implementa la logica para poder retirar una cantidad de dinero
 * determinada por el usuario de la cuenta
 * 
 * @author Luis
 *
 */
public class RetirarCantidadDineroListener implements ActionListener {
	private int extraido;

	public RetirarCantidadDineroListener(int extraido) {
		this.extraido = extraido;
	}

	/***
	 * Accion que verifica si la cantidad a extraer es valida y que comprueba si el
	 * saldo es suficiente , después se establece en la cuenta el saldo actualizado
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean ingresoValido = this.validarExtraccion();
		if (ingresoValido == false) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación. Debe introducir una cantidad mayor que 0 y múltiplo de 5", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			float saldoActual = SesionTarjetaControlador.datosCuenta.getSaldo();
			try {
				float saldoRestante = (saldoActual - this.extraido);
				if (saldoRestante >= 0) {
					SesionTarjetaControlador.datosCuenta.setSaldo(saldoRestante);
					CuentaDAO cuentaDAO = new CuentaDAO();
					cuentaDAO.actualizarCuenta(SesionTarjetaControlador.datosCuenta);
					MovimientoDAO movimientoDAO = new MovimientoDAO();
					long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
					MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis),
							"Extracción de dinero", SesionTarjetaControlador.datosTarjeta.getId());
					movimientoDAO.insertarMovimiento(movimientoDTO);
					JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception error) {
				SesionTarjetaControlador.datosCuenta.setSaldo(saldoActual);
				JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.print(error);
			}
		}
	}

	/***
	 * Metodo que sirve para validar si la cantidad es mayor que 0 o multiplo de 5
	 * 
	 * @return booleano
	 */
	private boolean validarExtraccion() {
		boolean valido = false;
		if (this.extraido > 0 && this.extraido % 5 == 0) {
			valido = true;
		}
		return valido;
	}
}
