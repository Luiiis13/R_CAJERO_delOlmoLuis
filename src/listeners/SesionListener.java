package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import java.sql.Date;
import controlador.OpcionesControlador;
import controlador.SesionControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.SesionDAO;
import modelo.dao.TarjetaDAO;
import modelo.dao.UsuarioDAO;
import modelo.dto.CuentaDTO;
import modelo.dto.SesionDTO;
import modelo.dto.TarjetaDTO;
import modelo.dto.UsuarioDTO;
import vista.Sesion;

/***
 * Clase que es llamada por el controlador de sesion controlador para validar
 * los campos de numero de tarjeta y contraseña del frame sesion
 * 
 * @author Luis
 *
 */
public class SesionListener implements ActionListener {
	private SesionDAO sesionDAO;
	private Sesion sesionVista;

	public SesionListener(SesionDAO nuevaSesionDAO, Sesion Sesion) {
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
			int numeroTarjeta = Integer.parseInt(this.sesionVista.getNumeroTarjeta().getText());
			int pin = Integer.parseInt(this.sesionVista.getPin().getText());
			SesionDTO sesionDTO = this.sesionDAO.verificarSesion(numeroTarjeta);

			if (sesionDTO.getId() == 0) {
				JOptionPane.showMessageDialog(null, "Número incorrecto", "Error", JOptionPane.ERROR_MESSAGE);

				return;
			}
			if (sesionDTO.getPin() != pin) {
				JOptionPane.showMessageDialog(null, "Pin incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				SesionControlador.intentosFallidos++;
				if (SesionControlador.intentosFallidos > 4) {
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
		SesionControlador.datosTarjeta = datosTarjeta; // PARA HACER ACCESIBLE LOS DATOS DE LA TARJETA
		CuentaDAO cuenta = new CuentaDAO();
		CuentaDTO datosCuenta = cuenta.obtenerCuenta(datosTarjeta.getIdCuentaAsociada());
		SesionControlador.datosCuenta = datosCuenta;
		JOptionPane.showMessageDialog(null, "Credenciales validas");
		this.sesionVista.show(false);
		OpcionesControlador opcionesControlador = new OpcionesControlador();
	}

	private void bloquearTarjeta(int id) {
		TarjetaDAO tarjeta = new TarjetaDAO();
		TarjetaDTO datosTarjeta = tarjeta.obtenerTarjeta(id);
		datosTarjeta.setBloqueado(true);
		tarjeta.actualizarTarjeta(datosTarjeta);

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
