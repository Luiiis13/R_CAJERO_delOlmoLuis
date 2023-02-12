package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.SesionTarjetaControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dto.MovimientoDTO;
import vista.IngresarDineroPrincipalFrame;
/***
 * Clase que sirve para recargar la cuenta con un dinero predeterminado 
 * @author Luis 
 *
 */
public class IngresarCantidadDineroListener implements ActionListener {
	private int ingreso;
	private IngresarDineroPrincipalFrame frame;
	public IngresarCantidadDineroListener(int ingreso ,IngresarDineroPrincipalFrame frame) {
		this.ingreso = ingreso;
		this.frame=frame;
	}
	/***
	 * Accion que verifica si la cantidad a ingresar es valida y que comprueba si el
	 * saldo es suficiente , después se establece en la cuenta el saldo actualizado
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean ingresoValido = this.validarIngreso();
		if (ingresoValido == false) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación. Debe introducir una cantidad mayor que 0 y múltiplo de 5", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			float saldoActual = SesionTarjetaControlador.datosCuenta.getSaldo();
			float saldoTotalIngresado = (saldoActual + this.ingreso);
			try {
				this.frame.setVisible(false);
				SesionTarjetaControlador.datosCuenta.setSaldo(saldoTotalIngresado);
				CuentaDAO cuentaDAO = new CuentaDAO();
				cuentaDAO.actualizarCuenta(SesionTarjetaControlador.datosCuenta);
				MovimientoDAO movimientoDAO = new MovimientoDAO();
				long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
				MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Ingreso de dinero",
						SesionTarjetaControlador.datosTarjeta.getId());
				movimientoDAO.insertarMovimiento(movimientoDTO);
				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			} catch (Exception error) {
				SesionTarjetaControlador.datosCuenta.setSaldo(saldoActual);
				JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.print(error);
			}
		}
	}
/***
 * Metodo que sirve para validar que el numero es mayor que 0 y multiplo de 5
 * @return devulve un booleano 
 */
	private boolean validarIngreso() {
		boolean valido = false;
		if (this.ingreso > 0 && this.ingreso % 5 == 0) {
			valido = true;
		}

		return valido;
	}
}
