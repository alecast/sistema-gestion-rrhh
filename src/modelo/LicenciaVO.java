package modelo;

import java.time.LocalDateTime;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class LicenciaVO {
	
	private int id_licencia;
	private String descripcion;
	private Date fecha_inicio;
	private Date fecha_fin;
	private LocalDateTime fecha_solicitud;
	private int cant_dias;
	private String motivo;
	private String certificado;
	private int usuario_aprobado;
	private int id_usuario_licencia;
	
	public int getId_licencia() {
		return id_licencia;
	}
	public void setId_licencia(int id_licencia) {
		this.id_licencia = id_licencia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public LocalDateTime getFecha_solicitud() {
		return fecha_solicitud;
	}
	public void setFecha_solicitud(LocalDateTime fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}
	public int getCant_dias() {
		return cant_dias;
	}
	public void setCant_dias(int cant_dias) {
		this.cant_dias = cant_dias;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	public int getUsuario_aprobado() {
		return usuario_aprobado;
	}
	public void setUsuario_aprobado(int usuario_aprobado) {
		this.usuario_aprobado = usuario_aprobado;
	}
	public int getId_usuario_licencia() {
		return id_usuario_licencia;
	}
	public void setId_usuario_licencia(int id_usuario_licencia) {
		this.id_usuario_licencia = id_usuario_licencia;
	}
	
	 public LicenciaVO(int id_licencia, Date fecha_inicio, Date fecha_fin, LocalDateTime fecha_solicitud, int cant_dias, String descripcion) {
	     this.id_licencia = id_licencia ;
	     this.fecha_inicio = fecha_inicio;
	     this.fecha_fin = fecha_fin;
		 this.fecha_solicitud = fecha_solicitud;
		 this.cant_dias = cant_dias;
	     this.descripcion = descripcion;


	 }
}
