package modelo;

//Usando el patrón VO (value object), esto sería que esta clase refleja los valores de la base de datos
//
public class EmpleadoVO {
	private int legajo;
	private String nombre;
	private String apellido;
	private int DNI;
	private int   cuil;
	private String  domicilio;
	private int    telefono;
	private String     estado_civil;
	private String     fecha_ingreso;
	private int        antiguedad;
	private String   estado;
	private int       cant_disponible;
	
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
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
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public int getCuil() {
		return cuil;
	}
	public void setCuil(int cuil) {
		this.cuil = cuil;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}
	public String getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCant_disponible() {
		return cant_disponible;
	}
	public void setCant_disponible(int cant_disponible) {
		this.cant_disponible = cant_disponible;
	}
	
	
	
	
	

}
