package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controlador.SesionAdministradorControlador;
import vista.PantallaInicioAdministradorFrame;

/***
 * Clase que saca los datos de la vista de Pantalla inicio administrador cuando
 * se da al boton aceptar y llama al controlador necesario para validar los
 * datos
 * 
 * @author Luis
 *
 */
public class SesionAdministradorListener implements ActionListener {
	private SesionAdministradorControlador sesionAdministradorControlador = new SesionAdministradorControlador();
	private PantallaInicioAdministradorFrame administradorFrame;

	public SesionAdministradorListener(PantallaInicioAdministradorFrame frame) {
		this.administradorFrame = frame;
	}

	/***
	 * Accion que saca el dni y la contrase�a del frame y llama al controlador para
	 * validarlo si son correctos se cierra ese frame y se muestra un mensaje
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String dni = this.administradorFrame.getDniTxt().getText();
			String contrase�a = this.administradorFrame.getContrase�aField().getText();
			boolean sesionValida = this.sesionAdministradorControlador.validarSesionAdministrador(dni, contrase�a);
			if (sesionValida == true) {
				JOptionPane.showMessageDialog(null, "Credenciales v�lidas");
				this.administradorFrame.setVisible(false);
				this.sesionAdministradorControlador.mostrarOpcionesAdministrador();
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error haciendo la operaci�n", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
