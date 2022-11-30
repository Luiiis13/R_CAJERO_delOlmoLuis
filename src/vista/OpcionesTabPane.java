package vista;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controlador.SesionControlador;

public class OpcionesTabPane extends JTabbedPane {
	private JPanel jUsuario=new PanelUsuario();
	private JPanel jAdministrador=new PanelAdministrador();

public OpcionesTabPane(){
		this.add("Usuario",jUsuario);
		//TO DO verificar porque no funciona
		if(SesionControlador.datosUsuario.getRol()=="admin") {
			this.add("administrador",jAdministrador);
			
		}
		
		
	}
	
}