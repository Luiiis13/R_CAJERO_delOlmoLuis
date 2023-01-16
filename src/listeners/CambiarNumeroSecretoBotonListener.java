package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import controlador.SesionControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dao.TarjetaDAO;
import modelo.dto.MovimientoDTO;
import vista.CambiarNumeroSecretoFrame;

public class CambiarNumeroSecretoBotonListener implements ActionListener {

	private CambiarNumeroSecretoFrame frame;

	public CambiarNumeroSecretoBotonListener(CambiarNumeroSecretoFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			boolean correcto = this.comprobarNuevoPin();
			if (correcto == true) {
				int nuevoPin = Integer.parseInt(this.frame.getPinPassfield().getText());
				SesionControlador.datosTarjeta.setPin(nuevoPin);
				TarjetaDAO tarjetaDAO = new TarjetaDAO();
				tarjetaDAO.actualizarTarjeta(SesionControlador.datosTarjeta);
				MovimientoDAO movimientoDAO = new MovimientoDAO();
				long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
				MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Cambio pin",
						SesionControlador.datosTarjeta.getId());
				movimientoDAO.insertarMovimiento(movimientoDTO);
				JOptionPane.showMessageDialog(null, "La operación se ha ejecutado correctamente");
				this.frame.setVisible(false);
			}
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.print(error);
		}
	}

	private boolean comprobarNuevoPin() {
		boolean correcto = false;
		String nuevoPinText = this.frame.getPinPassfield().getText();
		String confirmarPinText = this.frame.getRepetirPinPassfield().getText();
		correcto = nuevoPinText.length() == 4 && confirmarPinText.length() == 4;
		if (correcto == false) {
			JOptionPane.showMessageDialog(null, "El nuevo pin debe tener 4 dígitos ", "Error",
					JOptionPane.ERROR_MESSAGE);
			return correcto;
		}
		int nuevoPin = -1;
		int confirmarPin = -1;
		try {
			nuevoPin = Integer.parseInt(nuevoPinText);
			confirmarPin = Integer.parseInt(confirmarPinText);
		} catch (Exception e) {
			correcto = false;
			JOptionPane.showMessageDialog(null, "El pin nuevo tiene que ser numérico", "Error",
					JOptionPane.ERROR_MESSAGE);
			return correcto;
		}
		int numeroActual = SesionControlador.datosTarjeta.getPin();
		if (nuevoPin == numeroActual) {
			JOptionPane.showMessageDialog(null, "El pin nuevo es igual al anterior", "Error",
					JOptionPane.ERROR_MESSAGE);
			correcto = false;
			return correcto;
		}
		correcto = true;
		return correcto;
	}
}
