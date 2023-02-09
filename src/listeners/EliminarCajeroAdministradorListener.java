package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.CajeroControlador;
import modelo.tabla.CajeroFila;
import vista.AdministrarCajerosFrame;

public class EliminarCajeroAdministradorListener implements ActionListener {

	private AdministrarCajerosFrame eliminarCajerosFrame;

	public EliminarCajeroAdministradorListener(AdministrarCajerosFrame frame) {
		this.eliminarCajerosFrame = frame;
	}

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
						"�Est� seguro que desea eliminar los cajeros?");
				if (JOptionPane.OK_OPTION == confirmado) {
					this.eliminarCajeros(cajerosSeleccionados);
					JOptionPane.showMessageDialog(null, "Cajeros eliminados correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Operaci�n cancelada");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Error debe seleccionar un cajero", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error haciendo la operaci�n", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void eliminarCajeros(ArrayList<CajeroFila> cajerosSeleccionados) {
		CajeroControlador controladoCajero = new CajeroControlador();
		for (int i = 0; i < cajerosSeleccionados.size(); i++) {
			CajeroFila filaCajero = cajerosSeleccionados.get(i);
			int idCajero = filaCajero.getId();
			controladoCajero.eliminarCajero(idCajero);
		}
	}
}