package vista;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.util.Iterator;

import javax.swing.JButton;

import java.awt.Toolkit;

import controlador.ControladorM;
import controlador.ControladorMArresto;
import controlador.ConvertidorDeTipos;



import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import modelo.DAOagenteInterface;
import modelo.DAOagenteMYSQL;
import modelo.DAOsospechosoInterface;
import modelo.DAOsospechosoMYSQL;
import modelo.DTOagenteVO;
import modelo.DTOsospechosoVO;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;

import javax.swing.JComboBox;

public class MenuWindowBuilderProArresto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frmMenu;
	private JTextField textFieldHora;
	private JTextField textFieldFecha;
	JComboBox comboBoxSospechosos;
	private JComboBox res_1;
	private JComboBox res;
	private JTextField textFieldId;
	
	
	/**
	 * Create the frame.
	 */
	public MenuWindowBuilderProArresto() {
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
		
		JButton btnNewButton = new JButton("Vista agentes");
		btnNewButton.addActionListener(ControladorM.funcionalidadBotonEntradaAgente());
		
		JPanel panel_1 = new JPanel();
		
		JButton btnNewButton_2 = new JButton("Atras");
		btnNewButton_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frmMenu.dispose();
				InicioWindowBuilderPro frame = new InicioWindowBuilderPro();
				frame.mostrarVentana();				
			}
			
		});
		
		JLabel lblDetenidos = new JLabel("Sospechoso:");
		
		textFieldHora = new JTextField();
		textFieldHora.setColumns(10);
		
		JLabel lblPlaceh_1 = new JLabel("Hora:");
		
		JComboBox comboBoxSospechosos = crearComboBoxSospechoso();
		JLabel lblAgentes = new JLabel("Agente:");
		
		JComboBox comboBoxAgentes = crearComboBoxAgente();
		
		JLabel lblFechaArresto = new JLabel("Fecha:");
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		
		JButton button = new JButton("A\u00F1adir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				java.sql.Date fecha = null;
				try {
					fecha = ConvertidorDeTipos.stringToDate(textFieldFecha.getText());
					
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null, ConvertidorDeTipos.MENSAJE_DE_ERROR_FECHA_INCORRECTA);
					System.out.println("Hora= " + textFieldFecha.getText());
				}
				Time hora = null;
				try {
					hora = ConvertidorDeTipos.stringToHouer((textFieldHora.getText()));
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null, ConvertidorDeTipos.MENSAJE_DE_ERROR_HORA_INCORRECTA);
				}
				int id = Integer.parseInt(textFieldId.getText());
				DTOsospechosoVO sospechoso = (DTOsospechosoVO) comboBoxSospechosos.getSelectedItem();
				DTOagenteVO agente = (DTOagenteVO) comboBoxAgentes.getSelectedItem();
				ControladorMArresto.funcionalidadBotonAñadir(fecha, hora, id, sospechoso, agente);
			}
		});
		
		JLabel lbld = new JLabel("Id:");
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDetenidos)
						.addComponent(lbld)
						.addComponent(lblAgentes))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(res_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addComponent(res, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
									.addGap(357)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblFechaArresto)
										.addComponent(lblPlaceh_1))
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldHora, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))))
							.addGap(706))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(447)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_2)
								.addComponent(button)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbld)
								.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDetenidos)
								.addComponent(res_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFechaArresto)
								.addComponent(textFieldFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(30)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAgentes)
										.addComponent(res, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(42)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFieldHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPlaceh_1))))))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		frmMenu.getContentPane().setLayout(new MigLayout("", "[1px][215px][761.00px,grow][][838px,grow,center]", "[33.00px][][23px][][6px][72.00px][510px,bottom]"));
		frmMenu.getContentPane().add(btnNewButton, "cell 1 0,grow");
		
		JButton btnAnyadirAgente = new JButton("A\u00F1adir Agente");
		btnAnyadirAgente.addActionListener(ControladorM.funcionalidadBotonVistaAgente(frmMenu));
		frmMenu.getContentPane().add(btnAnyadirAgente, "cell 2 1,alignx center");
		
		JButton btnAadirSospechoso = new JButton("A\u00F1adir Sospechoso");
		btnAadirSospechoso.addActionListener(ControladorM.funcionalidadBotonVistaSospechoso(frmMenu));
		frmMenu.getContentPane().add(btnAadirSospechoso, "cell 4 1");
		
		JButton btnAadirPrueba = new JButton("A\u00F1adir Prueba");
		btnAadirPrueba.addActionListener(ControladorM.funcionalidadBotonVistaPrueba(frmMenu));
		frmMenu.getContentPane().add(btnAadirPrueba, "cell 2 2,alignx center");
		
		JButton btnCrearInforme = new JButton("A\u00F1adir Informe");
		btnCrearInforme.addActionListener(ControladorM.funcionalidadBotonVistaInforme(frmMenu));
		frmMenu.getContentPane().add(btnCrearInforme, "cell 4 2,alignx center");
		
		
		JButton btnAadirArresto = new JButton("A\u00F1adir Arresto");
		
		frmMenu.getContentPane().add(btnAadirArresto, "cell 2 3,alignx center");
		
		JButton btnVistaArrestos = new JButton("Vista Arrestos");
		btnVistaArrestos.addActionListener(ControladorM.funcionalidadBotonEntradaArresto());
		frmMenu.getContentPane().add(btnVistaArrestos, "cell 1 5,growx");
		frmMenu.getContentPane().add(panel_1, "cell 1 6 4 1,alignx trailing,growy");
		
		JButton btnGeneradorPruebas = new JButton("Vista Pruebas");
		btnGeneradorPruebas.addActionListener(ControladorM.funcionalidadBotonEntradaPrueba());
		frmMenu.getContentPane().add(btnGeneradorPruebas, "cell 1 2,grow");

		JButton btnGeneradorInforme = new JButton("Vista Informes");
		btnGeneradorInforme.addActionListener(ControladorM.funcionalidadBotonEntradaInforme());
		frmMenu.getContentPane().add(btnGeneradorInforme, "cell 1 1,grow");
		
		JButton btnVistasSospechosos = new JButton("Vista Sospechosos");
		btnVistasSospechosos.addActionListener(ControladorM.funcionalidadBotonEntradaSospechoso());
		frmMenu.getContentPane().add(btnVistasSospechosos, "cell 1 3");
		
	}

	private JComboBox crearComboBoxSospechoso() {
		res_1 = new JComboBox();
		DAOsospechosoInterface DAOsospechoso = new DAOsospechosoMYSQL();
		Iterator<DTOsospechosoVO> sospechosoIt = DAOsospechoso.getAll().iterator();
		while (sospechosoIt.hasNext()) {
			DTOsospechosoVO sospechosoActual = sospechosoIt.next();
			//res.addItem(sospechosoActual.getNombre()+" "+sospechosoActual.getApellido());
			res_1.addItem(sospechosoActual);
		}
		return res_1;
	}
	
	private JComboBox crearComboBoxAgente() {
		
		res = new JComboBox();
		DAOagenteInterface DAOagente = new DAOagenteMYSQL();
		Iterator<DTOagenteVO> agenteIt = DAOagente.getAll().iterator();
		while (agenteIt.hasNext()) {
			DTOagenteVO agenteActual = agenteIt.next();
			//res.addItem(agenteActual.getNombre()+" "+agenteActual.getApellidos());
			res.addItem(agenteActual);
		}
		return res;
	}
	
	public void mostrarVentana(){
		frmMenu.setVisible(true);
	}
	public void ocultarVentana() {
		frmMenu.setVisible(false);
	}
}