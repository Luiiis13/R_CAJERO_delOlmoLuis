package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.CuentasControlador;
import controlador.SesionAdministradorControlador;
import modelo.dto.CuentaDTO;
import vista.InsertarCuentaAdministradorFrame;
/***
 * Clase que sirve para agregar una nueva cuenta a la base de datos 
 * @author Luis
 *
 */
public class AgregarCuentaAdministradorListener implements ActionListener {
	private InsertarCuentaAdministradorFrame insertarCuentaFrame;

	public AgregarCuentaAdministradorListener(InsertarCuentaAdministradorFrame insertarCuentaFrame) {
		this.insertarCuentaFrame = insertarCuentaFrame;
	}
	/***
	 * Accion que sirve para ingresar los distintos datos de una cuenta y posteriormente confirmar su inserccion 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			boolean valido = this.validarCampos();
			if (valido) {
				String numeroCuenta =this.insertarCuentaFrame.getNumeroTxt().getText();
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
			JOptionPane.showMessageDialog(null, "Error haciendo la operaci�n", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}
	}
	/***
	 * Metodo que sirve para validar que los campos rellenados son validos 
	 * @return 
	 */ 
	private boolean validarCampos() {
		boolean valido = true;
		String numeroCuentaTxt = this.insertarCuentaFrame.getNumeroTxt().getText();
		String ibanTxt = this.insertarCuentaFrame.getIbanTxt().getText();
		
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
