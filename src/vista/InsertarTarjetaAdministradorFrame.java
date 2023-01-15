package vista;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InsertarTarjetaAdministradorFrame extends JFrame {

	private JLabel numeroLbl = new JLabel("Numero:");
	private JLabel fecha_expiracionLbl = new JLabel("Fecha expiracion:");
	private JLabel cvvLbl = new JLabel("cvv:");
	private JLabel pinLbl = new JLabel("pin:");
	private JLabel bloqueadoLbl = new JLabel("bloqueado:");
	private JTextField numeroTxt = new JTextField();
	private JTextField fechaExpiracionTxt = new JTextField();
	private JTextField cvvTxt = new JTextField();
	private JTextField pinTxt = new JTextField();
	private JTextField bloqueadoTxt = new JTextField();
	private JButton aceptarBtn = new JButton("Aceptar");
	private JButton cancelarBtn = new JButton("Cancelar");

	public InsertarTarjetaAdministradorFrame() {

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setTitle("Pantalla de administrar tarjeta");
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
		contenedor.add(bloqueadoLbl);
		contenedor.add(bloqueadoTxt);
		this.getContentPane().add(contenedor);
		JPanel contenedorBtn = new JPanel();
		contenedorBtn.setAlignmentX(CENTER_ALIGNMENT);
		contenedorBtn.add(aceptarBtn);
		this.getContentPane().add(contenedorBtn);
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

	public JTextField getPinTxt() {
		return pinTxt;
	}

	public JTextField getBloqueadoTxt() {
		return bloqueadoTxt;
	}

}
