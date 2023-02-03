package vista;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import listeners.EliminarCuentasAdministradorListener;
import listeners.MostrarInserccionCuentasListener;

public class AdministrarCuentasFrame extends JFrame{
	private JPanel panelTabla = new JPanel();
	private JPanel panelBotones = new JPanel();
	private JTable table;
	private JScrollPane scroll = new JScrollPane();
	private ModeloTablaCuentas modelo;
	private JButton insertarbtn = new JButton("Nuevo");
	private JButton modificarbtn = new JButton("Modificar");
	private JButton eliminarbtn = new JButton("Eliminar");
	public AdministrarCuentasFrame() {
		
		this.setTitle("Administrar Cuentas");
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		this.setSize(500, 500);
		this.modelo = new ModeloTablaCuentas();
		this.table = new JTable(this.modelo);
		this.scroll.setViewportView(this.table);
		c.add(this.panelTabla);
		this.panelTabla.add(scroll);// Para agregar el scrool al panel

		this.panelBotones.setLayout(new FlowLayout());
		c.add(this.panelBotones);
		this.panelBotones.add(insertarbtn);
		this.panelBotones.add(modificarbtn);
		this.panelBotones.add(eliminarbtn);
		this.setVisible(true);
		this.inicializar();
	}

	public ModeloTablaCuentas getModelo() {
		return modelo;
	}	
	public void inicializar() {
		this.insertarbtn.addActionListener(new MostrarInserccionCuentasListener());
		this.modificarbtn.addActionListener(new MostrarInserccionCuentasListener());
		this.eliminarbtn.addActionListener(new EliminarCuentasAdministradorListener(this));
	}
}
