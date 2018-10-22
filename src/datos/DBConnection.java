package datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection createConnection() {
		//Datos de conexión a la base (ver cómo generalizar)
		//String conString = "jdbc:mysql://localhost:3306/gestionrrhh?serverTimezone=UTC";
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
		String conString = "jdbc:mysql://localhost:3306/javapro?serverTimezone=UTC";
		String user = "root";
		String pass = "root";
		Connection con = null;
		try {
			
			con = DriverManager.getConnection(conString,user,pass); //Conecta a la DB
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	

}
