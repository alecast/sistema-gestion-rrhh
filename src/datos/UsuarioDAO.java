package datos;
import modelo.LicenciaVO;
import modelo.UsuarioVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
			ps = con.prepareStatement("INSERT INTO USUARIO VALUES(?,?,?,?,?)");
			ps.setString(1,user.getNombre_usuario());
			ps.setString(2,user.getContraseña());
			ps.setInt(3, user.getTipo_usuario().getId_tipo_usuario());
			ps.setInt(4, user.getEmpleado().getLegajo());
			ps.setString(5, "Activo");
			ps.executeUpdate();
			exito = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exito;
	}
	
	public List<UsuarioVO> getListaUsuariosPorNombre(String nombreLike, boolean activo){
		List<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
		con = null;
		st = null;
		rs = null;
		String query = "";
		if (activo) query = "select * from usuario where nombre_usuario like '%"+nombreLike+"%' and estado != 'Inactivo'"; 
		else query = "select * from usuario where nombre_usuario like '%"+nombreLike+"%'";
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				UsuarioVO u = new UsuarioVO();
				u.setContraseña(rs.getString("contraseña"));
				u.setTipo_usuario(rs.getInt("id_tipo_usuario")); 
				u.setId_usuario(rs.getInt("id_usuario"));
				u.setEmpleado(rs.getInt("legajo"));
				u.setNombre_usuario(rs.getString("nombre_usuario"));
				u.setEstado(rs.getString("estado"));
				listaUsuarios.add(u);
			}			
			rs.close();
			st.close();
		} catch (SQLException e) { e.printStackTrace();}
		  finally { DBConnection.closeConnection(); }
		
		return listaUsuarios;
	}

	public boolean bajaUsuario(int id_usuario) {

		boolean eliminado = false;
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			st.executeUpdate("update usuario set estado = 'Inactivo' where id_usuario = "+id_usuario);
			eliminado = true;
			st.close();
		} catch (SQLException e) { e.printStackTrace();} 
		finally { DBConnection.closeConnection();}
		
		return eliminado;
	}
	
	public boolean bajaUsuarioPorLegajo(int legajo) {
		boolean eliminado = false;
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			st.executeUpdate("update usuario set estado = 'Inactivo' where legajo = "+legajo);
			eliminado = true;
			st.close();
		} catch (SQLException e) { e.printStackTrace();} 
		finally { DBConnection.closeConnection();}
		
		return eliminado;
	}
	
	public boolean modificarUsuario(String pass, int tipoUsuario, int idUsuario) {
		boolean modifico = false;
		if (pass.isEmpty()){
			try {
				con = DBConnection.createConnection();
				st = con.createStatement();
				st.executeUpdate("update usuario set id_tipo_usuario = "+tipoUsuario+" where id_usuario="+idUsuario);
				modifico = true;
				st.close();
			} catch (SQLException e) { e.printStackTrace();} 
			finally { DBConnection.closeConnection();}	
		} else {
			try {
				con = DBConnection.createConnection();
				st = con.createStatement();
				st.executeUpdate("update usuario set id_tipo_usuario = "+tipoUsuario+", contraseña='"+pass+"' where id_usuario="+idUsuario);
				modifico = true;
				st.close();
			} catch (SQLException e) { e.printStackTrace();} 
			finally { DBConnection.closeConnection();}
		}
		return modifico;
	}
	
	public List<UsuarioVO> getListaUsuarios(boolean activo){
		List<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
		con = null;
		st = null;
		rs = null;
		String query = "";
		if (activo) query = "select * from usuario where estado != 'Inactivo'"; 
		else query = "select * from usuario";
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				UsuarioVO u = new UsuarioVO();
				u.setContraseña(rs.getString("contraseña"));
				u.setTipo_usuario(rs.getInt("id_tipo_usuario")); 
				u.setId_usuario(rs.getInt("id_usuario"));
				u.setEmpleado(rs.getInt("legajo")); 
				u.setNombre_usuario(rs.getString("nombre_usuario"));
				u.setEstado(rs.getString("estado"));
				listaUsuarios.add(u);
			}			
			rs.close();
			st.close();
		} catch (SQLException e) { e.printStackTrace();}
		  finally { DBConnection.closeConnection(); }
		
		return listaUsuarios;
	}

	public UsuarioVO getUsuarioVO(String user, String pass) {
		UsuarioVO usuVO = new UsuarioVO();
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from usuario where nombre_usuario = '"+user+"' and contraseña = '"+pass+"'");

			if(rs.next()) { //Se fija si hay una fila resultado de la consulta
				usuVO.setId_usuario(rs.getInt("id_usuario"));
				usuVO.setNombre_usuario(rs.getString("nombre_usuario"));
				usuVO.setContraseña(rs.getString("contraseña"));
				usuVO.setTipo_usuario(rs.getInt("id_tipo_usuario"));
				usuVO.setEmpleado(rs.getInt("legajo"));
				usuVO.setEstado(rs.getString("estado"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) { e.printStackTrace();} 
		finally { DBConnection.closeConnection();}
		
		return usuVO;	
	}
	
	
}
