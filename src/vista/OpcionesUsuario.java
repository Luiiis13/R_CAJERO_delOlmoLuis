package vista;

import java.awt.Button;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import listeners.CambiarNumeroSecretoOpcionListener;
import listeners.ExtraerDineroOpcionListener;
import listeners.IngresarDineroOpcionListener;
import listeners.MovimientosOpcionListener;

public class OpcionesUsuario extends JFrame{
	private JLabel elegirLbl = new JLabel("Elige una de las siguientes opciones");
	private Button retirarDineroBtn = new Button("Retirar dinero");
	private Button ingresarDineroBtn = new Button("Ingresar dinero");
	private Button cambiarNumeroBtn = new Button("Cambiar número secreto");
	private Button movimientosBtn = new Button("Ver movimientos y saldo de la cuenta");
	
	public OpcionesUsuario() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Opciones de usuario");
		this.setSize(500, 500);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.getContentPane().add(elegirLbl);
		this.ingresarDineroBtn.setBackground(new java.awt.Color(173,255,47));
		this.ingresarDineroBtn.setForeground(new java.awt.Color(0,0,0));
		this.getContentPane().add(ingresarDineroBtn);
		this.retirarDineroBtn.setBackground(new java.awt.Color(255,117,020));
		this.retirarDineroBtn.setForeground(new java.awt.Color(0,0,0));
	this.getContentPane().add(retirarDineroBtn);
	this.cambiarNumeroBtn.setBackground(new java.awt.Color(255,215,000));
	this.cambiarNumeroBtn.setForeground(new java.awt.Color(0,0,0));
	this.getContentPane().add(cambiarNumeroBtn);
	this.movimientosBtn.setBackground(new java.awt.Color(255,215,000));
	this.movimientosBtn.setForeground(new java.awt.Color(0,0,0));
	this.getContentPane().add(movimientosBtn);
		this.setVisible(true);
		this.pack();		
		this.inicializar();
		}

		private void inicializar() {
			this.retirarDineroBtn.addActionListener(new ExtraerDineroOpcionListener());
			this.ingresarDineroBtn.addActionListener(new IngresarDineroOpcionListener());
			this.cambiarNumeroBtn.addActionListener(new CambiarNumeroSecretoOpcionListener());
			this.movimientosBtn.addActionListener(new MovimientosOpcionListener());
		}
}
