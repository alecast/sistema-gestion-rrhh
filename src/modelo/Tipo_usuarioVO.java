package modelo;
import datos.Tipo_usuarioDAO;
import util.CustomException;

public class Tipo_usuarioVO {
	//Atributos
	private int id_tipo_usuario;
	private String descripcion;
	//Getters - Setters
	public int getId_tipo_usuario() {
		return id_tipo_usuario;
	}
	public void setId_tipo_usuario(int id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	//Constructores
	public Tipo_usuarioVO() {
		
	}
	public Tipo_usuarioVO(int id_tipo_usuario) {
		this.setId_tipo_usuario(id_tipo_usuario);
		Tipo_usuarioDAO tipoUsuDAO = new Tipo_usuarioDAO();
		try {
			this.setDescripcion(tipoUsuDAO.getTipo_Usuario(id_tipo_usuario).getDescripcion());
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
