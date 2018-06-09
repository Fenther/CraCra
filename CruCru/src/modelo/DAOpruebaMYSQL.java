package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class DAOpruebaMYSQL implements DAOpruebaInterface {

	private Connection con;
	private ResultSet res;
	
	@Override
	public boolean create(DTOpruebaVO prueba) {
		con = SingletonConexionMYSQL.getInstance();
		try {
			
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO pruebas (Prueba_ID,Descripcion,Categoria) VALUES (?,?,?)");
			ps.setInt(1, prueba.getPrueba_id());
			ps.setString(2, prueba.getDescripcion());
			ps.setString(3, prueba.getCategoria());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(
						null,
						"Se ha insertado correctamente la prueba "
								+ prueba.getPrueba_id() + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(
						null,
						"No se han podido insertar la prueba "
								+ prueba.getPrueba_id() + ".");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public boolean delete(int prueba_id) {
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("DELETE FROM pruebas WHERE Prueba_ID=?");
			ps.setInt(1, prueba_id);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(
						null,
						"Se ha eliminado correctamente el agente "
								+ prueba_id + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(
						null,
						"No se han podido eliminar el agente "
								+ prueba_id + ".");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public boolean update(DTOpruebaVO prueba) {
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE pruebas SET Descripcion=?,Categoria=? WHERE Prueba_ID=?");
			ps.setInt(3, prueba.getPrueba_id());
			ps.setString(1, prueba.getDescripcion());
			ps.setString(2, prueba.getCategoria());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(
						null,
						"Se ha actualizado correctamente la prueba "
								+ prueba.getPrueba_id() + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(
						null,
						"No se han podido actualizar la prueba "
								+ prueba.getPrueba_id() + ".");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public DTOpruebaVO getById(int prueba_id) {
		DTOpruebaVO prueba = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM pruebas WHERE Prueba_ID= ?");
			ps.setInt(1, prueba_id);
			res = ps.executeQuery();
			if (res.next()) {
				prueba = new DTOpruebaVO(res.getInt("Prueba_ID"),
						res.getString("Descripcion"), res.getString("Categoria"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SingletonConexionMYSQL.InstanceClose();
		return prueba;
	}

	@Override
	public List<DTOpruebaVO> getAll() {
		List<DTOpruebaVO> pruebas = new LinkedList<DTOpruebaVO>();
		DTOpruebaVO prueba = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM pruebas");
			res = ps.executeQuery();
			while (res.next()) {
				prueba = new DTOpruebaVO(res.getInt("Prueba_ID"),
						res.getString("Descripcion"), res.getString("Categoria"));
				pruebas.add(prueba);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SingletonConexionMYSQL.InstanceClose();
		return pruebas;
	}

}
