package datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String conString = "jdbc:mysql://localhost:3306/gestionrrhh?serverTimezone=UTC";
	private static String user = "root";
	private static String pass = "root";
	static Connection con = null;
	
	public static Connection createConnection() {
		//Driver para mysql DB
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(conString,user,pass); //Conecta a la DB
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
