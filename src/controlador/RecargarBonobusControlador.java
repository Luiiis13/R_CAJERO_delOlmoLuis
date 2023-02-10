package controlador;

import modelo.dao.BonobusDAO;
import modelo.dto.BonobusDTO;

public class RecargarBonobusControlador {
	private BonobusDAO bonobusDAO = new BonobusDAO();

	public void recargarBonobus(int cantidad, int idTarjeta) throws Exception {
		try {
			BonobusDTO datosBonobus = bonobusDAO.obtenerBonobus(idTarjeta);
			datosBonobus.setSaldo(cantidad + datosBonobus.getSaldo());
			bonobusDAO.actualizarBonobus(datosBonobus);

		} catch (Exception e) {
			throw e;
		}

	}

}
