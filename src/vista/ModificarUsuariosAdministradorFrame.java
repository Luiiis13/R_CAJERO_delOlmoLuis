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

import listeners.EditarUsuariosAdministradorListener;

/***
 * Clase que implementa la vista para poder modificar un usuario desde las
 * opciones de administrador
 * 
 * @author Luis
 *
 */
public class ModificarUsuariosAdministradorFrame extends JFrame {
	private int idUsuario;
	private JLabel nombreLbl = new JLabel("Nombre:");
	private JLabel dniLbl = new JLabel("Dni:");
	private JLabel primerApellidoLbl = new JLabel("Primer apellido:");
	private JLabel contraseņaLbl = new JLabel("Contraseņa:");
	private JLabel esAdminLbl = new JLabel("Administrador:");
	private JTextField nombreTxt = new JTextField();
	private JTextField dniTxt = new JTextField();
	private JTextField primerApellidoTxt = new JTextField();
	private JCheckBox esAdmin = new JCheckBox();
	private JPasswordField contraseņaField = new JPasswordField();
	private JButton aceptarBtn = new JButton("Aceptar");
	private JButton cancelarBtn = new JButton("Cancelar");

	public ModificarUsuariosAdministradorFrame() {

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
		contenedor.add(contraseņaLbl);
		contenedor.add(contraseņaField);
		contenedor.add(esAdminLbl);
		contenedor.add(esAdmin);
		this.getContentPane().add(contenedor);
		JPanel contenedorBtn = new JPanel();
		contenedorBtn.setAlignmentX(CENTER_ALIGNMENT);
		contenedorBtn.add(aceptarBtn);
		this.getContentPane().add(contenedorBtn);
		this.setVisible(true);
		this.inicializar();
		this.limitarTamaņoDni();
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
		return esAdmin;
	}

	public JPasswordField getContraseņaField() {
		return contraseņaField;
	}

	/***
	 * Metodo para inicializar el actionListener
	 */
	private void inicializar() {
		this.aceptarBtn.addActionListener(new EditarUsuariosAdministradorListener(this));
	}

	/***
	 * Metodo que sirve para poder poner vacios los distintos campos que editaremos
	 */
	public void limpiarCampos() {
		this.contraseņaField.setText("");
		this.nombreTxt.setText("");
		this.dniTxt.setText("");
		this.primerApellidoTxt.setText("");

	}

	public void setNombreTxt(String nombreTxt) {
		this.nombreTxt.setText(nombreTxt);
	}

	public void setDniTxt(String dniTxt) {
		this.dniTxt.setText(dniTxt);
	}

	public void setPrimerApellidoTxt(String primerApellidoTxt) {
		this.primerApellidoTxt.setText(primerApellidoTxt);
	}

	public void setIsAdmin(boolean isAdmin) {
		this.esAdmin.setSelected(isAdmin);
	}

	public void setContraseņaField(String contraseņa) {
		this.contraseņaField.setText(contraseņa);
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	private void limitarTamaņoDni() {
		this.dniTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = ((JTextField) e.getComponent()).getText();
				if (text.length() >= 9)
					e.consume();
			}
		});
	}
}
