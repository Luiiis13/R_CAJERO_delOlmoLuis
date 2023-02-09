package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.Year;

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
				String numeroCuenta = this.insertarTarjetasFrame.getCuentaTxt().getText();
				CuentasControlador controladorCuenta = new CuentasControlador();
				CuentaDTO cuentaDTO = controladorCuenta.obtenerCuentaDadoNumero(numeroCuenta);
				if (cuentaDTO == null) {
					JOptionPane.showMessageDialog(null, "Error haciendo la operación: Cuenta no válida", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				String numero = this.insertarTarjetasFrame.getNumeroTxt().getText();
				int cvv = Integer.parseInt(this.insertarTarjetasFrame.getCvvTxt().getText());
				String fechaStr=this.insertarTarjetasFrame.getFechaExpiracionTxt().getText();  
			    Date fechaExpiracion=Date.valueOf(fechaStr);//converting string into sql date  
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
		String fechaStr=this.insertarTarjetasFrame.getFechaExpiracionTxt().getText();  

		try {
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
		if(fechaStr.length()!=10) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación: La fecha debe tener el siguiente formato: AAAA-MM-DD", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		String añoStr = fechaStr.substring(0, 4);
		try {
			int año = Integer.parseInt(añoStr);
			int añoActual = Year.now().getValue();
			if(año<añoActual) {
				JOptionPane.showMessageDialog(null, "Error haciendo la operación: El año tiene que ser mayor que el año actual", "Error",
						JOptionPane.ERROR_MESSAGE);
				return valido = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación: Año no válido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		String mesStr = fechaStr.substring(5,7);
		try {
			int mes = Integer.parseInt(mesStr);
			if(mes>12) {
				JOptionPane.showMessageDialog(null, "Error haciendo la operación: El mes no puede ser superior a 12", "Error",
						JOptionPane.ERROR_MESSAGE);
				return valido = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación: Mes no válido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		String diaStr = fechaStr.substring(8,10);
		try {
			int dia = Integer.parseInt(diaStr);
			if(dia>31) {
				JOptionPane.showMessageDialog(null, "Error haciendo la operación: El día no puede ser superior a 31", "Error",
						JOptionPane.ERROR_MESSAGE);
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
