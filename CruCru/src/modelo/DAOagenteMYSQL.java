package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class DAOagenteMYSQL implements DAOagenteInterface {

	private Connection con;
	private ResultSet res;

	@Override
	public boolean create(DTOagenteVO agente) {
		con = SingletonConexionMYSQL.getInstance();
		try {
			
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO agente (Num_Placa,Nombre,Apellidos) VALUES (?,?,?)");
			ps.setInt(1, agente.getNum_placa());
			ps.setString(2, agente.getNombre());
			ps.setString(3, agente.getApellidos());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(
						null,
						"Se ha insertado correctamente el agente "
								+ agente.getNum_placa() + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(
						null,
						"No se han podido insertar el agente "
								+ agente.getNum_placa() + ".");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido insertar el agente "
							+ agente.getNum_placa() + ".");
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public boolean delete(int num_placa) {
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("DELETE FROM agente WHERE Num_Placa=?");
			ps.setInt(1, num_placa);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(
						null,
						"Se ha eliminado correctamente el agente "
								+ num_placa + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(
						null,
						"No se han podido eliminar el agente "
								+ num_placa + ".");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido eliminar el agente "
							+ num_placa + ".");
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public boolean update(DTOagenteVO agente) {
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE agente SET Nombre=?,Apellidos=? WHERE Num_Placa=?");
			ps.setInt(3, agente.getNum_placa());
			ps.setString(1, agente.getNombre());
			ps.setString(2, agente.getApellidos());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(
						null,
						"Se ha actualizado correctamente el agente "
								+ agente.getNum_placa() + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(
						null,
						"No se han podido actualizar el agente "
								+ agente.getNum_placa() + ".");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido actualizar el agente "
							+ agente.getNum_placa() + ".");
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public DTOagenteVO getByNumPlaca(int num_placa) {
		DTOagenteVO agente = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM agente WHERE num_placa = ?");
			ps.setInt(1, num_placa);
			res = ps.executeQuery();
			if (res.next()) {
				agente = new DTOagenteVO(res.getInt("Num_Placa"),
						res.getString("Nombre"), res.getString("Apellidos"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido encontrar el agente.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return agente;
	}

	@Override
	public List<DTOagenteVO> getAll() {
		List<DTOagenteVO> agentes = new LinkedList<DTOagenteVO>();
		DTOagenteVO agente = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM agente");
			res = ps.executeQuery();
			while (res.next()) {
				agente = new DTOagenteVO(res.getInt("Num_Placa"),
						res.getString("Nombre"), res.getString("Apellidos"));
				agentes.add(agente);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido encontrar los agentes.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return agentes;
	}

}