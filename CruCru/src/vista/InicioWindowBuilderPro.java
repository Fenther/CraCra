package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.ControladorInicio;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

public class InicioWindowBuilderPro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frmLogin;
	
	public InicioWindowBuilderPro(){
		inicializar();
	}
	/**
	 * Create the frame.
	 */
	private void inicializar() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Inicio");
		frmLogin.setBounds(100,100,450,300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new BorderLayout(0,0));
		
		JPanel panel_Norte = new JPanel();
		panel_Norte.setPreferredSize(new Dimension(100, 70));
		panel_Norte.setLayout(new FlowLayout(FlowLayout.CENTER, 5,15));
		frmLogin.getContentPane().add(panel_Norte,BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Comisaria DDS");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 20));
		panel_Norte.add(lblTitulo);
		
		
		JPanel panel_Centro = new JPanel();
		frmLogin.getContentPane().add(panel_Centro, BorderLayout.CENTER);
		panel_Centro.setLayout(new GridLayout(4, 2, 0, 0));
		
		Component rigidArea_C1 = Box.createRigidArea(new Dimension(20, 20));
		panel_Centro.add(rigidArea_C1);
		
		JPanel panel_C1 = new JPanel();
		panel_Centro.add(panel_C1);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.addActionListener(ControladorInicio.funcionalidadBotonAdministrador(frmLogin));
		panel_C1.add(btnNewButton);
		
		JPanel panel_C2 = new JPanel();
		panel_Centro.add(panel_C2);
		
		JButton btnAgente = new JButton("Agente");
		btnAgente.addActionListener(ControladorInicio.funcionalidadBotonAgente(frmLogin));
		panel_C2.add(btnAgente);
		
		JPanel panel_C3 = new JPanel();
		panel_Centro.add(panel_C3);
		
		JButton btnNewButton_1 = new JButton("Agente Pruebas");
		btnNewButton_1.addActionListener(ControladorInicio.funcionalidadBotonAgentePruebas(frmLogin));
		panel_C3.add(btnNewButton_1);
		
		JPanel panel_SUR = new JPanel();
		frmLogin.getContentPane().add(panel_SUR, BorderLayout.SOUTH);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		panel_SUR.add(rigidArea_4);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		panel_SUR.add(rigidArea_3);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		panel_SUR.add(rigidArea_2);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel_SUR.add(rigidArea_1);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		panel_SUR.add(rigidArea);
		
		JButton btnSalir = new JButton("Salir");
		panel_SUR.add(btnSalir);
		btnSalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frmLogin.dispose();
				System.exit(0);
			}
		});
	}
	
	public void mostrarVentana(){
		frmLogin.setVisible(true);
	}
	
	
	public void ocultarVentana() {
		frmLogin.setVisible(false);
	}
	
}