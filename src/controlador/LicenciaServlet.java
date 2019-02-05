package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String btnLicencia = request.getParameter("btnLicencia");
		
		// Lleva a la pagina de alta de licencia
		if(btnLicencia.equals("alta")){
			
			Date fecha_hoy = new Date();
			
			LicenciaDAO LicenDAO = new LicenciaDAO();
			
			// Muestra el id de licencia mientras se carga una nueva
			int ultimo_id = LicenDAO.ultimoIdLicencia();
			request.setAttribute("ultimo_id", ultimo_id);
			
			// Intenta darle formato a la fecha_solicitud para setearla al dia en curso
			DateFormat formato_fecha = new SimpleDateFormat("dd/MM/yyyy");
			formato_fecha.format(fecha_hoy);
			System.out.println(fecha_hoy);
			request.setAttribute("fecha_hoy", fecha_hoy);
			
			request.getRequestDispatcher("/WEB-INF/JSP/Licencia/LicenciaAlta.jsp").forward(request, response);
			}
				
		// Toma los datos ingresados y los guarda en la base de datos. Pasa a la pagina licencia_nueva
		else if (btnLicencia.equals("aceptaAlta")){
			
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				request.getRequestDispatcher("/WEB-INF/JSP/Licencia/LicenciaNueva.jsp").forward(request, response);
			   
				int id_licencia = 1;
				String descripcion = request.getParameter("descripcion");
				Date fecha_inicio = null;
				Date fecha_fin = null;
				Date fecha_solicitud = null;
				int cant_dias = Integer.parseInt(request.getParameter("cant_dias"));
				String motivo = request.getParameter("motivo");
				String certificado = request.getParameter("certificado");
				int usuario_aprobado = 1;
				int id_empleado_licencia = 1;
			   
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
			   
		    // Crea los objetos que van a contener los datos ingresado en licencia_alta
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
		
		if(btnLicencia.equals("volverMenu")){
			request.getRequestDispatcher("/WEB-INF/JSP/Menu.jsp").forward(request, response);
			}
		
		// Listado de todas las licencias
		if(btnLicencia.equals("listado")){
			LicenciaDAO licenDAO = new LicenciaDAO();
			List<LicenciaVO> listaLicencias = licenDAO.getListaLicencias();
			request.setAttribute("listaLicencias", listaLicencias);
			request.getRequestDispatcher("/WEB-INF/JSP/Licencia/LicenciaListar.jsp").forward(request, response);
			}
		else if(btnLicencia.equals("listarTodo")){
			
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
