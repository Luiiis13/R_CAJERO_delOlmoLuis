package vista;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import listeners.EditarTarjetasAdministradorListener;
/***
 *  Clase que implementa la vista para poder modificar una tarjeta desde las
 * opciones de administrador
 * @author Luis
 *
 */
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
		this.limitarTamañoCvv();
		this.limitarTamañoNumeroTarjeta();
		this.limitarTamañoPin();
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
		this.cvvTxt.setText(String.valueOf(cvvTxt));
	}

	public void setPinTxt(int pinTxt) {
		this.pinTxt.setText(String.valueOf(pinTxt));
	}

	public void setBloqueadoTxt(boolean bloqueadoTxt) {
		this.bloqueadoTxt.setSelected(bloqueadoTxt);
	}
	/***
	 * Metodo que al abrir limpia los distintos campos a rellenar de la interfaz
	 */
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
	/***
	 * Metodo que limita el campo de cvv a 3 digitos
	 */
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
	 * Metodo que limita el campo de numero a 16 digitos
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
	
}
