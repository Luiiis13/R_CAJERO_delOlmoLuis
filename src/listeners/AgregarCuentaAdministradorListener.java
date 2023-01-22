package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.CuentasControlador;
import controlador.SesionAdministradorControlador;
import modelo.dto.CuentaDTO;
import vista.InsertarCuentaAdministradorFrame;

public class AgregarCuentaAdministradorListener implements ActionListener {
	private InsertarCuentaAdministradorFrame insertarCuentaFrame;

	public AgregarCuentaAdministradorListener(InsertarCuentaAdministradorFrame insertarCuentaFrame) {
		this.insertarCuentaFrame = insertarCuentaFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			boolean valido = this.validarCampos();
			if (valido) {
				int numeroCuenta = Integer.parseInt(this.insertarCuentaFrame.getNumeroTxt().getText());
				String iban = this.insertarCuentaFrame.getIbanTxt().getText();
				int idUsuario = SesionAdministradorControlador.sesionAdminDTO.getId();
				CuentasControlador controladorCuenta = new CuentasControlador();
				CuentaDTO cuentaDTO = new CuentaDTO(0, numeroCuenta, iban, 0, idUsuario);
				controladorCuenta.insertarCuenta(cuentaDTO);
				JOptionPane.showMessageDialog(null, "Cuenta insertada correctamente");
				this.insertarCuentaFrame.limpiarCampos();
				this.insertarCuentaFrame.setVisible(false);
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}
	}

	private boolean validarCampos() {
		boolean valido = true;
		String numeroCuentaTxt = this.insertarCuentaFrame.getNumeroTxt().getText();
		String ibanTxt = this.insertarCuentaFrame.getIbanTxt().getText();
		try {
			Integer.parseInt(numeroCuentaTxt);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación: Verifique que el numero de cuenta es numérico", "Error",
					JOptionPane.ERROR_MESSAGE);
			valido = false;
		}

		if (numeroCuentaTxt.length() < 20) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operación: El número de cuenta debe tener 20 dígitos ", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		if (ibanTxt.length() < 24) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación: El IBAN debe tener 24 dígitos ", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		return valido;
	}

}
