package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.SesionUsuarioControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dao.TelefonoDAO;
import modelo.dto.CuentaDTO;
import modelo.dto.MovimientoDTO;
import modelo.dto.TelefonoDTO;

public class RecargarTelefonoListener implements ActionListener {
	private int cantidad;

	public RecargarTelefonoListener(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			TelefonoDAO telefonoDAO = new TelefonoDAO();
			int idCuenta = SesionUsuarioControlador.datosCuenta.getId();
			int idTarjeta = SesionUsuarioControlador.datosTarjeta.getId();
			TelefonoDTO datosTelefono = telefonoDAO.obtenerTelefono(idTarjeta);
			datosTelefono.setSaldo(this.cantidad + datosTelefono.getSaldo());
			CuentaDAO cuentaDAO = new CuentaDAO();
			CuentaDTO datosDeCuenta = cuentaDAO.obtenerCuenta(idCuenta);
			float nuevoSaldo = datosDeCuenta.getSaldo() - this.cantidad;
			if (nuevoSaldo < 0.0f) {
				JOptionPane.showMessageDialog(null, "ERROR no hay saldo disponible", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			SesionUsuarioControlador.datosCuenta.setSaldo(nuevoSaldo);
			telefonoDAO.actualizarTelefono(datosTelefono);
			cuentaDAO.actualizarCuenta(SesionUsuarioControlador.datosCuenta);
			MovimientoDAO movimientoDAO = new MovimientoDAO();
			long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
			MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Recarga de telefono",
					SesionUsuarioControlador.datosTarjeta.getId());
			movimientoDAO.insertarMovimiento(movimientoDTO);
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "ERROR recargando bonobus", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}
	}
}
