package datos;
import modelo.EmpleadoVO;
import java.sql.*;
import datos.DBConnection;


public class EmpleadoDAO {
	private Connection con = null;
	private PreparedStatement psst = null;
	private ResultSet rs = null;
 
	
   

public void Insertar(int dni,int cuil, String nombre, String apellido, String domicilio,int telefono, String estado_civil, String fecha_ingreso, int antiguedad, String estado, int cant_disponible) {


    // Establecer conexión con la base de datos
      //  Connection con = new Connection();

        // Pasamos el objeto Connection de nuestra clase "ConexionBD" a esta instancia por medio del método getConnection()
    //    Connection con = connection.getConnection();

        // Crear sentencia SQL para insertar en la base de datos
        String query = "INSERT INTO Empleado(dni, cuil, nombre, apellido, domicilio, telefono, estado_civil, fecha_ingreso, antiguedad, estado, cant_disponible) values (?,?,' ?', '?', '?', ?,'?', '?', ?, '?', ?)";

        try {
            PreparedStatement psst = con.prepareStatement(query);
         
            
            psst.setInt (1, dni);
            psst.setInt       (2, cuil);
            psst.setString    (3, nombre);
            psst.setString    (4, apellido);
            psst.setString    (5, domicilio);
            psst.setInt       (6, telefono);
            psst.setString    (7, estado_civil);
            psst.setString    (8, fecha_ingreso);
            psst.setInt       (9, antiguedad);
            psst.setString    (10, estado);
            psst.setInt       (11, cant_disponible);
            // Indicamos que comience la actualización de la tabla en nuestra base de datos
            psst.executeUpdate(query);

            // Cerramos las conexiones, en orden inverso a su apertura
            psst.close();
            con.close();

            System.out.println("Llamada agregada con éxito a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
        }
}
}