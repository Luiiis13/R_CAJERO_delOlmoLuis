package vista;

import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Usuario extends JPanel{
	private Button retirarDinero = new Button("Retirar dinero");
	private Button ingresarDinero = new Button("Ingresar dinero");
	private Button cambiarNumero = new Button("Cambiar número secreto");
	private Button noviminetos = new Button("Ver movimientos y saldo de la cuenta");

	public Usuario() {
		this.add(retirarDinero);
		this.add(ingresarDinero);
		this.add(cambiarNumero);
		this.add(noviminetos);
	}

}
