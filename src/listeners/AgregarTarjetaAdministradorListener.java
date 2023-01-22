package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

import controlador.CuentasControlador;
import controlador.TarjetasControlador;
import modelo.dto.CuentaDTO;
import modelo.dto.TarjetaDTO;
import vista.InsertarTarjetaAdministradorFrame;

public class AgregarTarjetaAdministradorListener implements ActionListener {
	private InsertarTarjetaAdministradorFrame insertarTarjetasFrame;

	public AgregarTarjetaAdministradorListener(InsertarTarjetaAdministradorFrame frame) {
		this.insertarTarjetasFrame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			boolean valido = this.validarCampos();
			if (valido) {
				int numeroCuenta = Integer.parseInt(this.insertarTarjetasFrame.getCuentaTxt().getText());
				CuentasControlador controladorCuenta = new CuentasControlador();
				CuentaDTO cuentaDTO = controladorCuenta.obtenerCuentaDadoNumero(numeroCuenta);
				if (cuentaDTO == null) {
					JOptionPane.showMessageDialog(null, "Error haciendo la operación: Cuenta no válida", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				int numero = Integer.parseInt(this.insertarTarjetasFrame.getNumeroTxt().getText());
				int cvv = Integer.parseInt(this.insertarTarjetasFrame.getCvvTxt().getText());
				long millis = System.currentTimeMillis();
				Date fechaExpiracion = new Date(millis);// TO DO obtener del Jcalendar
				int pin = Integer.parseInt(this.insertarTarjetasFrame.getPinTxt().getText());

				TarjetaDTO tarjetaDTO = new TarjetaDTO(0, numero, fechaExpiracion, cvv, pin, false, cuentaDTO.getId());
				TarjetasControlador controladorTarjetas = new TarjetasControlador();
				controladorTarjetas.agregarTarjeta(tarjetaDTO);
				JOptionPane.showMessageDialog(null, "Tarjeta insertada correctamente");
				this.insertarTarjetasFrame.limpiarCampos();
				this.insertarTarjetasFrame.show(false);
				// TO DO Insertar bonobus y registro bonobus y telefono
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}

	}

	private boolean validarCampos() {
		boolean valido = true;
		String cuentaTxt = this.insertarTarjetasFrame.getCuentaTxt().getText();
		String numeroTxt = this.insertarTarjetasFrame.getNumeroTxt().getText();
		String cvvTxt = this.insertarTarjetasFrame.getCvvTxt().getText();
		String pinTxt = this.insertarTarjetasFrame.getPinTxt().getText();
		try {
			Integer.parseInt(cuentaTxt);
			Integer.parseInt(numeroTxt);
			Integer.parseInt(cvvTxt);
			Integer.parseInt(pinTxt);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación: Verifique que los parámetros sean numéricos", "Error",
					JOptionPane.ERROR_MESSAGE);
			valido = false;
		}
		
		if (cuentaTxt.length() < 20) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación: El número de cuenta debe tener 20 dígitos ", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
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
		return valido;
	}

}
