package vista;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listeners.IngresarCantidadDineroListener;
import listeners.IngresarDineroOpcionListener;
import listeners.IngresarOtraCantidadListener;
import listeners.RetirarOtraCantidadListener;
import listeners.SalirBotonListener;

/***
 * Clase que implementa el frame de ingresar una cantidad determinada a la
 * cuenta
 * 
 * @author Luis
 *
 */
public class IngresarDineroPrincipalFrame extends JFrame {
	private JLabel elegirLbl = new JLabel("Elige la cantidad a ingresar");
	private Button cincoBtn = new Button("Ingresar 5€");
	private Button veinticincoBtn = new Button("Ingresar 25€");
	private Button cincuentaBtn = new Button("Ingresar 50€");
	private Button setentaycincoBtn = new Button("Ingresar 75€");
	private Button cienBtn = new Button("Ingresar 100€");
	private Button otraCantidadBtn = new Button("Otra cantidad");

	public IngresarDineroPrincipalFrame() {
		this.setTitle("Retirar Dinero");
		this.setSize(500, 500);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(elegirLbl, BorderLayout.NORTH);
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
		this.getContentPane().add(panelIzquierdo, BorderLayout.WEST);
		panelIzquierdo.add(cincoBtn);
		panelIzquierdo.add(cincuentaBtn);
		panelIzquierdo.add(cienBtn);
		JPanel panelDerecho = new JPanel();
		panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
		this.getContentPane().add(panelDerecho, BorderLayout.EAST);
		panelDerecho.add(veinticincoBtn);
		panelDerecho.add(setentaycincoBtn);
		panelDerecho.add(otraCantidadBtn);
		this.inicializar();
		this.setVisible(true);
		this.pack();

	}

	/***
	 * Metodo que inicializa los actionListeners de los botones
	 */
	private void inicializar() {
		this.cincoBtn.addActionListener(new IngresarCantidadDineroListener(5));
		this.veinticincoBtn.addActionListener(new IngresarCantidadDineroListener(25));
		this.cincuentaBtn.addActionListener(new IngresarCantidadDineroListener(50));
		this.setentaycincoBtn.addActionListener(new IngresarCantidadDineroListener(75));
		this.cienBtn.addActionListener(new IngresarCantidadDineroListener(100));
		this.otraCantidadBtn.addActionListener(new IngresarOtraCantidadListener());
	}
}
