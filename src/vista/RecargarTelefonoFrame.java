package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listeners.RecargarBonobusListener;
import listeners.RecargarOtraCantidadBonobusFrameListener;
import listeners.RecargarOtraCantidadTelefonoFrameListener;
import listeners.RecargarTelefonoListener;

public class RecargarTelefonoFrame extends JFrame {
	private JLabel elegirLbl = new JLabel("Elige la cantidad a recargar");
	private Button cincoBtn = new Button("Recargar 5€");
	private Button diezBtn = new Button("Recargar 10€");
	private Button quinceBtn = new Button("Recargar 15€");
	private Button veinteBtn = new Button("Recargar 20€");
	private Button otraCantidadBtn = new Button("Otra cantidad");

	public RecargarTelefonoFrame() {
		this.setTitle("Recargar Dinero");
		this.setSize(500, 500);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(elegirLbl, BorderLayout.NORTH);
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
		this.getContentPane().add(panelIzquierdo, BorderLayout.WEST);
		panelIzquierdo.add(cincoBtn);
		panelIzquierdo.add(quinceBtn);
		JPanel panelDerecho = new JPanel();
		panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
		this.getContentPane().add(panelDerecho, BorderLayout.EAST);
		panelDerecho.add(diezBtn);
		panelDerecho.add(veinteBtn);
		panelDerecho.add(otraCantidadBtn);
		this.inicializar();
		this.setVisible(true);
		this.pack();
	}

	public void inicializar() {
		this.otraCantidadBtn.addActionListener(new RecargarOtraCantidadTelefonoFrameListener());
		this.cincoBtn.addActionListener(new RecargarTelefonoListener(5));
		this.diezBtn.addActionListener(new RecargarTelefonoListener(10));
		this.quinceBtn.addActionListener(new RecargarTelefonoListener(15));
		this.veinteBtn.addActionListener(new RecargarTelefonoListener(20));
	}
}
