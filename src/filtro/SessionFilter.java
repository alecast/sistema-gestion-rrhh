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

import modelo.UsuarioVO;

/**
 * Servlet Filter implementation class SessionFilter
 */
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
        
		HttpSession session = req.getSession(false); //Devuelve null si no existe sesión
		if (session == null) { //Manejo de sesión no existente
			messages.put("error", "Su sesión ha expirado. Debe loguear nuevamente.");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		} else { //Si la sesión existe, sigue la cadena de peticiones normal
		// Seteo la dirección con la que se ingresó al filtro
		String path = ((HttpServletRequest) request).getRequestURI(); 
		//Si se ingresó a la página de Login o al MainServlet, se sigue normalmente
		if (path.startsWith("/Sistema-de-Gestion-RRHH/Login.jsp") || path.startsWith("/Sistema-de-Gestion-RRHH/MainServlet")) { 
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
