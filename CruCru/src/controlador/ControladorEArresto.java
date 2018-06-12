package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.DAOarrestoInterface;
import modelo.DAOarrestoMYSQL;
import modelo.DTOarrestoVO;
import modelo.IIteradorVistas;
import modelo.IteradorVistas;

public class ControladorEArresto {

	private IIteradorVistas<DTOarrestoVO> iterador;
	private DAOarrestoInterface DAO;
	List<DTOarrestoVO> arrestos;
	
	public ControladorEArresto(){
		DAO = new DAOarrestoMYSQL();
	}
	
	public List<DTOarrestoVO> getAll(){
		arrestos = DAO.getAll();
		iterador = new IteradorVistas<DTOarrestoVO>(arrestos);
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}

	public List<DTOarrestoVO> primero(){
		iterador.primero();
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	
	public List<DTOarrestoVO> siguiente(){
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return iterador.Actual();
	}
	
	public List<DTOarrestoVO> anterior(){
		List<DTOarrestoVO> anterior = iterador.Anterior();
		if(anterior != null){
			return anterior;
		}
		return iterador.Actual();
	}
	
	public void elimina(int index){
		if(index > 0){
		DAO.delete(iterador.Actual().get(index-1).getId());
		}
	}
	
	public List<DTOarrestoVO> buscarById(int id){
		arrestos = new ArrayList<DTOarrestoVO>();
		arrestos.add(DAO.getById(id));
		iterador = new IteradorVistas<DTOarrestoVO>(arrestos);
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	public List<DTOarrestoVO> buscarByDetenido(int detenido){
		arrestos = DAO.getByDetenido(detenido);
		iterador = new IteradorVistas<DTOarrestoVO>(arrestos);
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	public List<DTOarrestoVO> buscarByAgente(int agente){
		arrestos = DAO.getByAgente(agente);
		iterador = new IteradorVistas<DTOarrestoVO>(arrestos);
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	public void actualizar(DTOarrestoVO arresto){
		DAO.update(arresto);
	}
}

