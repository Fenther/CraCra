package modelo;

public class DTOpruebaVO {
	private int prueba_id;
	private String descripcion;
	private String categoria;
	
	public DTOpruebaVO(int prueba_id, String descripcion, String categoria){
		this.prueba_id = prueba_id;
		this.descripcion = descripcion;
		this.categoria = categoria;
	}

	public int getPrueba_id() {
		return prueba_id;
	}

	public void setPrueba_id(int prueba_id) {
		this.prueba_id = prueba_id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
