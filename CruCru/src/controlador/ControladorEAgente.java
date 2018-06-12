package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.DAOagenteInterface;
import modelo.DAOagenteMYSQL;
import modelo.DTOagenteVO;
import modelo.IIteradorVistas;
import modelo.IteradorVistas;

public class ControladorEAgente {

	private IIteradorVistas<DTOagenteVO> iterador;
	private DAOagenteInterface DAO;
	List<DTOagenteVO> agentes;
	
	public ControladorEAgente(){
		DAO = new DAOagenteMYSQL();
	}
	
	public List<DTOagenteVO> getAll(){
		agentes = DAO.getAll();
		iterador = new IteradorVistas<DTOagenteVO>(agentes);
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}

	public List<DTOagenteVO> primero(){
		iterador.primero();
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	
	public List<DTOagenteVO> siguiente(){
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return iterador.Actual();
	}
	
	public List<DTOagenteVO> anterior(){
		List<DTOagenteVO> anterior = iterador.Anterior();
		if(anterior != null){
			return anterior;
		}
		return iterador.Actual();
	}
	
	public void elimina(int index){
		if(index > 0){
		DAO.delete(iterador.Actual().get(index-1).getNum_placa());
		}
	}
	
	public List<DTOagenteVO> buscarByNum(int num){
		agentes = new ArrayList<DTOagenteVO>();
		agentes.add(DAO.getByNumPlaca(num));
		iterador = new IteradorVistas<DTOagenteVO>(agentes);
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	
	public void actualizar(DTOagenteVO agente){
		DAO.update(agente);
	}
}
