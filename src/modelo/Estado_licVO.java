package modelo;

import java.util.Date;

import datos.LicenciaDAO;


public class Estado_licVO {
	
	private int id_estado;
	private String estado;
	private Date fecha_iniciacion;
	private Date fecha_finalizacion;
	private String motivo_cambio; //cambiar tipo de dato en el modelo relacional de drive
	//private int id_licencia;
	private LicenciaVO licencia;
	
	
	
	public LicenciaVO getLicencia() {
		return licencia;
	}
	public void setLicencia(LicenciaVO licencia) {
		this.licencia = licencia;
	}
	public int getId_estado() {
		return id_estado;
	}
	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha_iniciacion() {
		return fecha_iniciacion;
	}
	public void setFecha_iniciacion(Date fecha_iniciacion) {
		this.fecha_iniciacion = fecha_iniciacion;
	}
	public Date getFecha_finalizacion() {
		return fecha_finalizacion;
	}
	public void setFecha_finalizacion(Date fecha_finalizacion) {
		this.fecha_finalizacion = fecha_finalizacion;
	}
	public String getMotivo_cambio() {
		return motivo_cambio;
	}
	public void setMotivo_cambio(String motivo_cambio) {
		this.motivo_cambio = motivo_cambio;
	}
	public LicenciaVO getLicencia(int id_licencia) {
		return this.licencia;
	}
	public void setLicencia(int id_licencia) {
		LicenciaDAO licenDAO = new LicenciaDAO();
		this.licencia = licenDAO.getLicencia(id_licencia);
	}
/*	
	public int getId_licencia() {
		return id_licencia;
	}
	public void setId_licencia(int id_licencia) {
		this.id_licencia = id_licencia;
	}
	
	*/
}
