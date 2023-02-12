package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.CuentasControlador;
/***
 * Clase que sirve para sacar la vista de las cuentas que hay con sus datos 
 * @author Luis
 *
 */
public class AdministrarCuentasListener  implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		CuentasControlador cuentasControlador = new CuentasControlador();
		cuentasControlador.inicializar();
			
	}

}
