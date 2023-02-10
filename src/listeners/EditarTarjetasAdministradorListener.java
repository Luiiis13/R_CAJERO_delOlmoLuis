package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.Year;

import javax.swing.JOptionPane;

import controlador.TarjetasControlador;
import controlador.UsuariosControlador;
import modelo.dto.TarjetaDTO;
import modelo.dto.UsuarioDTO;
import vista.ModificarTarjetaAdministradorFrame;
import vista.ModificarUsuariosAdministradorFrame;

public class EditarTarjetasAdministradorListener implements ActionListener {
	private ModificarTarjetaAdministradorFrame editarTarjetasFrame;

	public EditarTarjetasAdministradorListener(ModificarTarjetaAdministradorFrame frame) {
		this.editarTarjetasFrame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			boolean valido = this.validarCampos();
			if (valido == true) {
				TarjetasControlador controladorTarjetas = new TarjetasControlador();
				int idTarjeta = this.editarTarjetasFrame.getIdTarjeta();
				String numeroTarjeta = this.editarTarjetasFrame.getNumeroTxt().getText();
				int cvv = Integer.parseInt(editarTarjetasFrame.getCvvTxt().getText());
				int pin = Integer.parseInt(this.editarTarjetasFrame.getPinTxt().getText());
				boolean bloqueado = this.editarTarjetasFrame.getBloqueadoTxt().isSelected();
				String fechaStr = this.editarTarjetasFrame.getFechaExpiracionTxt().getText();
				Date fechaExpiracion = Date.valueOf(fechaStr);// converting string into sql date
				int idCuentaAsociada = this.editarTarjetasFrame.getIdCuentaAsociada();

				TarjetaDTO tarjetaDTO = new TarjetaDTO(idTarjeta, numeroTarjeta, fechaExpiracion, cvv, pin, bloqueado,
						idCuentaAsociada);
				controladorTarjetas.actualizarTarjeta(tarjetaDTO);
				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
				this.editarTarjetasFrame.limpiarCampos();
				this.editarTarjetasFrame.setVisible(false);
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}
	}

	private boolean validarCampos() {
		boolean valido = true;

		String numeroTxt = this.editarTarjetasFrame.getNumeroTxt().getText();
		String cvvTxt = this.editarTarjetasFrame.getCvvTxt().getText();
		String pinTxt = this.editarTarjetasFrame.getPinTxt().getText();
		String fechaStr = this.editarTarjetasFrame.getFechaExpiracionTxt().getText();

		try {
			Integer.parseInt(cvvTxt);
			Integer.parseInt(pinTxt);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación: Verifique que los parámetros sean numéricos", "Error",
					JOptionPane.ERROR_MESSAGE);
			valido = false;
		}

		if (numeroTxt.length() < 16) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación: El número de tarjeta debe tener 16 dígitos ", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		if (cvvTxt.length() < 3) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación: El número de seguridad debe tener 3 dígitos ", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		if (pinTxt.length() < 4) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación: El pin debe tener 4 dígitos ", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		if (fechaStr.length() != 10) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación: La fecha debe tener el siguiente formato: AAAA-MM-DD", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		String añoStr = fechaStr.substring(0, 4);
		try {
			int año = Integer.parseInt(añoStr);
			int añoActual = Year.now().getValue();
			if (año < añoActual) {
				JOptionPane.showMessageDialog(null,
						"Error haciendo la operación: El año tiene que ser mayor que el año actual", "Error",
						JOptionPane.ERROR_MESSAGE);
				return valido = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación: Año no válido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		String mesStr = fechaStr.substring(5, 7);
		try {
			int mes = Integer.parseInt(mesStr);
			if (mes > 12) {
				JOptionPane.showMessageDialog(null, "Error haciendo la operación: El mes no puede ser superior a 12",
						"Error", JOptionPane.ERROR_MESSAGE);
				return valido = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación: Mes no válido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		String diaStr = fechaStr.substring(8, 10);
		try {
			int dia = Integer.parseInt(diaStr);
			if (dia > 31) {
				JOptionPane.showMessageDialog(null, "Error haciendo la operación: El día no puede ser superior a 31",
						"Error", JOptionPane.ERROR_MESSAGE);
				return valido = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación: Día no válido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		return valido;
	}

}
