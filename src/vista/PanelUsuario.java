package vista;

import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.JPanel;

import listeners.ExtraerDineroOpcionListener;

public class PanelUsuario extends JPanel{
	private Button retirarDineroBtn = new Button("Retirar dinero");
	private Button ingresarDineroBtn = new Button("Ingresar dinero");
	private Button cambiarNumeroBtn = new Button("Cambiar número secreto");
	private Button noviminetosBtn = new Button("Ver movimientos y saldo de la cuenta");

	public PanelUsuario() {
		this.add(retirarDineroBtn);
		this.add(ingresarDineroBtn);
		this.add(cambiarNumeroBtn);
		this.add(noviminetosBtn);
		this.inicializar();
	}

	private void inicializar() {
		this.retirarDineroBtn.addActionListener(new ExtraerDineroOpcionListener());
		
	}
}
