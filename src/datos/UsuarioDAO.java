package datos;
import modelo.UsuarioVO;
import java.sql.*;

public class UsuarioDAO {

	public boolean validarUsuario(String user, String pass) {
		boolean valido = false;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			rs = st.executeQuery("select nombre_usuario,contraseña from usuario where nombre_usuario = '"+user+"' and contraseña = '"+pass+"'");

			if(rs.next()) { //Se fija si hay una fila resultado de la consulta
				String u = rs.getString("nombre_usuario"); // Obtengo el nombre_usuario de la consulta
				if (!rs.wasNull()) valido = true; // Si el getString de arriba no dio nulo, el usuario es valido
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valido;
	}
	
}
