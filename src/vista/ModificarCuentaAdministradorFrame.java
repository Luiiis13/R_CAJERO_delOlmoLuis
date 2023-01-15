package vista;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificarCuentaAdministradorFrame extends JFrame{

	private JLabel numeroLbl = new JLabel("Numero:");
	private JLabel ibanLbl = new JLabel("Iban:");
	private JLabel saldoLbl = new JLabel("saldo:");
	private JLabel tarjeta_asociadaLbl = new JLabel("Tarjeta_asociada:");
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
		contenedor.add(tarjeta_asociadaLbl);
		contenedor.add(tarjeta_asociadaTxt);
		contenedor.add(id_usuarioLbl);
		contenedor.add(id_usuarioTxt);
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
}
