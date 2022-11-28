package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Opciones extends JFrame {
private JPanel panel = new JPanel();
private JTabbedPane jtab = new UsuarioJtabPane();
public Opciones() {
	this.add(panel);
	this.setContentPane(panel);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setTitle("Usuario");
	this.setVisible(true);
	this.setSize(500, 500);
	this.getContentPane().add(jtab);
	this.pack();
	}
}
