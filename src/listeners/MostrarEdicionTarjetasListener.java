package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.TarjetasControlador;
import controlador.UsuariosControlador;
import modelo.dto.TarjetaDTO;
import modelo.dto.UsuarioDTO;
import modelo.tabla.TarjetaFila;
import modelo.tabla.UsuarioFila;
import vista.AdministrarTarjetasFrame;

public class MostrarEdicionTarjetasListener implements ActionListener {
	private AdministrarTarjetasFrame mostrarEdicionTarjetas;

	public MostrarEdicionTarjetasListener(AdministrarTarjetasFrame frame) {
		this.mostrarEdicionTarjetas = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ArrayList<TarjetaFila> arrayTarjetas = this.mostrarEdicionTarjetas.getModelo().getDatos();
			ArrayList<TarjetaFila> tarjetasSeleccionadas = new ArrayList<>();
			for (int i = 0; i < arrayTarjetas.size(); i++) {
				TarjetaFila filatarjeta = arrayTarjetas.get(i);
				if (filatarjeta.isSeleccionable() == true) {
					tarjetasSeleccionadas.add(filatarjeta);
				}
			}
			if (tarjetasSeleccionadas.size() > 1) {
				JOptionPane.showMessageDialog(null, "Error debe seleccionar solamente una tarjeta", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			if (tarjetasSeleccionadas.size() == 1) {
				TarjetaFila filaTarjeta = tarjetasSeleccionadas.get(0);
				TarjetasControlador controladorTarjetas = new TarjetasControlador();
				TarjetaDTO tarjetaDTO = new TarjetaDTO(filaTarjeta.getId(), filaTarjeta.getNumero(),
						filaTarjeta.getFecha_expiracion(), filaTarjeta.getPin(), filaTarjeta.getCvv(),
						filaTarjeta.isBloqueado(), filaTarjeta.getIdCuentaAsociada());
				controladorTarjetas.mostrarInterfazEdicion(tarjetaDTO);
				this.mostrarEdicionTarjetas.setVisible(false);
			}
			if (tarjetasSeleccionadas.size() == 0) {
				JOptionPane.showMessageDialog(null, "Error debe seleccionar una tarjeta", "Error",
						JOptionPane.ERROR_MESSAGE);

			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error haciendo la operación", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
