package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.TarjetasControlador;
import modelo.tabla.TarjetaFila;
import vista.AdministrarTarjetasFrame;

/***
 * Clase que sirve para eliminar una determinada tarjeta
 * 
 * @author Luis
 *
 */
public class EliminarTarjetasAdministradorListener implements ActionListener {
	private AdministrarTarjetasFrame eliminarTarjetasFrame;

	public EliminarTarjetasAdministradorListener(AdministrarTarjetasFrame frame) {
		this.eliminarTarjetasFrame = frame;
	}
	/***
	 * Accion que obtiene la/las tarjeta a eliminar con sus datos y se muestra un
	 * panel de confirmacion y si acepta se elimina la tarjeta
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			ArrayList<TarjetaFila> arrayTarjeta = this.eliminarTarjetasFrame.getModelo().getDatos();
			ArrayList<TarjetaFila> tarjetasSeleccionados = new ArrayList<>();
			for (int i = 0; i < arrayTarjeta.size(); i++) {
				TarjetaFila filaTarjeta = arrayTarjeta.get(i);
				if (filaTarjeta.isSeleccionable() == true) {
					tarjetasSeleccionados.add(filaTarjeta);
				}
			}
			if (tarjetasSeleccionados.size() > 0) {
				int confirmado = JOptionPane.showConfirmDialog(this.eliminarTarjetasFrame,
						"�Est� seguro que desea eliminar las tarjetas?");
				if (JOptionPane.OK_OPTION == confirmado) {
					this.eliminarTarjetas(tarjetasSeleccionados);
					JOptionPane.showMessageDialog(null, "Tarjetas eliminadas correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Operaci�n cancelada");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Error debe seleccionar una tarjeta", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error haciendo la operaci�n", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/***
	 * Metodo que sirve para recoger la tarjeta determinado y eliminarlo
	 * 
	 * @param tarjetasSeleccionados parametro para recoger la tarjeta
	 * @throws Exception
	 */
	private void eliminarTarjetas(ArrayList<TarjetaFila> tarjetasSeleccionados) throws Exception {
		TarjetasControlador controladorTarjetas = new TarjetasControlador();
		for (int i = 0; i < tarjetasSeleccionados.size(); i++) {
			TarjetaFila filaTarjetas = tarjetasSeleccionados.get(i);
			int idTarjeta = filaTarjetas.getId();
			controladorTarjetas.eliminarTarjetas(idTarjeta);
		}
	}

}
