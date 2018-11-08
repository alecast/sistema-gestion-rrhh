package datos;
import modelo.EmpleadoVO;
import java.sql.*;
import datos.DBConnection;


public class EmpleadoDAO {
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
 
	
   

public void Insertar(int dni,int cuil, String nombre, String apellido, String domicilio,int telefono, String estado_civil, String fecha_ingreso, int antiguedad, String estado, int cant_disponible) {


    // Establecer conexión con la base de datos
      //  Connection con = new Connection();

        // Pasamos el objeto Connection de nuestra clase "ConexionBD" a esta instancia por medio del método getConnection()
    //    Connection con = connection.getConnection();

        // Crear sentencia SQL para insertar en la base de datos
        String query = "INSERT INTO Empleado(dni, cuil, nombre, apellido, domicilio, telefono, estado_civil, fecha_ingreso, antiguedad, estado, cant_disponible) values (?,?,' ?', '?', '?', ?,'?', '?', ?, '?', ?)";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
         
            
         /*   rs.setInt       (1, DNI);
            rs.setInt       (2, cuil);
            rs.setString    (3, nombre);
            rs.setString    (4, apellido);
            rs.setString    (5, domicilio);
            rs.setInt       (6, telefono);
            rs.setString    (7, estado_civil);
            rs.setString    (8, fecha_ingreso);
            rs.setInt       (9, antiguedad);
            rs.setString    (10, estado);
            rs.setInt       (11, cant_disponible);
         */   // Indicamos que comience la actualización de la tabla en nuestra base de datos
            st.executeUpdate(query);

            // Cerramos las conexiones, en orden inverso a su apertura
            st.close();
            con.close();

            System.out.println("Llamada agregada con éxito a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
        }
}
}