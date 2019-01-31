package modelo;

import datos.EmpleadoDAO;;

public class UsuarioVO {
	
	private int id_usuario;
	private EmpleadoVO empleado;
	private String nombre_usuario;
	private String contraseña;
	//private int id_tipo_usuario;
	private Tipo_usuarioVO tipo_usuario;
	//private int legajo;	
	private String estado;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public void setEmpleado(int legajo) {
		EmpleadoDAO empleDAO = new EmpleadoDAO();
		this.empleado = empleDAO.getEmpleado(legajo);
	}
	public EmpleadoVO getEmpleado() {
		return empleado;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	/*
	public int getId_tipo_usuario() {
		return id_tipo_usuario;
	}
	public void setId_tipo_usuario(int id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}
	*/
	public void setTipoUsuario(int id_tipo_usuario) {
		this.tipo_usuario = new Tipo_usuarioVO(id_tipo_usuario);
	}
	public Tipo_usuarioVO getTipoUsuario() {
		return tipo_usuario;
	}
	/*
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	*/
}
