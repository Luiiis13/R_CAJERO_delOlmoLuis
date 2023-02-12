package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.AdministrarUsuariosFrame;
import vista.InsertarUsuarioAdministradorFrame;
/***
 * Clase que sirve para sacar la vista del frame de insertar usuario
 * @author Luis
 *
 */
public class MostrarInserccionUsuariosListener implements ActionListener{
private AdministrarUsuariosFrame frameAdministrador;

public MostrarInserccionUsuariosListener(AdministrarUsuariosFrame frame) {
	this.frameAdministrador=frame;
}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.frameAdministrador.setVisible(false);
		InsertarUsuarioAdministradorFrame nuevoUsuarioFrame = new InsertarUsuarioAdministradorFrame();
	}
}
