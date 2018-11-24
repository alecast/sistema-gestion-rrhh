package controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.UsuarioDAO;
import modelo.UsuarioVO;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Preparar devolución de mensajes
        Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
        
		String btn = request.getParameter("btnUsuario"); 
		UsuarioDAO usuDAO = new UsuarioDAO();
		if(btn.equals("alta")) {
			request.getRequestDispatcher("WEB-INF/JSP/Usuario/Alta.jsp").forward(request, response);
		};
		if(btn.equals("busqueda")) {
			request.getRequestDispatcher("WEB-INF/JSP/Usuario/Busqueda.jsp").forward(request, response);
		};
		if(btn.equals("confirmaAlta")) {
			UsuarioVO usuVO = new UsuarioVO();
			String legajo = request.getParameter("legajo");
			String nombreUsuario = request.getParameter("nombreUsuario");
			String pass = request.getParameter("passUsuario");
			String pass2 = request.getParameter("pass2Usuario"); 
			if(legajo.isEmpty() || nombreUsuario.isEmpty() || pass.isEmpty() || pass2.isEmpty()) {
				messages.put("error","Debe completar todos los campos");
				request.getRequestDispatcher("WEB-INF/JSP/Usuario/Alta.jsp").forward(request, response);
			} else {
				if(!pass.equals(pass2)) {
					messages.put("error", "Las contraseñas no coinciden");
					request.getRequestDispatcher("WEB-INF/JSP/Usuario/Alta.jsp").forward(request, response);
				} else {
					usuVO.setNombre_usuario(request.getParameter("nombreUsuario"));
					usuVO.setContraseña(request.getParameter("passUsuario"));
					usuVO.setId_tipo_usuario((Integer.parseInt(request.getParameter("tipoUsuario")))); //Convertir a objeto
					usuVO.setLegajo((Integer.parseInt(request.getParameter("legajo")))); //Validar contra base, debería ser un objeto Empleado
					
					if(usuDAO.altaUsuario(usuVO)) request.getRequestDispatcher("WEB-INF/JSP/Usuario/Opciones.jsp").forward(request,response);
				}
			}
		}
		if(btn.equals("volverOpciones")) request.getRequestDispatcher("WEB-INF/JSP/Usuario/Opciones.jsp").forward(request,response);
	}

}
