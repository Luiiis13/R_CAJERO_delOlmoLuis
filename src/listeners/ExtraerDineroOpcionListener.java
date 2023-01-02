package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.ExtraerDineroFrame;
import vista.RetirarDineroPrincipalFrame;

public class ExtraerDineroOpcionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		//ExtraerDineroFrame extraerDinero = new ExtraerDineroFrame();
		RetirarDineroPrincipalFrame retirarDinero = new RetirarDineroPrincipalFrame();
	}

}
