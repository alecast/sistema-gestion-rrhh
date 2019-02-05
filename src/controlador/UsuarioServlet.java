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

import datos.EmpleadoDAO;
import datos.UsuarioDAO;
import modelo.EmpleadoVO;
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
				messages.put("error","Debe completar todos los campos.");
				request.getRequestDispatcher("WEB-INF/JSP/Usuario/Alta.jsp").forward(request, response);
			} else {
				if(!pass.equals(pass2)) {
					messages.put("error", "Las contraseñas no coinciden.");
					request.getRequestDispatcher("WEB-INF/JSP/Usuario/Alta.jsp").forward(request, response);
				} else {
					EmpleadoDAO empleDAO = new EmpleadoDAO();
					EmpleadoVO empleVO = empleDAO.getEmpleado(Integer.parseInt(legajo));
					// Consulto en base por un empleado con ese legajo, a lo que trae, lo comparto con el legajo ingresado
					if( empleVO.getLegajo() != Integer.parseInt(legajo)) {
						messages.put("error", "No existe empleado para el legajo ingresado.");
						request.getRequestDispatcher("WEB-INF/JSP/Usuario/Alta.jsp").forward(request, response);	
					} else  {
						if (empleVO.getEstado().equals("Inactivo")) {
							messages.put("error", "El empleado ingresado no está activo actualmente.");
							request.getRequestDispatcher("WEB-INF/JSP/Usuario/Alta.jsp").forward(request, response);	
						} else {
							usuVO.setNombre_usuario(nombreUsuario);
							usuVO.setContraseña(pass);
							usuVO.setTipoUsuario(((Integer.parseInt(request.getParameter("tipoUsuario"))))); 
							usuVO.setEmpleado((Integer.parseInt(legajo))); 
							UsuarioDAO usuDAO = new UsuarioDAO();
							if(usuDAO.altaUsuario(usuVO)) {
								messages.put("success", "Usuario registrado exitosamente.");
								request.getRequestDispatcher("WEB-INF/JSP/Usuario/Alta.jsp").forward(request, response);
							} else {
								messages.put("error", "No se pudo agregar el usuario correctamente.");
								request.getRequestDispatcher("WEB-INF/JSP/Usuario/Alta.jsp").forward(request, response);
							}
						}
					}
				}
			}
		}
		//Ingreso a búsqueda, traer listado entero
		if(btn.equals("busqueda")) {
			String activo = request.getParameter("chbUsuInactivo"); //Checkbox para buscar usuarios inactivos
			boolean usuActivo = true; 
			UsuarioDAO usuDAO = new UsuarioDAO();
			List<UsuarioVO> listaUsuarios;
			if (activo != null) usuActivo = false;
			listaUsuarios = usuDAO.getListaUsuarios(usuActivo);
			request.setAttribute("listaUsuarios", listaUsuarios);
			request.getRequestDispatcher("WEB-INF/JSP/Usuario/Busqueda.jsp").forward(request, response);
		}

		//Búsqueda de Usuario con like nombre_usuario
		if(btn.equals("aceptarBusqueda")) {
			String nombreLike = request.getParameter("nombreLike");
			if(nombreLike.isEmpty()) {
				messages.put("error","Debe completar todos los campos.");
				request.getRequestDispatcher("WEB-INF/JSP/Usuario/Busqueda.jsp").forward(request, response);	
			} else {
				String activo = request.getParameter("chbUsuInactivo"); //Checkbox para buscar usuarios inactivos
				boolean usuActivo = true; 
				UsuarioDAO usuDAO = new UsuarioDAO();
				if (activo != null) usuActivo = false;
				List<UsuarioVO> listaUsuariosLike = usuDAO.getListaUsuariosPorNombre(nombreLike,usuActivo);
				request.setAttribute("listaUsuariosLike", listaUsuariosLike);
				request.getRequestDispatcher("WEB-INF/JSP/Usuario/Busqueda.jsp").forward(request, response);
			}
		}
		//Eliminación de Usuario
		//El botón Eliminar Usuario tiene un value igual a "eliminarUsuario" + el indice que trae de Base de datos
		if(btn.contains("eliminarUsuario")) { //Se fija que se haya apretado alguno de los "eliminarUsuario"
			int index = Integer.parseInt(btn.substring(15,btn.length())); //Índice que saca del value en el JSP, lo usa para eliminar ese usuario
			UsuarioDAO usuDAO = new UsuarioDAO();
			if(usuDAO.bajaUsuario(index)) {
				messages.put("baja", "Se eliminó al usuario correctamente.");
				List<UsuarioVO> listaUsuarios = usuDAO.getListaUsuarios(true);
				request.setAttribute("listaUsuarios", listaUsuarios);
				request.getRequestDispatcher("WEB-INF/JSP/Usuario/Busqueda.jsp").forward(request, response);				
			} else {
				messages.put("baja", "No se pudo eliminar el usuario");
				request.getRequestDispatcher("WEB-INF/JSP/Usuario/Busqueda.jsp").forward(request, response);	
			}
		}
		//Modificación de Usuario
		//El botón Modificar Usuario tiene un value igual a "ModificarUsuario" + el indice que trae de Base de datos
		if(btn.contains("modificarUsuario")) { //Se fija que se haya apretado alguno de los "modificarUsuario"
			int index = Integer.parseInt(btn.substring(16,btn.length())); //Índice que saca del value en el JSP, lo usa para modificar ese usuario
			String nombreUsuario = request.getParameter("nombreUsuario"+btn.substring(16,btn.length()));
			request.setAttribute("idUsuario", index);
			request.setAttribute("nombreUsuario", nombreUsuario);
			request.getRequestDispatcher("WEB-INF/JSP/Usuario/Modifica.jsp").forward(request, response);	
		}
		//Aceptar modifición de Usuario
		//El botón Aceptar tiene un value igual a "AceptaModifica" + el indice que trae de Base de datos
		if(btn.contains("aceptaModifica")) { //
			String pass = request.getParameter("userPass");
			String pass2 = request.getParameter("userPass2");
			if(!pass.equals(pass2)) {
				messages.put("error", "Las contraseñas no coinciden.");
				request.getRequestDispatcher("WEB-INF/JSP/Usuario/Modifica.jsp").forward(request, response);
			} else {
				int index = Integer.parseInt(btn.substring(14,btn.length())); //Índice que saca del value en el JSP, lo usa para modificar ese usuario
				int tipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));
				UsuarioDAO usuDAO = new UsuarioDAO();
				if(usuDAO.modificarUsuario(pass,tipoUsuario,index)) {
					messages.put("baja", "Usuario modificado exitosamente.");
					List<UsuarioVO> listaUsuarios = usuDAO.getListaUsuarios(true);
					request.setAttribute("listaUsuarios", listaUsuarios);
					request.getRequestDispatcher("WEB-INF/JSP/Usuario/Busqueda.jsp").forward(request, response);				
				} else {
					messages.put("baja", "No se pudo modificar al usuario.");
					request.getRequestDispatcher("WEB-INF/JSP/Usuario/Busqueda.jsp").forward(request, response);	
				}
			}
		}
	}
}
