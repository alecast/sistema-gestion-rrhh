package datos;
import modelo.UsuarioVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UsuarioDAO {
	private Connection con = null;
	private Statement st = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public boolean validarUsuario(String user, String pass) {
		boolean valido = false;
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			rs = st.executeQuery("select nombre_usuario,contraseña from usuario where nombre_usuario = '"+user+"' and contraseña = '"+pass+"'");

			if(rs.next()) { //Se fija si hay una fila resultado de la consulta
				String u = rs.getString("nombre_usuario"); // Obtengo el nombre_usuario de la consulta
				if (!rs.wasNull()) valido = true; // Si el getString de arriba no dio nulo, el usuario es valido
			}
			rs.close();
			st.close();
		} catch (SQLException e) { e.printStackTrace();} 
		finally { DBConnection.closeConnection();}
		
		return valido;
	}
	
	public boolean altaUsuario(UsuarioVO user) {
		boolean exito = false;
		try {
			con = DBConnection.createConnection();
			ps = con.prepareStatement("INSERT INTO USUARIO VALUES(?,?,?,?)");
			ps.setString(1,user.getNombre_usuario());
			ps.setString(2,user.getContraseña());
			ps.setInt(3, user.getId_tipo_usuario());
			ps.setInt(4, user.getLegajo());
			ps.executeUpdate();
			exito = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exito;
	}
	
	public List<UsuarioVO> getListaUsuariosPorNombre(String nombreLike){
		List<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
		con = null;
		st = null;
		rs = null;
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from usuario where nombre_usuario like '%"+nombreLike+"%'");
			while(rs.next()) {
				UsuarioVO u = new UsuarioVO();
				u.setContraseña(rs.getString("contraseña"));
				u.setId_tipo_usuario(rs.getInt("id_tipo_usuario")); //Debería ser un llamado a un objeto
				u.setId_usuario(rs.getInt("id_usuario"));
				u.setLegajo(rs.getInt("legajo")); //Debería ser un llamado a un objeto
				u.setNombre_usuario(rs.getString("nombre_usuario"));
				listaUsuarios.add(u);
			}			
			rs.close();
			st.close();
		} catch (SQLException e) { e.printStackTrace();}
		  finally { DBConnection.closeConnection(); }
		
		return listaUsuarios;
	}

	public boolean eliminarUsuario(int id_usuario) {
		boolean eliminado = false;
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			rs = st.executeQuery("delete from usuario where id_usuario = "+id_usuario);
			eliminado = true;
			rs.close();
			st.close();
		} catch (SQLException e) { e.printStackTrace();} 
		finally { DBConnection.closeConnection();}
		
		return eliminado;
	}
}
