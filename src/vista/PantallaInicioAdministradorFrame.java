package vista;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import listeners.SesionAdministradorListener;

/***
 * Clase que implementa la vista para ver si un determinado usuario es
 * administrador a traves de dos campos ,Dni y contrase�a
 * 
 * @author Luis
 *
 */
public class PantallaInicioAdministradorFrame extends JFrame {
	private JLabel dniLbl = new JLabel("Dni:");
	private JTextField dniTxt = new JTextField();
	private JLabel contrase�aLbl = new JLabel("Contrase�a:");
	private JPasswordField contrase�aField = new JPasswordField();
	private JButton aceptarBtn = new JButton("Aceptar");

	public PantallaInicioAdministradorFrame() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Pantalla de administrador");
		this.limitarTama�oDni();
		this.setSize(250, 120);
		JPanel contenedor = new JPanel();
		contenedor.setLayout(new GridLayout(2, 2));
		contenedor.add(dniLbl);
		contenedor.add(dniTxt);
		contenedor.add(contrase�aLbl);
		contenedor.add(contrase�aField);
		this.getContentPane().add(contenedor);
		JPanel contenedorBtn = new JPanel();
		contenedorBtn.setAlignmentX(CENTER_ALIGNMENT);
		contenedorBtn.add(aceptarBtn);
		this.getContentPane().add(contenedorBtn);
		this.inicializar();
		this.setVisible(true);

	}

	public JTextField getDniTxt() {
		return dniTxt;
	}

	public JPasswordField getContrase�aField() {
		return contrase�aField;
	}

	/***
	 * Metodo para inicializar los actionListener
	 */
	public void inicializar() {
		this.aceptarBtn.addActionListener(new SesionAdministradorListener(this));
	}

	/***
	 * Metodo que sirve para limitar los caractares que se pueden a�adir en el campo
	 * dni
	 */
	private void limitarTama�oDni() {
		this.dniTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = ((JTextField) e.getComponent()).getText();
				if (text.length() >= 9)
					e.consume();
			}
		});
	}

	


}
