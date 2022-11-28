package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Sesion extends JFrame {
	private JPanel panel = new JPanel();
	private JLabel numeroTarjetalbl = new JLabel("Introduce el numero de tarjeta");
	private JLabel pinlbl = new JLabel("Introduce el pin");
	private JTextField numeroTarjeta = new JTextField();
	private JPasswordField pin = new JPasswordField();
	private JButton aceptarbtn = new JButton("Aceptar");
	

// Por defecto que posicion ocupa en la ventana 
//El jframe para insertar algo tengo que poner un Jpanel?

	public Sesion() {

		this.add(panel);
		this.setContentPane(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Iniciar sesion");
		this.setVisible(true);
		this.setSize(500, 500);

		this.panel.add(numeroTarjetalbl);
		this.panel.add(numeroTarjeta);
		this.panel.add(pinlbl);
		this.panel.add(pin);
		this.panel.add(aceptarbtn);
		
		
		
		this.pack();

	}

	public JTextField getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public JPasswordField getPin() {
		return pin;
	}

	public JButton getAceptarbtn() {
		return aceptarbtn;
	}
}
