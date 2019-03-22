package filtro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import datos.LicenciaDAO;
import modelo.UsuarioVO;

/**
 * Servlet Filter implementation class SessionFilter
 */
@SuppressWarnings("unused")
//@WebFilter("/SessionFilter")
@WebFilter(urlPatterns={"/*"})
public class SessionFilter implements Filter {
	
	/**
     * Default constructor. 
     */
    public SessionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
        //Variable para setear mensajes y pasarlos como par�metro a los JSP
		Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
        		
        HttpServletRequest req = (HttpServletRequest) request;
        
        String path = ((HttpServletRequest) request).getRequestURI(); //Url de la petici�n

        //Seteo de URL de inicio v�lidas
        String validPaths[] = new String[10];
        validPaths[0] = "/Sistema-de-Gestion-RRHH/Login.jsp";
        validPaths[1] = "/Sistema-de-Gestion-RRHH/js/bootstrap.min.js";
        validPaths[2] = "/Sistema-de-Gestion-RRHH/css/Estilos.css";
        validPaths[3] = "/Sistema-de-Gestion-RRHH/css/bootstrap.min.css";
        validPaths[4] = "/Sistema-de-Gestion-RRHH/MainServlet";
        validPaths[5] = "/Sistema_de_Gestion_RRHH/Login.jsp";
        validPaths[6] = "/Sistema_de_Gestion_RRHH/js/bootstrap.min.js";
        validPaths[7] = "/Sistema_de_Gestion_RRHH/css/Estilos.css";
        validPaths[8] = "/Sistema_de_Gestion_RRHH/css/bootstrap.min.css";
        validPaths[9] = "/Sistema_de_Gestion_RRHH/MainServlet";
        
		HttpSession session = req.getSession(false); //Devuelve null si no existe sesi�n
        
        //Si no ingreso de una direcci�n de inicio v�lida, se validan los datos en sesi�n para continuar
		if (!(path.startsWith(validPaths[0]) || path.startsWith(validPaths[1]) || path.startsWith(validPaths[2]) 
		|| path.startsWith(validPaths[3]) || path.startsWith(validPaths[4]) || path.startsWith(validPaths[5]) 
		|| path.startsWith(validPaths[6]) || path.startsWith(validPaths[7]) || path.startsWith(validPaths[8]) 
		|| path.startsWith(validPaths[9])) )  { 
			//Manejo de sesi�n no existente o usuario no seteado siempre que no se acceda desde path de inicio v�lidos
			if ((session == null || session.getAttribute("usuario") == null)) {
				messages.put("error", "Su sesi�n ha expirado. Debe loguear nuevamente.");
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			} else { //Si la sesi�n existe, sigue la cadena de peticiones normal	
				// Seteo de licencias para CU - Aprobar licencia
				UsuarioVO usuVO = (UsuarioVO) session.getAttribute("usuario");
				LicenciaDAO licenDAO = new LicenciaDAO();
				// Si es administrador busco las licencias pendientes de aprobacion
				if(usuVO.getTipo_usuario().getDescripcion().equals("Administrador")) {
					int licenciasPendientes = licenDAO.getCantidadLicenciasPendientes();
					session.setAttribute("licenciasPendientes", licenciasPendientes);
				} else { // Si no lo es, busco las aprobadas para este usuario
					int licenciasAprobadas = licenDAO.getCantidadLicenciasAprobadasPorUsuario(usuVO.getEmpleado().getLegajo());
					session.setAttribute("licenciasAprobadas", licenciasAprobadas);
				}
				chain.doFilter(request, response); //Continua la cadena http
			} 
		}
		// Si se ingres� desde una direcci�n de inicio v�lida, se sigue normalmente
		else chain.doFilter(request, response);	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		fConfig.getServletContext();
	}

}
