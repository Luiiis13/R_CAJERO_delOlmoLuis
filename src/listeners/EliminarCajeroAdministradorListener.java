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
			}else {
				JOptionPane.showMessageDialog(null, "Operación cancelada");
			}
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
