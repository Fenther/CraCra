package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;

import java.awt.Toolkit;

import javax.swing.text.NumberFormatter;

import controlador.ControladorM;
import modelo.DAOsospechosoInterface;
import modelo.DAOsospechosoMYSQL;
import modelo.DTOsospechosoVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class MenuWindowBuilderProSospechoso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frmMenu;
	private JTextField textFieldDni;
	private JTextField textFieldApellidos;
	private JTextField textFieldNombre;
	private JTextField textFieldRaza;
	private JFormattedTextField formattedTextFieldEdad;
	private JComboBox comboBoxSexo;
	private JComboBox res_1;
	private JFormattedTextField res;
	private JTextField textFieldId;
	
	
	/**
	 * Create the frame.
	 */
	public MenuWindowBuilderProSospechoso() {
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
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		
		JLabel lblSexo = new JLabel("Sexo:");
		
		JLabel lblRaza = new JLabel("Raza:");
		//textField_3.setVisible(false);
		
		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		textFieldRaza = new JTextField();
		textFieldRaza.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Edad:");
		
		JLabel lblPlaceh = new JLabel("DNI:");
		
		JLabel lblPlaceh_1 = new JLabel("Apellidos:");
		
		//JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo = crearComboBoxSexo();
		JFormattedTextField formattedTextFieldEdad = crearFormattedTextFieldEdad();
		JButton button = new JButton("A\u00F1adir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textFieldId.getText().trim());
				String nombre = textFieldNombre.getText().trim();
				String apellido = textFieldApellidos.getText().trim();
				String sexo = (String) comboBoxSexo.getSelectedItem();
				String raza = textFieldRaza.getText().trim();
				int edad = Integer.parseInt(formattedTextFieldEdad.getText().trim());
				String dni =  textFieldDni.getText().trim();
				DTOsospechosoVO sospechoso = new DTOsospechosoVO(id,nombre,apellido, sexo,raza, edad, dni);
				DAOsospechosoInterface DAOsospechoso = new DAOsospechosoMYSQL();
				DAOsospechoso.create(sospechoso);
			}
		});
		
		
		
		JLabel lblId = new JLabel("Id:");
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(801)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(147))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(lblId)
							.addComponent(lblNewLabel)
							.addComponent(lblPlaceh_1))
						.addComponent(lblPlaceh))
					.addGap(31)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(180))
						.addComponent(textFieldApellidos)
						.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
						.addComponent(textFieldDni))
					.addGap(130)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(res, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblSexo)
							.addGap(18)
							.addComponent(res_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblRaza)
							.addGap(18)
							.addComponent(textFieldRaza, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
					.addGap(373))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_1)
									.addComponent(res, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblSexo)
									.addComponent(res_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(8))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(18)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblRaza)
									.addComponent(textFieldRaza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblId))
									.addGap(48))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(26)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPlaceh_1))))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPlaceh)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(302)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_2)
								.addComponent(button))))
					.addContainerGap(32, Short.MAX_VALUE))
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
		btnAadirSospechoso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("anyadir sospechoso pulsado");
			}
		});
		frmMenu.getContentPane().add(btnAadirSospechoso, "cell 4 1");
		
		JButton btnGeneradorPruebas = new JButton("Vista Pruebas");
		frmMenu.getContentPane().add(btnGeneradorPruebas, "cell 1 2,grow");
		
		JButton btnAadirPrueba = new JButton("A\u00F1adir Prueba");
		btnAadirPrueba.addActionListener(ControladorM.funcionalidadBotonVistaPrueba(frmMenu));
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
		frmMenu.getContentPane().add(panel_1, "cell 0 6 5 1,alignx trailing,growy");

	}
	
	public JComboBox crearComboBoxSexo() {
		res_1 = new JComboBox();
		res_1.addItem("Masculino");
		res_1.addItem("Femenino");
		return res_1;
	}
	
	private JFormattedTextField crearFormattedTextFieldEdad() {
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(200);
	    formatter.setAllowsInvalid(true);
	    formatter.setCommitsOnValidEdit(false);
	    
	    res = new JFormattedTextField(formatter);
	    res.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
	    
	    return res;
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