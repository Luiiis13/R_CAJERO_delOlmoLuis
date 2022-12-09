package vista;

import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAdministrador extends JPanel {

	private Button administrarUsuarios = new Button("Administrar usuarios");
	private Button administrarTarjertas = new Button("Administrar tarjetas");
	private Button administrarCuentas = new Button("Administrar cuentas");
	private Button administrarCajero = new Button("Administrar cajero");

	public PanelAdministrador() {
		this.add(this.administrarUsuarios);
		this.add(this.administrarTarjertas);
		this.add(this.administrarCuentas);
		this.add(this.administrarCajero);
	}
}
