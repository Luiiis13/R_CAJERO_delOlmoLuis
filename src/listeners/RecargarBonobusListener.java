package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.RecargarBonobusFrame;

public class RecargarBonobusListener implements ActionListener {
	private RecargarBonobusFrame bonobusFrame;

	@Override
	public void actionPerformed(ActionEvent e) {
		bonobusFrame = new RecargarBonobusFrame();
	}

}
