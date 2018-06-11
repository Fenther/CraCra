package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Component;

import javax.swing.Box;

import controlador.FlagsUsuario;

public class MenuWindowBuilderPro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frmMenu;
	
	/**
	 * Create the frame.
	 */
	public MenuWindowBuilderPro() {
		inicializar();
	}
	public MenuWindowBuilderPro(FlagsUsuario u) {
		inicializar();
	}
	
	private void inicializar(){
		
		frmMenu = new JFrame();
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.setTitle("Menu Principal");
		frmMenu.setBounds(100,100,450,300);
		frmMenu.getContentPane().setLayout(new BorderLayout(0,0));
		
		JPanel panel_Centro = new JPanel();
		panel_Centro.setPreferredSize(new Dimension(100, 200));
		frmMenu.getContentPane().add(panel_Centro, BorderLayout.CENTER);
		panel_Centro.setLayout(new GridLayout(0, 1, 0, 0));
		
		Component rigidArea_C1 = Box.createRigidArea(new Dimension(20, 15));
		panel_Centro.add(rigidArea_C1);
		
		
		JButton btnVistaAbiertos = new JButton("Vista Abiertos");
		panel_Centro.add(btnVistaAbiertos);
		
		Component rigidArea_C2 = Box.createRigidArea(new Dimension(20, 10));
		panel_Centro.add(rigidArea_C2);
		
		JButton VistaCerrados = new JButton("Vista Cerrados");
		panel_Centro.add(VistaCerrados);
		
		Component rigidArea_C3 = Box.createRigidArea(new Dimension(20, 10));
		panel_Centro.add(rigidArea_C3);
		
		JButton btnCrearNuevaEntrada = new JButton("Crear nueva entrada");
		panel_Centro.add(btnCrearNuevaEntrada);
		
		Component rigidArea_C4 = Box.createRigidArea(new Dimension(20, 10));
		panel_Centro.add(rigidArea_C4);
		
		JPanel panel = new JPanel();
		panel_Centro.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindowBuilderPro login = new LoginWindowBuilderPro();
				login.mostrarVentana();
				frmMenu.dispose();
			}
		});
		panel.add(btnLogout);
		
		Component rigidArea = Box.createRigidArea(new Dimension(40, 20));
		panel.add(rigidArea);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.dispose();
				System.exit(0);
			}
		});
		panel.add(btnSalir);
		
		Component rigidArea_C5 = Box.createRigidArea(new Dimension(20, 15));
		panel_Centro.add(rigidArea_C5);
		
		Component rigidArea_Oeste = Box.createRigidArea(new Dimension(40, 20));
		frmMenu.getContentPane().add(rigidArea_Oeste, BorderLayout.WEST);
		
		Component rigidArea_Este = Box.createRigidArea(new Dimension(40, 20));
		frmMenu.getContentPane().add(rigidArea_Este, BorderLayout.EAST);
		btnVistaAbiertos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				DirectorBuilderEntradas entradasAbiertas = new DirectorBuilderEntradas(new EntradasAbiertasWindowBuilderPro());
				entradasAbiertas.ConstruirVistaEntrada();
			
			};
		});

	}
	public void mostrarVentana(){
		frmMenu.setVisible(true);
	}

}
