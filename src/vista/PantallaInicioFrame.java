package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listeners.InicioSesionAdministradorListener;
import listeners.PantallaInicioUsuarioListener;
/***
 * 
 * @author Luis
 * Clase que sirve para mostrar un panel de bienvenida al cajero con dos botones comenzar y comenzar como administrador 
 */
public class PantallaInicioFrame extends JFrame {

	private JLabel bienvenidaLbl = new JLabel("Bienvenido al cajero");
	private JButton comnezarBtn = new JButton("Comenzar");
	private JButton opcionesDeAdministradorBtn = new JButton("Comenzar como administrador");
	public PantallaInicioFrame() {

		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Pantalla de inicio");
		this.setSize(500, 500);
		this.getContentPane().add(this.bienvenidaLbl,BorderLayout.NORTH);
		JPanel contenedorBotones = new JPanel();
		this.getContentPane().add(contenedorBotones,BorderLayout.CENTER);
		contenedorBotones.setLayout(new FlowLayout());
		this.comnezarBtn.setBackground(new java.awt.Color(50,205,50));
		this.comnezarBtn.setForeground(new java.awt.Color(255,255,255));
		contenedorBotones.add(this.comnezarBtn);
		this.opcionesDeAdministradorBtn.setBackground(new java.awt.Color(50,205,50));
		this.opcionesDeAdministradorBtn.setForeground(new java.awt.Color(255,255,255));
		contenedorBotones.add(this.opcionesDeAdministradorBtn);
		this.setVisible(true);
		this.inicializar();
		this.pack();
	}
/***
 * Metodo que invoca a los action listener de cada uno 
 */
	private void inicializar() {
		this.comnezarBtn.addActionListener(new PantallaInicioUsuarioListener(this));
		this.opcionesDeAdministradorBtn.addActionListener(new InicioSesionAdministradorListener(this));
	}
}
