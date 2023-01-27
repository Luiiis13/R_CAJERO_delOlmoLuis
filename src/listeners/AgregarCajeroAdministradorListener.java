package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.CajeroControlador;
import controlador.CuentasControlador;
import controlador.SesionAdministradorControlador;
import modelo.dto.CajeroDTO;
import modelo.dto.CuentaDTO;
import vista.InsertarCajeroAdministradorFrame;

public class AgregarCajeroAdministradorListener implements ActionListener{
private InsertarCajeroAdministradorFrame insertarCajeroFrame;
	public AgregarCajeroAdministradorListener(InsertarCajeroAdministradorFrame frame) {
		this.insertarCajeroFrame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			boolean valido = this.validarCampos();
			if (valido) {
				String ubicacion =this.insertarCajeroFrame.getUbicacionTxt().getText();
				int idUsuario = SesionAdministradorControlador.sesionAdminDTO.getId();
				CajeroControlador controladorCajero = new CajeroControlador();
				CajeroDTO cajeroDTO = new CajeroDTO(0, ubicacion);
				controladorCajero.insertarCajero(cajeroDTO);
				JOptionPane.showMessageDialog(null, "Cajero insertado correctamente");
				this.insertarCajeroFrame.limpiarCampos();
				this.insertarCajeroFrame.setVisible(false);
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}
	}

	private boolean validarCampos() {
		boolean valido = true;
		String ubicacion = this.insertarCajeroFrame.getUbicacionTxt().getText();
		try {

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación: Verifique que el numero de cuenta es numérico", "Error",
					JOptionPane.ERROR_MESSAGE);
			valido = false;
		}
		return valido;
	}
}
