package datos;
import modelo.Tipo_usuarioVO;
import util.CustomException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tipo_usuarioDAO {
	private Connection con = null;
	private Statement st = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public Tipo_usuarioVO getTipo_Usuario(int id_tipo_usuario) throws CustomException {
		Tipo_usuarioVO tipoUsu = new Tipo_usuarioVO();
		
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from tipo_usuario where id_tipo_usuario = '"+id_tipo_usuario+"'");

			if(rs.next()) { //Se fija si hay una fila resultado de la consulta
				String desc = rs.getString("descripcion"); // Obtengo la descripcion de la consulta
				if (!rs.wasNull()) { // Si el getString de arriba no dio nulo, se setea el tipo_usuario
					tipoUsu.setId_tipo_usuario(id_tipo_usuario);
					tipoUsu.setDescripcion(desc);
				} else throw new CustomException("El tipo de usuario selecciona es inválido");
			}
			rs.close();
			st.close();

		} catch (SQLException e) { e.printStackTrace();} 
		finally { DBConnection.closeConnection();}

		return tipoUsu;
	}

}
