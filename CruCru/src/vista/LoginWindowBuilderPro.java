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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

public class LoginWindowBuilderPro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmLogin;
	private JTextField textUser;
	private JPasswordField textPassword;
	
	public LoginWindowBuilderPro(){
		inicializar();
	}
	/**
	 * Create the frame.
	 */
	private void inicializar() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100,100,450,300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new BorderLayout(0,0));
		
		JPanel panel_Norte = new JPanel();
		panel_Norte.setPreferredSize(new Dimension(100, 70));
		panel_Norte.setLayout(new FlowLayout(FlowLayout.CENTER, 5,15));
		frmLogin.getContentPane().add(panel_Norte,BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Proyecto de DDS \"Gestor de una BD\"");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_Norte.add(lblTitulo);
		
		JPanel panel_Oeste = new JPanel();
		frmLogin.getContentPane().add(panel_Oeste, BorderLayout.WEST);
		panel_Oeste.setLayout(new GridLayout(3, 1, 0, 0));
		
		Component rigidArea_O = Box.createRigidArea(new Dimension(40, 40));
		panel_Oeste.add(rigidArea_O);
		
		
		
		JPanel panel_Centro = new JPanel();
		frmLogin.getContentPane().add(panel_Centro, BorderLayout.CENTER);
		panel_Centro.setLayout(new GridLayout(4, 2, 0, 0));
		
		Component rigidArea_C1 = Box.createRigidArea(new Dimension(20, 20));
		panel_Centro.add(rigidArea_C1);
		
		JPanel panel_C1 = new JPanel();
		panel_Centro.add(panel_C1);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setPreferredSize(new Dimension(65, 14));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_C1.add(lblUsuario);
		
		textUser = new JTextField();
		textUser.setColumns(15);
		panel_C1.add(textUser);
		
		JPanel panel_C2 = new JPanel();
		panel_Centro.add(panel_C2);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setPreferredSize(new Dimension(65, 14));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_C2.add(lblPassword);
		
		textPassword = new JPasswordField();
		panel_C2.add(textPassword);
		textPassword.setColumns(15);
		
		JPanel panel_SUR = new JPanel();
		frmLogin.getContentPane().add(panel_SUR, BorderLayout.SOUTH);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_SUR.add(btnLogin);
		// BOTON LOGIN FUNCIONALIDAD
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//if (comprobarLogin()){
				
				MenuWindowBuilderPro menu = new MenuWindowBuilderPro();
				menu.mostrarVentana();
				frmLogin.dispose();
				
				//}else {
				/*
				JOptionPane.showMessageDialog(frmLogin,
				"Nombre de usuario o contraseña no valido",
				"Error", JOptionPane.ERROR_MESSAGE);
				*/
				//}
			}
		});
		// FIN BOTON LOGIN
		
		Component rigidArea_S1 = Box.createRigidArea(new Dimension(40,40));
		panel_SUR.add(rigidArea_S1);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setVerticalAlignment(SwingConstants.BOTTOM);
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

}
