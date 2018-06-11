package modelo;

import java.util.List;

public interface IIteradorVistas<T> {
	void primero();
	List<T> Actual();
	List<T> Anterior();
	List<T> Siguiente();
	boolean quedanElementos();
}
