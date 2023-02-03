package vista;

import java.awt.GridLayout;
import java.sql.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.EditarTarjetasAdministradorListener;
import listeners.EditarUsuariosAdministradorListener;

public class ModificarTarjetaAdministradorFrame extends JFrame{
	private int idCuentaAsociada;
	private int idTarjeta;
	private JLabel numeroLbl = new JLabel("Numero:");
	private JLabel fecha_expiracionLbl = new JLabel("Fecha expiracion:");
	private JLabel cvvLbl = new JLabel("cvv:");
	private JLabel pinLbl = new JLabel("pin:");
	private JLabel bloqueadoLbl = new JLabel("bloqueado:");
	private JTextField numeroTxt = new JTextField();
	private JTextField fechaExpiracionTxt = new JTextField();
	private JTextField cvvTxt = new JTextField();
	private JTextField pinTxt = new JTextField();
	private JCheckBox bloqueadoTxt = new JCheckBox();
	private JButton aceptarBtn = new JButton("Aceptar");
	private JButton cancelarBtn = new JButton("Cancelar");

	public ModificarTarjetaAdministradorFrame() {

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

	public JTextField getPinTxt() {
		return pinTxt;
	}

	public JCheckBox getBloqueadoTxt() {
		return bloqueadoTxt;
	}

	public void setNumeroTxt(String numeroTxt) {
		this.numeroTxt.setText(numeroTxt);;
	}

//	public void setFechaExpiracionTxt(Date fechaExpiracionTxt) {
//		this.fechaExpiracionTxt.set
//	}

	public void setCvvTxt(int cvvTxt) {
		this.cvvTxt.setText(String.valueOf(cvvTxt));;
	}

	public void setPinTxt(int pinTxt) {
		this.pinTxt.setText(String.valueOf(pinTxt));;
	}

	public void setBloqueadoTxt(boolean bloqueadoTxt) {
		this.bloqueadoTxt.setSelected(bloqueadoTxt);
	}
	public void limpiarCampos() {
		this.numeroTxt.setText("");
		this.pinTxt.setText("");
		this.cvvTxt.setText("");
		
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public int getIdCuentaAsociada() {
		return idCuentaAsociada;
	}

	public void setIdCuentaAsociada(int idCuentaAsociada) {
		this.idCuentaAsociada = idCuentaAsociada;
	}

	private void inicializar() {
	this.aceptarBtn.addActionListener(new EditarTarjetasAdministradorListener(this));
	}
}
