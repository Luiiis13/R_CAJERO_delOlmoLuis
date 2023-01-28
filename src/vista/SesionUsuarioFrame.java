package vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SesionUsuarioFrame extends JFrame {
	/***
	 * Clase que crea la vista para introducir el numero de tarjeta junto a su
	 * contraseña
	 */
	private JLabel numeroTarjetalbl = new JLabel("Introduce el número de tarjeta");
	private JLabel pinlbl = new JLabel("Introduce el pin");
	private JPasswordField pin = new JPasswordField();
	private JButton validarBtn = new JButton("Validar");
	private JTextField numeroTarjeta = new JTextField();

	public SesionUsuarioFrame() {

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Iniciar sesion");
		this.limitarTamañoContraseña();
		this.limitarTamañoTarjeta();
		this.setSize(500, 500);
		this.getContentPane().add(numeroTarjetalbl);
		this.getContentPane().add(numeroTarjeta);
		this.getContentPane().add(pinlbl);
		this.getContentPane().add(pin);
		this.validarBtn.setBackground(new java.awt.Color(255, 215, 000));
		this.validarBtn.setForeground(new java.awt.Color(0, 0, 0));
		this.getContentPane().add(validarBtn);
		
		this.setVisible(true);
		this.pack();

	}

	/***
	 * Metodo que limita el campo de contraseña a 4 digitos
	 */
	private void limitarTamañoContraseña() {
		this.pin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = ((JPasswordField) e.getComponent()).getText();
				if (text.length() >= 4) // limit to 4 characters
					e.consume();
			}
		});
	}
	
	private void limitarTamañoTarjeta() {
		this.numeroTarjeta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = ((JTextField) e.getComponent()).getText();
				if (text.length() >= 16) // limit to 4 characters
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

	public JButton getValidarbtn() {
		return validarBtn;
	}

}
