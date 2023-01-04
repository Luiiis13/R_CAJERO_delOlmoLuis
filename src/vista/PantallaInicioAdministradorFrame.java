package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class PantallaInicioAdministradorFrame extends JFrame {
	private JLabel nombreLbl = new JLabel("Nombre:");
	private JTextField nombreTxt = new JTextField();
	private JLabel contraseñaLbl = new JLabel("Contraseña:");
	private JPasswordField contraseñaField = new JPasswordField();
	private JButton aceptarBtn = new JButton("Aceptar");

	public PantallaInicioAdministradorFrame() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Pantalla de administrador");
		this.setSize(250, 120);
//		this.getContentPane().setMaximumSize(new Dimension(250,120));
		JPanel contenedor = new JPanel();
		contenedor.setLayout(new GridLayout(2, 2));
		contenedor.add(nombreLbl);
		contenedor.add(nombreTxt);
		contenedor.add(contraseñaLbl);
		contenedor.add(contraseñaField);
		this.getContentPane().add(contenedor);
		JPanel contenedorBtn = new JPanel();
		contenedorBtn.setAlignmentX(CENTER_ALIGNMENT);
		contenedorBtn.add(aceptarBtn);
		this.getContentPane().add(contenedorBtn);
		this.setVisible(true);
	}
}
