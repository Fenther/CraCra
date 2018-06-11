package vista;


import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



import java.awt.Toolkit;




import controlador.ControladorM;
import controlador.ControladorMPrueba;
import modelo.DAOpruebaInterface;
import modelo.DAOpruebaMYSQL;
import modelo.DTOpruebaVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;

public class MenuWindowBuilderProPrueba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frmMenu;
	private JTextField textFieldDescripcion;
	private JTextField textFieldCategoria;
	private JTextField textFieldId;
	
	
	/**
	 * Create the frame.
	 */
	public MenuWindowBuilderProPrueba() {
		inicializar();
	}
	
	private void inicializar(){

		
		frmMenu = new JFrame();
		frmMenu.setForeground(Color.GRAY);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frmMenu.setBounds(0, 0,screen.width - 500,screen.height - 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmMenu.setLocation(dim.width/2-frmMenu.getSize().width/2, dim.height/2-frmMenu.getSize().height/2);
		
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.setTitle("Menu Principal");
		
		JButton btnNewButton = new JButton("Vista Arrestos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel panel_1 = new JPanel();
		
		JButton btnNewButton_2 = new JButton("Atras");
		
		JLabel lblNewLabel = new JLabel("Descripci\u00F3n:");
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setColumns(10);
		
		textFieldCategoria = new JTextField();
		textFieldCategoria.setColumns(10);
		
		JButton button = new JButton("A\u00F1adir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textFieldId.getText().trim());
				String descripcion = textFieldDescripcion.getText().trim();
				String categoria = textFieldDescripcion.getText().trim();
				ControladorMPrueba.funcionalidadBotonAñadir(id, descripcion, categoria);
			}
		});
		
		JLabel lblIddescripcion = new JLabel("Id:");
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(6)
									.addComponent(lblCategora)
									.addGap(18)
									.addComponent(textFieldCategoria, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblIddescripcion)
										.addComponent(lblNewLabel))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldDescripcion, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))))
							.addGap(1064))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(147))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIddescripcion)
						.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(37)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategora)
						.addComponent(textFieldCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(308)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(button))
					.addGap(72))
		);
		panel_1.setLayout(gl_panel_1);
		frmMenu.getContentPane().setLayout(new MigLayout("", "[1px][215px][761.00px,grow][][838px,grow,center]", "[33.00px][][23px][][6px][72.00px][510px,bottom]"));
		frmMenu.getContentPane().add(btnNewButton, "cell 1 0,grow");
		
		JButton btnGeneradorInforme = new JButton("Vista Informes");
		frmMenu.getContentPane().add(btnGeneradorInforme, "cell 1 1,grow");
		
		JButton btnAnyadirAgente = new JButton("A\u00F1adir Agente");
		btnAnyadirAgente.addActionListener(ControladorM.funcionalidadBotonVistaAgente(frmMenu));
		frmMenu.getContentPane().add(btnAnyadirAgente, "cell 2 1,alignx center");
		
		JButton btnAadirSospechoso = new JButton("A\u00F1adir Sospechoso");
		btnAadirSospechoso.addActionListener(ControladorM.funcionalidadBotonVistaSospechoso(frmMenu));
		frmMenu.getContentPane().add(btnAadirSospechoso, "cell 4 1");
		
		JButton btnGeneradorPruebas = new JButton("Vista Pruebas");
		frmMenu.getContentPane().add(btnGeneradorPruebas, "cell 1 2,grow");
		
		JButton btnAadirPrueba = new JButton("A\u00F1adir Prueba");
		
		frmMenu.getContentPane().add(btnAadirPrueba, "cell 2 2,alignx center");
		
		JButton btnCrearInforme = new JButton("A\u00F1adir Informe");
		btnCrearInforme.addActionListener(ControladorM.funcionalidadBotonVistaInforme(frmMenu));
		frmMenu.getContentPane().add(btnCrearInforme, "cell 4 2,alignx center");
		
		JButton btnVistasSospechosos = new JButton("Vista Sospechosos");
		frmMenu.getContentPane().add(btnVistasSospechosos, "cell 1 3");
		
		JButton btnAadirArresto = new JButton("A\u00F1adir Arresto");
		btnAadirArresto.addActionListener(ControladorM.funcionalidadBotonVistaArresto(frmMenu));
		frmMenu.getContentPane().add(btnAadirArresto, "cell 2 3,alignx center");
		
		JButton btnVistaAgentes = new JButton("Vista Agentes");
		frmMenu.getContentPane().add(btnVistaAgentes, "cell 1 5,growx");
		frmMenu.getContentPane().add(panel_1, "cell 1 6 4 1,alignx trailing,growy");

	}
	
	public void mostrarVentana(){
		frmMenu.setVisible(true);
	}
	public void ocultarVentana() {
		frmMenu.setVisible(false);
	}
	
	public void imprimir() {
		System.out.println("Este metodo debe ejecutarse ok del todo");
	}
}