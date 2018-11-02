package datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String conString = "jdbc:sqlserver://localhost:1433;databaseName=gestionrrhh;integratedSecurity=true";
	private static String user = "";
	private static String pass = "";
	static Connection con = null;
	
	public static Connection createConnection() {
		//Driver para mysql DB
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(conString); //Conecta a la DB
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
