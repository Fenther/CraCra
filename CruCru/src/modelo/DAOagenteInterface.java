package modelo;

import java.util.List;

public interface DAOagenteInterface {

	boolean create(DTOagenteVO agente);
	boolean delete(int num_placa);
	boolean update(DTOagenteVO agente);
	DTOagenteVO getByNumPlaca(int num_placa);
	List<DTOagenteVO> getAll();
	
}
