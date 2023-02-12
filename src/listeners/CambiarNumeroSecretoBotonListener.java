package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.SesionTarjetaControlador;
import modelo.dao.MovimientoDAO;
import modelo.dao.TarjetaDAO;
import modelo.dto.MovimientoDTO;
import vista.CambiarNumeroSecretoFrame;
/***
 * Clase que implementa la logica para cambiar el numero secreto de la tarjeta 
 * @author Luis
 *
 */
public class CambiarNumeroSecretoBotonListener implements ActionListener {

	private CambiarNumeroSecretoFrame frame;

	public CambiarNumeroSecretoBotonListener(CambiarNumeroSecretoFrame frame) {
		this.frame = frame;
	}
/***
 * Accion que verifica que el pin es valido , actualiza la tarjeta y luego crea un nuevo movimiento 
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			boolean correcto = this.comprobarNuevoPin();
			if (correcto == true) {
				int nuevoPin = Integer.parseInt(this.frame.getPinPassfield().getText());
				SesionTarjetaControlador.datosTarjeta.setPin(nuevoPin);
				TarjetaDAO tarjetaDAO = new TarjetaDAO();
				tarjetaDAO.actualizarTarjeta(SesionTarjetaControlador.datosTarjeta);
				MovimientoDAO movimientoDAO = new MovimientoDAO();
				long millis = System.currentTimeMillis();// PARA COGER LA FECHA ACTUAL
				MovimientoDTO movimientoDTO = new MovimientoDTO(0, new java.sql.Date(millis), "Cambio pin",
						SesionTarjetaControlador.datosTarjeta.getId());
				movimientoDAO.insertarMovimiento(movimientoDTO);
				JOptionPane.showMessageDialog(null, "La operación se ha ejecutado correctamente");
				this.frame.setVisible(false);
			}
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.print(error);
		}
	}
/***
 * Metodo que sirve para comprobar que el pin a insertar es valido 
 */
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
		int numeroActual = SesionTarjetaControlador.datosTarjeta.getPin();
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
