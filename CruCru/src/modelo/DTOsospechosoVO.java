package modelo;

public class DTOsospechosoVO {
	private int sospechoso_id;
	private String nombre;
	private String apellido;
	private String sexo;
	private String raza;
	private int edad;
	private String dni;
	
	public DTOsospechosoVO(int id, String nombre,String apellido,String sexo,String raza, int edad, String dni){
		this.sospechoso_id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.raza = raza;
		this.edad = edad;
		this.dni = dni;
		this.sexo = sexo;
	}

	public int getSospechoso_id() {
		return sospechoso_id;
	}

	public void setSospechoso_id(int sospechoso_id) {
		this.sospechoso_id = sospechoso_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String toString() {
		return nombre + " " + apellido;
	}
	
}
