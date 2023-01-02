package vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;

import listeners.CambiarNumeroSecretoBotonListener;

public class CambiarNumeroSecretoFrame extends JFrame {
// Clase que extiende de un Jframe para la opcion Cambiar el numero secreto 
	private JLabel mensajelbl = new JLabel("Escriba el nuevo pin de la tarjeta");
	private JPasswordField pinPassfield = new JPasswordField();
	private JLabel repetirMensajelbl = new JLabel("Repita el pin");
	private JPasswordField repetirPinPassfield = new JPasswordField();
	private JButton confirmarBtn = new JButton("Confirmar");
	private JPanel panel = new JPanel();

	public CambiarNumeroSecretoFrame() {
		this.add(panel);
		this.setContentPane(panel);
		this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setTitle("Ingresar dinero");
		this.limitarTamañoContraseña();
		this.setVisible(true);
		this.setSize(500, 500);
		this.panel.add(mensajelbl);
		this.panel.add(pinPassfield);
		this.panel.add(repetirMensajelbl);
		this.panel.add(repetirPinPassfield);
		this.panel.add(confirmarBtn);
		this.inicializar();
		this.pack();
	}

//Metodo que llama a un evento al pulsar el boton confirmar
	private void inicializar() {
		confirmarBtn.addActionListener(new CambiarNumeroSecretoBotonListener(this));
	}

	public JPasswordField getPinPassfield() {
		return pinPassfield;
	}

	public JPasswordField getRepetirPinPassfield() {
		return repetirPinPassfield;
	}
	
	private void limitarTamañoContraseña() {
		this.pinPassfield.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	           String text = ((JPasswordField)e.getComponent()).getText();
	        	if (text.length() >= 4 ) // limit to 4 characters
	                e.consume();
	        }
	    });
		
		this.repetirPinPassfield.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	           String text = ((JPasswordField)e.getComponent()).getText();
	        	if (text.length() >= 4 ) // limit to 4 characters
	                e.consume();
	        }
	    });
	}
}
