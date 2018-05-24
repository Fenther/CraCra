package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.FlowLayout;
import java.awt.Component;

import javax.swing.Box;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

import conexiones.SingletonConexion;

final class EntradasAbiertasWindowBuilderPro extends BuilderEntradas {
	
	
	public void entradasTabla(){
    	try{
    		Connection con = null;
    		con = SingletonConexion.getInstance();
    		PreparedStatement ps;
    		ResultSet res;
    		ps = con.prepareStatement("SELECT * FROM persona");
    		res = ps.executeQuery();
    		
    		if(res.next()){
    			System.out.println(res.getString("nombre"));
    			System.out.println(res.getString("domicilio"));
    		}else{
    			JOptionPane.showMessageDialog(null, "No Existen Datos");
    		}
    		
    		con.close();
    			
    	} catch(Exception e){
    		System.out.println(e);
    	}
	}

    
    
    
	//Estos son los metodos que adquiere del builder
	void crearTabla() {
		//tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblEntradas.setCellSelectionEnabled(true);
		tblEntradas.setShowGrid(true);
		tblEntradas.setShowVerticalLines(true);
		tblEntradas.setGridColor(Color.BLACK);

		modelo = new DefaultTableModel() {
			private String[] columnNames = {"Unidades","Producto","Precio unidad","Subtotal"};
			public String getColumnName(int column) {
			    return columnNames[column];
			}
		    public int getColumnCount() {return 4;}
		    public boolean isCellEditable(int row, int col){ return false;}
		};
		tblEntradas.setModel(modelo);
		TableColumn columna = tblEntradas.getColumn("Unidades"); 
		columna.setPreferredWidth(70);
		columna.setMinWidth(70);
		columna.setMaxWidth(70);
		columna = tblEntradas.getColumn("Producto"); 
		columna.setPreferredWidth(250);
		columna.setMinWidth(250);
		columna.setMaxWidth(250);

	}
	void crearEntradasTabla(){
		Object [] nuevaFila = new Object[4];
		modelo.addRow(nuevaFila);
		modelo.addRow(nuevaFila);
		entradasTabla();
	}

}
