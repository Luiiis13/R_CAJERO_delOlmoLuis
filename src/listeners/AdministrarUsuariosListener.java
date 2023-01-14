package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.UsuariosControlador;

public class AdministrarUsuariosListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		UsuariosControlador usuariosControlador = new UsuariosControlador();
		usuariosControlador.inicializar();
	}

}
