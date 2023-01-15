package vista;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificarCajerosAdministradorFrame extends JFrame{
	private JLabel ubicacionLbl = new JLabel("Ubicacion:");
	private JTextField ubicacionTxt = new JTextField();
	private JButton aceptarBtn = new JButton("Aceptar");
	private JButton cancelarBtn = new JButton("Cancelar");

	public ModificarCajerosAdministradorFrame() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setTitle("Pantalla de administrar usuarios");
		this.setSize(500, 500);
		JPanel contenedor = new JPanel();
		contenedor.setLayout(new GridLayout(2, 2));
		contenedor.add(ubicacionLbl);
		contenedor.add(ubicacionTxt);
		this.getContentPane().add(contenedor);
		JPanel contenedorBtn = new JPanel();
		contenedorBtn.setAlignmentX(CENTER_ALIGNMENT);
		contenedorBtn.add(aceptarBtn);
		this.getContentPane().add(contenedorBtn);
		this.setVisible(true);
		this.pack();
	}

	public JTextField getUbicacionTxt() {
		return ubicacionTxt;
	}

}
