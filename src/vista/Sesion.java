package vista;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Sesion extends JFrame {
	private JPanel panel = new JPanel();
	private JLabel numeroTarjetalbl = new JLabel("Introduce el numero de tarjeta");
	private JLabel pinlbl = new JLabel("Introduce el pin");
	private JPasswordField pin = new JPasswordField();
	private JButton aceptarbtn = new JButton("Aceptar");
	private JTextField numeroTarjeta=new JTextField();

	public Sesion() {
		this.add(panel);
		this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Iniciar sesion");
		this.setVisible(true);
		this.limitarTamañoContraseña();
		this.setSize(500, 500);
		this.panel.add(numeroTarjetalbl);
		this.panel.add(numeroTarjeta);
		this.panel.add(pinlbl);
		this.panel.add(pin);
		this.panel.add(aceptarbtn);
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
