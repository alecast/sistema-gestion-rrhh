package modelo;

//Usando el patrón VO (value object), esto sería que esta clase refleja los valores de la base de datos
//
public class EmpleadoVO {
	private int legajo;
	private String nombre;
	private String apellido;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	//Esto es una prueba para subir algo de codigo, habria que hacer las propiedades 
	//posta del Empleado con sus get y set
	

}
