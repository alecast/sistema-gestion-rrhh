package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.LicenciaDAO;
import modelo.LicenciaVO;

@WebServlet("/LicenciaServlet")
public class LicenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LicenciaServlet() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @param fecha_ingreso 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String btnLicencia = request.getParameter("btnLicencia");
		
		if(btnLicencia.equals("alta")){
			
			Date fecha_hoy = new Date();
			
			LicenciaDAO LicenDAO = new LicenciaDAO();
			
			int ultimo_id = LicenDAO.ultimoIdLicencia();
			request.setAttribute("ultimo_id", ultimo_id);
			
			DateFormat formato_fecha = new SimpleDateFormat("dd/MM/yyyy");
			formato_fecha.format(fecha_hoy);
			System.out.println(fecha_hoy);
			request.setAttribute("fecha_hoy", fecha_hoy);

			
			request.getRequestDispatcher("/WEB-INF/JSP/Licencia/LicenciaAlta.jsp").forward(request, response);
			}
				
		
		else if (btnLicencia.equals("aceptaAlta")){
			 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				request.getRequestDispatcher("/WEB-INF/JSP/Licencia/LicenciaNueva.jsp").forward(request, response);
		     //  int Legajo = Integer.parseInt(request.getParameter("Legajo"));
			  // int id_licencia = Integer.parseInt(request.getParameter("id_licencia"));
			 //  int fecha_inicio = Integer.parseInt(request.getParameter("fecha_inicio"));
			//   int fecha_fin = Integer.parseInt(request.getParameter("fecha_fin"));
			//   int fecha_solicitud = Integer.parseInt(request.getParameter("fecha_solicitud"));
			//   Date fecha_inicio = null;
			//   Date fecha_fin = null;
			//   Date fecha_solicitud = null;
			   
			   int id_licencia = 1;
			// Integer.parseInt(request.getParameter("id_licencia"));
			   String descripcion = request.getParameter("descripcion");
			   Date fecha_inicio = null;
			   Date fecha_fin = null;
			   Date fecha_solicitud = null;
			   int cant_dias = Integer.parseInt(request.getParameter("cant_dias"));
			   String motivo = request.getParameter("motivo");
			   String certificado = request.getParameter("certificado");
			   int usuario_aprobado = 1;
			//Integer.parseInt(request.getParameter("usuario_aprobado"));
			   int id_empleado_licencia = 1;
			//Integer.parseInt(request.getParameter("id_usuario_licencia"));
		       
		       
			/* es lo que estaba en empleadoServlet
				 int DNI = Integer.parseInt(request.getParameter("DNI"));
				   int cuil = Integer.parseInt(request.getParameter("cuil"));
				   int telefono = Integer.parseInt(request.getParameter("telefono"));
				   int antiguedad = Integer.parseInt(request.getParameter("antiguedad"));
				   int cant_disponible = Integer.parseInt(request.getParameter("cant_disponible"));
				   Date fecha_ingreso = null;
			*/
			   
			try {
				fecha_inicio = dateFormat.parse(request.getParameter("fecha_inicio"));
				} catch (ParseException e) {
					e.printStackTrace();
					}
			try {
				fecha_fin = dateFormat.parse(request.getParameter("fecha_fin"));
				} catch (ParseException e) {
					e.printStackTrace();
					}
			try {
				fecha_solicitud = dateFormat.parse(request.getParameter("fecha_solicitud"));
				} catch (ParseException e) {
					e.printStackTrace();
					}			
			   
		    LicenciaVO licenVO = new LicenciaVO (id_licencia, fecha_inicio, fecha_fin, fecha_solicitud, cant_dias, descripcion, motivo, certificado, usuario_aprobado, id_empleado_licencia);
		    
		    LicenciaDAO licenDAO = new LicenciaDAO();
		    
		    
		    try {
		    	licenDAO.AltaLicencia(licenVO);
		    	String estado = "Pendiente";
			     int id = licenDAO.ultimoIdLicencia()-1;
		    	licenDAO.AltaEstadoLicencia(estado, id, fecha_solicitud);
				} catch (SQLException e) {
					e.printStackTrace();
					}
		    
		    /*  try { // empleDAO.Alta(empleaVO);
           //         try {
						licenDAO.AltaLicencia(licenVO);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
			//	empleDAO.Insertar(DNI,cuil,request.getParameter("nombre"),request.getParameter("apellido"),request.getParameter("domicilio"),telefono ,request.getParameter("estado_civil"),request.getParameter("fecha_ingreso"), antiguedad ,request.getParameter("estado"), cant_disponible);    
			//	} catch(Exception e) 
                   }
					     
		     
	
		if(btnLicencia.equals("aceptaModifica")) {
			String pass = request.getParameter("userPass");
			String pass2 = request.getParameter("userPass2");		
        	}
		
		if(btnLicencia.equals("volverOpciones")){
			request.getRequestDispatcher("/WEB-INF/JSP/Licencia/LicenciaOpciones.jsp").forward(request, response);
			}
		
	/*	else if(btnLicencia.equals("aceptaAlta")){
			request.getRequestDispatcher("/WEB-INF/JSP/Licencia/LicenciaNueva.jsp").forward(request, response);
			}
	*/	
	
		
		if(btnLicencia.equals("volverAlta")){
			request.getRequestDispatcher("/WEB-INF/JSP/Licencia/LicenciaAlta.jsp").forward(request, response);
			}
	
}
         
     /*	else
		{
			request.getRequestDispatcher("/Empleado Opciones.jsp").forward(request, response);
		}*/
		//( btnEmpleado.equals("Modificar")


public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
    return new java.sql.Date(date.getTime());
}
}
