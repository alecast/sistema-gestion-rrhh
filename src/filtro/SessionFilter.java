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
        //Variable para setear mensajes y pasarlos como parámetro a los JSP
		Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
        		
        HttpServletRequest req = (HttpServletRequest) request;
        //HttpServletResponse res = (HttpServletResponse) response;
        String path = ((HttpServletRequest) request).getRequestURI(); //Url de la petición
		HttpSession session = req.getSession(false); //Devuelve null si no existe sesión
		//Manejo de sesión no existente o usuario no seteado siempre que no se acceda desde el Login o el MainServlet
		if ((session == null || session.getAttribute("usuario") == null) 
			&& !(path.startsWith("/Sistema-de-Gestion-RRHH/Login.jsp") || path.startsWith("/Sistema-de-Gestion-RRHH/MainServlet"))){ 
			messages.put("error", "Su sesión ha expirado. Debe loguear nuevamente.");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		} else { //Si la sesión existe, sigue la cadena de peticiones normal
		//Si no se ingresó a la página de Login o al MainServlet, se sigue normalmente
		if (!(path.startsWith("/Sistema-de-Gestion-RRHH/Login.jsp") || path.startsWith("/Sistema-de-Gestion-RRHH/MainServlet"))) { 
			// Seteo de licencias para CU - Aprobar licencia
			UsuarioVO usuVO = (UsuarioVO) session.getAttribute("usuario");
			LicenciaDAO licenDAO = new LicenciaDAO();
			int licenciasPendientes = 0;
			int licenciasAprobadas = 0;
			// Si es administrador busco las licencias pendientes de aprobacion
			if(usuVO.getTipo_usuario().getDescripcion().equals("Administrador")) {
				licenciasPendientes = licenDAO.getCantidadLicenciasPendientes();
				session.setAttribute("licenciasPendientes", licenciasPendientes);
			} else { // Si no lo es, busco las aprobadas para este usuario
				licenciasAprobadas = licenDAO.getCantidadLicenciasAprobadasPorUsuario(usuVO.getEmpleado().getLegajo());
				session.setAttribute("licenciasAprobadas", licenciasAprobadas);
			}
			chain.doFilter(request, response); //Continua la cadena http
		} else { //Si se ingresó a cualquier no Login, seteo el atributo en sesión del tipo de usuario
			chain.doFilter(request, response);
		}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		fConfig.getServletContext();
	}

}
