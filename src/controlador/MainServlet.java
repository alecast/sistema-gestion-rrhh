package controlador;

import datos.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String btn = request.getParameter("btnMain");
		if(btn.equals("login")){	
			String user = request.getParameter("userLogin");
			String pass = request.getParameter("passLogin");
			UsuarioDAO userDAO = new UsuarioDAO();
			if (userDAO.validarUsuario(user, pass)) {
				request.setAttribute("nombreUsuario", user);
				request.getRequestDispatcher("/WEB-INF/JSP/Menu.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}		
		} else if(btn.equals("usuario")) request.getRequestDispatcher("/WEB-INF/JSP/Usuario/Opciones.jsp").forward(request, response);
		  else if(btn.equals("empleado")) request.getRequestDispatcher("/Empleado.jsp").forward(request, response);
		  else if(btn.equals("Cargar Empleado")) request.getRequestDispatcher("/EmpleadoNuevo.jsp").forward(request, response);
	}

}
