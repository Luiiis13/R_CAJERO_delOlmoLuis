package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.RecargaTelefonoControlador;
import controlador.SesionTarjetaControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dto.CuentaDTO;
import modelo.dto.MovimientoDTO;
import vista.RecargarTelefonoFrame;

/***
 * Clase que sirve para recargar un telefono con una cantidad preestablecida que
 * se le pasa en el constructor
 * @author Luis
 *
 */
public class RecargarTelefonoListener implements ActionListener {
	private int cantidad;
	private RecargarTelefonoFrame frame;

	public RecargarTelefonoListener(int cantidad, RecargarTelefonoFrame frame) {
		this.cantidad = cantidad;
		this.frame = frame;
	}
	/***
	 * accion que verifica si el metodo es valido y quita el saldo de la cuenta , lo
	 * añade al telefono y luego lo marca en moviminetos
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			boolean valido = this.validarDatos();
			if (valido == true) {
				int idCuenta = SesionTarjetaControlador.datosCuenta.getId();
				CuentaDAO cuentaDAO = new CuentaDAO();
				CuentaDTO datosDeCuenta = cuentaDAO.obtenerCuenta(idCuenta);
				float nuevoSaldo = datosDeCuenta.getSaldo() - this.cantidad;
				if (nuevoSaldo < 0.0f) {
					JOptionPane.showMessageDialog(null, "ERROR no hay saldo disponible", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				RecargaTelefonoControlador controladorTelefono = new RecargaTelefonoControlador();
				String numeroTelefono = this.frame.getNumTelefonoTxt().getText();
				int numero = Integer.parseInt(numeroTelefono);
				int idTarjeta = SesionTarjetaControlador.datosTarjeta.getId();
				controladorTelefono.recargarTelefono(numero, this.cantidad, idTarjeta);
				SesionTarjetaControlador.datosCuenta.setSaldo(nuevoSaldo);
				cuentaDAO.actualizarCuenta(SesionTarjetaControlador.datosCuenta);
				MovimientoDAO movimientoDAO = new MovimientoDAO();
				long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
				MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Recarga de telefono",
						SesionTarjetaControlador.datosTarjeta.getId());
				movimientoDAO.insertarMovimiento(movimientoDTO);
				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "ERROR recargando télefono", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}
	}

	/***
	 * Metodo que sirve para poder validar los datos de que el telefono esta bien
	 * introducido
	 * 
	 * @return retorna un booleano
	 */
	private boolean validarDatos() {
		boolean valido = true;
		String numeroTelefono = this.frame.getNumTelefonoTxt().getText();
		if (numeroTelefono.length() < 9) {
			JOptionPane.showMessageDialog(null, "ERROR: número de télefono inválido", "Error",
					JOptionPane.ERROR_MESSAGE);
			valido = false;
			return valido;
		}
		try {
			int numero = Integer.parseInt(numeroTelefono);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: número de télefono inválido, no debe contener letras", "Error",
					JOptionPane.ERROR_MESSAGE);
			valido = false;
			return valido;

		}
		String primerDigito = numeroTelefono.substring(0, 1);
		if (primerDigito.equalsIgnoreCase("6") == false && primerDigito.equalsIgnoreCase("7") == false) {
			JOptionPane.showMessageDialog(null, "ERROR: número de télefono inválido, debe comenzar con 6 o 7 ", "Error",
					JOptionPane.ERROR_MESSAGE);
			valido = false;
			return valido;
		}
		return valido;
	}
}
