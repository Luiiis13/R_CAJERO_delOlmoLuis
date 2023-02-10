package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.Annotation;

import javax.swing.JOptionPane;

import controlador.CajeroControlador;
import modelo.dto.CajeroDTO;
import vista.AdministrarCajerosFrame;
import vista.ModificarCajerosAdministradorFrame;

public class EditarCajeroAdministradorListener implements ActionListener {
	private ModificarCajerosAdministradorFrame editarCajero;

	public EditarCajeroAdministradorListener(ModificarCajerosAdministradorFrame frame) {
		this.editarCajero = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			boolean valido = this.validarCampos();
			if (valido == true) {
				CajeroControlador controladorCajero = new CajeroControlador();
				int idCajero = editarCajero.getIdCajero();
				String ubicacion = editarCajero.getUbicacionTxt().getText();
				CajeroDTO cajeroDTO = new CajeroDTO(idCajero, ubicacion);
				controladorCajero.actualizarCajero(cajeroDTO);
				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
				this.editarCajero.limpiarCampos();
				this.editarCajero.setVisible(false);

			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}
	}

	private boolean validarCampos() {
		boolean valido = true;
		String ubicacion = this.editarCajero.getUbicacionTxt().getText();
		try {

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación: Verifique que la ubicación es string",
					"Error", JOptionPane.ERROR_MESSAGE);
			valido = false;
		}
		return valido;
	}
}
