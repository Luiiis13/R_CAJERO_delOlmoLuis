package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;

import listeners.CambiarNumeroSecretoBotonListener;

public class CambiarNumeroSecretoFrame extends JFrame {

	private JLabel mensajelbl = new JLabel("Ponga el numero a asignar");
	private JPasswordField pinPassfield = new JPasswordField();
	private JLabel repetirMensajelbl = new JLabel("Repita el número");
	private JPasswordField repetirPinPassfield = new JPasswordField();
	private JButton confirmarBtn = new JButton("Confirmar");
	private JPanel panel = new JPanel();

	public CambiarNumeroSecretoFrame() {
		this.add(panel);
		this.setContentPane(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Ingresar dinero");
		this.setVisible(true);
		this.setSize(500, 500);
		this.panel.add(mensajelbl);
		this.panel.add(pinPassfield);
		this.panel.add(repetirMensajelbl);
		this.panel.add(repetirPinPassfield);
		this.panel.add(confirmarBtn);
		this.inicializar();
	}

	private void inicializar() {
		confirmarBtn.addActionListener(new CambiarNumeroSecretoBotonListener(this));
	}

	public JPasswordField getPinPassfield() {
		return pinPassfield;
	}

	public JPasswordField getRepetirPinPassfield() {
		return repetirPinPassfield;
	}
}
