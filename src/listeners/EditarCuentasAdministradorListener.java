package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import controlador.CuentasControlador;
import controlador.TarjetasControlador;
import modelo.dto.CuentaDTO;
import modelo.dto.TarjetaDTO;
import vista.ModificarCuentaAdministradorFrame;
import vista.ModificarTarjetaAdministradorFrame;

public class EditarCuentasAdministradorListener implements ActionListener{
	private ModificarCuentaAdministradorFrame editarCuentasFrame;

	public EditarCuentasAdministradorListener(ModificarCuentaAdministradorFrame frame) {
		this.editarCuentasFrame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			CuentasControlador controladorCuentas = new CuentasControlador();
			int idCuenta = this.editarCuentasFrame.getIdCuenta();
			String numero = this.editarCuentasFrame.getNumeroTxt().getText();
			String iban = this.editarCuentasFrame.getIbanTxt().getText();
			float saldo = Float.parseFloat(editarCuentasFrame.getSaldoTxt().getText()); 
			int idUsuario =Integer.parseInt(this.editarCuentasFrame.getId_usuarioTxt().getText());
			CuentaDTO cuentaDTO = new CuentaDTO(idCuenta, numero,iban, saldo,idUsuario);
			controladorCuentas.actualizarCuenta(cuentaDTO);
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			this.editarCuentasFrame.limpiarCampos();
			this.editarCuentasFrame.setVisible(false);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}		
	}

}
