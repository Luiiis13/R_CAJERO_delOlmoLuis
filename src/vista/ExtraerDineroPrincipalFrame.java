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
import listeners.RetirarCantidadDineroListener;
import listeners.RetirarOtraCantidadListener;
import listeners.SalirBotonListener;
/***
 * Clase que implementa el frame para seleccionar una determinada cantidad a retirar de la cuenta 
 * @author Luis
 *
 */
public class ExtraerDineroPrincipalFrame extends JFrame {
	private JLabel elegirLbl = new JLabel("Elige la cantidad a retirar");
	private Button cincoBtn = new Button("Retirar 5€");
	private Button veinticincoBtn = new Button("Retirar 25€");
	private Button cincuentaBtn = new Button("Retirar 50€");
	private Button setentaycincoBtn = new Button("Retirar 75€");
	private Button cienBtn = new Button("Retirar 100€");
	private Button otraCantidadBtn = new Button("Otra cantidad");

	public ExtraerDineroPrincipalFrame() {
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
 * Metodo que sirve para incializar el actionListener de los botones 
 */
	private void inicializar() {
		this.otraCantidadBtn.addActionListener(new RetirarOtraCantidadListener(this));
		this.cincoBtn.addActionListener(new RetirarCantidadDineroListener(5));
		this.veinticincoBtn.addActionListener(new RetirarCantidadDineroListener(25));
		this.cincuentaBtn.addActionListener(new RetirarCantidadDineroListener(50));
		this.setentaycincoBtn.addActionListener(new RetirarCantidadDineroListener(75));
		this.cienBtn.addActionListener(new RetirarCantidadDineroListener(100));
	}
}
