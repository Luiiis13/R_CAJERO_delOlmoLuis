package controlador;

import modelo.dao.TelefonoDAO;
import modelo.dto.TelefonoDTO;

public class RecargaTelefonoControlador {
	private TelefonoDAO telefonoDAO = new TelefonoDAO();

	public void recargarTelefono(int numeroTelefono, int cantidad, int idTarjetaAsociada) throws Exception {
		try {
			TelefonoDTO datosTelefono = telefonoDAO.obtenerTelefono(numeroTelefono);
			if (datosTelefono == null) {
				TelefonoDTO telefonoDto = new TelefonoDTO(0, numeroTelefono, cantidad, idTarjetaAsociada);
				telefonoDAO.insertarTelefono(telefonoDto);
			} else {
				datosTelefono.setSaldo(cantidad + datosTelefono.getSaldo());
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
