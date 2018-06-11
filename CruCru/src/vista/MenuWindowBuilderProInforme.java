package vista;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.util.Iterator;

import javax.swing.JButton;

import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import controlador.ControladorM;
import controlador.ControladorMInforme;
import controlador.ConvertidorDeTipos;
import modelo.DAOarrestoInterface;
import modelo.DAOarrestoMYSQL;
import modelo.DAOpruebaInterface;
import modelo.DAOpruebaMYSQL;
import modelo.DTOarrestoVO;
import modelo.DTOpruebaVO;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;

import javax.swing.JComboBox;

public class MenuWindowBuilderProInforme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frmMenu;
	private JTextField textFieldFecha;
	private JComboBox comboBoxArresto_1;
	private JComboBox comboBoxPrueba_1;

	
	/**
	 * Create the frame.
	 */
	public MenuWindowBuilderProInforme() {
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
		
		JLabel lblNewLabel = new JLabel("Prueba:");
		
		JLabel lblArresto = new JLabel("Arresto:");
		
		JLabel lblFecha = new JLabel("Fecha:");
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		
		JComboBox comboBoxPrueba = crearComboBoxPrueba();
	
		JComboBox comboBoxArresto = crearComboBoxArresto();
		
		JButton buttonAnyadir = new JButton("A\u00F1adir");
		buttonAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DTOpruebaVO prueba = (DTOpruebaVO) comboBoxPrueba.getSelectedItem();
				DTOarrestoVO arresto = (DTOarrestoVO) comboBoxArresto.getSelectedItem();
				java.sql.Date fecha = null;
				try {
					fecha = ConvertidorDeTipos.stringToDate(textFieldFecha.getText());
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null, ConvertidorDeTipos.MENSAJE_DE_ERROR_FECHA_INCORRECTA);
				}
				ControladorMInforme.funcionalidadBotonAñadir(prueba, arresto, fecha);
				
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblFecha)
									.addComponent(lblArresto))
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldFecha, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
									.addComponent(comboBoxArresto_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addComponent(comboBoxPrueba_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
							.addGap(1072))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(buttonAnyadir, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(147))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(72)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(comboBoxPrueba_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblArresto)
						.addComponent(comboBoxArresto_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFecha))
					.addGap(264)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(buttonAnyadir))
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
		btnAadirPrueba.addActionListener(ControladorM.funcionalidadBotonVistaPrueba(frmMenu));
		frmMenu.getContentPane().add(btnAadirPrueba, "cell 2 2,alignx center");
		
		JButton btnCrearInforme = new JButton("A\u00F1adir Informe");
		btnCrearInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("anyadir informe pulsado");
			}
		});
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
	
	private JComboBox crearComboBoxPrueba() {
		comboBoxPrueba_1 = new JComboBox();
		DAOpruebaInterface DAOprueba = new DAOpruebaMYSQL();
		Iterator<DTOpruebaVO> pruebasIt = DAOprueba.getAll().iterator();
		while (pruebasIt.hasNext()) {
			DTOpruebaVO pruebaActual = pruebasIt.next();
			//comboBoxPrueba_1.addItem(pruebaActual.getPrueba_id());
			comboBoxPrueba_1.addItem(pruebaActual);
		}
		
		return comboBoxPrueba_1;
	}
	
	private JComboBox crearComboBoxArresto() {
		comboBoxArresto_1 = new JComboBox();
		DAOarrestoInterface DAOarresto = new DAOarrestoMYSQL();
		Iterator<DTOarrestoVO> arrestoIt = DAOarresto.getAll().iterator();
		
		while (arrestoIt.hasNext()) {
			DTOarrestoVO pruebaActual = arrestoIt.next();
			//comboBoxArresto_1.addItem(pruebaActual.getId());
			comboBoxArresto_1.addItem(pruebaActual);
		}
		
		return comboBoxArresto_1;
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