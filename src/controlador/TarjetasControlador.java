package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.dao.TarjetaDAO;
import modelo.dao.UsuarioDAO;
import modelo.dto.TarjetaDTO;
import modelo.dto.UsuarioDTO;
import vista.AdministrarTarjetasFrame;

public class TarjetasControlador {
	private AdministrarTarjetasFrame frame;
	private TarjetaDAO tarjetaDAO;
public TarjetasControlador() {
	this.tarjetaDAO=new TarjetaDAO();
	this.inicializar();
	}
private void inicializar() {
	try {
		ArrayList<TarjetaDTO> tarjetasBD=this.tarjetaDAO.obtenerTarjetas();
		this.frame = new AdministrarTarjetasFrame();
		this.frame.getModelo().agregarDatosDeTabla(tarjetasBD);
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
	}
}

}
