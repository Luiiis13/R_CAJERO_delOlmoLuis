package controlador;

import modelo.dao.BonobusDAO;
import modelo.dto.BonobusDTO;
/***
 * Clase que une las distintas funcionalidades de la base de datos con los distintos listeners 
 * @author Luis
 *
 */
public class RecargarBonobusControlador {
	private BonobusDAO bonobusDAO = new BonobusDAO();
/***
 * metodo que sirve para recargar un bonobus 
 * @param cantidad
 * @param idTarjeta
 * @throws Exception
 */
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
