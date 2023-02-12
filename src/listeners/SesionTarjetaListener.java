package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import java.sql.Date;
import controlador.OpcionesControlador;
import controlador.SesionTarjetaControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.SesionDAO;
import modelo.dao.TarjetaDAO;
import modelo.dto.CuentaDTO;
import modelo.dto.SesionTarjetaDTO;
import modelo.dto.TarjetaDTO;
import vista.SesionTarjetaFrame;

/***
 * Clase que es llamada por el controlador de sesion controlador para validar
 * los campos de numero de tarjeta y contraseña del frame sesion
 * 
 * @author Luis
 *
 */
public class SesionTarjetaListener implements ActionListener {
	private SesionDAO sesionDAO;
	private SesionTarjetaFrame sesionVista;

	public SesionTarjetaListener(SesionDAO nuevaSesionDAO, SesionTarjetaFrame Sesion) {
		this.sesionDAO = nuevaSesionDAO;
		this.sesionVista = Sesion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.verificarCredenciales();
	}

	/***
	 * Metodo que comprueba si el numero de la tarjeta existe en base de datos y
	 * comprueba que el pin y el numero sean correctos
	 */
	private void verificarCredenciales() {
		try {
			String numeroTarjeta = this.sesionVista.getNumeroTarjeta().getText();
			int pin = Integer.parseInt(this.sesionVista.getPin().getText());
			SesionTarjetaDTO sesionDTO = this.sesionDAO.verificarSesion(numeroTarjeta);

			if (sesionDTO.getId() == 0) {
				JOptionPane.showMessageDialog(null, "Número incorrecto", "Error", JOptionPane.ERROR_MESSAGE);

				return;
			}
			if (sesionDTO.getPin() != pin) {
				JOptionPane.showMessageDialog(null, "Pin incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				SesionTarjetaControlador.intentosFallidos++;
				if (SesionTarjetaControlador.intentosFallidos > 4) {
					this.bloquearTarjeta(sesionDTO.getId());
					JOptionPane.showMessageDialog(null, "Tarjeta bloqueada");
				}
				return;
			}

			boolean fechaValida = this.verificarFechaDeExpiracion(sesionDTO.getFechaExpiracion());
			if (fechaValida == false) {
				JOptionPane.showMessageDialog(null, "Tarjeta expirada", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (numeroTarjeta.length() < 16) {
				JOptionPane.showMessageDialog(null,
						"Error haciendo la operación: El número de tarjeta debe tener 16 dígitos ", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			this.obtenerDatosUsuario(sesionDTO.getId());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Formato no valido");
		}
	}

	/***
	 * Metodo que sirve para a traves de la tarjeta sacar los datos del usuario y
	 * guardar los datos de la tarjeta y los datos de la cuenta y una vez estan
	 * guardados mostrar un mensaje de credenciales validas
	 * 
	 * @param idTarjeta
	 */
	private void obtenerDatosUsuario(int idTarjeta) {
		TarjetaDAO tarjeta = new TarjetaDAO();
		TarjetaDTO datosTarjeta = tarjeta.obtenerTarjeta(idTarjeta);
		if (datosTarjeta.isBloqueado()) {
			JOptionPane.showMessageDialog(null, "Tarjeta bloqueada contacte con administrador", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		SesionTarjetaControlador.datosTarjeta = datosTarjeta; // PARA HACER ACCESIBLE LOS DATOS DE LA TARJETA
		CuentaDAO cuenta = new CuentaDAO();
		CuentaDTO datosCuenta = cuenta.obtenerCuenta(datosTarjeta.getIdCuentaAsociada());
		SesionTarjetaControlador.datosCuenta = datosCuenta;
		JOptionPane.showMessageDialog(null, "Credenciales validas");
		this.sesionVista.show(false);
		OpcionesControlador opcionesControlador = new OpcionesControlador();
	}

	private void bloquearTarjeta(int id) {
		try {
			TarjetaDAO tarjeta = new TarjetaDAO();
			TarjetaDTO datosTarjeta = tarjeta.obtenerTarjeta(id);
			datosTarjeta.setBloqueado(true);
			tarjeta.actualizarTarjeta(datosTarjeta);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/***
	 * Metodo que sirve para verificar que la fecha de la tarjeta es valida y por
	 * tanto no esta expirada
	 * 
	 * @param fechaTarjeta
	 * @return
	 */
	private boolean verificarFechaDeExpiracion(Date fechaTarjeta) {
		boolean valido = false;
		java.util.Date date = new java.util.Date();
		Date fechaActual = new Date(date.getTime());
		if (fechaActual.compareTo(fechaTarjeta) <= 0) {
			valido = true;

		}
		return valido;
	}

}
