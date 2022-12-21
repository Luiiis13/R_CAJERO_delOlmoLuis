package vista;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MovimientosFrame extends JFrame {
	private JLabel saldolbl = new JLabel("Saldo actual: ");
	private JLabel movimientoslbl = new JLabel("Movimientos");
	private JPanel panel = new JPanel();
	private JTable table;
	private JScrollPane scroll =new JScrollPane();
	private ModeloTablaMovimientos modelo;
	
	public MovimientosFrame() {
		this.add(panel);
		this.setContentPane(panel);
		this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setTitle("Saldo y movimientos");
		this.setVisible(true);
		this.setSize(500, 500);
		this.panel.add(saldolbl);
		this.panel.add(movimientoslbl);
		getContentPane().add(scroll);// Para agregar el scrool al panel 
		this.modelo=new ModeloTablaMovimientos() ;
		this.table=new JTable(this.modelo);
		this.scroll.setViewportView(this.table);

	}

	public ModeloTablaMovimientos getModelo() {
		return modelo;
	}

	public JLabel getSaldolbl() {
		return saldolbl;
	}

}
