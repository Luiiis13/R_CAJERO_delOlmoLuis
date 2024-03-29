package vista;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listeners.CambiarNumeroSecretoOpcionListener;
import listeners.ExtraerDineroOpcionListener;
import listeners.IngresarDineroOpcionListener;
import listeners.MovimientosOpcionListener;
import listeners.RecargarBonobusBotonListener;
import listeners.RecargarTelefonoBotonListener;
import listeners.SalirBotonListener;

/***
 * Clase que implementa la vista de las distintas opciones que puede elegir un
 * usuario
 * 
 * @author Luis
 *
 */
public class OpcionesUsuario extends JFrame {
	private JLabel elegirLbl = new JLabel("Elige una de las siguientes opciones");
	private Button retirarDineroBtn = new Button("Retirar dinero");
	private Button ingresarDineroBtn = new Button("Ingresar dinero");
	private Button cambiarNumeroBtn = new Button("Cambiar n�mero secreto");
	private Button movimientosBtn = new Button("Ver movimientos y saldo de la cuenta");
	private Button recargarBonobusBtn = new Button("Recargar el bonobus");
	private Button recargarTelefonoBtn = new Button("Recargar el tel�fono");
	private Button salirBtn = new Button("Salir");

	public OpcionesUsuario() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Opciones de usuario");
		this.setSize(500, 500);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(elegirLbl, BorderLayout.NORTH);
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
		this.getContentPane().add(panelIzquierdo, BorderLayout.WEST);
		this.ingresarDineroBtn.setBackground(new java.awt.Color(173, 255, 47));
		this.ingresarDineroBtn.setForeground(new java.awt.Color(0, 0, 0));
		panelIzquierdo.add(ingresarDineroBtn);
		this.retirarDineroBtn.setBackground(new java.awt.Color(173, 255, 47));
		this.retirarDineroBtn.setForeground(new java.awt.Color(0, 0, 0));
		panelIzquierdo.add(retirarDineroBtn);

		JPanel panelDerecho = new JPanel();
		panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
		this.getContentPane().add(panelDerecho, BorderLayout.EAST);
		this.cambiarNumeroBtn.setBackground(new java.awt.Color(255, 215, 000));
		this.cambiarNumeroBtn.setForeground(new java.awt.Color(0, 0, 0));
		panelDerecho.add(cambiarNumeroBtn);
		this.movimientosBtn.setBackground(new java.awt.Color(255, 215, 000));
		this.movimientosBtn.setForeground(new java.awt.Color(0, 0, 0));
		panelDerecho.add(movimientosBtn);
		this.recargarBonobusBtn.setBackground(new java.awt.Color(255, 215, 000));
		this.recargarBonobusBtn.setForeground(new java.awt.Color(0, 0, 0));
		panelDerecho.add(recargarBonobusBtn);
		this.recargarTelefonoBtn.setBackground(new java.awt.Color(173, 255, 47)); // Opcion para poder cambiar de color
																					// el fondo de los botones
		this.recargarTelefonoBtn.setForeground(new java.awt.Color(0, 0, 0)); // Opcion para poder cambiar el color de
																				// las letras que vienen en el boton
		panelIzquierdo.add(recargarTelefonoBtn);
		this.salirBtn.setBackground(new java.awt.Color(255, 117, 020));
		this.salirBtn.setForeground(new java.awt.Color(0, 0, 0));
		panelIzquierdo.add(salirBtn);
		this.setVisible(true);
		this.pack();
		this.inicializar();
	}

	/***
	 * Metodo que inicializa los distintos actionListeners de los botones
	 */
	private void inicializar() {
		this.retirarDineroBtn.addActionListener(new ExtraerDineroOpcionListener());
		this.ingresarDineroBtn.addActionListener(new IngresarDineroOpcionListener());
		this.cambiarNumeroBtn.addActionListener(new CambiarNumeroSecretoOpcionListener());
		this.movimientosBtn.addActionListener(new MovimientosOpcionListener());
		this.recargarBonobusBtn.addActionListener(new RecargarBonobusBotonListener());
		this.recargarTelefonoBtn.addActionListener(new RecargarTelefonoBotonListener());
		this.salirBtn.addActionListener(new SalirBotonListener());
	}
}
