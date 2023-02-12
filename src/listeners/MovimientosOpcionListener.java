package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.MovimientosControlador;
/***
 * Clase que sirve para crear la vista del frame de movimientos 
 * @author Luis
 *
 */
public class MovimientosOpcionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		MovimientosControlador movimientosControlador = new MovimientosControlador();

	}

}
