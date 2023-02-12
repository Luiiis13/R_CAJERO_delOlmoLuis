package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.CuentasControlador;
import modelo.dto.CuentaDTO;
import modelo.tabla.CuentasFila;
import vista.AdministrarCuentasFrame;
/***
 * Clase que implementa la cuenta que se ha escogido cuando se da al boton de
 * modicar
 * 
 * @author Luis
 *
 */
public class MostrarEdicionCuentasListener implements ActionListener{
	private AdministrarCuentasFrame mostrarEdicionCuentas;

	public MostrarEdicionCuentasListener(AdministrarCuentasFrame frame) {
		this.mostrarEdicionCuentas = frame;
	}
	/***
	 * Accion que verifica si se ha escogido mas de una cuenta y si se ha escogido
	 * que muestre la interfaz correspondiente con sus datos
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ArrayList<CuentasFila> arrayCuentas = this.mostrarEdicionCuentas.getModelo().getDatos();
			ArrayList<CuentasFila> cuentasSeleccionadas = new ArrayList<>();
			for (int i = 0; i < arrayCuentas.size(); i++) {
				CuentasFila filaCuentas = arrayCuentas.get(i);
				if (filaCuentas.isSeleccionable() == true) {
					cuentasSeleccionadas.add(filaCuentas);
				}
			}
			if (cuentasSeleccionadas.size() > 1) {
				JOptionPane.showMessageDialog(null, "Error debe seleccionar solamente una cuenta", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			if (cuentasSeleccionadas.size() == 1) {
				CuentasFila filaCuentas = cuentasSeleccionadas.get(0);
				CuentasControlador controladorCuentas = new CuentasControlador();
				CuentaDTO cuentaDTO = new CuentaDTO(filaCuentas.getId(), filaCuentas.getNumero(),
						filaCuentas.getIban(), filaCuentas.getSaldo(),filaCuentas.getIdUsuario());
				controladorCuentas.mostrarInterfazEdicion(cuentaDTO);
				this.mostrarEdicionCuentas.setVisible(false);
			}
			if (cuentasSeleccionadas.size() == 0) {
				JOptionPane.showMessageDialog(null, "Error debe seleccionar una cuenta", "Error",
						JOptionPane.ERROR_MESSAGE);

			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}


}
