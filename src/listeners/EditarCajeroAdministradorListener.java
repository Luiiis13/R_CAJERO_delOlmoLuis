package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.Annotation;

import javax.swing.JOptionPane;

import controlador.CajeroControlador;
import modelo.dto.CajeroDTO;
import vista.AdministrarCajerosFrame;
import vista.ModificarCajerosAdministradorFrame;

public class EditarCajeroAdministradorListener implements ActionListener{
	private ModificarCajerosAdministradorFrame editarCajero;
	
	public EditarCajeroAdministradorListener(ModificarCajerosAdministradorFrame frame) {
		this.editarCajero=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
				CajeroControlador controladorCajero = new CajeroControlador();
				int idCajero=editarCajero.getIdCajero();
				String ubicacion = editarCajero.getUbicacionTxt().getText();
				CajeroDTO cajeroDTO = new CajeroDTO(idCajero, ubicacion);
				controladorCajero.actualizarCajero(cajeroDTO);
				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
				this.editarCajero.limpiarCampos();
				this.editarCajero.setVisible(false);

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}
	
		
		
		
	}

}
