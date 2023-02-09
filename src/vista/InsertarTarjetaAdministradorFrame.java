package vista;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import listeners.AgregarTarjetaAdministradorListener;

/***
 * Clase que implementa en la vista los distintos campos para poder añadir una
 * nueva tarjeta
 * 
 * @author Luis
 *
 */
public class InsertarTarjetaAdministradorFrame extends JFrame {

	private JLabel numeroLbl = new JLabel("Número:");
	private JLabel fecha_expiracionLbl = new JLabel("Fecha expiración:");
	private JLabel cvvLbl = new JLabel("Cvv:");
	private JLabel pinLbl = new JLabel("Pin:");
	private JLabel cuentaLbl = new JLabel("Cuenta:");
	private JTextField numeroTxt = new JTextField();
	private JTextField fechaExpiracionTxt = new JTextField();
	private JTextField cvvTxt = new JTextField();
	private JPasswordField pinTxt = new JPasswordField();
	private JTextField cuentaTxt = new JTextField();
	private JButton aceptarBtn = new JButton("Aceptar");
	private JButton cancelarBtn = new JButton("Cancelar");

	public InsertarTarjetaAdministradorFrame() {

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setTitle("Pantalla de administrar tarjeta");
		this.limitarTamañoPin();
		this.limitarTamañoCvv();
		this.limitarTamañoNumeroTarjeta();
		this.limitarTamañoNumeroCuenta();
		this.setSize(500, 500);
		JPanel contenedor = new JPanel();
		contenedor.setLayout(new GridLayout(5, 2));
		contenedor.add(numeroLbl);
		contenedor.add(numeroTxt);
		contenedor.add(fecha_expiracionLbl);
		contenedor.add(fechaExpiracionTxt);
		contenedor.add(cvvLbl);
		contenedor.add(cvvTxt);
		contenedor.add(pinLbl);
		contenedor.add(pinTxt);
		contenedor.add(cuentaLbl);
		contenedor.add(cuentaTxt);
		this.getContentPane().add(contenedor);
		JPanel contenedorBtn = new JPanel();
		contenedorBtn.setAlignmentX(CENTER_ALIGNMENT);
		contenedorBtn.add(aceptarBtn);
		this.getContentPane().add(contenedorBtn);
		this.inicializar();
		this.setVisible(true);
		this.pack();
	}

	public JTextField getNumeroTxt() {
		return numeroTxt;
	}

	public JTextField getFechaExpiracionTxt() {
		return fechaExpiracionTxt;
	}

	public JTextField getCvvTxt() {
		return cvvTxt;
	}

	public JPasswordField getPinTxt() {
		return pinTxt;
	}

	public JTextField getCuentaTxt() {
		return cuentaTxt;
	}

	/***
	 * Metodo que inicializa los distintos actionListeners
	 */
	public void inicializar() {
		this.aceptarBtn.addActionListener(new AgregarTarjetaAdministradorListener(this));
	}

	/***
	 * Metodo que sirve para limpiar los distintos campos
	 */
	public void limpiarCampos() {
		this.numeroTxt.setText("");
		this.fechaExpiracionTxt.setText("");
		this.cvvTxt.setText("");
		this.pinTxt.setText("");
		this.cuentaTxt.setText("");
	}

	/***
	 * Metodo que limita el campo de contraseña a 4 digitos
	 */
	private void limitarTamañoPin() {
		this.pinTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = ((JPasswordField) e.getComponent()).getText();
				if (text.length() >= 4)
					e.consume();
			}
		});
	}

	private void limitarTamañoCvv() {
		this.cvvTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = ((JTextField) e.getComponent()).getText();
				if (text.length() >= 3)
					e.consume();
			}
		});
	}

	/***
	 * Metodo que sirve para limitar el numero de carcteres en ese campo
	 */
	private void limitarTamañoNumeroTarjeta() {
		this.numeroTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = ((JTextField) e.getComponent()).getText();
				if (text.length() >= 16)
					e.consume();
			}
		});
	}

	/***
	 * Metodo que sirve para limitar el numero de carcteres en ese campo
	 */
	private void limitarTamañoNumeroCuenta() {
		this.cuentaTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = ((JTextField) e.getComponent()).getText();
				if (text.length() >= 20)
					e.consume();
			}
		});
	}
}
