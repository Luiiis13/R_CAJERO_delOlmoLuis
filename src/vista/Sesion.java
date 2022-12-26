package vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Sesion extends JFrame {
	
	private JLabel numeroTarjetalbl = new JLabel("Introduce el número de tarjeta");
	private JLabel pinlbl = new JLabel("Introduce el pin");
	private JPasswordField pin = new JPasswordField();
	private JButton aceptarbtn = new JButton("Validar");
	private JTextField numeroTarjeta=new JTextField();

	public Sesion() {
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Iniciar sesion");
		this.limitarTamañoContraseña();
		this.setSize(500, 500);
		this.getContentPane().add(numeroTarjetalbl);
		this.getContentPane().add(numeroTarjeta);
		this.getContentPane().add(pinlbl);
		this.getContentPane().add(pin);
		this.getContentPane().add(aceptarbtn);
		this.setVisible(true);
		this.pack();
		
	}

	private void limitarTamañoContraseña() {
		this.pin.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	           String text = ((JPasswordField)e.getComponent()).getText();
	        	if (text.length() >= 4 ) // limit to 4 characters
	                e.consume();
	        }
	    });
		
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
