package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class DAOsospechosoMYSQL implements DAOsospechosoInterface {

	private Connection con;
	private ResultSet res;

	@Override
	public boolean create(DTOsospechosoVO sospechoso) {
		con = SingletonConexionMYSQL.getInstance();
		try {

			PreparedStatement ps = con
					.prepareStatement("INSERT INTO sospechosos (Sospechosos_ID,Nombre,Apellidos, Sexo, Raza, Edad, DNI) VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, sospechoso.getSospechoso_id());
			ps.setString(2, sospechoso.getNombre());
			ps.setString(3, sospechoso.getApellido());
			ps.setString(4, sospechoso.getSexo());
			ps.setString(5, sospechoso.getRaza());
			ps.setInt(6, sospechoso.getEdad());
			ps.setString(7, sospechoso.getDni());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Se ha insertado correctamente el sospechoso "
								+ sospechoso.getSospechoso_id() + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(null,
						"No se han podido insertar el sospechosos "
								+ sospechoso.getSospechoso_id() + ".");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public boolean delete(int id) {
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("DELETE FROM sospechosos WHERE Sospechosos_ID=?");
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Se ha eliminado correctamente el sospechoso " + id
								+ ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(null,
						"No se han podido eliminar el sospechoso " + id + ".");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public boolean update(DTOsospechosoVO sospechoso) {
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE sospechosos SET Nombre=?, Apellidos=?, Sexo=?, Raza=?, Edad=?, DNI=? WHERE Sospechosos_ID=?");
			ps.setString(1, sospechoso.getNombre());
			ps.setString(2, sospechoso.getApellido());
			ps.setString(3, sospechoso.getSexo());
			ps.setString(4, sospechoso.getRaza());
			ps.setInt(5, sospechoso.getEdad());
			ps.setString(6, sospechoso.getDni());
			ps.setInt(7, sospechoso.getSospechoso_id());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Se ha actualizado correctamente el sospechoso "
								+ sospechoso.getSospechoso_id() + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(null,
						"No se han podido actualizar el sospechoso "
								+ sospechoso.getSospechoso_id() + ".");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public DTOsospechosoVO getById(int id) {
		DTOsospechosoVO sospechoso = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM sospechosos WHERE Sospechosos_ID = ?");
			ps.setInt(1, id);
			res = ps.executeQuery();
			if (res.next()) {
				sospechoso = new DTOsospechosoVO(res.getInt("Sospechosos_ID"),
						res.getString("Nombre"), res.getString("Apellidos"),
						res.getString("Sexo"), res.getString("Raza"),
						res.getInt("Edad"), res.getString("DNI"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SingletonConexionMYSQL.InstanceClose();
		return sospechoso;
	}

	@Override
	public DTOsospechosoVO getByDNI(String dni) {
		DTOsospechosoVO sospechoso = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM sospechosos WHERE DNI = ?");
			ps.setString(1, dni);
			res = ps.executeQuery();
			if (res.next()) {
				sospechoso = new DTOsospechosoVO(res.getInt("Sospechosos_ID"),
						res.getString("Nombre"), res.getString("Apellidos"),
						res.getString("Sexo"), res.getString("Raza"),
						res.getInt("Edad"), res.getString("DNI"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SingletonConexionMYSQL.InstanceClose();
		return sospechoso;
	}

	@Override
	public List<DTOsospechosoVO> getAll() {
		List<DTOsospechosoVO> sospechosos = new LinkedList<DTOsospechosoVO>();
		DTOsospechosoVO sospechoso = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM sospechosos");
			res = ps.executeQuery();
			while (res.next()) {
				sospechoso = new DTOsospechosoVO(res.getInt("Sospechosos_ID"),
						res.getString("Nombre"), res.getString("Apellidos"),
						res.getString("Sexo"), res.getString("Raza"),
						res.getInt("Edad"), res.getString("DNI"));
				sospechosos.add(sospechoso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SingletonConexionMYSQL.InstanceClose();
		return sospechosos;
	}

}
