package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
			SesionDTO sesionDTO = new SesionDTO(numeroTarjeta, pin);
			int idTarjeta = this.sesionDAO.verificarSesion(sesionDTO);
			if (idTarjeta != -1) {
				JOptionPane.showMessageDialog(null, "Credenciales validas");
				this.sesionVista.show(false);
				obtenerDatosUsuario(idTarjeta);
				OpcionesControlador opcionesControlador = new OpcionesControlador();
			} else {
				JOptionPane.showMessageDialog(null, "Credenciales no validas", "Error", JOptionPane.ERROR_MESSAGE);
			}
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
		// System.out.print(datosCuenta.getId_usuario());

		UsuarioDAO usuario = new UsuarioDAO();
		UsuarioDTO datosUsuario = usuario.obtenerUsuario(datosCuenta.getId_usuario());
		SesionControlador.datosUsuario = datosUsuario;
		// System.out.print(datosUsuario.getRol());
	}
}
