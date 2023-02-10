package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CancelarBotonListener implements ActionListener {
	private JFrame frame;

	public CancelarBotonListener(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.setVisible(false);
	}

}
