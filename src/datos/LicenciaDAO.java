package datos;

import modelo.Estado_licVO;

import modelo.EmpleadoVO;

import modelo.LicenciaVO;

import java.sql.*;
import datos.DBConnection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LicenciaDAO {
	private Connection con = null;
	private PreparedStatement psst = null;
	private ResultSet rs = null;
	private Statement st = null;
   
//public void AltaEmpleado(empleado EmpleadoVO);
//EmpleadoVO empleado = new EmpleadoVO();

/*public void Insertar(int legajo,int dni,int cuil, String nombre, String apellido, String domicilio,int telefono, String estado_civil, String fecha_ingreso, int antiguedad, String estado, int cant_disponible) {

    // Establecer conexi�n con la base de datos
      //  Connection con = new Connection();

        // Pasamos el objeto Connection de nuestra clase "ConexionBD" a esta instancia por medio del m�todo getConnection()
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
            // Indicamos que comience la actualizaci�n de la tabla en nuestra base de datos
            psst.executeUpdate(query);

            // Cerramos las conexiones, en orden inverso a su apertura
            psst.close();
            con.close();

            System.out.println("Llamada agregada con �xito a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
        }
}
*/

public void AltaLicencia(LicenciaVO licenVO) throws SQLException {
	
	// TODO Auto-generated method stub
	String query = "INSERT INTO Licencia(fecha_inicio, fecha_fin, fecha_solicitud, legajo, cant_dias, descripcion, motivo, certificado, legajo_adm, id_empleado_licencia) values (?,?,?,?,?,?,?,?,?,?)";

	// try {
		 con = DBConnection.createConnection();
		 //Connection con = new connection();
		
         psst = con.prepareStatement(query);
         
        // int id_licencia = ((LicenciaVO) licenVO).getId_licencia();
         java.sql.Date f =  convertJavaDateToSqlDate(((LicenciaVO) licenVO).getFecha_inicio());
         java.sql.Date g =  convertJavaDateToSqlDate(((LicenciaVO) licenVO).getFecha_fin());
         java.sql.Date h =  convertJavaDateToSqlDate(((LicenciaVO) licenVO).getFecha_solicitud());
         int legajo = ((LicenciaVO) licenVO).getEmpleado().getLegajo();
         int cant_dias = ((LicenciaVO) licenVO).getCant_dias();
         String descripcion = ((LicenciaVO) licenVO).getDescripcion();
         String motivo = ((LicenciaVO) licenVO).getMotivo();
         String certificado = ((LicenciaVO) licenVO).getCertificado();
         int legajo_adm = ((LicenciaVO) licenVO).getLegajo_adm();
         int id_empleado_licencia = ((LicenciaVO) licenVO).getId_empleado_licencia();          

       //  Date fecha_inicio = ((LicenciaVO) licenVO).getFecha_inicio();
       //  Date fecha_fin = ((LicenciaVO) licenVO).getFecha_fin();     
       //  setLocalDateTime fecha_solicitud = ((LicenciaVO) licenVO).getFecha_solicitud();         

       //  java.sql.Date fecha_ingreso = ((EmpleadoVO) empleaVO).getFecha_ingreso();

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

         //psst.setInt            (1, id_licencia);
         psst.setDate           (1, f);
         psst.setDate           (2, g);
         psst.setDate  			(3, h);
         psst.setInt			(4, legajo);
         psst.setInt            (5, cant_dias);
         psst.setString         (6, descripcion);
         psst.setString         (7, motivo);
         psst.setString         (8, certificado);
         psst.setInt            (9, legajo_adm);         
         psst.setInt         	(10, id_empleado_licencia);
         
  //       psst.setString         (6, motivo);
  //       psst.setString         (7, certificado);
   //      psst.setInt            (8, usuario_aprobado); 
    //     psst.setInt            (9, 1);
        
         
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
   
         // Indicamos que comience la actualizaci�n de la tabla en nuestra base de datos
         psst.executeUpdate();


         // Cerramos las conexiones, en orden inverso a su apertura
         psst.close();
         con.close();
	
}

public void AltaEstadoLicencia (String estado, int id_licencia, Date fecha_solicitud ) {
	
	// TODO Auto-generated method stub
	String query = "INSERT INTO Estado_lic(estado,fecha_iniciacion, id_licencia) values (?,?,?)";

	// try {
		 con = DBConnection.createConnection();
		 //Connection con = new connection();
		
         try {
        	 java.sql.Date f =  convertJavaDateToSqlDate(fecha_solicitud);
        	 psst = con.prepareStatement(query);         
        	 psst.setString         (1, estado);
        	 psst.setDate  			(2, f);
        	 psst.setInt            (3, id_licencia);
        	
        	 psst.executeUpdate();
        	 psst.close();
        	 con.close();
         } catch (SQLException e) {}
	
}

public int ultimoIdLicencia()
{ 
	int p =0;
	try {
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery("select MAX(id_licencia+1)as numero from Licencia");
		
		while (rs.next()) { //Se fija si hay una fila resultado de la consulta
			p = rs.getInt("numero"); // Obtengo el nombre_usuario de la consulta			
		}
		
		rs.close();
		st.close();		
		
	} catch (SQLException e) { e.printStackTrace();} 
	finally { DBConnection.closeConnection();}
	return p;			
	}

public int contador()
{ 
	int p =0;
	try {
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery("select count(estado)as numero from Estado_lic where estado ='Pendiente'");
		
		while (rs.next()) { //Se fija si hay una fila resultado de la consulta
			p = rs.getInt("numero"); // Obtengo el nombre_usuario de la consulta			
		}
		rs.close();
		st.close();		
		
	} catch (SQLException e) { e.printStackTrace();} 
	finally { DBConnection.closeConnection();}
	return p;			
	}

public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
    return new java.sql.Date(date.getTime());
}

public LicenciaVO getLicencia(int id_licencia) {
	
	LicenciaVO lic = new LicenciaVO();
	con = null;
	st = null;
	rs = null;
	
	try {
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery("select * from licencia where id_licencia ='"+id_licencia+"' "); 
		while(rs.next()) 
		{
			lic.setId_licencia(rs.getInt("id_licencia"));
			lic.setDescripcion(rs.getString("descripcion"));
			lic.setFecha_inicio(rs.getDate("fecha_inicio"));
			lic.setFecha_fin(rs.getDate("fecha_fin"));
			lic.setFecha_solicitud(rs.getDate("fecha_solicitud"));
			lic.setCant_dias(rs.getInt("cant_dias"));
			lic.setMotivo(rs.getString("motivo"));
			lic.setCertificado(rs.getString("certificado")) ;
			lic.setLegajo_adm(rs.getInt("legajo_adm"));
			lic.setId_empleado_licencia(rs.getInt("id_empleado_licencia"));
			lic.setEmpleado(rs.getInt("legajo"));			
		}
		rs.close();
		st.close();
		
	} catch (SQLException e) { e.printStackTrace();} 
	finally { DBConnection.closeConnection();}
	
	return lic;
}
	
public List<LicenciaVO> getListaLicencias() {
		List<LicenciaVO> listaLicencias = new ArrayList<LicenciaVO>();
		con = null;
		st = null;
		rs = null;
		String query = "";
		query = "select * from licencia"; 
		
		try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				LicenciaVO u = new LicenciaVO();
				u.setId_licencia(rs.getInt("id_licencia"));
				u.setDescripcion(rs.getString("descripcion"));
				u.setFecha_inicio(rs.getDate("fecha_inicio")); 
				u.setFecha_fin(rs.getDate("fecha_fin"));
				u.setFecha_solicitud(rs.getDate("fecha_solicitud")); 
				u.setCant_dias(rs.getInt("cant_dias"));
				u.setMotivo(rs.getString("motivo"));
				u.setCertificado(rs.getString("certificado"));
				u.setLegajo_adm(rs.getInt("legajo_adm"));
				u.setEmpleado(rs.getInt("legajo"));
				listaLicencias.add(u);
			}			
			rs.close();
			st.close();
			} catch (SQLException e) { e.printStackTrace();}
		 
		finally { DBConnection.closeConnection(); }
		
		//return listaLicencias;
		return listaLicencias;
	}


public List<Estado_licVO> getListaLicenciasPendientes() {
	List<Estado_licVO> listaLicenciasPendientes = new ArrayList<Estado_licVO>();
	con = null;
	st = null;
	rs = null;
	String query = "";
	query = "select * from V_LicenciaCU where fecha_finalizacion is null and estado = 'Pendiente'"; 
	
	try {
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery(query);
		while(rs.next()) {
			LicenciaVO u = new LicenciaVO();
			Estado_licVO e = new Estado_licVO();
			u.setId_licencia(rs.getInt("id_licencia"));
			u.setDescripcion(rs.getString("descripcion"));
			u.setFecha_inicio(rs.getDate("fecha_inicio")); 
			u.setFecha_fin(rs.getDate("fecha_fin"));
			u.setFecha_solicitud(rs.getDate("fecha_solicitud")); 
			u.setCant_dias(rs.getInt("cant_dias"));
			u.setMotivo(rs.getString("motivo"));
			u.setCertificado(rs.getString("certificado"));
			u.setLegajo_adm(rs.getInt("legajo_adm"));
			u.setEmpleado(rs.getInt("legajo"));
			
			e.setEstado(rs.getString("estado"));
			e.setFecha_iniciacion(rs.getDate("fecha_iniciacion"));
			e.setFecha_finalizacion(rs.getDate("fecha_finalizacion"));
			e.setMotivo_cambio(rs.getString("motivo_cambio"));
			
			e.setLicencia(u);
			
			
			listaLicenciasPendientes.add(e);
		}			
		rs.close();
		st.close();
		} catch (SQLException e) { e.printStackTrace();}
	 
	finally { DBConnection.closeConnection(); }
	
	//return listaLicencias;
	return listaLicenciasPendientes;
}

public List<Estado_licVO> getListaLicenciasAprobadas(int legajo) {
	List<Estado_licVO> listaLicenciasAprobadas = new ArrayList<Estado_licVO>();
	con = null;
	st = null;
	rs = null;
	String query = "";
	query = "select * from V_LicenciaCU where estado = 'Aprobado' and legajo = '"+legajo+"'"; 
	
	try {
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery(query);
		while(rs.next()) {
			LicenciaVO u = new LicenciaVO();
			Estado_licVO e = new Estado_licVO();
			u.setId_licencia(rs.getInt("id_licencia"));
			u.setDescripcion(rs.getString("descripcion"));
			u.setFecha_inicio(rs.getDate("fecha_inicio")); 
			u.setFecha_fin(rs.getDate("fecha_fin"));
			u.setFecha_solicitud(rs.getDate("fecha_solicitud")); 
			u.setCant_dias(rs.getInt("cant_dias"));
			u.setMotivo(rs.getString("motivo"));
			u.setCertificado(rs.getString("certificado"));
			u.setLegajo_adm(rs.getInt("legajo_adm"));
			u.setEmpleado(rs.getInt("legajo"));
			
			e.setEstado(rs.getString("estado"));
			e.setFecha_iniciacion(rs.getDate("fecha_iniciacion"));
			e.setFecha_finalizacion(rs.getDate("fecha_finalizacion"));
			e.setMotivo_cambio(rs.getString("motivo_cambio"));
			
			e.setLicencia(u);
			
			
			listaLicenciasAprobadas.add(e);
		}			
		rs.close();
		st.close();
		} catch (SQLException e) { e.printStackTrace();}
	 
	finally { DBConnection.closeConnection(); }
	
	//return listaLicencias;
	return listaLicenciasAprobadas;
}

public void modificarLicencia(int id_licencia, Date fecha_inicio, Date fecha_fin, String descripcion, String motivo, String certificado) {	

    java.sql.Date f =  convertJavaDateToSqlDate(fecha_inicio);
	java.sql.Date g =  convertJavaDateToSqlDate(fecha_fin);
	
	//java.sql.Date h =  convertJavaDateToSqlDate(((LicenciaVO) licenVO).getFecha_solicitud());
    
  //  int id_licencia = ((LicenciaVO) licenVO).getId_licencia();
  //  String descripcion = ((LicenciaVO) licenVO).getDescripcion();
 //   Date fecha_inicio = ((LicenciaVO) licenVO).getFecha_inicio();
 //   Date fecha_fin = ((LicenciaVO) licenVO).getFecha_fin();
 //   Date fecha_solicitud = ((LicenciaVO) licenVO).getFecha_solicitud();
  //  int cant_dias = ((LicenciaVO) licenVO).getCant_dias();
  //  String motivo = ((LicenciaVO) licenVO).getMotivo();
   // String certificado = ((LicenciaVO) licenVO).getCertificado();
    //int legajo_adm = ((LicenciaVO) licenVO).getLegajo_adm();
    //int id_empleado_licencia = ((LicenciaVO) licenVO).getId_empleado_licencia();
    //LicenciaVO empleado = ((LicenciaVO) licenVO).getEmpleado();
	try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			st.executeUpdate("update Licencia set descripcion='"+descripcion+"',fecha_inicio='"+f+"' ,fecha_fin='"+g+"',motivo= '"+motivo+"',certificado='"+certificado+"' where id_licencia = "+id_licencia+"");
			
			st.close();
		} catch (SQLException e) { e.printStackTrace();} 
		finally { DBConnection.closeConnection();}		
}

public void eliminarLicencia(int id_licencia){
	    	 
	try {
			con = DBConnection.createConnection();
			st = con.createStatement();
			st.executeUpdate("delete from Estado_lic where id_licencia = "+id_licencia+"");
			st.executeUpdate("delete from Licencia where id_licencia = "+id_licencia+"");
			st.close();
		} catch (SQLException e) { e.printStackTrace();} 
		finally { DBConnection.closeConnection();}	
}
public int getCantidadLicenciasPendientes() {
	int cantidad = 0;
	con = null;
	st = null;
	rs = null;
	String query = "";
	query = "select count(*) from V_LicenciaCU where fecha_finalizacion is null and estado = 'Pendiente'"; 
	
	try {
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery(query);
		while(rs.next()) {
			cantidad = rs.getInt(1); 
		}			
		rs.close();
		st.close();
		} catch (SQLException e) { e.printStackTrace();}
	 
	finally { DBConnection.closeConnection(); }
	return cantidad;

}
public int getCantidadLicenciasAprobadasPorUsuario(int legajo) {
	int cantidad = 0;
	con = null;
	st = null;
	rs = null;
	String query = "";
	query = "select count(*) from V_LicenciaCU where estado = 'Aprobado' and legajo = '"+legajo+"'"; 
	
	try {
		con = DBConnection.createConnection();
		st = con.createStatement();
		rs = st.executeQuery(query);
		while(rs.next()) {
			cantidad = rs.getInt(1); 
		}			
		rs.close();
		st.close();
		} catch (SQLException e) { e.printStackTrace();}
	 
	finally { DBConnection.closeConnection(); }
	return cantidad;
}
public void nuevoEstado (int id_licencia, Date fecha_inicio, Date fecha_fin, String motivo ) {
	con = null;
	st = null;
	rs = null;
	// TODO Auto-generated method stub
	String query = "INSERT INTO Estado_lic(estado,fecha_iniciacion,fecha_finalizacion, id_licencia,motivo_cambio) values (?,?,?,?,?)";
	String query2 = "update Estado_lic set fecha_finalizacion=GETDATE(),motivo_cambio='Aprobacion' where id_licencia="+id_licencia+ " and estado = 'Pendiente'";
	// try {
		 con = DBConnection.createConnection();
		 //Connection con = new connection();
		
         try {
        	 java.sql.Date f =  convertJavaDateToSqlDate(fecha_inicio);
        	 java.sql.Date j =  convertJavaDateToSqlDate(fecha_fin);
        	 psst = con.prepareStatement(query);         
        	 psst.setString         (1, "Aprobado");
        	 psst.setDate  			(2, f);
        	 psst.setDate  			(3, j);
        	 psst.setInt            (4, id_licencia);
        	 psst.setString         (5, motivo);
        	
        	 psst.executeUpdate();
        	 psst.close();
        	 
        	 st = con.createStatement();
        	 st.executeUpdate(query2);
        	 
        	 st.close();
        	 con.close();
        	 
         } catch (SQLException e) {}
         finally { DBConnection.closeConnection(); }
}

}