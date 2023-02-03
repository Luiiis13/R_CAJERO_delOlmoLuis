package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import controlador.TarjetasControlador;
import controlador.UsuariosControlador;
import modelo.dto.TarjetaDTO;
import modelo.dto.UsuarioDTO;
import vista.ModificarTarjetaAdministradorFrame;
import vista.ModificarUsuariosAdministradorFrame;

public class EditarTarjetasAdministradorListener implements ActionListener{
	private ModificarTarjetaAdministradorFrame editarTarjetasFrame;

	public EditarTarjetasAdministradorListener(ModificarTarjetaAdministradorFrame frame) {
		this.editarTarjetasFrame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			TarjetasControlador controladorTarjetas = new TarjetasControlador();
			int idTarjeta = this.editarTarjetasFrame.getIdTarjeta();
			String numeroTarjeta = this.editarTarjetasFrame.getNumeroTxt().getText();
			int cvv = Integer.parseInt(editarTarjetasFrame.getCvvTxt().getText()); 
			//Date fechaExpiracion = this.editarTarjetasFrame.
			int pin =Integer.parseInt(this.editarTarjetasFrame.getPinTxt().getText());
			boolean bloqueado = this.editarTarjetasFrame.getBloqueadoTxt().isSelected();
			long millis = System.currentTimeMillis();
			Date fechaExpiracion = new Date(millis);// TO DO obtener del Jcalendar
			int idCuentaAsociada = this.editarTarjetasFrame.getIdCuentaAsociada();

			TarjetaDTO tarjetaDTO = new TarjetaDTO(idTarjeta, numeroTarjeta,fechaExpiracion, cvv,pin,bloqueado,idCuentaAsociada);
			controladorTarjetas.actualizarTarjeta(tarjetaDTO);
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			this.editarTarjetasFrame.limpiarCampos();
			this.editarTarjetasFrame.setVisible(false);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}		
	}

}
