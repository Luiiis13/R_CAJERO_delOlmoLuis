package vista;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class UsuarioJtabPane extends JTabbedPane {
	private JPanel jUsuario=new Usuario();
	private JPanel jAdministrador=new Administrador();

public UsuarioJtabPane(){
		
		this.add("Usuario",jUsuario);
		this.add("administrador",jAdministrador);
	}
	
}