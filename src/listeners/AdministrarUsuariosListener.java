package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.UsuariosControlador;
/***
 * Clase que sirve para sacar la vista de los usuarios que hay con sus datos 
 * @author Luis
 *
 */
public class AdministrarUsuariosListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		UsuariosControlador usuariosControlador = new UsuariosControlador();
		usuariosControlador.inicializar();
	}

}
