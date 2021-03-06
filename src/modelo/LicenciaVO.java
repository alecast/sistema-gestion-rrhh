package modelo;
import java.util.Date;

import datos.EmpleadoDAO;

//import java.time.LocalDateTime;
//import javax.print.attribute.standard.DateTimeAtCompleted;

public class LicenciaVO {
	
	private int id_licencia;
	private String descripcion;
	private Date fecha_inicio;
	private Date fecha_fin;
	private Date fecha_solicitud;
	private int cant_dias;
	private String motivo;
	private String certificado;
	private int legajo_adm;
	private int id_empleado_licencia;
	private EmpleadoVO empleado;
	
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
	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}
	public void setFecha_solicitud(Date fecha_solicitud) {
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
	public int getLegajo_adm() {
		return legajo_adm;
	}
	public void setLegajo_adm(int legajo_adm) {
		this.legajo_adm = legajo_adm;
	}
	public int getId_empleado_licencia() {
		return id_empleado_licencia;
	}
	public void setId_empleado_licencia(int id_empleado_licencia) {
		this.id_empleado_licencia = id_empleado_licencia;
	}
	public void setEmpleado(int legajo) {
		EmpleadoDAO empleDAO = new EmpleadoDAO();
		this.empleado = empleDAO.getEmpleado(legajo);
	}
	public EmpleadoVO getEmpleado() {
		return empleado;
	}
	
	 public LicenciaVO(int id_licencia, Date fecha_inicio, Date fecha_fin, Date fecha_solicitud, int cant_dias, String descripcion, String motivo, String certificado, int legajo_adm, int id_empleado_licencia, EmpleadoVO empleado) {
	     this.setId_licencia(id_licencia);
	     this.setFecha_inicio(fecha_inicio);
	     this.setFecha_fin(fecha_fin);
		 this.setFecha_solicitud(fecha_solicitud);
		 this.setCant_dias(cant_dias);
	     this.setDescripcion(descripcion);
		 this.setMotivo(motivo);
		 this.setCertificado(certificado);
		 this.setLegajo_adm(legajo_adm);
	     this.setId_empleado_licencia(id_empleado_licencia);
	     this.setEmpleado(empleado.getLegajo());
	 }
	 
	public LicenciaVO(int id_licencia2, int cant_dias2, Date fecha_inicio2, Date fecha_fin2, Date fecha_solicitud2,	String descripcion2) {
		// TODO Auto-generated constructor stub
	}
	public LicenciaVO() {
		// TODO Auto-generated constructor stub
	}
}
