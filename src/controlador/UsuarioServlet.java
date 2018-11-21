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
        messages.put("pass","");
        
		String btn = request.getParameter("btnUsuario"); 
		UsuarioDAO usuDAO = new UsuarioDAO();
		if(btn.equals("alta")) {
			request.getRequestDispatcher("WEB-INF/JSP/Usuario/Alta.jsp").forward(request, response);
		};
		if(btn.equals("confirmaAlta")) {
			UsuarioVO usuVO = new UsuarioVO();
			String pass = request.getParameter("passUsuario");
			String pass2 = request.getParameter("pass2Usuario"); 
			if(!pass.equals(pass2)) {
				messages.put("pass", "Las contraseñas no coinciden");
				request.getRequestDispatcher("WEB-INF/JSP/Usuario/Alta.jsp").forward(request, response);
			} else {
				messages.put("pass","Coinciden");
				usuVO.setNombre_usuario(request.getParameter("nombreUsuario"));
				usuVO.setContraseña(request.getParameter("passUsuario"));
				usuVO.setId_tipo_usuario((Integer.parseInt(request.getParameter("tipoUsuario")))); //Convertir a objeto
				usuVO.setLegajo((Integer.parseInt(request.getParameter("legajo")))); //Validar contra base
				
				usuDAO.altaUsuario(usuVO);
			}
		}
	}

}
