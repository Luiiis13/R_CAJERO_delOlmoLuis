package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.SesionControlador;
import modelo.dao.CuentaDAO;
import modelo.dao.TarjetaDAO;
import vista.CambiarNumeroSecretoFrame;

public class CambiarNumeroSecretoBotonListener implements ActionListener {

	private CambiarNumeroSecretoFrame frame;

	public CambiarNumeroSecretoBotonListener(CambiarNumeroSecretoFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		
			int nuevoPin = Integer.parseInt(this.frame.getPinPassfield().getText());
			boolean correcto = this.ComprobarNuevoPin(nuevoPin);
			if (correcto == true) {
				SesionControlador.datosTarjeta.setPin(nuevoPin);
				TarjetaDAO tarjetaDAO = new TarjetaDAO();
				tarjetaDAO.actualizarTarjeta(SesionControlador.datosTarjeta);
				JOptionPane.showMessageDialog(null, "La operacion se ha ejecutado correctamente");
			}
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operacion", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.print(error);
		}
	}

	private boolean ComprobarNuevoPin(int nuevoPin) {
		boolean correcto = false;
		int numeroActual = SesionControlador.datosTarjeta.getPin();
		int confirmarPin = Integer.parseInt(this.frame.getRepetirPinPassfield().getText());
		
		if(nuevoPin != confirmarPin) {
			JOptionPane.showMessageDialog(null, "El pin nuevo no es igual al de confirmacion","Error", JOptionPane.ERROR_MESSAGE);
		}else{
			if(nuevoPin==numeroActual) {
				JOptionPane.showMessageDialog(null, "El pin nuevo es igual al anterior","Error", JOptionPane.ERROR_MESSAGE);
			}else {
				correcto=true;
			}	
		}
		return correcto;
	}
}
