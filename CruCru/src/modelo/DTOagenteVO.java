package modelo;

public class DTOagenteVO {
	//Atributos de agente en la BD
	private int num_placa;
	private String nombre;
	private String apellidos;
	//fin atributos en la BD
	
	public DTOagenteVO(int num_placa, String nombre,String apellidos){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.num_placa = num_placa;
	}
	
	//metodos get/set de todos los atributos de agente en la BD
	public int getNum_placa(){
		return this.num_placa;
	}
	public void setNum_placa(int num_placa){
		this.num_placa = num_placa;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getApellidos(){
		return this.apellidos;
	}
	public void setApellidos(String apellidos){
		this.apellidos = apellidos;
	}
	//Fin metodos get/set
}
