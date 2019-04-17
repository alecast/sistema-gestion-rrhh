package controlador;

import datos.EmpleadoDAO;
import datos.LicenciaDAO;
import datos.UsuarioDAO;
import modelo.EmpleadoVO;
import modelo.Estado_licVO;
import modelo.LicenciaVO;
import modelo.UsuarioVO;
import util.CustomException;
import util.SendEmail;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Variable para setear mensajes y pasarlos como par�metro a los JSP
		Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
        
        //Nombre del bot�n para cualquier input a partir del que se programa la l�gica del servlet
		String btn = request.getParameter("btnMain");		
		
		//Manejo del Inicio de sesi�n
		if(btn.equals("login")){
			// Valido que no exista una sesi�n en curso
			HttpSession session = request.getSession(false); 
			if (session != null) { //Si no devolvi� nulo, osea si la sesi�n existe
			    session.invalidate(); //Invalido la sesi�n actual para que deje de tener a mi usuario
			}
			String user = request.getParameter("userLogin");
			String pass = request.getParameter("passLogin");
			UsuarioDAO userDAO = new UsuarioDAO();
			
			try {
				UsuarioVO usuVO = userDAO.getUsuarioVO(user,pass);
				if(usuVO.getEstado().equals("Inactivo")) { //Si el usuario est� inactivo
					messages.put("error","Usuario no activo.");				
					request.getRequestDispatcher("/Login.jsp").forward(request, response);					
				} else { //Validaciones de logueo correctas
				//Creo una variable de sesi�n e inserto el Usuario 
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", usuVO);
				
				// Si es administrador, busco las licencias pendientes de aprobaci�n para mostrar en notificaci�n
				LicenciaDAO licenDAO = new LicenciaDAO();
				
				if(usuVO.getTipo_usuario().getDescripcion().equals("Administrador")) {
					int licenciasPendientes = licenDAO.getCantidadLicenciasPendientes();
					sesion.setAttribute("licenciasPendientes", licenciasPendientes);
				} else { // Si no es administrador, muestro licencias aprobadas
					int licenciasAprobadas = licenDAO.getCantidadLicenciasAprobadasPorUsuario(usuVO.getEmpleado().getLegajo());
					sesion.setAttribute("licenciasAprobadas", licenciasAprobadas);
				}
				request.getRequestDispatcher("/WEB-INF/JSP/Menu.jsp").forward(request, response);
				}
			} catch (CustomException e) { //User o pass incorrectos
				messages.put("error",e.getMessage());				
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}		
		} 
		// Manejo de cierre de sesi�n
		else if(btn.equals("cerrarSesion")) {
			// Creo una variable de sesi�n con getSession(false) que devuelve nulo si no existe la sesi�n
			HttpSession session = request.getSession(false); 
			if (session != null) { //Si no devolvi� nulo, osea si la sesi�n existe
			    session.invalidate(); //Invalido la sesi�n actual para que deje de tener a mi usuario
			}
			// Redirecciono a la p�gino de Logueo
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
		// Manejo del CU: Solicitar Licencia
		
		//Listado de licencias pendientes de aprobaci�n (Administrador solo)
	   else if(btn.equals("LicenciasCU")) {
		   LicenciaDAO LicenDAO = new LicenciaDAO();
		   List<Estado_licVO> listaLicenciasPendientes = LicenDAO.getListaLicenciasPendientes();
		   request.setAttribute("listaLicenciasPendientes", listaLicenciasPendientes);
		   request.getRequestDispatcher("/WEB-INF/JSP/CU/LicenciasCU.jsp").forward(request, response);
		}
		//Listado de licencias aprobadas para el usuario (Empleado solo)
       else if(btn.equals("LicenciasAprobadas")) {
    	   UsuarioVO usuVO = new UsuarioVO();
    	   HttpSession sesion = request.getSession();
    	   usuVO = (UsuarioVO) sesion.getAttribute("usuario");
		   LicenciaDAO LicenDAO = new LicenciaDAO();	
		   List<Estado_licVO> listaLicenciasAprobadas = LicenDAO.getListaLicenciasAprobadas(usuVO.getEmpleado().getLegajo());
		   request.setAttribute("listaLicenciasAprobadas", listaLicenciasAprobadas);
		   request.getRequestDispatcher("/WEB-INF/JSP/CU/ListaLicenciasAprobadas.jsp").forward(request, response);
		}	
		// Aceptaci�n de una licencia pendiente de aprobaci�n lleva a completar los campos necesarios para aprobar
       else if(btn.contains("AceptaPendiente")) {
    	   int index = Integer.parseInt(btn.substring(15,btn.length()));
    	   request.setAttribute("id_licencia", index);
    	   request.getRequestDispatcher("/WEB-INF/JSP/CU/ModificarEstado.jsp").forward(request, response);
		}		
		// Confirmaci�n de aceptaci�n de licencia con los campos necesarios
       else if(btn.contains("aceptaModifica")) {
    	   int index = Integer.parseInt(btn.substring(14,btn.length()));
    	   request.setAttribute("id_licencia", index);
    	   if(request.getParameter("motivo").isEmpty() || request.getParameter("fecha_inicio").isEmpty() || request.getParameter("fecha_fin").isEmpty() ) {
    		   request.getRequestDispatcher("/WEB-INF/JSP/CU/ModificarEstado.jsp").forward(request, response);
			} else {
	    	   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    	   Date fecha_inicio = null;
	    	   Date fecha_fin = null;
	    	   String motivo = request.getParameter("motivo");
	    		try {
					fecha_inicio = dateFormat.parse(request.getParameter("fecha_inicio"));
					fecha_fin = dateFormat.parse(request.getParameter("fecha_fin"));
		    	   LicenciaDAO licenDAO = new LicenciaDAO();
		    	   licenDAO.nuevoEstado(index,fecha_inicio,fecha_fin,motivo);
		    	   
		    	   // Se recuperan los datos para dicha licencia y se envian al usuario que la solicito
		    	   LicenciaVO licenVO = new LicenciaVO();
		    	   licenVO = licenDAO.getLicencia(index);
		    	   EmpleadoVO empVO = new EmpleadoVO();
		    	   EmpleadoDAO empDAO = new EmpleadoDAO();
		    	   empVO = empDAO.getEmpleado(licenVO.getId_licencia()); 
		    	   String msg = empVO.getNombre()+", la licencia que solicit� de N�: "+Integer.toString(licenVO.getId_licencia()) + 
		    	   " fue aprobada";
		    	   SendEmail.send(empVO.getEmail(),"Licencia Aprobada",msg);
		    	   
				} catch (ParseException e) {
					e.printStackTrace();
				} finally {
					request.getRequestDispatcher("/WEB-INF/JSP/Menu.jsp").forward(request, response);
				}
			}	
	   	}
		
		// Redirecci�n a JSP de cada funcionalidad
		else if(btn.equals("usuario")) request.getRequestDispatcher("/WEB-INF/JSP/Usuario/Opciones.jsp").forward(request, response);

		else if(btn.equals("empleado")) request.getRequestDispatcher("/WEB-INF/JSP/Empleado/Empleado Opciones.jsp").forward(request, response);		

		else if(btn.equals("licencia")) request.getRequestDispatcher("/WEB-INF/JSP/Licencia/LicenciaOpciones.jsp").forward(request, response);		
			
		else if(btn.equals("volverLicenciasCU")) request.getRequestDispatcher("/WEB-INF/JSP/Menu.jsp").forward(request, response);
	}
}
