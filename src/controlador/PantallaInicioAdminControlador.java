package controlador;

import vista.AdministradorMenuFrame;
import vista.InsertarAdministradorUsuarioFrame;
import vista.InsertarTarjetaAdministrador;
import vista.PantallaInicioAdministradorFrame;

public class PantallaInicioAdminControlador {
	private PantallaInicioAdministradorFrame frame;
	private AdministradorMenuFrame frameMenu;
	private InsertarAdministradorUsuarioFrame insetarFrame;
	private InsertarTarjetaAdministrador insertarTarjeta;
	
	public PantallaInicioAdminControlador() {
		//this.frame = new PantallaInicioAdministradorFrame();
		this.frameMenu = new AdministradorMenuFrame();
		//this.insetarFrame=new InsertarAdministradorFrame();
		//this.insertarTarjeta=new InsertarTarjetaAdministrador();
	}
}
