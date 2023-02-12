package vista;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import listeners.AgregarUsuarioAdministradorListener;
import listeners.CancelarBotonListener;

/***
 * Clase que implementa en la vista los distintos campos para poder añadir un
 * nuevo usuario
 * 
 * @author Luis
 *
 */
public class InsertarUsuarioAdministradorFrame extends JFrame {

	private JLabel nombreLbl = new JLabel("Nombre:");
	private JLabel dniLbl = new JLabel("Dni:");
	private JLabel primerApellidoLbl = new JLabel("Primer apellido:");
	private JLabel contraseñaLbl = new JLabel("Contraseña:");
	private JLabel isAdminLbl = new JLabel("Administrador:");
	private JTextField nombreTxt = new JTextField();
	private JTextField dniTxt = new JTextField();
	private JTextField primerApellidoTxt = new JTextField();
	private JCheckBox isAdmin = new JCheckBox();
	private JPasswordField contraseñaField = new JPasswordField();
	private JButton aceptarBtn = new JButton("Aceptar");
	private JButton cancelarBtn = new JButton("Cancelar");

	public InsertarUsuarioAdministradorFrame() {

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setTitle("Pantalla de administrar usuarios");
		this.setSize(500, 500);
		JPanel contenedor = new JPanel();
		contenedor.setLayout(new GridLayout(5, 2));
		contenedor.add(nombreLbl);
		contenedor.add(nombreTxt);
		contenedor.add(dniLbl);
		contenedor.add(dniTxt);
		contenedor.add(primerApellidoLbl);
		contenedor.add(primerApellidoTxt);
		contenedor.add(contraseñaLbl);
		contenedor.add(contraseñaField);
		contenedor.add(isAdminLbl);
		contenedor.add(isAdmin);
		this.getContentPane().add(contenedor);
		JPanel contenedorBtn = new JPanel();
		contenedorBtn.setAlignmentX(CENTER_ALIGNMENT);
		contenedorBtn.add(aceptarBtn);
		contenedorBtn.add(cancelarBtn);
		this.getContentPane().add(contenedorBtn);
		this.setVisible(true);
		this.inicializar();
		this.limitarTamañoDni();
		this.limitarTamañoPass();
		this.pack();

	}

	public JTextField getNombreTxt() {
		return nombreTxt;
	}

	public JTextField getDniTxt() {
		return dniTxt;
	}

	public JTextField getPrimerApellidoTxt() {
		return primerApellidoTxt;
	}

	public JCheckBox getIsAdmin() {
		return isAdmin;
	}

	public JPasswordField getContraseñaField() {
		return contraseñaField;
	}

	/***
	 * Metodo que inicializa el action listener
	 */
	public void inicializar() {
		this.aceptarBtn.addActionListener(new AgregarUsuarioAdministradorListener(this));
		this.cancelarBtn.addActionListener(new CancelarBotonListener(this));
	}

	/***
	 * Metodo que sirve para limitar el numero de caracteres que puedes agregar en
	 * ese campo
	 */
	private void limitarTamañoDni() {
		this.dniTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = ((JTextField) e.getComponent()).getText();
				if (text.length() >= 9)
					e.consume();
			}
		});
	}

	/***
	 * Metodo que sirve para limitar el numero de caracteres que puedes agregar en
	 * ese campo
	 */
	private void limitarTamañoPass() {
		this.contraseñaField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = ((JPasswordField) e.getComponent()).getText();
				if (text.length() >= 9)
					e.consume();
			}
		});
	}
}
