package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class OpcionesFrame extends JFrame {
private JPanel panel = new JPanel();
private JTabbedPane jtab;
public OpcionesFrame() {
	this.add(panel);
	this.setContentPane(panel);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setTitle("Usuario");
	this.setVisible(true);
	this.setSize(500, 500);
	this.jtab= new OpcionesTabPane();
	this.getContentPane().add(jtab);
	this.pack();
	}
}
