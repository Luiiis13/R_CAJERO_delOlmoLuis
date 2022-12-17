package vista;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import listeners.IngresarDineroBotonListener;
//Clase la cual implementa el frame de ingresar dinero usuario cuando se pulsa el boton 
public class IngresarDineroFrame extends JFrame{
private JLabel mensajelbl = new JLabel("Seleccione la cantidad que desea ingresar ");
private JSpinner cantidadSpinner = new JSpinner();
private JButton confirmarBtn = new JButton("Confirmar");
private JPanel panel = new JPanel();

		public IngresarDineroFrame() {
			this.add(panel);
			this.setContentPane(panel);
			this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setTitle("Ingresar dinero");
			this.setVisible(true);
			this.setSize(500, 500);
			this.panel.add(mensajelbl);
			this.panel.add(cantidadSpinner);
			this.panel.add(confirmarBtn);
			this.inicializar();
			this.pack();
		}
		// metodo que añade un evento al pulsar el boton confirmar
		private void inicializar() {
			confirmarBtn.addActionListener(new IngresarDineroBotonListener(this));
		}
		public JSpinner getCantidadSpinner() {
			return cantidadSpinner;
		}
	}