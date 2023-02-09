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

import listeners.EditarCuentasAdministradorListener;

/***
 * Clase que implementa la vista para poder modificar una cuenta desde las
 * opciones de administrador
 * 
 * @author Luis
 *
 */

public class ModificarCuentaAdministradorFrame extends JFrame {
	private int idCuenta;

	private JLabel numeroLbl = new JLabel("Numero:");
	private JLabel ibanLbl = new JLabel("Iban:");
	private JLabel saldoLbl = new JLabel("saldo:");
//	private JLabel tarjeta_asociadaLbl = new JLabel("Tarjeta_asociada:");
	private JLabel id_usuarioLbl = new JLabel("Id usuario:");
	private JTextField numeroTxt = new JTextField();
	private JTextField ibanTxt = new JTextField();
	private JTextField saldoTxt = new JTextField();
	private JTextField tarjeta_asociadaTxt = new JTextField();
	private JTextField id_usuarioTxt = new JTextField();

	private JButton aceptarBtn = new JButton("Aceptar");
	private JButton cancelarBtn = new JButton("Cancelar");

	public ModificarCuentaAdministradorFrame() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setTitle("Pantalla de administrar Cuenta");
		this.setSize(500, 500);
		JPanel contenedor = new JPanel();
		contenedor.setLayout(new GridLayout(5, 2));
		contenedor.add(numeroLbl);
		contenedor.add(numeroTxt);
		contenedor.add(ibanLbl);
		contenedor.add(ibanTxt);
		contenedor.add(saldoLbl);
		contenedor.add(saldoTxt);
		// contenedor.add(tarjeta_asociadaLbl);
		contenedor.add(tarjeta_asociadaTxt);
		contenedor.add(id_usuarioLbl);
		contenedor.add(id_usuarioTxt);
		this.getContentPane().add(contenedor);
		JPanel contenedorBtn = new JPanel();
		contenedorBtn.setAlignmentX(CENTER_ALIGNMENT);
		contenedorBtn.add(aceptarBtn);
		this.getContentPane().add(contenedorBtn);
		this.limitarTamañoIban();
		this.limitarTamañoNumero();
		this.setVisible(true);
		this.pack();
	}

	public JTextField getNumeroTxt() {
		return numeroTxt;
	}

	public JTextField getIbanTxt() {
		return ibanTxt;
	}

	public JTextField getSaldoTxt() {
		return saldoTxt;
	}

	public JTextField getTarjeta_asociadaTxt() {
		return tarjeta_asociadaTxt;
	}

	public JTextField getId_usuarioTxt() {
		return id_usuarioTxt;
	}

	public void setNumeroTxt(String numeroTxt) {
		this.numeroTxt.setText(numeroTxt);

	}

	public void setIbanTxt(String ibanTxt) {
		this.ibanTxt.setText(ibanTxt);
	}

	public void setSaldoTxt(float saldoTxt) {
		this.saldoTxt.setText(String.valueOf(saldoTxt));
	}

//	public void setTarjeta_asociadaTxt(JTextField tarjeta_asociadaTxt) {
//		this.tarjeta_asociadaTxt = tarjeta_asociadaTxt;
//	}

	public void setId_usuarioTxt(int id_usuarioTxt) {
		this.id_usuarioTxt.setText(String.valueOf(id_usuarioTxt));
	}

	/***
	 * Metodo que permite limpiar los distintos campos de texto a rellenar
	 */
	public void limpiarCampos() {
		this.numeroTxt.setText("");
		this.ibanTxt.setText("");
		this.saldoTxt.setText("");
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	/***
	 * Metodo que inicializa el actionListener
	 */
	public void inicializar() {
		this.aceptarBtn.addActionListener(new EditarCuentasAdministradorListener(this));
	}

	/***
	 * Metodo que permite limitar el número de carecteres del campo de texto de
	 * numero
	 */
	private void limitarTamañoNumero() {
		this.numeroTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = ((JTextField) e.getComponent()).getText();
				if (text.length() >= 20)
					e.consume();
			}
		});
	}

	/***
	 * Metodo que permite limitar el número de carecteres en el campo iban
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
}
