package vista;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import listeners.ExtraerOtraCantidadDineroListener;

/***
 * Clase que implementa el frame para seleccionar otra cantidad de dinero a
 * retirar
 * 
 * @author Luis
 *
 */
public class ExtraerOtraCantidadDineroFrame extends JFrame {
	private JLabel mensajelbl = new JLabel("Seleccione la cantidad que desea extraer ");
	private SpinnerModel sm = new SpinnerNumberModel(0, 0, 1000, 5);
	private JSpinner cantidadSpinner = new JSpinner(sm);
	private JButton confirmarBtn = new JButton("Confirmar");
	private JPanel panel = new JPanel();

	public ExtraerOtraCantidadDineroFrame() {
		this.add(panel);
		this.setContentPane(panel);
		this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setTitle("Extraer dinero");
		this.setVisible(true);
		this.setSize(500, 500);
		this.panel.add(mensajelbl);
		this.panel.add(cantidadSpinner);
		this.panel.add(confirmarBtn);
		this.inicializar();
		this.pack();
	}

	/***
	 * Metodo que sirve para inicializar el actionListener
	 */
	private void inicializar() {
		confirmarBtn.addActionListener(new ExtraerOtraCantidadDineroListener(this));
	}

	public JSpinner getCantidadSpinner() {
		return cantidadSpinner;
	}
}
