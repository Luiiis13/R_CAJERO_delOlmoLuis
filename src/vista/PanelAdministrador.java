package vista;

import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.JPanel;

import listeners.AdministrarCajerosListener;
import listeners.AdministrarCuentasListener;
import listeners.AdministrarTarjetasListener;
import listeners.AdministrarUsuariosListener;
import listeners.CambiarNumeroSecretoOpcionListener;
import listeners.ExtraerDineroOpcionListener;
import listeners.IngresarDineroOpcionListener;
import listeners.MovimientosOpcionListener;

public class PanelAdministrador extends JPanel {

	private Button administrarUsuariosbtn = new Button("Administrar usuarios");
	private Button administrarTarjertasbtn = new Button("Administrar tarjetas");
	private Button administrarCuentasbtn = new Button("Administrar cuentas");
	private Button administrarCajerobtn = new Button("Administrar cajero");

	public PanelAdministrador() {
		this.add(this.administrarUsuariosbtn);
		this.add(this.administrarTarjertasbtn);
		this.add(this.administrarCuentasbtn);
		this.add(this.administrarCajerobtn);
		this.inicializar();
	}
	private void inicializar() {
		this.administrarUsuariosbtn.addActionListener(new AdministrarUsuariosListener());
		this.administrarTarjertasbtn.addActionListener(new AdministrarTarjetasListener());
		this.administrarCuentasbtn.addActionListener(new AdministrarCuentasListener());
		this.administrarCajerobtn.addActionListener(new AdministrarCajerosListener());
	}
}
