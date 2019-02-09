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
        //Variable para setear mensajes y pasarlos como par�metro a los JSP
		Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
        		
        HttpServletRequest req = (HttpServletRequest) request;
        //HttpServletResponse res = (HttpServletResponse) response;
        
		HttpSession session = req.getSession(false); //Devuelve null si no existe sesi�n
		if (session == null) { //Manejo de sesi�n no existente
			messages.put("error", "Su sesi�n ha expirado. Debe loguear nuevamente.");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		} else { //Si la sesi�n existe, sigue la cadena de peticiones normal
		// Seteo la direcci�n con la que se ingres� al filtro
		String path = ((HttpServletRequest) request).getRequestURI(); 
		//Si se ingres� a la p�gina de Login o al MainServlet, se sigue normalmente
		if (path.startsWith("/Sistema-de-Gestion-RRHH/Login.jsp") || path.startsWith("/Sistema-de-Gestion-RRHH/MainServlet")) { 
			chain.doFilter(request, response); //Continua la cadena http
		} else { //Si se ingres� a cualquier no Login, seteo el atributo en sesi�n del tipo de usuario
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
