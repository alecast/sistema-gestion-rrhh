package modelo;

import java.util.Date;

public class Tipo_empleadoVO {
	
	private int id_tipo_empleado;
	private String descripcion;
	private Date fecha_alta;
	private Date fecha_baja;
	
	public int getId_tipo_empleado() {
		return id_tipo_empleado;
	}
	public void setId_tipo_empleado(int id_tipo_empleado) {
		this.id_tipo_empleado = id_tipo_empleado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public Date getFecha_baja() {
		return fecha_baja;
	}
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}


}
