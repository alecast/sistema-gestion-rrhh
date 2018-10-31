package datos;
import modelo.EmpleadoVO;
import java.sql.*;

public class EmpleadoDAO {
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;

	
	public boolean altaEmpleado(EmpleadoVO empleado) {
		boolean exito = false;
		con = null;
		st = null;
		rs = null;
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			//rs = st.executeQuery("insert ")
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exito;
	}
}