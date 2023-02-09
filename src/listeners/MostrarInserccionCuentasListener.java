package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.AdministrarCuentasFrame;
import vista.InsertarCuentaAdministradorFrame;

public class MostrarInserccionCuentasListener implements ActionListener{
private AdministrarCuentasFrame frameCuentas;

public MostrarInserccionCuentasListener(AdministrarCuentasFrame frame) {
	this.frameCuentas=frame;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.frameCuentas.setVisible(false);
		InsertarCuentaAdministradorFrame insertarCuenta = new InsertarCuentaAdministradorFrame();
	}

}
