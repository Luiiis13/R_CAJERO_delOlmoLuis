package vista;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import listeners.IngresarDineroBotonListener;
//Clase la cual implementa el frame de ingresar dinero usuario cuando se pulsa el boton 
public class IngresarDineroFrame extends JFrame{
private JLabel mensajelbl = new JLabel("Seleccione la cantidad que desea ingresar ");
private SpinnerModel sm = new SpinnerNumberModel(0, 0, 1000, 1);
private JSpinner cantidadSpinner = new JSpinner(sm);
private JButton confirmarBtn = new JButton("Confirmar");
private JPanel panel = new JPanel();

		public IngresarDineroFrame() {
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
		// metodo que a�ade un evento al pulsar el boton confirmar
		private void inicializar() {
			confirmarBtn.addActionListener(new IngresarDineroBotonListener(this));
		}
		public JSpinner getCantidadSpinner() {
			return cantidadSpinner;
		}
	}