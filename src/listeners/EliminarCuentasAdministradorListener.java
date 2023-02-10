package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.CuentasControlador;
import modelo.tabla.CuentasFila;
import vista.AdministrarCuentasFrame;

public class EliminarCuentasAdministradorListener implements ActionListener{
private AdministrarCuentasFrame eliminarCuentasFrame;
public EliminarCuentasAdministradorListener(AdministrarCuentasFrame frame) {
	this.eliminarCuentasFrame=frame;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ArrayList<CuentasFila> arrayCuentas = this.eliminarCuentasFrame.getModelo().getDatos();
			ArrayList<CuentasFila> cuentasSeleccionadas = new ArrayList<>();
			for (int i = 0; i < arrayCuentas.size(); i++) {
				CuentasFila filaCuentas = arrayCuentas.get(i);
				if (filaCuentas.isSeleccionable() == true) {
					cuentasSeleccionadas.add(filaCuentas);
				}
			}
			if (cuentasSeleccionadas.size() > 0) {
				int confirmado = JOptionPane.showConfirmDialog(this.eliminarCuentasFrame,
						"¿Está seguro que desea eliminar las cuentas?");
				if (JOptionPane.OK_OPTION == confirmado) {
					this.eliminarCuentasFrame.setVisible(false);
					this.eliminarCuentas(cuentasSeleccionadas);
					JOptionPane.showMessageDialog(null, "Cuentas eliminadas correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Operación cancelada");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Error debe seleccionar una cuenta", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void eliminarCuentas(ArrayList<CuentasFila> cuentasSeleccionadas) throws Exception {
		CuentasControlador controladorCuentas = new CuentasControlador();
		for (int i = 0; i < cuentasSeleccionadas.size(); i++) {
			CuentasFila filaCuenta = cuentasSeleccionadas.get(i);
			int idCuenta = filaCuenta.getId();
			controladorCuentas.eliminarCuenta(idCuenta);
		}
	}

}
