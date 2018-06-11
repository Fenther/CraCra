package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public abstract class BuilderEntradas extends JFrame{
	
	JFrame frmAbiertas;
	JTextField txtCampo1;
	JTextField txtCampo2;
	JTable tblEntradas;
	DefaultTableModel modelo;
	
	void crearFrame(){
		frmAbiertas = new JFrame();
		frmAbiertas.setTitle("Entradas");
		frmAbiertas.setBounds(100, 100, 800, 600);
		frmAbiertas.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmAbiertas.getContentPane().setLayout(new BorderLayout(0, 0));
	}
	abstract void crearPanelBuscar();
	abstract void  crearBotonesIterador();
	void crearMarcoTabla(){
		JPanel panel_Centro = new JPanel();
		frmAbiertas.getContentPane().add(panel_Centro, BorderLayout.CENTER);
		panel_Centro.setLayout(new BorderLayout(0,0));
		
		Component rigidArea_tblOeste = Box.createRigidArea(new Dimension(5, 5));
		panel_Centro.add(rigidArea_tblOeste, BorderLayout.WEST);
		Component rigidArea_tblEste = Box.createRigidArea(new Dimension(5, 5));
		panel_Centro.add(rigidArea_tblEste, BorderLayout.EAST);
		Component rigidArea_tblSur = Box.createRigidArea(new Dimension(5, 5));
		panel_Centro.add(rigidArea_tblSur, BorderLayout.SOUTH);
		Component rigidArea_tblNorte = Box.createRigidArea(new Dimension(5, 5));
		panel_Centro.add(rigidArea_tblNorte, BorderLayout.NORTH);
		
		JPanel panel_Centro2 = new JPanel();
		panel_Centro.add(panel_Centro2, BorderLayout.CENTER);
		panel_Centro2.setLayout(new BorderLayout(0,0));
		panel_Centro2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tblEntradas = new JTable();
		panel_Centro2.add(tblEntradas, BorderLayout.CENTER);
	}
	abstract void crearTabla();
	public void mostrarVentana(){
		frmAbiertas.setVisible(true);
	}
	
}
