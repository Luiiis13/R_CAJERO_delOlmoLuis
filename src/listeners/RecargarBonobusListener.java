package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.SesionControlador;
import modelo.dao.BonobusDAO;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dto.BonobusDTO;
import modelo.dto.CuentaDTO;
import modelo.dto.MovimientoDTO;

public class RecargarBonobusListener implements ActionListener {
	private int cantidad;

	public RecargarBonobusListener(int cantidad) {
		this.cantidad = cantidad;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			BonobusDAO bonobusDAO = new BonobusDAO();
			int idCuenta = SesionControlador.datosCuenta.getId();
			BonobusDTO datosBonobus = bonobusDAO.obtenerBonobus(idCuenta);
			datosBonobus.setSaldo(this.cantidad + datosBonobus.getSaldo());
			CuentaDAO cuentaDAO = new CuentaDAO();
			CuentaDTO datosDeCuenta = cuentaDAO.obtenerCuenta(idCuenta);
			float nuevoSaldo = datosDeCuenta.getSaldo() - this.cantidad;
			if (nuevoSaldo < 0.0f) {
				JOptionPane.showMessageDialog(null, "ERROR no hay saldo disponible", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			SesionControlador.datosCuenta.setSaldo(nuevoSaldo);

			bonobusDAO.actualizarBonobus(datosBonobus);
			cuentaDAO.actualizarCuenta(SesionControlador.datosCuenta);
			MovimientoDAO movimientoDAO = new MovimientoDAO();
			long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
			MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Recarga de bonobus",
					idCuenta);
			movimientoDAO.insertarMovimiento(movimientoDTO);
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "ERROR recargando bonobus", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
