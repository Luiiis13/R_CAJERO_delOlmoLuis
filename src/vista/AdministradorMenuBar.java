package vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import listeners.AdministrarCajerosListener;
import listeners.AdministrarCuentasListener;
import listeners.AdministrarTarjetasListener;
import listeners.AdministrarUsuariosListener;
import listeners.SalirBotonListener;

/***
 * Clase que implementa las distintas opciones en la barra del menu con sus
 * respectivos actionListeners
 * 
 * @author Luis
 *
 */
public class AdministradorMenuBar extends JMenuBar {
	private JMenu inicio;
	private JMenu operaciones;

	public AdministradorMenuBar() {
		this.inicio = new JMenu("Inicio");
		this.operaciones = new JMenu("Operaciones");

		this.add(this.inicio);
		this.add(this.operaciones);
		JMenuItem apagarCajero = new JMenuItem("Apagar cajero");
		apagarCajero.addActionListener(new SalirBotonListener());
		this.inicio.add(apagarCajero);

		JMenuItem administrarUsuarios = new JMenuItem("Administrar Usuarios");
		administrarUsuarios.addActionListener(new AdministrarUsuariosListener());
		this.operaciones.add(administrarUsuarios);

		JMenuItem administrarCuenta = new JMenuItem("Administrar Cuenta");
		administrarCuenta.addActionListener(new AdministrarCuentasListener());
		this.operaciones.add(administrarCuenta);
		

		JMenuItem administrarTarjetas = new JMenuItem("Administrar Tarjetas");
		administrarTarjetas.addActionListener(new AdministrarTarjetasListener());
		this.operaciones.add(administrarTarjetas);
		
		JMenuItem administrarCajero = new JMenuItem("Administrar Cajero");
		administrarCajero.addActionListener(new AdministrarCajerosListener());
		this.operaciones.add(administrarCajero);
	}

}
