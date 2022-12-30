package vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import listeners.PantallaInicioListener;

public class PantallaInicioFrame extends JFrame {

	private JLabel bienvenidaLbl = new JLabel("Bienvenido al cajero");
	private JButton comnezarBtn = new JButton("Comenzar");

	public PantallaInicioFrame() {

		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Pantalla de inicio");
		this.setSize(500, 500);
		this.getContentPane().add(this.bienvenidaLbl);
		this.comnezarBtn.setBackground(new java.awt.Color(50,205,50));
		this.comnezarBtn.setForeground(new java.awt.Color(255,255,255));
		this.getContentPane().add(this.comnezarBtn);
		this.setVisible(true);
		this.inicializar();
		this.pack();
	}

	private void inicializar() {
		this.comnezarBtn.addActionListener(new PantallaInicioListener(this));
	}
}
