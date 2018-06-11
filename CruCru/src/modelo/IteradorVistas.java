package modelo;

import java.util.ArrayList;
import java.util.List;

final public class IteradorVistas<T> implements IIteradorVistas<T> {

	private List<T> vistas;
	private int posicionActual;
	public static final int TAMAŅOVISTAS = 10;
	
	public IteradorVistas(List<T> listado){
		this.vistas = listado;
	}
	
	@Override
	public void primero() {
		this.posicionActual = -1;
	}

	@Override
	public List<T> Actual() {
		if ((this.vistas == null) ||
				(this.vistas.size() == 0) || 
				(posicionActual > this.vistas.size() -1) ||
				(this.posicionActual < 0)){
			return null;
		} else {
			List<T> actual = new ArrayList<T>(TAMAŅOVISTAS);
			int marcador = this.posicionActual;
			for(int i = 0; (i<TAMAŅOVISTAS)||(this.vistas.size()>marcador) ; i++)
			{
				actual.add(i, this.vistas.get(marcador));
				marcador++;
			}
			return actual;
		}
	}

	@Override
	public List<T> Siguiente() {
		if ((this.vistas == null) ||
				(this.vistas.size() == 0) ||
				(posicionActual + TAMAŅOVISTAS > this.vistas.size() - 1 )){
			return null;
		} else {
			this.posicionActual += TAMAŅOVISTAS;
			List<T> siguiente = new ArrayList<T>(TAMAŅOVISTAS);
			int marcador = this.posicionActual;
			for(int i = 0; (i<10)||(this.vistas.size()>marcador) ; i++)
			{
				siguiente.add(i, this.vistas.get(marcador));
				marcador++;
			}
			return siguiente;
		}
	}
	
	public List<T> Anterior(){
		if ((this.vistas == null) ||
				(this.vistas.size() == 0) ||
				(posicionActual - TAMAŅOVISTAS < 0)){
			return null;
		} else {
			this.posicionActual -= TAMAŅOVISTAS;
			List<T> anterior = new ArrayList<T>(TAMAŅOVISTAS);
			int marcador = this.posicionActual;
			for(int i = 0; (i<10)||(this.vistas.size()>marcador) ; i++)
			{
				anterior.add(i, this.vistas.get(marcador));
				marcador++;
			}
			return anterior;
		}
	}

	@Override
	public boolean quedanElementos() {
		return (posicionActual+1 <= this.vistas.size() -1);
	}

}
