package modelo;


import java.util.Date;

//Usando el patrón VO (value object), esto sería que esta clase refleja los valores de la base de datos
//
public class EmpleadoVO {
	

	
	private int legajo;
	private String nombre;
	private String apellido;
	private int DNI;
	private String   cuil;
	private String  domicilio;
	private int    telefono;
	private String     estado_civil;
	private Date     fecha_ingreso;
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
		this.DNI = dNI;
	}
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
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
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(Date fecha_ingreso) {
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
	
	
	  public EmpleadoVO(int legajo,int dni,String cuil, String nombre, String apellido, String domicilio,int telefono, String estado_civil, Date fecha_ingreso, int antiguedad, String estado, int cant_disponible) {
	     this.setLegajo(legajo) ;
	     this.setDNI(dni);
	     this.setNombre(nombre);
		 this.setApellido(apellido);
		 this.setCuil(cuil);
	     this.setDomicilio(domicilio);
		 this.setTelefono(telefono);
		 this.setEstado_civil(estado_civil);
		 this.setFecha_ingreso(fecha_ingreso);
		 this.setAntiguedad(antiguedad);
		 this.setEstado(estado);
		 this.setCant_disponible(cant_disponible);
		
	   
	  
	  
	  }
	public EmpleadoVO() {
		// TODO Auto-generated constructor stub
	}

		 



	

}
