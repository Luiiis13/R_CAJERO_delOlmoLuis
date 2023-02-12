package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.RecargarOtraCantidadTelefonoFrame;
import vista.RecargarTelefonoFrame;
/***
 * Clase que sirve para traspasar el numero al frame de recargarOtraCantidad
 * @author Luis
 *
 */
public class RecargarOtraCantidadTelefonoFrameListener implements ActionListener {
	private RecargarOtraCantidadTelefonoFrame frame;
	private RecargarTelefonoFrame recargarTelefonoFrame;

	public RecargarOtraCantidadTelefonoFrameListener(RecargarTelefonoFrame recargarTelefonoFrame) {
		this.recargarTelefonoFrame = recargarTelefonoFrame;
	}
/***
 * Acci�n que sirve para traspasar el n�mero al frame correspondiente  
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean validar = this.validarDatos();
		if (validar) {
			this.frame = new RecargarOtraCantidadTelefonoFrame();
			String numeroStr = this.recargarTelefonoFrame.getNumTelefonoTxt().getText();
			int numeroTelefono = Integer.parseInt(numeroStr);
			this.frame.setNumeroTelefono(numeroTelefono);
			this.recargarTelefonoFrame.setVisible(false);
		}
	}
/***
 * Metodo que sirve para validar que el n�mero introducido es v�lido 
 * @return
 */
	private boolean validarDatos() {
		boolean valido = true;
		String numeroTelefono = this.recargarTelefonoFrame.getNumTelefonoTxt().getText();
		if (numeroTelefono.length() < 9) {
			JOptionPane.showMessageDialog(null, "ERROR: n�mero de t�lefono inv�lido", "Error",
					JOptionPane.ERROR_MESSAGE);
			valido = false;
			return valido;
		}
		try {
			int numero = Integer.parseInt(numeroTelefono);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: n�mero de t�lefono inv�lido, no debe contener letras", "Error",
					JOptionPane.ERROR_MESSAGE);
			valido = false;
			return valido;

		}
		String primerDigito = numeroTelefono.substring(0, 1);
		if (primerDigito.equalsIgnoreCase("6") == false && primerDigito.equalsIgnoreCase("7") == false) {
			JOptionPane.showMessageDialog(null, "ERROR: n�mero de t�lefono inv�lido, debe comenzar con 6 o 7 ", "Error",
					JOptionPane.ERROR_MESSAGE);
			valido = false;
			return valido;
		}
		return valido;
	}
}
