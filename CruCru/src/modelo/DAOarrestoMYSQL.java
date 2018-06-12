package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class DAOarrestoMYSQL implements DAOarrestoInterface {

	private Connection con;
	private ResultSet res;

	@Override
	public boolean create(DTOarrestoVO arresto) {
		con = SingletonConexionMYSQL.getInstance();
		try {

			PreparedStatement ps = con
					.prepareStatement("INSERT INTO arresto (Arresto_ID,Detenido,Agente,FechaArresto,HoraArresto) VALUES (?,?,?,?,?)");
			ps.setInt(1, arresto.getId());
			ps.setInt(2, arresto.getDetenido());
			ps.setInt(3, arresto.getAgente());
			ps.setDate(4, arresto.getFecha());
			ps.setTime(5, arresto.getHora());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(
						null,
						"Se ha insertado correctamente el arresto "
								+ arresto.getId() + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(
						null,
						"No se han podido insertar el arresto "
								+ arresto.getId() + ".");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido insertar el arresto "
							+ arresto.getId() + ".");
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public boolean delete(int id) {
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("DELETE FROM arresto WHERE Arresto_ID=?");
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,
						"Se ha eliminado correctamente el arresto " + id + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(null,
						"No se han podido eliminar el arresto " + id + ".");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"No se han podido eliminar el arresto.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public boolean update(DTOarrestoVO arresto) {
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE arresto SET Detenido=?,Agente=?, FechaArresto=?, HoraArresto=? WHERE Arresto_ID=?");
			ps.setInt(1, arresto.getDetenido());
			ps.setInt(2, arresto.getAgente());
			ps.setDate(3, arresto.getFecha());
			ps.setTime(4, arresto.getHora());
			ps.setInt(5, arresto.getId());
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(
						null,
						"Se ha actualizado correctamente el arresto "
								+ arresto.getId() + ".");
				SingletonConexionMYSQL.InstanceClose();
				return true;
			} else {
				JOptionPane.showMessageDialog(
						null,
						"No se han podido actualizar el arresto "
								+ arresto.getId() + ".");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido actualizar el arresto.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return false;
	}

	@Override
	public DTOarrestoVO getById(int id) {
		DTOarrestoVO arresto = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM arresto WHERE Arresto_ID= ?");
			ps.setInt(1, id);
			res = ps.executeQuery();
			if (res.next()) {
				arresto = new DTOarrestoVO(res.getInt("Arresto_ID"),
						res.getInt("Detenido"), res.getInt("Agente"),
						res.getDate("FechaArresto"), res.getTime("HoraArresto"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido encontrar el arresto.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return arresto;
	}

	@Override
	public List<DTOarrestoVO> getByDetenido(int detenido_id) {
		List<DTOarrestoVO> arrestos = new LinkedList<DTOarrestoVO>();
		DTOarrestoVO arresto = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM arresto WHERE Detenido= ?");
			ps.setInt(1, detenido_id);
			res = ps.executeQuery();
			while (res.next()) {
				arresto = new DTOarrestoVO(res.getInt("Arresto_ID"),
						res.getInt("Detenido"), res.getInt("Agente"),
						res.getDate("FechaArresto"), res.getTime("HoraArresto"));
				arrestos.add(arresto);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido encontrar los arrestos.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return arrestos;
	}

	@Override
	public List<DTOarrestoVO> getByAgente(int num_placa) {
		List<DTOarrestoVO> arrestos = new LinkedList<DTOarrestoVO>();
		DTOarrestoVO arresto = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM arresto WHERE Agente= ?");
			ps.setInt(1, num_placa);
			res = ps.executeQuery();
			while (res.next()) {
				arresto = new DTOarrestoVO(res.getInt("Arresto_ID"),
						res.getInt("Detenido"), res.getInt("Agente"),
						res.getDate("FechaArresto"), res.getTime("HoraArresto"));
				arrestos.add(arresto);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido encontrar los arrestos.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return arrestos;
	}

	@Override
	public List<DTOarrestoVO> getAll() {
		List<DTOarrestoVO> arrestos = new LinkedList<DTOarrestoVO>();
		DTOarrestoVO arresto = null;
		con = SingletonConexionMYSQL.getInstance();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM arresto");
			res = ps.executeQuery();
			while (res.next()) {
				arresto = new DTOarrestoVO(res.getInt("Arresto_ID"),
						res.getInt("Detenido"), res.getInt("Agente"),
						res.getDate("FechaArresto"), res.getTime("HoraArresto"));
				arrestos.add(arresto);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null,
					"No se han podido encontrar los arrestos.");
		}
		SingletonConexionMYSQL.InstanceClose();
		return arrestos;
	}

}