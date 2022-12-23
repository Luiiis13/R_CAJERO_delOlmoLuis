package vista;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdministrarUsuariosFrame extends JFrame{
	private JPanel panel = new JPanel();
	private JTable table;
	private JScrollPane scroll =new JScrollPane();
	private ModeloTablaUsuarios modelo;
	


	public AdministrarUsuariosFrame() {
		this.add(panel);
		this.setContentPane(panel);
		this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setTitle("Administrar usuarios");
		this.setVisible(true);
		this.setSize(500, 500);
		getContentPane().add(scroll);// Para agregar el scrool al panel 
		this.modelo=new ModeloTablaUsuarios();
		this.table=new JTable(this.modelo);
		this.scroll.setViewportView(this.table);
	}	
	public ModeloTablaUsuarios getModelo() {
		return modelo;
	}

}
