package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.Color;

import controlador.ControladorM;
import controlador.ControladorMAgente;
import controlador.FlagsUsuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import net.miginfocom.swing.MigLayout;

public class MenuWindowBuilderProAgente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frmMenu;
	private JTextField textFieldNombre;
	private JTextField textFieldNumPlaca;
	private JTextField textFieldApellidos;

	public MenuWindowBuilderProAgente() {
		inicializar();
	}

	private void inicializar() {

		frmMenu = new JFrame();
		frmMenu.setForeground(Color.GRAY);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frmMenu.setBounds(0, 0, screen.width - 500, screen.height - 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmMenu.setLocation(dim.width / 2 - frmMenu.getSize().width / 2,
				dim.height / 2 - frmMenu.getSize().height / 2);

		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.setTitle("Insertar un agente");

		JButton btnNewButton = new JButton("Vista Arrestos");
		btnNewButton.addActionListener(ControladorM.funcionalidadBotonEntradaAgente());

		JPanel panel_1 = new JPanel();
		JButton btnNewButton_2 = new JButton("Atras");
		JLabel lblNombre = new JLabel("Nombre:");
		JLabel lblNmeroDePlaca = new JLabel("N\u00FAmero de placa:");
		JLabel lblApellidos = new JLabel("Apellidos:");

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);

		textFieldNumPlaca = new JTextField();
		textFieldNumPlaca.setColumns(10);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);

		JButton btnAnyadir = new JButton("A\u00F1adir");
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorMAgente.funcionalidadBotonAñadir(Integer
						.parseInt(textFieldNumPlaca.getText()), textFieldNombre
						.getText().trim(), textFieldApellidos.getText().trim());
			}
		});

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																Alignment.TRAILING,
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				btnAnyadir,
																				GroupLayout.PREFERRED_SIZE,
																				85,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				btnNewButton_2,
																				GroupLayout.PREFERRED_SIZE,
																				85,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(147))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				lblNmeroDePlaca)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				textFieldNumPlaca,
																				GroupLayout.DEFAULT_SIZE,
																				232,
																				Short.MAX_VALUE)
																		.addGap(1020))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(52)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_1
																										.createSequentialGroup()
																										.addComponent(
																												lblApellidos)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												textFieldApellidos,
																												GroupLayout.DEFAULT_SIZE,
																												226,
																												Short.MAX_VALUE))
																						.addGroup(
																								gl_panel_1
																										.createSequentialGroup()
																										.addComponent(
																												lblNombre)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												textFieldNombre,
																												GroupLayout.DEFAULT_SIZE,
																												232,
																												Short.MAX_VALUE)))
																		.addGap(1020)))));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(66)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldNombre,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNombre))
										.addGap(18)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblApellidos)
														.addComponent(
																textFieldApellidos,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(32)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldNumPlaca,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNmeroDePlaca))
										.addGap(273)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnNewButton_2)
														.addComponent(
																btnAnyadir))
										.addGap(72)));
		panel_1.setLayout(gl_panel_1);
		frmMenu.getContentPane().setLayout(
				new MigLayout("",
						"[1px][215px][761.00px,grow][][838px,grow,center]",
						"[33.00px][][23px][][6px][72.00px][510px,bottom]"));
		frmMenu.getContentPane().add(btnNewButton, "cell 1 0,grow");

		JButton btnGeneradorInforme = new JButton("Vista Informes");
		frmMenu.getContentPane().add(btnGeneradorInforme, "cell 1 1,grow");

		JButton btnAnyadirAgente = new JButton("A\u00F1adir Agente");

		frmMenu.getContentPane()
				.add(btnAnyadirAgente, "cell 2 1,alignx center");

		JButton btnAadirSospechoso = new JButton("A\u00F1adir Sospechoso");
		btnAadirSospechoso.addActionListener(ControladorM
				.funcionalidadBotonVistaSospechoso(frmMenu));

		frmMenu.getContentPane().add(btnAadirSospechoso, "cell 4 1");

		JButton btnGeneradorPruebas = new JButton("Vista Pruebas");
		frmMenu.getContentPane().add(btnGeneradorPruebas, "cell 1 2,grow");

		JButton btnAadirPrueba = new JButton("A\u00F1adir Prueba");
		btnAadirPrueba.addActionListener(ControladorM
				.funcionalidadBotonVistaPrueba(frmMenu));

		frmMenu.getContentPane().add(btnAadirPrueba, "cell 2 2,alignx center");

		JButton btnCrearInforme = new JButton("A\u00F1adir Informe");
		btnCrearInforme.addActionListener(ControladorM
				.funcionalidadBotonVistaInforme(frmMenu));

		frmMenu.getContentPane().add(btnCrearInforme, "cell 4 2,alignx center");

		JButton btnVistasSospechosos = new JButton("Vista Sospechosos");
		frmMenu.getContentPane().add(btnVistasSospechosos, "cell 1 3");

		JButton btnAadirArresto = new JButton("A\u00F1adir Arresto");
		btnAadirArresto.addActionListener(ControladorM
				.funcionalidadBotonVistaArresto(frmMenu));
		frmMenu.getContentPane().add(btnAadirArresto, "cell 2 3,alignx center");
		frmMenu.getContentPane().add(panel_1,
				"cell 1 6 4 1,alignx trailing,growy");

	}

	public void mostrarVentana() {
		frmMenu.setVisible(true);
	}

	public void ocultarVentana() {
		frmMenu.setVisible(false);
	}
}
