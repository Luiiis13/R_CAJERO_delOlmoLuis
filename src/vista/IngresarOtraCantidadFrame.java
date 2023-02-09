package vista;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import listeners.IngresarOtraCantidadDineroListener;

/***
 * Clase que implementa el frame de ingresar otra cantidad cuando se selecciona
 * la opcion en el usuario
 * 
 * @author Luis
 *
 */
//Clase la cual implementa el frame de ingresar dinero usuario cuando se pulsa el boton 
public class IngresarOtraCantidadFrame extends JFrame {
	private JLabel mensajelbl = new JLabel("Seleccione la cantidad que desea ingresar ");
	private SpinnerModel sm = new SpinnerNumberModel(0, 0, 1000, 5);
	private JSpinner cantidadSpinner = new JSpinner(sm);
	private JButton confirmarBtn = new JButton("Confirmar");
	private JPanel panel = new JPanel();

	public IngresarOtraCantidadFrame() {
		this.add(panel);
		this.setContentPane(panel);
		this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setTitle("Ingresar dinero");
		this.setVisible(true);
		this.setSize(500, 500);
		this.panel.add(mensajelbl);
		this.panel.add(cantidadSpinner);
		this.panel.add(confirmarBtn);
		this.inicializar();
		this.pack();
	}

	/***
	 * metodo que añade un evento al pulsar el boton confirmar
	 */
	private void inicializar() {
		confirmarBtn.addActionListener(new IngresarOtraCantidadDineroListener(this));
	}

	public JSpinner getCantidadSpinner() {
		return cantidadSpinner;
	}
}