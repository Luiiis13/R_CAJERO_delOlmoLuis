package vista;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import listeners.RecargarOtraCantidadTelefonoListener;

/***
 * Clase que implementa la vista cuando se da al boton de recargar otra cantidad
 * en la opcion de teléfono
 * 
 * @author Luis
 *
 */
public class RecargarOtraCantidadTelefonoFrame extends JFrame {
	private int numeroTelefono;
	private JLabel mensajelbl = new JLabel("Seleccione la cantidad que desea recargar ");
	private SpinnerModel sm = new SpinnerNumberModel(0, 0, 1000, 5);
	private JSpinner cantidadSpinner = new JSpinner(sm);
	private JButton confirmarBtn = new JButton("Confirmar");
	private JPanel panel = new JPanel();

	public RecargarOtraCantidadTelefonoFrame() {
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
	 * Metodo que inicializa el actionlistener
	 */
	private void inicializar() {
		confirmarBtn.addActionListener(new RecargarOtraCantidadTelefonoListener(this));
	}

	public JSpinner getCantidadSpinner() {
		return cantidadSpinner;
	}
	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

}
