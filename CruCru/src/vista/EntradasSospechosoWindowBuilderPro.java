package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.DTOagenteVO;
import modelo.DTOsospechosoVO;
import controlador.ControladorEAgente;
import controlador.ControladorESospechoso;

public class EntradasSospechosoWindowBuilderPro extends BuilderEntradas {
	
	private static final int NUMCOLUMNAS = 7;
	private ControladorESospechoso controlador = new ControladorESospechoso(); 
	private List<DTOsospechosoVO> vista = controlador.getAll();;
	
	
	void crearEntradasTabla() {
		if(vista != null){
			Object[] fila = new Object[NUMCOLUMNAS];
			for(int i = 0 ; ((i < 10)&&(i < vista.size())) ; i++){
				fila[0] = vista.get(i).getSospechoso_id();
				fila[1] = vista.get(i).getNombre();
				fila[2] = vista.get(i).getApellido();
				fila[3] = vista.get(i).getEdad();
				fila[4] = vista.get(i).getSexo();
				fila[5] = vista.get(i).getRaza();
				fila[6] = vista.get(i).getDni();
				
				modelo.addRow(fila);
			}
		}
	}

	@Override
	void crearTabla(){
		tblEntradas.setCellSelectionEnabled(true);
		tblEntradas.setShowGrid(true);
		tblEntradas.setShowVerticalLines(true);
		tblEntradas.setGridColor(Color.BLACK);
		
		modelo = new DefaultTableModel();
		tblEntradas.setModel(modelo);
		modelo.addColumn("Sospechosos_ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Edad");
		modelo.addColumn("Sexo");
		modelo.addColumn("Raza");
		modelo.addColumn("DNI");
		Object[] fila = new Object[NUMCOLUMNAS];
		fila[0] = "ID";
		fila[1] = "Nombre";
		fila[2] = "Apellido";
		fila[3] = "Edad";
		fila[4] = "Sexo";
		fila[5] = "Raza";
		fila[6] = "DNI";
		modelo.addRow(fila);
		crearEntradasTabla();
		}
	
	@Override
	void crearBotonesIterador() 
		{
			JPanel panel_Este = new JPanel();
			frmAbiertas.getContentPane().add(panel_Este, BorderLayout.EAST);
			panel_Este.setLayout(new GridLayout(5, 1, 0, 0));
			
			JButton btnInit = new JButton("Principio");
			btnInit.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					vista = controlador.primero();
					crearTabla();
				}
			});
			panel_Este.add(btnInit);
			
			JButton btnUpTable = new JButton("Siguiente");
			btnUpTable.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					vista = controlador.siguiente();
					crearTabla();
				}
			});
			panel_Este.add(btnUpTable);
			
			JButton btnDownTable = new JButton("Anterior");
			btnDownTable.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					vista = controlador.anterior();
					crearTabla();
				}
			});
			panel_Este.add(btnDownTable);
			
			JButton btnRefres = new JButton("Volver a todos");
			btnRefres.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					vista = controlador.getAll();
					crearTabla();
				}
			});
			panel_Este.add(btnRefres);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					controlador.elimina(tblEntradas.getSelectedRow());
				}
			});
			panel_Este.add(btnDelete);
			
			
		}

	@Override
	void crearPanelBuscar() {
		{
			JPanel panel_Norte = new JPanel();
			panel_Norte.setLayout(new FlowLayout(FlowLayout.LEFT,10,1));
			panel_Norte.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Parámetros de búsqueda"));
			frmAbiertas.getContentPane().add(panel_Norte, BorderLayout.NORTH);
			
			Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
			panel_Norte.add(rigidArea);
			
			JLabel lblCampo1 = new JLabel("DNI");
			panel_Norte.add(lblCampo1);
			
			txtCampo1 = new JTextField();
			txtCampo1.setText("123");
			panel_Norte.add(txtCampo1);
			txtCampo1.setColumns(10);
			
			Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
			panel_Norte.add(rigidArea_1);
			
			
			JButton btnBuscar = new JButton("Buscar por DNI");
			btnBuscar.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					try{
						vista = controlador.buscarByDNI(txtCampo1.getText().trim());
						crearTabla();
					}catch(Exception r){
						JOptionPane.showMessageDialog(
								null,
								"No se han podido encontrar el sospechoso.");
					}
				}
			});
			panel_Norte.add(btnBuscar);
			
			Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
			panel_Norte.add(rigidArea_2);
			
			JLabel lblCampo2 = new JLabel("ID");
			panel_Norte.add(lblCampo2);
			
			txtCampo2 = new JTextField();
			txtCampo2.setText("123");
			panel_Norte.add(txtCampo2);
			txtCampo2.setColumns(10);
			
			Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
			panel_Norte.add(rigidArea_3);
			
			
			JButton btnBuscarID = new JButton("Buscar por ID");
			btnBuscarID.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					try{
						vista = controlador.buscarByID(Integer.parseInt(txtCampo2.getText().trim()));
						crearTabla();
					}catch(Exception r){
						JOptionPane.showMessageDialog(
								null,
								"No se han podido encontrar el sospechoso.");
					}
				}
			});
			panel_Norte.add(btnBuscarID);
		}
	}
	

}
