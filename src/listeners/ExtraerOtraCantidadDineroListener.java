package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import controlador.SesionTarjetaControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dto.MovimientoDTO;
import vista.ExtraerOtraCantidadDineroFrame;
/***
 * Clase que sirve para recargar la cuenta con un dinero predeterminado 
 * @author Luis 
 *
 */
public class ExtraerOtraCantidadDineroListener implements ActionListener {
	private ExtraerOtraCantidadDineroFrame frame;
	private int extraido;

	public ExtraerOtraCantidadDineroListener(ExtraerOtraCantidadDineroFrame frame) {
		this.frame = frame;
	}
	/***
	 * Accion que verifica si la cantidad a retirar es valido y que comprueba si el
	 * saldo es suficiente , despu�s se establece en la cuenta el saldo actualizado
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.extraido = Integer.parseInt(this.frame.getCantidadSpinner().getValue().toString());
		boolean ingresoValido = this.validarExtraccion();
		if (ingresoValido == false) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operaci�n. Debe introducir una cantidad mayor que 0 y m�ltiplo de 5", "Error",
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
							"Extracci�n de dinero", SesionTarjetaControlador.datosTarjeta.getId());
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
				this.frame.setVisible(false);
			}
		}

	}
/***
 * Metodo que sirve para validar que la cantidad a extraer era valida   
 * @return
 */
	private boolean validarExtraccion() {
		boolean valido = false;
		if (this.extraido > 0 && this.extraido % 5 == 0) {
			valido = true;
		}

		return valido;
	}

}
