package vista;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.AgregarCuentaAdministradorListener;
import listeners.CancelarBotonListener;

/***
 * Clase que implementa en la vista los distintos campos para poder añadir una
 * nueva cuenta
 * 
 * @author Luis
 *
 */
public class InsertarCuentaAdministradorFrame extends JFrame {

	private JLabel numeroLbl = new JLabel("Número:");
	private JLabel ibanLbl = new JLabel("IBAN:");
	private JTextField numeroTxt = new JTextField();
	private JTextField ibanTxt = new JTextField();

	private JButton aceptarBtn = new JButton("Aceptar");
	private JButton cancelarBtn = new JButton("Cancelar");

	public InsertarCuentaAdministradorFrame() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setTitle("Pantalla de administrar Cuenta");
		this.limitarTamañoNumero();
		this.limitarTamañoIban();
		this.setSize(500, 500);
		JPanel contenedor = new JPanel();
		contenedor.setLayout(new GridLayout(2, 2));
		contenedor.add(numeroLbl);
		contenedor.add(numeroTxt);
		contenedor.add(ibanLbl);
		contenedor.add(ibanTxt);
		this.getContentPane().add(contenedor);
		JPanel contenedorBtn = new JPanel();
		contenedorBtn.setAlignmentX(CENTER_ALIGNMENT);
		contenedorBtn.add(aceptarBtn);
		contenedorBtn.add(cancelarBtn);
		this.getContentPane().add(contenedorBtn);
		this.inicializar();
		this.setVisible(true);
		this.pack();
	}

	public JTextField getNumeroTxt() {
		return numeroTxt;
	}

	public JTextField getIbanTxt() {
		return ibanTxt;
	}

	/***
	 * Metodo que sirve para limitar el numero de carcteres en ese campo
	 */
	private void limitarTamañoNumero() {
		this.numeroTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = ((JTextField) e.getComponent()).getText();
				if (text.length() >= 20) // limit to 4 characters
					e.consume();
			}
		});
	}

	/***
	 * Metodo que sirve para limitar el numero de carcteres en ese campo
	 */
	private void limitarTamañoIban() {
		this.ibanTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = ((JTextField) e.getComponent()).getText();
				if (text.length() >= 24) // limit to 4 characters
					e.consume();
			}
		});
	}

	/***
	 * Metodo que sirve para inicializar el actionListener
	 */
	private void inicializar() {
		this.aceptarBtn.addActionListener(new AgregarCuentaAdministradorListener(this));
		this.cancelarBtn.addActionListener(new CancelarBotonListener(this));

	}

	/***
	 * Metodo que sirve para limpiar los distintos campos
	 */
	public void limpiarCampos() {
		this.numeroTxt.setText("");
		this.ibanTxt.setText("");
	}
}
