package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.CajeroControlador;
import modelo.dto.CajeroDTO;
import modelo.tabla.CajeroFila;
import vista.AdministrarCajerosFrame;
/***
 * Clase que implementa el cajero que se ha escogido cuando se da al boton de
 * modicar
 * 
 * @author Luis
 *
 */
public class MostrarEdicionCajerosListener implements ActionListener{
	private AdministrarCajerosFrame modificarCajerosFrame;

	public MostrarEdicionCajerosListener(AdministrarCajerosFrame frame) {
		this.modificarCajerosFrame = frame;
	}
	/***
	 * Accion que verifica si se ha escogido mas de un cajero y si se ha escogido
	 * que muestre la interfaz correspondiente con sus datos
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ArrayList<CajeroFila> arrayCajero = this.modificarCajerosFrame.getModelo().getDatos();
			ArrayList<CajeroFila> cajerosSeleccionados = new ArrayList<>();
			for (int i = 0; i < arrayCajero.size(); i++) {
				CajeroFila filaCajero = arrayCajero.get(i);
				if (filaCajero.isSeleccionable() == true) {
					cajerosSeleccionados.add(filaCajero);
				}
			}
			if (cajerosSeleccionados.size() > 1) {
				JOptionPane.showMessageDialog(null, "Error debe seleccionar solamente un cajero", "Error", JOptionPane.ERROR_MESSAGE);
			}
			if(cajerosSeleccionados.size()==1) {
				CajeroFila filaCajero= cajerosSeleccionados.get(0);
				CajeroControlador controladorCajero = new CajeroControlador();
				CajeroDTO cajeroDTO = new CajeroDTO(filaCajero.getId(), filaCajero.getUbicacion());
				controladorCajero.mostrarInterfazEdicion(cajeroDTO);
				this.modificarCajerosFrame.setVisible(false);
			}
			if(cajerosSeleccionados.size()==0) {
				JOptionPane.showMessageDialog(null, "Error debe seleccionar un cajero", "Error", JOptionPane.ERROR_MESSAGE);

			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
