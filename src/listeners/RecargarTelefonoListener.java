package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.RecargarTelefonoFrame;

public class RecargarTelefonoListener implements ActionListener {
	private RecargarTelefonoFrame telefonoFrame;

	@Override
	public void actionPerformed(ActionEvent e) {
		this.telefonoFrame = new RecargarTelefonoFrame();
	}

}
