package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.RecargarOtraCantidadTelefonoFrame;

public class RecargarOtraCantidadTelefonoFrameListener implements ActionListener {
	private RecargarOtraCantidadTelefonoFrame frame;

	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame = new RecargarOtraCantidadTelefonoFrame();
	}
}
