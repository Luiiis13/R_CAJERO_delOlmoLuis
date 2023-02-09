package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.CuentasControlador;
import controlador.TarjetasControlador;
import modelo.dto.CuentaDTO;
import modelo.dto.TarjetaDTO;
import modelo.tabla.CuentasFila;
import modelo.tabla.TarjetaFila;
import vista.AdministrarCuentasFrame;
import vista.AdministrarTarjetasFrame;

public class MostrarEdicionCuentasListener implements ActionListener{
	private AdministrarCuentasFrame mostrarEdicionCuentas;

	public MostrarEdicionCuentasListener(AdministrarCuentasFrame frame) {
		this.mostrarEdicionCuentas = frame;
	}

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
