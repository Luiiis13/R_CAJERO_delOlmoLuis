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

	private void verificarCredenciales() {
		try {
			int numeroTarjeta = Integer.parseInt(this.sesionVista.getNumeroTarjeta().getText());
			int pin = Integer.parseInt(this.sesionVista.getPin().getText());
			SesionDTO sesionDTO = this.sesionDAO.verificarSesion(numeroTarjeta);
			//TO DO agregar el atributo bloqueado a la consulta
			
			if (sesionDTO.getId() == 0) {
				JOptionPane.showMessageDialog(null, "Número no válido", "Error", JOptionPane.ERROR_MESSAGE);
				SesionControlador.intentosFallidos++;
				if (SesionControlador.intentosFallidos > 4) {
					this.bloquearTarjeta(sesionDTO.getId());
				}
				return;
			}
			if (sesionDTO.getPin() != pin) {
				JOptionPane.showMessageDialog(null, "Pin no válido", "Error", JOptionPane.ERROR_MESSAGE);
				SesionControlador.intentosFallidos++;
				if (SesionControlador.intentosFallidos > 4) {
					this.bloquearTarjeta(sesionDTO.getId());
					
				}
				return;
			}

			boolean fechaValida = this.verificarFechaDeExpiracion(sesionDTO.getFechaExpiracion());
			if (fechaValida == false) {
				JOptionPane.showMessageDialog(null, "Tarjeta expirada", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null, "Credenciales validas");
			this.sesionVista.show(false);
			this.obtenerDatosUsuario(sesionDTO.getId());
			OpcionesControlador opcionesControlador = new OpcionesControlador();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Formato no valido");
		}
	}

	private void obtenerDatosUsuario(int id) {
		TarjetaDAO tarjeta = new TarjetaDAO();
		TarjetaDTO datosTarjeta = tarjeta.obtenerTarjeta(id);
		SesionControlador.datosTarjeta = datosTarjeta; // PARA HACER ACCESIBLE LOS DATOS DE LA TARJETA

		CuentaDAO cuenta = new CuentaDAO();
		CuentaDTO datosCuenta = cuenta.obtenerCuentaDadoTarjeta(id);
		SesionControlador.datosCuenta = datosCuenta;

		UsuarioDAO usuario = new UsuarioDAO();
		UsuarioDTO datosUsuario = usuario.obtenerUsuario(datosCuenta.getId_usuario());
		SesionControlador.datosUsuario = datosUsuario;
	}

	private void bloquearTarjeta(int id) {
		TarjetaDAO tarjeta = new TarjetaDAO();
		TarjetaDTO datosTarjeta = tarjeta.obtenerTarjeta(id);
		datosTarjeta.setBloqueado(true);
		tarjeta.actualizarTarjeta(datosTarjeta);

	}

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
