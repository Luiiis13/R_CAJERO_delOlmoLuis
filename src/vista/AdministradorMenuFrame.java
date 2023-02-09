package vista;


import javax.swing.JFrame;
/***
 * Clase que implementa la vista del frame con la barra del menu 
 * @author Luis
 *
 */
public class AdministradorMenuFrame extends JFrame {
	private AdministradorMenuBar barra = new AdministradorMenuBar();

	public AdministradorMenuFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Menu");
		this.setSize(300, 300);
		this.setJMenuBar(this.barra);
		this.setVisible(true);
	}
}
