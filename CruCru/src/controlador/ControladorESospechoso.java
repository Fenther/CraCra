package controlador;

import java.util.ArrayList;
import java.util.List;



import modelo.DAOsospechosoInterface;
import modelo.DAOsospechosoMYSQL;
import modelo.DTOsospechosoVO;
import modelo.IIteradorVistas;
import modelo.IteradorVistas;

public class ControladorESospechoso {

	private IIteradorVistas<DTOsospechosoVO> iterador;
	private DAOsospechosoInterface DAO;
	List<DTOsospechosoVO> sospechosos;
	
	public ControladorESospechoso(){
		DAO = new DAOsospechosoMYSQL();
	}
	
	public List<DTOsospechosoVO> getAll(){
		sospechosos = DAO.getAll();
		iterador = new IteradorVistas<DTOsospechosoVO>(sospechosos);
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}

	public List<DTOsospechosoVO> primero(){
		iterador.primero();
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	
	public List<DTOsospechosoVO> siguiente(){
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return iterador.Actual();
	}
	
	public List<DTOsospechosoVO> anterior(){
		List<DTOsospechosoVO> anterior = iterador.Anterior();
		if(anterior != null){
			return anterior;
		}
		return iterador.Actual();
	}
	
	public void elimina(int index){
		if(index > 0){
		DAO.delete(iterador.Actual().get(index-1).getSospechoso_id());
		}
	}
	
	public List<DTOsospechosoVO> buscarByDNI(String dni){
		sospechosos = new ArrayList<DTOsospechosoVO>();
		iterador = new IteradorVistas<DTOsospechosoVO>(sospechosos);
		sospechosos.add(DAO.getByDNI(dni));
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	public List<DTOsospechosoVO> buscarByID(int ID){
		sospechosos = new ArrayList<DTOsospechosoVO>();
		iterador = new IteradorVistas<DTOsospechosoVO>(sospechosos);
		sospechosos.add(DAO.getById(ID));
		if(iterador.quedanElementos()){
			return iterador.Siguiente();
		}
		return null;
	}
	public void actualizar(DTOsospechosoVO sospechoso){
		DAO.update(sospechoso);
	}
}
