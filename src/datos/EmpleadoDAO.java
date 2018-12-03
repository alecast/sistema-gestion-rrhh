package datos;
import modelo.EmpleadoVO;
import modelo.UsuarioVO;

import java.sql.*;
import datos.DBConnection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class EmpleadoDAO {
	private Connection con = null;
	private PreparedStatement psst = null;
	private ResultSet rs = null;
    private Statement st = null;
	
   
//public void AltaEmpleado(empleado EmpleadoVO);
//EmpleadoVO empleado = new EmpleadoVO();

/*public void Insertar(int legajo,int dni,int cuil, String nombre, String apellido, String domicilio,int telefono, String estado_civil, String fecha_ingreso, int antiguedad, String estado, int cant_disponible) {

    // Establecer conexión con la base de datos
      //  Connection con = new Connection();

        // Pasamos el objeto Connection de nuestra clase "ConexionBD" a esta instancia por medio del método getConnection()
    //    Connection con = connection.getConnection();

        // Crear sentencia SQL para insertar en la base de datos
        String query = "INSERT INTO Empleado(dni, cuil, nombre, apellido, domicilio, telefono, estado_civil, fecha_ingreso, antiguedad, estado, cant_disponible) values (?,?,' ?', '?', '?', ?,'?', '?', ?, '?', ?)";

        try {
            PreparedStatement psst = con.prepareStatement(query);
         
            
            psst.setInt       (1, dni);
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
*/


public void AltaEmpleado(EmpleadoVO empleaVO) throws SQLException {
	
	// TODO Auto-generated method stub
	String query = "INSERT INTO Empleado(dni, cuil, nombre, apellido, domicilio, telefono, estado_civil, fecha_ingreso, antiguedad, estado, cant_disponible) values (?,?,?,?,?,?,?,?,?,?,?)";

	// try {
		 con = DBConnection.createConnection();
		 //Connection con = new connection();
		
         psst = con.prepareStatement(query);
        
         
      /* empleaVO.setDNI(dni);
         empleaVO.setNombre("cuil");
         empleaVO.setApellido("nombre");
         empleaVO.setApellido("apellido");
         empleaVO.setApellido("domicilio");
         empleaVO.setApellido("telefono");
         empleaVO.setApellido("estado_civil");
         empleaVO.setApellido("fecha_ingreso");
         empleaVO.setApellido("antiguedad");
         empleaVO.setApellido("estado");
         empleaVO.setApellido("cant_disponible");
         
        */
         
         java.sql.Date f =  convertJavaDateToSqlDate(((EmpleadoVO) empleaVO).getFecha_ingreso());
         
        
         int dni = ((EmpleadoVO) empleaVO).getDNI();
         String cuil = ((EmpleadoVO) empleaVO).getCuil();
         String nombre = ((EmpleadoVO) empleaVO).getNombre();
         String apellido = ((EmpleadoVO) empleaVO).getApellido();
         String domicilio = ((EmpleadoVO) empleaVO).getDomicilio();
         int telefono = ((EmpleadoVO) empleaVO).getTelefono();
         String estado_civil = ((EmpleadoVO) empleaVO).getEstado_civil();
       //  java.sql.Date fecha_ingreso = ((EmpleadoVO) empleaVO).getFecha_ingreso();
         int antiguedad = ((EmpleadoVO) empleaVO).getAntiguedad();
         String estado = ((EmpleadoVO) empleaVO).getEstado();
         int cant_disponible = ((EmpleadoVO) empleaVO).getCant_disponible();

      
        //  Date f = DateServlet.ParseFecha(fecha_ingreso); 
          
        //  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         // java.util.Date date;
        /*  try {
              date = dateFormat.parse(fecha_ingreso);
              System.out.println(date.toString()); // Wed Dec 04 00:00:00 CST 2013

              String output = dateFormat.format(date);
              System.out.println(output); // 2013-12-04
          } 
          catch (ParseException e) {
              e.printStackTrace();
          }*/
          
         psst.setInt       (1, dni);
         psst.setString       (2, cuil);
         psst.setString    (3, nombre);
         psst.setString    (4, apellido);
         psst.setString    (5, domicilio);
         psst.setInt       (6, telefono);
         psst.setString    (7, estado_civil);
         psst.setDate      (8, f);
         psst.setInt       (9, antiguedad); 
         psst.setString    (10, estado);
         psst.setInt       (11, cant_disponible);
        
         
    /*
        
         psst.setObject(1 , empleaVO.getDNI());
         psst.setObject(2 , empleaVO.getCuil());
         psst.setObject(3 , empleaVO.getNombre());
         psst.setObject(4 , empleaVO.getApellido());
         psst.setObject(5 , empleaVO.getDomicilio());
         psst.setObject(6 , empleaVO.getTelefono());
         psst.setObject(7 , empleaVO.getEstado_civil());
         psst.setObject(8 , empleaVO.getFecha_ingreso());
         psst.setObject(9 , empleaVO.getAntiguedad());
         psst.setObject(10 , empleaVO.getEstado());
         psst.setObject(11 , empleaVO.getCant_disponible());

        */
   
         // Indicamos que comience la actualización de la tabla en nuestra base de datos
          psst.executeUpdate();

         // Cerramos las conexiones, en orden inverso a su apertura
         psst.close();
         con.close();

	
	}


public List<EmpleadoVO> getListaEmpleados(){
	List<EmpleadoVO> listaEmpleado = new ArrayList<EmpleadoVO>();
	con = null;
	st = null;
	rs = null;
	
	try {
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery("select * from empleado");
		while(rs.next()) {
			EmpleadoVO emp = new EmpleadoVO();
		
			emp.setLegajo(rs.getInt("legajo")) ;
			emp.setDNI(rs.getInt("dni"));
			emp.setNombre(rs.getString("nombre"));
			emp.setApellido(rs.getString("apellido"));
			emp.setCuil(rs.getString("cuil"));
			emp.setDomicilio(rs.getString("domicilio")) ;
			emp.setTelefono(rs.getInt("telefono"));
			emp.setEstado_civil(rs.getString("estado_civil"));
			emp.setFecha_ingreso(rs.getDate("fecha_ingreso"));
			emp.setAntiguedad(rs.getInt("antiguedad")) ;
			emp.setEstado(rs.getString("estado"));
			emp.setCant_disponible(rs.getInt("cant_disponible"));
			
			
			listaEmpleado.add(emp);
		}			
		rs.close();
		st.close();
	} catch (SQLException e) { e.printStackTrace();}
	  finally { DBConnection.closeConnection(); }
	
	return listaEmpleado;
}


public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
    return new java.sql.Date(date.getTime());
}
}