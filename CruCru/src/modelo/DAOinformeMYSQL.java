package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class DAOinformeMYSQL implements DAOinformeInterface {

	private Connection con;
	private ResultSet res;

	@Override
	public boolean create(DTOinformeVO informe) {
		con = SingletonConexionMYSQL.getInstance();
		try {

			PreparedStatement ps = con
					.prepareStatement("INSERT INTO informe (Pruebas,Arresto,Fecha) VALUES (?,?,?)");
			ps.setInt(1, informe.getPruebas());
			ps.setInt(2, informe.getArresto());
			ps.setDate(3, informe.getFecha());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(
						null,
						"Se ha insertado correctamente el informe P:"
								+ informe.getPruebas() + " A:"
								+ informe.getArresto() + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(
						null,
						"No se ha podido insertar el informe P:"
								+ informe.getPruebas() + " A:"
								+ informe.getArresto() + ".");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se ha podido insertar el informe.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public boolean delete(int id_prueba, int id_arresto) {
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("DELETE FROM informe WHERE Pruebas=? AND Arresto=?");
			ps.setInt(1, id_prueba);
			ps.setInt(2, id_arresto);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Se ha eliminado correctamente el informe P:"
								+ id_prueba + " A:" + id_arresto + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(null,
						"No se ha podido eliminar el infome P:" + id_prueba
								+ " A:" + id_arresto + ".");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se ha podido eliminar el informe.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public boolean update(DTOinformeVO informe) {
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE informe SET fecha=? WHERE Arresto=? AND Pruebas=?");
			ps.setInt(2, informe.getArresto());
			ps.setInt(3, informe.getPruebas());
			ps.setDate(1, informe.getFecha());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(
						null,
						"Se ha actualizado correctamente el infome P:" + informe.getPruebas()
								+ " A:" + informe.getArresto() + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(
						null,
						"No se ha podido actualizar el infome P:" + informe.getPruebas()
								+ " A:" + informe.getArresto() + ".");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se ha podido actualizar el informe.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public DTOinformeVO get(int id_prueba, int id_arresto) {
		DTOinformeVO informe = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM informe WHERE Pruebas=? AND Arresto=?");
			ps.setInt(1, id_prueba);
			ps.setInt(2, id_arresto);
			res = ps.executeQuery();
			if (res.next()) {
				informe = new DTOinformeVO(res.getInt("Pruebas"),
						res.getInt("Arresto"), res.getDate("Fecha"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se ha podido encontrar el informe.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return informe;
	}

	@Override
	public List<DTOinformeVO> getByPrueba(int id_prueba) {
		List<DTOinformeVO> informes = new LinkedList<DTOinformeVO>();
		DTOinformeVO informe = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM informe WHERE Pruebas=?");
			ps.setInt(1, id_prueba);
			res = ps.executeQuery();
			while (res.next()) {
				informe = new DTOinformeVO(res.getInt("Pruebas"),
						res.getInt("Arresto"), res.getDate("Fecha"));
				informes.add(informe);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido encontrar los informes.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return informes;
	}

	@Override
	public List<DTOinformeVO> getByArresto(int id_arresto) {
		List<DTOinformeVO> informes = new LinkedList<DTOinformeVO>();
		DTOinformeVO informe = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM informe WHERE Arresto=?");
			ps.setInt(1, id_arresto);
			res = ps.executeQuery();
			while (res.next()) {
				informe = new DTOinformeVO(res.getInt("Pruebas"),
						res.getInt("Arresto"), res.getDate("Fecha"));
				informes.add(informe);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido encontrar los informes.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return informes;
	}

	@Override
	public List<DTOinformeVO> getAll() {
		List<DTOinformeVO> informes = new LinkedList<DTOinformeVO>();
		DTOinformeVO informe = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM informe");
			res = ps.executeQuery();
			while (res.next()) {
				informe = new DTOinformeVO(res.getInt("Pruebas"),
						res.getInt("Arresto"), res.getDate("Fecha"));
				informes.add(informe);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido encontrar los informes.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return informes;
	}

}
