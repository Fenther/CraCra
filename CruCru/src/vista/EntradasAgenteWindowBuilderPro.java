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

import controlador.ControladorEAgente;

public class EntradasAgenteWindowBuilderPro extends BuilderEntradas {

	private static final long serialVersionUID = 1L;
	private static final int NUMCOLUMNAS = 3;
	private ControladorEAgente controlador = new ControladorEAgente();
	private List<DTOagenteVO> vista = controlador.getAll();;

	void crearEntradasTabla() {
		if (vista != null) {
			Object[] fila = new Object[NUMCOLUMNAS];
			for (int i = 0; ((i < 10) && (i < vista.size())); i++) {
				fila[0] = vista.get(i).getNum_placa();
				fila[1] = vista.get(i).getNombre();
				fila[2] = vista.get(i).getApellidos();
				modelo.addRow(fila);
			}
		}
	}

	@Override
	void crearTabla() {
		tblEntradas.setCellSelectionEnabled(true);
		tblEntradas.setShowGrid(true);
		tblEntradas.setShowVerticalLines(true);
		tblEntradas.setGridColor(Color.BLACK);

		modelo = new DefaultTableModel();
		tblEntradas.setModel(modelo);
		modelo.addColumn("Num_placa");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		Object[] fila = new Object[NUMCOLUMNAS];
		fila[0] = "Num_Placa";
		fila[1] = "Nombre";
		fila[2] = "Apellido";
		modelo.addRow(fila);
		crearEntradasTabla();
	}

	@Override
	void crearBotonesIterador() {
		JPanel panel_Este = new JPanel();
		frmAbiertas.getContentPane().add(panel_Este, BorderLayout.EAST);
		panel_Este.setLayout(new GridLayout(6, 1, 0, 0));

		JButton btnInit = new JButton("Principio");
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vista = controlador.primero();
				crearTabla();
			}
		});
		panel_Este.add(btnInit);

		JButton btnUpTable = new JButton("Siguiente");
		btnUpTable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vista = controlador.siguiente();
				crearTabla();
			}
		});
		panel_Este.add(btnUpTable);

		JButton btnDownTable = new JButton("Anterior");
		btnDownTable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vista = controlador.anterior();
				crearTabla();
			}
		});
		panel_Este.add(btnDownTable);

		JButton btnRefres = new JButton("Volver a todos");
		btnRefres.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vista = controlador.getAll();
				crearTabla();
			}
		});
		panel_Este.add(btnRefres);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlador.elimina(tblEntradas.getSelectedRow());
			}
		});
		panel_Este.add(btnDelete);

		JButton btnUpload = new JButton("Guardar");
		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tblEntradas.getSelectedRow() > 0){
				DTOagenteVO agente = new DTOagenteVO(
						Integer.parseInt(tblEntradas.getValueAt(
								tblEntradas.getSelectedRow(), 0).toString()),
						tblEntradas.getValueAt(tblEntradas.getSelectedRow(), 1)
								.toString().trim(), tblEntradas
								.getValueAt(tblEntradas.getSelectedRow(), 2)
								.toString().trim());
				controlador.actualizar(agente);}
			}
		});
		panel_Este.add(btnUpload);

	}

	@Override
	void crearPanelBuscar() {
		{
			JPanel panel_Norte = new JPanel();
			panel_Norte.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));
			panel_Norte.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.GRAY),
					"Parámetros de búsqueda"));
			frmAbiertas.getContentPane().add(panel_Norte, BorderLayout.NORTH);

			Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
			panel_Norte.add(rigidArea);

			JLabel lblCampo1 = new JLabel("Numero de placa");
			panel_Norte.add(lblCampo1);

			txtCampo1 = new JTextField();
			txtCampo1.setText("1");
			panel_Norte.add(txtCampo1);
			txtCampo1.setColumns(10);

			Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
			panel_Norte.add(rigidArea_1);

			JButton btnBuscar = new JButton("Buscar por numero de placa");
			btnBuscar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						vista = controlador.buscarByNum(Integer
								.parseInt(txtCampo1.getText()));
						crearTabla();
					} catch (Exception r) {
						JOptionPane.showMessageDialog(null,
								"No se han podido encontrar el agente.");
					}
				}
			});
			panel_Norte.add(btnBuscar);
		}
	}

}
