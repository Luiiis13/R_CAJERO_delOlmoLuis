package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.CajeroControlador;
import modelo.tabla.CajeroFila;
import vista.AdministrarCajerosFrame;
/***
 * Clase que sirve para eliminar el determinada cajero
 * 
 * @author Luis
 *
 */
public class EliminarCajeroAdministradorListener implements ActionListener {

	private AdministrarCajerosFrame eliminarCajerosFrame;

	public EliminarCajeroAdministradorListener(AdministrarCajerosFrame frame) {
		this.eliminarCajerosFrame = frame;
	}
	/***
	 * Accion que obtiene el/los cajeros a eliminar con sus datos y se muestra un
	 * panel de confirmacion y si acepta se elimina el cajero
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			ArrayList<CajeroFila> arrayCajero = this.eliminarCajerosFrame.getModelo().getDatos();
			ArrayList<CajeroFila> cajerosSeleccionados = new ArrayList<>();
			for (int i = 0; i < arrayCajero.size(); i++) {
				CajeroFila filaCajero = arrayCajero.get(i);
				if (filaCajero.isSeleccionable() == true) {
					cajerosSeleccionados.add(filaCajero);
				}
			}
			if (cajerosSeleccionados.size() > 0) {
				int confirmado = JOptionPane.showConfirmDialog(eliminarCajerosFrame,
						"¿Está seguro que desea eliminar los cajeros?");
				if (JOptionPane.OK_OPTION == confirmado) {
					this.eliminarCajeros(cajerosSeleccionados);
					JOptionPane.showMessageDialog(null, "Cajeros eliminados correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Operación cancelada");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Error debe seleccionar un cajero", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	/***
	 * Metodo que sirve para recoger el cajero determinado y eliminarlo
	 * 
	 * @param cajerosSeleccionados parametro para recoger el cajero
	 * @throws Exception
	 */
	private void eliminarCajeros(ArrayList<CajeroFila> cajerosSeleccionados) throws Exception {
		CajeroControlador controladoCajero = new CajeroControlador();
		for (int i = 0; i < cajerosSeleccionados.size(); i++) {
			CajeroFila filaCajero = cajerosSeleccionados.get(i);
			int idCajero = filaCajero.getId();
			controladoCajero.eliminarCajero(idCajero);
		}
	}
}
