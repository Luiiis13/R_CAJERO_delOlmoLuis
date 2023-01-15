package vista;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import listeners.AgregarUsuarioListener;

public class InsertarUsuarioAdministradorFrame extends JFrame {

	private JLabel nombreLbl = new JLabel("Nombre:");
	private JLabel edadLbl = new JLabel("Edad:");
	private JLabel primerApellidoLbl = new JLabel("Primer apellido:");
	private JLabel contraseñaLbl = new JLabel("Contraseña:");
	private JLabel isAdminLbl = new JLabel("Administrador:");
	private JTextField nombreTxt = new JTextField();
	private JTextField edadTxt = new JTextField();
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
		contenedor.add(edadLbl);
		contenedor.add(edadTxt);
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
		this.getContentPane().add(contenedorBtn);
		this.setVisible(true);
		this.inicializar();
		this.pack();

	}

	public JTextField getNombreTxt() {
		return nombreTxt;
	}
	public JTextField getEdadTxt() {
		return edadTxt;
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
	public void inicializar() {
		this.aceptarBtn.addActionListener(new AgregarUsuarioListener(this));
	}
}
