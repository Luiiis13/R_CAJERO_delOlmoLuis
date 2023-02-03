package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.dao.BonobusDAO;
import modelo.dao.TarjetaDAO;
import modelo.dao.UsuarioDAO;
import modelo.dto.BonobusDTO;
import modelo.dto.TarjetaDTO;
import modelo.dto.UsuarioDTO;
import vista.AdministrarTarjetasFrame;
import vista.ModificarTarjetaAdministradorFrame;
import vista.ModificarUsuariosAdministradorFrame;

public class TarjetasControlador {
	private AdministrarTarjetasFrame frame;
	private TarjetaDAO tarjetaDAO;

	public TarjetasControlador() {
		this.tarjetaDAO = new TarjetaDAO();
	}

	public void inicializar() {
		try {
			ArrayList<TarjetaDTO> tarjetasBD = this.tarjetaDAO.obtenerTarjetas();
			this.frame = new AdministrarTarjetasFrame();
			this.frame.getModelo().agregarDatosDeTabla(tarjetasBD);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void agregarTarjeta(TarjetaDTO tarjetaDTO) {
		this.tarjetaDAO.insertarTarjeta(tarjetaDTO);
		BonobusDTO bonobusDTO = new BonobusDTO(0, 0, tarjetaDTO.getId());
		BonobusDAO bonobusDAO = new BonobusDAO();
		bonobusDAO.insertarbonobus(bonobusDTO);
	}

	public void eliminarTarjetas(int idTarjeta) {
		this.tarjetaDAO.eliminarTarjeta(idTarjeta);
	}

	public void mostrarInterfazEdicion(TarjetaDTO tarjetaDTO) {
		ModificarTarjetaAdministradorFrame frameModificar = new ModificarTarjetaAdministradorFrame();
		frameModificar.setNumeroTxt(tarjetaDTO.getNumero());
		frameModificar.setCvvTxt(tarjetaDTO.getCvv());
		frameModificar.setPinTxt(tarjetaDTO.getPin());
		frameModificar.setBloqueadoTxt(tarjetaDTO.isBloqueado());
		frameModificar.setIdTarjeta(tarjetaDTO.getId());
		frameModificar.setIdCuentaAsociada(tarjetaDTO.getIdCuentaAsociada());
	}

	public void actualizarTarjeta(TarjetaDTO tarjetaDTO) {
		this.tarjetaDAO.actualizarTarjeta(tarjetaDTO);
	}

}
