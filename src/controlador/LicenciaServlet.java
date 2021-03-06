package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.EmpleadoDAO;
import datos.LicenciaDAO;
import modelo.EmpleadoVO;
import modelo.LicenciaVO;
import modelo.UsuarioVO;

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
				//Obtenemos usuario actual desde sesion
				HttpSession sesion = request.getSession();
				UsuarioVO usuVO = new UsuarioVO();
				usuVO = (UsuarioVO) sesion.getAttribute("usuario");	
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				request.getRequestDispatcher("/WEB-INF/JSP/Licencia/LicenciaNueva.jsp").forward(request, response);
			   
				int id_licencia = 1;
				String descripcion = request.getParameter("descripcion");
				Date fecha_inicio = null;
				Date fecha_fin = null;
				Date fecha_solicitud = null;
				//int cant_dias = Integer.parseInt(request.getParameter("cant_dias"));
				int cant_dias = 0;
				String motivo = request.getParameter("motivo");
				String certificado = request.getParameter("certificado");
				int legajo_adm = 1;
				int id_empleado_licencia = 1;
			   
			try {
				fecha_inicio = dateFormat.parse(request.getParameter("fecha_inicio"));
				fecha_fin = dateFormat.parse(request.getParameter("fecha_fin"));
				fecha_solicitud = dateFormat.parse(request.getParameter("fecha_solicitud"));
			    long diffInMillies = Math.abs(fecha_fin.getTime() - fecha_inicio.getTime());
			    cant_dias = (int)(long)(TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS));
				request.setAttribute("cant_dias", cant_dias);
			} catch (ParseException e) {
					e.printStackTrace();
			}
		    // Crea los objetos que van a contener los datos ingresado en licencia_alta
			LicenciaVO licenVO = new LicenciaVO (id_licencia, fecha_inicio, fecha_fin, fecha_solicitud, cant_dias, descripcion, motivo, certificado, legajo_adm, id_empleado_licencia,usuVO.getEmpleado());
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
					     
		     
	
		if(btnLicencia.contains("aceptaModifica")) {
			
			Map<String, String> messages = new HashMap<String, String>();
	        request.setAttribute("messages", messages);
			
			if(request.getParameter("descripcion").isEmpty() || request.getParameter("motivo").isEmpty() || request.getParameter("certificado").isEmpty() || request.getParameter("fecha_inicio").isEmpty() || request.getParameter("fecha_fin").isEmpty()) {
				messages.put("error","Debe completar todos los campos.");
				request.getRequestDispatcher("WEB-INF/JSP/Licencia/LicenciaModificar.jsp").forward(request, response);
			} else {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			String descripcion = request.getParameter("descripcion");
			Date fecha_inicio = null;
			Date fecha_fin = null;
			String motivo = request.getParameter("motivo");
			String certificado = request.getParameter("certificado");
			
			try {
				fecha_inicio = dateFormat.parse(request.getParameter("fecha_inicio"));
				fecha_fin = dateFormat.parse(request.getParameter("fecha_fin"));
				//fecha_solicitud = dateFormat.parse(request.getParameter("fecha_solicitud"));
			} catch (ParseException e) {
					e.printStackTrace();}
			
			int index = Integer.parseInt(btnLicencia.substring(14,btnLicencia.length())); //�ndice que saca del value en el JSP, lo usa para modificar ese usuario
			request.setAttribute("id_licencia", index);
			
			LicenciaDAO licenDAO = new LicenciaDAO();
			licenDAO.modificarLicencia(index, fecha_inicio, fecha_fin, descripcion, motivo, certificado);
			
			request.getRequestDispatcher("/WEB-INF/JSP/Licencia/LicenciaOpciones.jsp").forward(request, response);		
        	}
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
		
		if(btnLicencia.contains("modificarLicencia")) { //Se fija que se haya apretado alguno de los "aceptaModifica"
			int index = Integer.parseInt(btnLicencia.substring(17,btnLicencia.length())); //�ndice que saca del value en el JSP, lo usa para modificar ese usuario
			request.setAttribute("id_licencia", index);			
			
			LicenciaDAO licenDAO = new LicenciaDAO();
			LicenciaVO licenVO = new LicenciaVO();
			licenVO = licenDAO.getLicencia(index);
			request.setAttribute("licencia", licenVO);					
			
			request.getRequestDispatcher("WEB-INF/JSP/Licencia/LicenciaModificar.jsp").forward(request, response);	
		}
		else if(btnLicencia.contains("eliminarLicencia")) {
			int index = Integer.parseInt(btnLicencia.substring(16,btnLicencia.length()));
			LicenciaDAO licenDAO = new LicenciaDAO();
		//	request.setAttribute("id_licencia", index);
			licenDAO.eliminarLicencia(index);
			
			request.getRequestDispatcher("WEB-INF/JSP/Licencia/LicenciaOpciones.jsp").forward(request, response);			
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
