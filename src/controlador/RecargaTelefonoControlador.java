package controlador;

import modelo.dao.TelefonoDAO;
import modelo.dto.TelefonoDTO;
/***
 * Clase que une las distintas funcionalidades de la base de datos con los distintos listeners 
 * @author Luis
 *
 */
public class RecargaTelefonoControlador {
	private TelefonoDAO telefonoDAO = new TelefonoDAO();
/***
 * Metodo que sirve para recrgar un numero de telefono 
 * @param numeroTelefono
 * @param cantidad
 * @param idTarjetaAsociada
 * @throws Exception
 */
	public void recargarTelefono(int numeroTelefono, int cantidad, int idTarjetaAsociada) throws Exception {
		try {
			TelefonoDTO datosTelefono = telefonoDAO.obtenerTelefono(numeroTelefono);
			if (datosTelefono == null) {
				TelefonoDTO telefonoDto = new TelefonoDTO(0, numeroTelefono, cantidad, idTarjetaAsociada);
				telefonoDAO.insertarTelefono(telefonoDto);
			} else {
				datosTelefono.setSaldo(cantidad + datosTelefono.getSaldo());
				telefonoDAO.actualizarTelefono(datosTelefono);
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
