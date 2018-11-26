package controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
        
		String btn = request.getParameter("btnUsuario"); //Botón que se usa como disparador de las diferentes acciones		
		//Botones de redireccionamiento puro
		if(btn.equals("alta")) request.getRequestDispatcher("WEB-INF/JSP/Usuario/Alta.jsp").forward(request, response);
		if(btn.equals("volverOpciones")) request.getRequestDispatcher("WEB-INF/JSP/Usuario/Opciones.jsp").forward(request,response);
		if(btn.equals("volverMenu")) request.getRequestDispatcher("WEB-INF/JSP/Menu.jsp").forward(request, response);
		//Botones con funcionalidad
		//Alta Usuario y sus validaciones
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
					UsuarioDAO usuDAO = new UsuarioDAO();
					if(usuDAO.altaUsuario(usuVO)) request.getRequestDispatcher("WEB-INF/JSP/Usuario/Opciones.jsp").forward(request,response);
					else request.getRequestDispatcher("WEB-INF/JSP/Usuario/Alta.jsp").forward(request, response);
					messages.put("error", "No se pudo agregar el usuario correctamente");
				}
			}
		}
		//Ingreso a búsqueda, traer listado entero
		if(btn.equals("busqueda")) {
			UsuarioDAO usuDAO = new UsuarioDAO();
			List<UsuarioVO> listaUsuarios = usuDAO.getListaEmpleados();
			request.setAttribute("listaUsuarios", listaUsuarios);
			request.getRequestDispatcher("WEB-INF/JSP/Usuario/Busqueda.jsp").forward(request, response);
		}

		//Búsqueda de Usuario con like nombre_usuario
		if(btn.equals("aceptarBusqueda")) {
			String nombreLike = request.getParameter("nombreLike");
			if(nombreLike.isEmpty()) {
				messages.put("error","Debe completar todos los campos");
				request.getRequestDispatcher("WEB-INF/JSP/Usuario/Busqueda.jsp").forward(request, response);	
			} else {
				UsuarioDAO usuDAO = new UsuarioDAO();
				List<UsuarioVO> listaUsuariosLike = usuDAO.getListaUsuariosPorNombre(nombreLike);
				request.setAttribute("listaUsuariosLike", listaUsuariosLike);
				request.getRequestDispatcher("WEB-INF/JSP/Usuario/Busqueda.jsp").forward(request, response);
			}
		}
		//Eliminación de Usuario
		//El botón Eliminar Usuario tiene un value igual a "eliminarUsuario" + el indice que trae de Base de datos
		if(btn.contains("eliminarUsuario")) { //Se fija que se haya apretado alguno de los "eliminarUsuario"
			int index = Integer.parseInt(btn.substring(15,btn.length())); //Índice que saca del value en el JSP, lo usa para eliminar ese usuario
			UsuarioDAO usuDAO = new UsuarioDAO();
			if(usuDAO.eliminarUsuario(index)) {
				messages.put("baja", "Se eliminó al usuario correctamente");
				request.getRequestDispatcher("WEB-INF/JSP/Usuario/Busqueda.jsp").forward(request, response);				
			} else {
				messages.put("baja", "No se pudo eliminar el usuario");
				request.getRequestDispatcher("WEB-INF/JSP/Usuario/Busqueda.jsp").forward(request, response);	
			}
		}
		
	}

}
