package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.AdministrarTarjetasFrame;
import vista.InsertarTarjetaAdministradorFrame;

public class MostrarInserccionTarjetasListener implements ActionListener{
private AdministrarTarjetasFrame frameTarjetas;
public MostrarInserccionTarjetasListener(AdministrarTarjetasFrame frame) {
	this.frameTarjetas=frame;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.frameTarjetas.setVisible(false);
		InsertarTarjetaAdministradorFrame insertarTarjeta = new InsertarTarjetaAdministradorFrame();
	}

}
