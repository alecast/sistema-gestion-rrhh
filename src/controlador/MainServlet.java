package controlador;

import datos.UsuarioDAO;
import modelo.UsuarioVO;

import java.io.IOException;
import java.util.HashMap;
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
			if (userDAO.validarUsuario(user, pass)) { //Si se ingresaron credenciales correctas
				UsuarioVO usuVO = userDAO.getUsuarioVO(user,pass);
				if(usuVO.getEstado().equals("Inactivo")) { //Si el usuario est� inactivo
					messages.put("error","Usuario no activo.");				
					request.getRequestDispatcher("/Login.jsp").forward(request, response);					
				} else { //Validaciones de logueo correctas
				//Creo una variable de sesi�n e inserto el Usuario 
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", usuVO);
				request.getRequestDispatcher("/WEB-INF/JSP/Menu.jsp").forward(request, response);
				}
			} else { //User o pass incorrectos
				messages.put("error","Usuario y/o contrase�a incorrectos.");				
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
		
		
	   else if(btn.equals("LicenciasCU")) {
		   
		   
		
		request.getRequestDispatcher("/WEB-INF/JSP/CU/LicenciasCU.jsp").forward(request, response);
		
		}
		
		// Redirecci�n a JSP de cada funcionalidad
		else if(btn.equals("usuario")) request.getRequestDispatcher("/WEB-INF/JSP/Usuario/Opciones.jsp").forward(request, response);

		else if(btn.equals("empleado")) request.getRequestDispatcher("/WEB-INF/JSP/Empleado/Empleado Opciones.jsp").forward(request, response);		

		else if(btn.equals("licencia")) request.getRequestDispatcher("/WEB-INF/JSP/Licencia/LicenciaOpciones.jsp").forward(request, response);		
	}
}
