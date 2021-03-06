
package datos;
import modelo.EmpleadoVO;


import java.sql.*;
import datos.DBConnection;
import java.util.ArrayList;
import java.util.List;



public class EmpleadoDAO {
	private Connection con = null;
	private PreparedStatement psst = null;
	private ResultSet rs = null;
    private Statement st = null;
	
   

public void AltaEmpleado(EmpleadoVO empleaVO) throws SQLException {
	
	// TODO Auto-generated method stub
	String query = "INSERT INTO Empleado(dni, cuil, nombre, apellido, domicilio, telefono, estado_civil, fecha_ingreso, antiguedad, estado, cant_disponible, email) values (?,?,?,?,?,?,?,?,?,?,?,?)";

	// try {
		 con = DBConnection.createConnection();
		 //Connection con = new connection();
		
         psst = con.prepareStatement(query);
        

         java.sql.Date f =  convertJavaDateToSqlDate(((EmpleadoVO) empleaVO).getFecha_ingreso());
         
        
         int dni = ((EmpleadoVO) empleaVO).getDNI();
         String cuil = ((EmpleadoVO) empleaVO).getCuil();
         String nombre = ((EmpleadoVO) empleaVO).getNombre();
         String apellido = ((EmpleadoVO) empleaVO).getApellido();
         String domicilio = ((EmpleadoVO) empleaVO).getDomicilio();
         int telefono = ((EmpleadoVO) empleaVO).getTelefono();
         String estado_civil = ((EmpleadoVO) empleaVO).getEstado_civil();
         int antiguedad = ((EmpleadoVO) empleaVO).getAntiguedad();
         String estado = ((EmpleadoVO) empleaVO).getEstado();
         int cant_disponible = ((EmpleadoVO) empleaVO).getCant_disponible();
         String email = ((EmpleadoVO) empleaVO).getEmail();
      
     
          
         psst.setInt       (1, dni);
         psst.setString    (2, cuil);
         psst.setString    (3, nombre);
         psst.setString    (4, apellido);
         psst.setString    (5, domicilio);
         psst.setInt       (6, telefono);
         psst.setString    (7, estado_civil);
         psst.setDate      (8, f);
         psst.setInt       (9, antiguedad); 
         psst.setString    (10, estado);
         psst.setInt       (11, cant_disponible);
         psst.setString	   (12, email);
        
         

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
			emp.setEmail(rs.getString("email"));
			
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
public List<EmpleadoVO> getListaEmpleadosPorNombre(String CampoLike, String RadioBusquedaPor, String Ch_inactivo ){
	List<EmpleadoVO> listaEmpleados = new ArrayList<EmpleadoVO>();
	con = null;
	st = null;
	rs = null;
	
	try {
		String Q ="select * from empleado where "+RadioBusquedaPor+" like '%"+CampoLike+"%' and estado not like 'Inactivo'";
		if (Ch_inactivo.contains("Inactivo")) Q = "select * from empleado where "+RadioBusquedaPor+" like '%"+CampoLike+"%'";
		
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery(Q);
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
			emp.setEmail(rs.getString("email"));
			listaEmpleados.add(emp);
		}			
		rs.close();
		st.close();
	} catch (SQLException e) { e.printStackTrace();}
	  finally { DBConnection.closeConnection(); }
	
	return listaEmpleados;
}
public void BajarEmpleado(String EstadoEmpleado, int legajo) {
	con = null;
	st = null;
	rs = null;
	
	try {
		con = DBConnection.createConnection();
		st = con.createStatement();
		st.executeUpdate("update empleado set estado = '"+EstadoEmpleado+"' where legajo ="+legajo+"");
		
		st.close();
	} catch (SQLException e) { e.printStackTrace();} 
	finally { DBConnection.closeConnection();}	
	
	
	
}
public EmpleadoVO getEmpleado(int legajo)
{
	
	EmpleadoVO emp = new EmpleadoVO();
	con = null;
	st = null;
	rs = null;
	
	try {
		
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery("select * from empleado where legajo ='"+legajo+"' "); 
		while(rs.next()) {
			
			
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
			emp.setEmail(rs.getString("email"));
			
		}
		rs.close();
		st.close();
		
	} catch (SQLException e) { e.printStackTrace();} 
	finally { DBConnection.closeConnection();}
	return emp;
}
public EmpleadoVO getEmpleadoPorDni(int dni)
{
	
	EmpleadoVO emp = new EmpleadoVO();
	con = null;
	st = null;
	rs = null;
	
	try {
		
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery("select * from empleado where dni ='"+dni+"' "); 
		while(rs.next()) {
			
			
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
			emp.setEmail(rs.getString("email"));
			
		}
		rs.close();
		st.close();
		
	} catch (SQLException e) { e.printStackTrace();} 
	finally { DBConnection.closeConnection();}
	return emp;
}

public int getMaxLegajo()

{   int Legajo=0;
	con = null;
	st = null;
	rs = null;
try {
		
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery("select max(legajo+1) as s from empleado "); 
		while( rs.next()){
		Legajo = rs.getInt("s");
		}
	

rs.close();
st.close();

} catch (SQLException e) { e.printStackTrace();} 
finally { DBConnection.closeConnection();}
return Legajo;}

public void modificarEmpleado(EmpleadoVO empleaVO) {
	

    java.sql.Date f =  convertJavaDateToSqlDate(((EmpleadoVO) empleaVO).getFecha_ingreso());
    
    int legajo = ((EmpleadoVO) empleaVO).getLegajo();
    int dni = ((EmpleadoVO) empleaVO).getDNI();
    String cuil = ((EmpleadoVO) empleaVO).getCuil();
    String nombre = ((EmpleadoVO) empleaVO).getNombre();
    String apellido = ((EmpleadoVO) empleaVO).getApellido();
    String domicilio = ((EmpleadoVO) empleaVO).getDomicilio();
    int telefono = ((EmpleadoVO) empleaVO).getTelefono();
    String estado_civil = ((EmpleadoVO) empleaVO).getEstado_civil();
    int antiguedad = ((EmpleadoVO) empleaVO).getAntiguedad();
    String estado = ((EmpleadoVO) empleaVO).getEstado();
    int cant_disponible = ((EmpleadoVO) empleaVO).getCant_disponible();
    String email = ((EmpleadoVO) empleaVO).getEmail();
 
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			st.executeUpdate("update Empleado set dni="+dni+",cuil='"+cuil+"' ,nombre='"+nombre+"',apellido='"+apellido+"',domicilio='"+domicilio+"',telefono= "+telefono+",estado_civil='"+estado_civil+"',fecha_ingreso='"+f+"',antiguedad="+antiguedad+",estado='"+estado+"',cant_disponible="+cant_disponible+",email='"+email+"'  where legajo="+legajo+"");
			
			st.close();
		} catch (SQLException e) { e.printStackTrace();} 
		finally { DBConnection.closeConnection();}	
	
	}
	

public void modificarCategoria(int x,int Categoria ,java.util.Date fecha ) {
	

    java.sql.Date f =  convertJavaDateToSqlDate(fecha);
    
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			st.executeUpdate("update Empleado_categoria set fecha_baja='"+f+"' where legajo ="+x+" and id_categoria ="+Categoria+"");
			
			st.close();
		} catch (SQLException e) { e.printStackTrace();} 
		finally { DBConnection.closeConnection();}	
	
	}
	

public void modificarTipo(int x,int tipo ,java.util.Date fecha ) {
	

    java.sql.Date f =  convertJavaDateToSqlDate(fecha);
    
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			st.executeUpdate("update Empleado_tipo set fecha_baja='"+f+"' where legajo ="+x+" and id_tipo_empleado ="+tipo+"");
			
			st.close();
		} catch (SQLException e) { e.printStackTrace();} 
		finally { DBConnection.closeConnection();}	
	
	}
	


public int getMaxIdTipo(int legajo)

{   int id=0;
	con = null;
	st = null;
	rs = null;
try {
		
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery("select max(id_Empleado_tipo) as s from Empleado_tipo where legajo = "+legajo+" "); 
		while( rs.next()){
		id = rs.getInt("s");
		}
	

rs.close();
st.close();

} catch (SQLException e) { e.printStackTrace();} 
finally { DBConnection.closeConnection();}
return id;}
public int getMaxIdCate(int legajo)

{   int id=0;
	con = null;
	st = null;
	rs = null;
try {
		
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery("select max(id_Empleado_categoria) as s from Empleado_tipo where legajo = "+legajo+" "); 
		while( rs.next()){
		id = rs.getInt("s");
		}
	

rs.close();
st.close();

} catch (SQLException e) { e.printStackTrace();} 
finally { DBConnection.closeConnection();}
return id;}

public void AltaTipo(int x ,int tipo ,java.util.Date fecha) throws SQLException {
	
	// TODO Auto-generated method stub
	String query = "INSERT INTO Empleado_tipo(legajo, id_tipo_empleado, fecha_alta ) values (?,?,?)";

	
		 con = DBConnection.createConnection();
		
		
       psst = con.prepareStatement(query);
      

       java.sql.Date f =  convertJavaDateToSqlDate(fecha);
       
     
        
       psst.setInt       (1, x);
       psst.setInt    (2, tipo);
       psst.setDate      (3, f);
      
       

       // Indicamos que comience la actualización de la tabla en nuestra base de datos
        psst.executeUpdate();

       // Cerramos las conexiones, en orden inverso a su apertura
       psst.close();
       con.close();

	
}
public void AltaCategoria(int x ,int categoria ,java.util.Date fecha) throws SQLException {
	
	// TODO Auto-generated method stub
	String query = "INSERT INTO Empleado_Categoria(legajo, id_categoria, fecha_alta ) values (?,?,?)";

	
		 con = DBConnection.createConnection();
		
		
       psst = con.prepareStatement(query);
      

       java.sql.Date f =  convertJavaDateToSqlDate(fecha);
       
     
        
       psst.setInt       (1, x);
       psst.setInt    (2, categoria);
       psst.setDate      (3, f);
      
       

       // Indicamos que comience la actualización de la tabla en nuestra base de datos
        psst.executeUpdate();

       // Cerramos las conexiones, en orden inverso a su apertura
       psst.close();
       con.close();

	
}}