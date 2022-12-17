package vista;

import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.JPanel;

import listeners.CambiarNumeroSecretoOpcionListener;
import listeners.ExtraerDineroOpcionListener;
import listeners.IngresarDineroOpcionListener;
import listeners.MovimientosOpcionListener;

public class PanelUsuario extends JPanel {
	private Button retirarDineroBtn = new Button("Retirar dinero");
	private Button ingresarDineroBtn = new Button("Ingresar dinero");
	private Button cambiarNumeroBtn = new Button("Cambiar número secreto");
	private Button movimientosBtn = new Button("Ver movimientos y saldo de la cuenta");

	public PanelUsuario() {
		this.add(retirarDineroBtn);
		this.add(ingresarDineroBtn);
		this.add(cambiarNumeroBtn);
		this.add(movimientosBtn);
		this.inicializar();
	}

	private void inicializar() {
		this.retirarDineroBtn.addActionListener(new ExtraerDineroOpcionListener());
		this.ingresarDineroBtn.addActionListener(new IngresarDineroOpcionListener());
		this.cambiarNumeroBtn.addActionListener(new CambiarNumeroSecretoOpcionListener());
		this.movimientosBtn.addActionListener(new MovimientosOpcionListener());
	}
}
