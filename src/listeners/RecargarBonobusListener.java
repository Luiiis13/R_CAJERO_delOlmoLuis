package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.RecargarBonobusControlador;
import controlador.SesionTarjetaControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dto.CuentaDTO;
import modelo.dto.MovimientoDTO;
/***
 * Clase que sirve para recargar un bonobus con una cantidad preestablecida que
 * se le pasa en el constructor
 * @author Luis
 *
 */
public class RecargarBonobusListener implements ActionListener {
	private int cantidad;

	public RecargarBonobusListener(int cantidad) {
		this.cantidad = cantidad;

	}
	/***
	 * Accion que verifica si el metodo es valido y quita el saldo de la cuenta , lo
	 * añade al bonobus y luego crea un movimiento.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			int idCuenta = SesionTarjetaControlador.datosCuenta.getId();
			int idTarjeta = SesionTarjetaControlador.datosTarjeta.getId();
			CuentaDAO cuentaDAO = new CuentaDAO();
			CuentaDTO datosDeCuenta = cuentaDAO.obtenerCuenta(idCuenta);
			float nuevoSaldo = datosDeCuenta.getSaldo() - this.cantidad;
			if (nuevoSaldo < 0.0f) {
				JOptionPane.showMessageDialog(null, "ERROR no hay saldo disponible", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			RecargarBonobusControlador controladorBonobus = new RecargarBonobusControlador();
			controladorBonobus.recargarBonobus(this.cantidad, idTarjeta);
			SesionTarjetaControlador.datosCuenta.setSaldo(nuevoSaldo);
			cuentaDAO.actualizarCuenta(SesionTarjetaControlador.datosCuenta);
			MovimientoDAO movimientoDAO = new MovimientoDAO();
			long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
			MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Recarga de bonobus",
					SesionTarjetaControlador.datosTarjeta.getId());
			movimientoDAO.insertarMovimiento(movimientoDTO);
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "ERROR recargando bonobus", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
