package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.RecargarOtraCantidadBonobusFrame;

public class RecargarOtraCantidadBonobusListener implements ActionListener {
	private RecargarOtraCantidadBonobusFrame frame;

	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame = new RecargarOtraCantidadBonobusFrame();

	}
}
