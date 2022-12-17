package vista;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MovimientosFrame extends JFrame {
	private JLabel saldolbl = new JLabel("Saldo actual: ");
	private JPanel panel = new JPanel();

	public MovimientosFrame() {
		this.add(panel);
		this.setContentPane(panel);
		this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Saldo y movimientos");
		this.setVisible(true);
		this.setSize(500, 500);
		this.panel.add(saldolbl);
	}

	public JLabel getSaldolbl() {
		return saldolbl;
	}

}
