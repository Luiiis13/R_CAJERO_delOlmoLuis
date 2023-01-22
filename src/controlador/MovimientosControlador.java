package controlador;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.dao.BonobusDAO;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dao.TelefonoDAO;
import modelo.dto.BonobusDTO;
import modelo.dto.CuentaDTO;
import modelo.dto.MovimientoDTO;
import modelo.dto.TelefonoDTO;
import vista.MovimientosFrame;

public class MovimientosControlador {
	private MovimientosFrame frame;
	private CuentaDAO cuentaDAO;
	private MovimientoDAO movimientoDAO;
	private TelefonoDAO telefonoDAO;
	private BonobusDAO bonobusDAO;

	public MovimientosControlador() {

		this.movimientoDAO = new MovimientoDAO();
		this.cuentaDAO = new CuentaDAO();
		this.bonobusDAO = new BonobusDAO();
		this.telefonoDAO = new TelefonoDAO();
		this.inicializar();
	}

	private void inicializar() {
		try {
			int idCuenta = SesionUsuarioControlador.datosCuenta.getId();
			int idTarjeta = SesionUsuarioControlador.datosTarjeta.getId();

			this.frame = new MovimientosFrame();
			CuentaDTO cuentaDTO = this.cuentaDAO.obtenerCuenta(idCuenta);
			String textolblSaldo = this.frame.getSaldolbl().getText();
			textolblSaldo += cuentaDTO.getSaldo() + "€";
			this.frame.getSaldolbl().setText(textolblSaldo);

			TelefonoDTO telefonoDTO = this.telefonoDAO.obtenerTelefono(idTarjeta);
			String textoLblTelefono = this.frame.getTelefonolbl().getText();
			textoLblTelefono += telefonoDTO.getSaldo() + "€";
			this.frame.getTelefonolbl().setText(textoLblTelefono);

			BonobusDTO bonobusDTO = this.bonobusDAO.obtenerBonobus(idTarjeta);
			String textoLblBonobus = this.frame.getBonobuslbl().getText();
			textoLblBonobus += bonobusDTO.getSaldo() + "€";
			this.frame.getBonobuslbl().setText(textoLblBonobus);

			ArrayList<MovimientoDTO> movimientosCuenta = this.movimientoDAO.obtenerMovimiento(idTarjeta);
			this.frame.getModelo().agregarDatosDeTabla(movimientosCuenta);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
