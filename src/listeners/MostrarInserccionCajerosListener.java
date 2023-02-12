package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.InsertarCajeroAdministradorFrame;
/***
 * Clase que saca la vista del frame de insertar cajeros 
 * @author Luis
 *
 */
public class MostrarInserccionCajerosListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		InsertarCajeroAdministradorFrame insertarCajeroFrame = new InsertarCajeroAdministradorFrame();
	}

}
