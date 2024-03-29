package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.CuentasControlador;
import modelo.dto.CuentaDTO;
import vista.ModificarCuentaAdministradorFrame;
/***
 * Clase que sirve para editar los datos de una cuenta y actualizarla 
 * @author Luis
 *
 */
public class EditarCuentasAdministradorListener implements ActionListener {
	private ModificarCuentaAdministradorFrame editarCuentasFrame;

	public EditarCuentasAdministradorListener(ModificarCuentaAdministradorFrame frame) {
		this.editarCuentasFrame = frame;
	}
	/***
	 * Accion que sirve para actualizar los datos de la cuenta a modificar
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			boolean valido = this.validarCampos();
			if (valido == true) {
				CuentasControlador controladorCuentas = new CuentasControlador();
				int idCuenta = this.editarCuentasFrame.getIdCuenta();
				String numero = this.editarCuentasFrame.getNumeroTxt().getText();
				String iban = this.editarCuentasFrame.getIbanTxt().getText();
				float saldo = Float.parseFloat(editarCuentasFrame.getSaldoTxt().getText());
				int idUsuario = Integer.parseInt(this.editarCuentasFrame.getId_usuarioTxt().getText());
				CuentaDTO cuentaDTO = new CuentaDTO(idCuenta, numero, iban, saldo, idUsuario);
				controladorCuentas.actualizarCuenta(cuentaDTO);
				JOptionPane.showMessageDialog(null, "Operaci�n realizada correctamente");
				this.editarCuentasFrame.limpiarCampos();
				this.editarCuentasFrame.setVisible(false);
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operaci�n", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}
	}
	/***
	 * Metodo que sirve para validar que los datos a insertar en los campos son
	 * correctos
	 * 
	 * @return devuelve un booleano
	 */
	private boolean validarCampos() {
		boolean valido = true;
		String numeroCuentaTxt = this.editarCuentasFrame.getNumeroTxt().getText();
		String ibanTxt = this.editarCuentasFrame.getIbanTxt().getText();

		if (numeroCuentaTxt.length() < 20) {
			JOptionPane.showMessageDialog(null,
					"Error haciendo la operaci�n: El n�mero de cuenta debe tener 20 d�gitos ", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		if (ibanTxt.length() < 24) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operaci�n: El IBAN debe tener 24 d�gitos ", "Error",
					JOptionPane.ERROR_MESSAGE);
			return valido = false;
		}
		return valido;
	}

}
